@Configuration
public class GreeterConfig {
    @Bean
    public Greeter greeter() {
        return new Greeter("Hello from Config");
    }
}
