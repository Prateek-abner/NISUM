import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        user = new User("Alice", "alice@example.com", 25);
    }

    @Test
    void testUserFields() {
        assertAll("User Fields",
            () -> assertNotNull(user.getName(), "Name should not be null"),
            () -> assertNotNull(user.getEmail(), "Email should not be null"),
            () -> assertTrue(user.getAge() > 0, "Age should be positive"),
            () -> assertEquals("Alice", user.getName(), "Name should be Alice"),
            () -> assertEquals("alice@example.com", user.getEmail(), "Email mismatch"),
            () -> assertEquals(25, user.getAge(), "Age mismatch")
        );
    }
}
