package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private EmailSender emailSender;

    @InjectMocks
    private UserService userService;

    @Test
    void testProcessUserFirstCallThrowsException() {
        when(userRepository.findById(anyString())).thenReturn(null, new User("1", "test@example.com"));

        assertThrows(IllegalArgumentException.class, () -> userService.processUser("1"));
        verify(userRepository).findById("1");
        verify(emailSender, never()).send(anyString(), anyString(), anyString());
        verifyNoMoreInteractions(emailSender);
    }

    @Test
    void testProcessUserSecondCallSendsEmail() {
        User user = new User("1", "test@example.com");
        when(userRepository.findById(anyString())).thenReturn(null, user);

        // First call
        try {
            userService.processUser("1");
        } catch (IllegalArgumentException ignored) {
        }

        // Second call
        userService.processUser("1");

        verify(userRepository, times(2)).findById("1");
        verify(emailSender).send("test@example.com", "Welcome", "Hello, 1");
    }
}