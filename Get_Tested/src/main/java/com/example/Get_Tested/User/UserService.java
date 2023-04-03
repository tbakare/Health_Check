package com.example.Get_Tested.User;

import com.example.Get_Tested.Role.Role;
import com.example.Get_Tested.Role.RoleName;
import com.example.Get_Tested.Role.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User register(UserRegistrationDTO userRegistrationDTO) {
        System.out.println("starting the user reg");
        if (userRepository.existsByUsername(userRegistrationDTO.getUsername())) {
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

        System.out.println("finished building the user");
        // Assigning the default role
//        Role userRole = roleRepository.findByName(RoleName.USER)
//                .orElseThrow(() -> new RuntimeException("User Role not found"));
//        newUser.setRoles(Collections.singleton(userRole));
//        newUser.setEnabled(true);

        // Save the new user in the database
        return userRepository.save(newUser);
    }
}
