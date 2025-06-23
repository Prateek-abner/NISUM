@Configuration
@ConditionalOnMissingBean
public class GreeterAutoConfig {
    @Bean
    public Greeter greeter() {
        return new Greeter("Hello from AutoConfig");
    }
}
