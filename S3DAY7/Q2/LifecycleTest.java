import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) 
public class LifecycleTest {

    @BeforeAll
    void beforeAll() {
        System.out.println("BeforeAll - Executed once before all test methods.");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("BeforeEach - Executed before each test method.");
    }

    @Test
    void testOne() {
        System.out.println("TestOne - Executing test one.");
    }

    @Test
    void testTwo() {
        System.out.println("TestTwo - Executing test two.");
    }

    @AfterEach
    void afterEach() {
        System.out.println("AfterEach - Executed after each test method.");
    }

    @AfterAll
    void afterAll() {
        System.out.println("AfterAll - Executed once after all test methods.");
    }
}
