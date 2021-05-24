package nl.inholland.securityjwt.controller;

import nl.inholland.securityjwt.Service.UserService;
import nl.inholland.securityjwt.model.DTO.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO login){
        return userService.login(login.getUsername(), login.getPassword());
    }
}
