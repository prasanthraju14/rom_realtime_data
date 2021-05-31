package com.rom.mylabs.ui;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rom")
@CrossOrigin(origins = "*")
public class UiController {

  @RequestMapping("/resource")
  public Map<String,Object> home() {
    Map<String,Object> model = new HashMap<String,Object>();
    model.put("id", UUID.randomUUID().toString());
    model.put("content", "Hello World from UiController:: Time now :: "+LocalDateTime.now());
    return model;
  }
  
  @RequestMapping("/user")
  public Principal user(Principal user) {
    return user;
  }

}
