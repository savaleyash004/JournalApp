package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.scheduler.UserScheduler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserSchedulertest {

    @Autowired
    private UserScheduler userScheduler;

    @Test
    public void userschedulerTest() {
        userScheduler.fetchUsersForSA();
    }
}
