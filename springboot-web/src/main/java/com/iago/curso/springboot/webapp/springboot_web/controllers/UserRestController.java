package com.iago.curso.springboot.webapp.springboot_web.controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iago.curso.springboot.webapp.springboot_web.models.User;
import com.iago.curso.springboot.webapp.springboot_web.models.dto.UserDto;


@RestController
@RequestMapping("api")
public class UserRestController {

    @RequestMapping(path="details", method = RequestMethod.GET)
    public Map<String, Object> details(){
        User user = new User("iago", "porto");
        Map<String, Object> body = new HashMap<>();
        body.put("title", "Primer trabajo en Spring Boot");
        body.put("user", user);
        return body;
    }
    @RequestMapping(path="details-dto", method=RequestMethod.GET)
    public UserDto detailsDto() {
        User user = new User("iago", "porto");
        UserDto userDto = new UserDto("prueba", user);
        return userDto;
    }

    @RequestMapping(path="details-list", method=RequestMethod.GET)
    public List<User> detailsList() {
        User user = new User("pepe", "garcia");
        User user2 = new User("lorena", "vazquez");
        List<User> users = Arrays.asList(user, user2);
        return users;
    }
    
    

}
