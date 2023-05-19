package com.example.Get_Tested.User;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid UserRegistrationDTO userRegistrationDTO) {
        String response = userService.register(userRegistrationDTO);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping(value = {"/login", "/sign-in"})
    public ResponseEntity<String> login (@RequestBody  UserLoginDTO userLoginDTO){
        String response = userService.login(userLoginDTO);
        return ResponseEntity.ok(response);
    }
}

