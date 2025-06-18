import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    public void testAdd() {
        assertEquals(5, calculator.add(2, 3));
        assertNotEquals(6, calculator.add(2, 3));
    }

    @Test
    public void testSubtract() {
        assertEquals(1, calculator.subtract(4, 3));
        assertNotEquals(0, calculator.subtract(4, 3));
    }

    @Test
    public void testMultiply() {
        assertEquals(12, calculator.multiply(4, 3));
        assertNotEquals(10, calculator.multiply(4, 3));
    }

    @Test
    public void testDivide() {
        assertEquals(2, calculator.divide(6, 3));
        assertNotEquals(1, calculator.divide(6, 3));
    }

    @Test
    public void testDivideByZeroThrowsException() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
            calculator.divide(5, 0);
        });
        assertEquals("Division by zero is not allowed", exception.getMessage());
    }
}
