package com.rom.security.local.user;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.rom.security.common.APIUser;

@RestController
@RequestMapping("rom")
@CrossOrigin(origins = "*")
public class UserController
{
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public UserController(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder)
    {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/signup")
    public void signUp(@RequestBody APIUser user)
    {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
    
    
	@GetMapping("/user/{name}")
	public APIUser getUser(@PathVariable String name) {
		return userRepository.findByUsername(name);
	}
	
	@GetMapping("/users")
	public Iterable<APIUser> gerUsers() {
		return userRepository.findAll();
	}
    
	@PostMapping("/romLogin")
	String newProduct(@RequestBody UserCredDto userCred) {
		System.out.println("Login Start");
		System.out.println(userCred.getUsername());
		System.out.println(userCred.getPassword());
		String token = userLogin(userCred);
		System.out.println("Login end");
		return token;
	}

	private String userLogin(UserCredDto userCred) {
		String authtoken = "";
		try {
			final String uri = "http://infusers.in:8080/rom/login";
			RestTemplate template = new RestTemplate();
			HttpHeaders requestHeaders = new HttpHeaders();
			requestHeaders.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<UserCredDto> requestEntity = new HttpEntity<>(userCred, requestHeaders);
			HttpEntity<String> response = template.exchange(uri, HttpMethod.POST, requestEntity, String.class);
			// String resultString = response.getBody();
			HttpHeaders headers = response.getHeaders();
			authtoken = headers.get("Authorization").get(0);
			System.out.println("Valid Login and authtoken =" + authtoken);
		} catch (Exception e) {
			System.out.println("Invalid login");
		}
		return authtoken;
	}

}

class UserCredDto {

	String username;
	String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
