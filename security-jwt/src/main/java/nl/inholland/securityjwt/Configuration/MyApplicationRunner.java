package nl.inholland.securityjwt.Configuration;

import nl.inholland.securityjwt.Service.UserService;
import nl.inholland.securityjwt.model.Role;
import nl.inholland.securityjwt.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;

@Component
public class MyApplicationRunner implements ApplicationRunner {

    @Autowired
    UserService userService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User testUser = new User();
        testUser.setUsername("test");
        testUser.setPassword("test");
        testUser.setRole(Arrays.asList(Role.ROLE_USER));
        userService.addUser(testUser);
    }
}
