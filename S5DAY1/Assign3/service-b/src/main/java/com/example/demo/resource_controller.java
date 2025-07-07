package com.example.demo;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {

    @GetMapping("/api/resource")
    public String resourceEndpoint(@AuthenticationPrincipal UserDetails userDetails) {
        return "Resource Data for " + userDetails.getUsername();
    }
}
