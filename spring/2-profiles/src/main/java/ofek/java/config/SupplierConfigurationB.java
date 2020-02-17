package ofek.java.config;

import ofek.java.util.StringSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("B")
@Configuration
public class SupplierConfigurationB {
    @Bean
    @Primary
    public StringSupplier getB() {
        return () -> "B";
    }
}
