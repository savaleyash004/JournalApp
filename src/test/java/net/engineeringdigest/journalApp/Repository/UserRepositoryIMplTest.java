package net.engineeringdigest.journalApp.Repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRepositoryIMplTest {

    @Autowired
    UserRepositoryIMpl userRepositoryIMpl;

    @Test
    public void testGetUserForSA () {
        Assertions.assertNotNull(userRepositoryIMpl.getUserForSA());
    }
}
