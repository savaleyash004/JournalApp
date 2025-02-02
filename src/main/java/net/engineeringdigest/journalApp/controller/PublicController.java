package net.engineeringdigest.journalApp.controller;


import net.engineeringdigest.journalApp.Service.UserService;
import net.engineeringdigest.journalApp.entry.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/public")
@RestController
public class PublicController {

    @Autowired
    private UserService userService;

    @PostMapping("/create-user")
    public void createUser(@RequestBody User user) {
        userService.saveNewUser(user);
    }

    @GetMapping("/health-check")
    public String healthCheck() {
        return "Ok";
    }


}
