
package com.example.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/user/1")
    public String getUser() {
        return "User Profile - ID: 1";
    }
}
