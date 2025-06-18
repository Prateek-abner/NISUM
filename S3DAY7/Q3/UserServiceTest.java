import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    UserService userService = new UserService();

    @Test
    void testValidateAgeThrowsExceptionForUnderage() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            userService.validateAge(16);
        });
        assertEquals("Underage", exception.getMessage());
    }

    @Test
    void testValidateAgeDoesNotThrowForAdult() {
        assertDoesNotThrow(() -> userService.validateAge(18));
    }
}
