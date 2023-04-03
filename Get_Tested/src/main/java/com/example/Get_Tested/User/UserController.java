package com.example.Get_Tested.User;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserService userAuthService;

    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid UserRegistrationDTO userRegistrationDTO) {
        System.out.println("reg endpoint");
        User registeredUser = userAuthService.register(userRegistrationDTO);
        System.out.println("end reg endpoint");
        return ResponseEntity.ok("User registered successfully");
    }

//    @PostMapping("/signup")
//    public ResponseEntity<?> registerUser(@Valid @RequestBody UserRegistrationDTO userRegistrationDTO) {
//        userAuthService.registerUser(userRegistrationDTO);
//        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
//    }


//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody @Valid UserLoginDTO userLoginDTO) {
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        userLoginDTO.getUsername(),
//                        userLoginDTO.getPassword()
//                )
//        );
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        String jwt = jwtTokenProvider.generateToken(authentication);
//        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
//    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody UserRegistrationDTO userRegistrationDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userRegistrationDTO.getUsername(), userRegistrationDTO.getPassword())
        );

        if (authentication.isAuthenticated()) {
            return ResponseEntity.ok("User authenticated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }
}

