package com.example.demo;

public class UserService {
    private final UserRepository userRepository;
    private final EmailSender emailSender;

    public UserService(UserRepository userRepository, EmailSender emailSender) {
        this.userRepository = userRepository;
        this.emailSender = emailSender;
    }

    public void processUser(String userId) {
        User user = userRepository.findById(userId);
        if (user == null) {
            handleMissingUser(userId);
            throw new IllegalArgumentException("User not found: " + userId);
        }
        emailSender.send(user.getEmail(), "Welcome", "Hello, " + user.getId());
    }

    void handleMissingUser(String userId) {
        // Fallback logic, e.g., logging
        System.out.println("Handling missing user: " + userId);
    }
}