package com.rom.security.local.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}



