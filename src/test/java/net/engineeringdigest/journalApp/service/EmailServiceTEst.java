package net.engineeringdigest.journalApp.service;
import net.engineeringdigest.journalApp.Service.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTEst {

    @Autowired
    private EmailService emailService;

    @Test
    public void testEMailService() {
        emailService.sendEmail("savaleyash004@gmail.com",
                "Checking Email Status",
                "Hii Kaise ho App");
    }
 }
