package ofek.java.config;

import ofek.java.util.StringSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StringSupplierConfiguration {
    @Bean
    public StringSupplier supplyA() {
        return () -> "A";
    }
}
