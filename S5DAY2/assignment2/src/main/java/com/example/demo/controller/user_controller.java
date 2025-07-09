package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/vulnerable-sql")
    public ResponseEntity<String> vulnerableSqlInjection(@RequestParam String username) {
        return ResponseEntity.ok(userService.vulnerableSqlInjection(username));
    }

    @GetMapping("/secure-sql")
    public ResponseEntity<String> secureSqlInjection(@RequestParam String username) {
        return ResponseEntity.ok(userService.secureSqlInjection(username));
    }

    @GetMapping("/vulnerable-xss")
    public ResponseEntity<String> vulnerableXss(@RequestParam String input) {
        return ResponseEntity.ok("<html><body>" + input + "</body></html>");
    }

    @GetMapping("/secure-xss")
    public ResponseEntity<String> secureXss(@RequestParam String input) {
        return ResponseEntity.ok("<html><body>" + input.replaceAll("<", "&lt;").replaceAll(">", "&gt;") + "</body></html>");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserEntity user) {
        return userService.authenticateUser(user.getUsername(), user.getPassword())
                .map(u -> ResponseEntity.ok("Login successful"))
                .orElse(ResponseEntity.status(401).body("Invalid credentials"));
    }
}
