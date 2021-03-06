package nl.inholland.securityjwt.Service;

import nl.inholland.securityjwt.Repository.UserRepository;
import nl.inholland.securityjwt.Security.JwtTokenProvider;
import nl.inholland.securityjwt.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtTokenProvider jwtTokenProvider;


    public User addUser(User user){
        if(userRepository.findByUsername(user.getUsername()) == null){
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userRepository.save(user);
        }else{
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Username already in use");
        }
    }

    public String login(String username, String password){
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
            User user = userRepository.findByUsername(username);
            return jwtTokenProvider.createToken(username, user.getRole());

        }catch(AuthenticationException e){
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Login failed");
        }
    }
}
