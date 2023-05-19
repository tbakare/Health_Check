package com.example.Get_Tested.User;

import com.example.Get_Tested.Role.Role;
import com.example.Get_Tested.Role.RoleName;
import com.example.Get_Tested.Role.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private AuthenticationManager authenticationManager;

    public UserService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       PasswordEncoder passwordEncoder,
                       AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public String register(UserRegistrationDTO userRegistrationDTO) {

        if (userRepository.existsByUsername(userRegistrationDTO.getUsername())) {
            //return "Username already Exists";
            throw new IllegalArgumentException("Username already exists");
        }
        if (userRepository.existsByEmailAddress(userRegistrationDTO.getEmailAddress())) {
            throw new IllegalArgumentException("Email already exists");
        }

        // Creating a new user from the UserRegistrationDTO
        User newUser = new User(
                userRegistrationDTO.getFirstName(),
                userRegistrationDTO.getLastName(),
                userRegistrationDTO.getDateOfBirth(),
                userRegistrationDTO.getAlbertaHealthNumber(),
                userRegistrationDTO.getTreatyNumber(),
                userRegistrationDTO.getMailingAddress(),
                userRegistrationDTO.getEmailAddress(),
                userRegistrationDTO.getUsername(),
                passwordEncoder.encode(userRegistrationDTO.getPassword())
        );

        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName(RoleName.USER).get();
        roles.add(userRole);
        newUser.setRoles(roles);
        userRepository.save(newUser);
        // Save the new user in the database
        return "user registered successfully";
    }

    public String login(UserLoginDTO loginDTO){
        Authentication authentication= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsername(),
                loginDTO.getPassword()));
        SecurityContextHolder.getContext()
                .setAuthentication(authentication);
        return "user logged-in successfully";
    }
}
