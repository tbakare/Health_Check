package com.example.Get_Tested.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findByEmailAddress(String emailAddress);

    Optional<User> findByUsernameOrEmailAddress(String username, String emailAddress);

    boolean existsByUsername(String username);

    boolean existsByEmailAddress(String emailAddress);

    boolean existsByAlbertaHealthNumber(String albertaHealthNumber);

    boolean existsByTreatyNumber(String treatyNumber);

    //boolean existsByEmail(String emailAddress);
}
