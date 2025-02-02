package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.Repository.UserRepository;
import net.engineeringdigest.journalApp.Service.UserDetailsServiceImpl;
import net.engineeringdigest.journalApp.Service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UserDetailsServiceImplTest {

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

//    @Test
//    void loadUserNameTest() {
//        // Arrange: Mock userRepository to return a User entity
//        when(userRepository.findByUserName(ArgumentMatchers.anyString()))
//                .thenReturn(new User("sahil", "sahil", "ROLE_USER")); // Use your entity's constructor
//
//        // Act: Load user from userDetailsService
//        UserDetails user = userDetailsService.loadUserByUsername("sahil");
//
//        // Assert: Ensure user is not null
//        Assertions.assertNotNull(user);
//        Assertions.assertEquals("sahil", user.getUsername());
//    }


}
