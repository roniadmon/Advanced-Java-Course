package ofek.java.config;

import ofek.java.util.StringSupplier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class SupplierConfigurationFromProp {
    @Value("${printer-value:null}")
    private String printerValue;

    @Bean
    @Primary
    @ConditionalOnProperty(value = "printer-value", havingValue = "C")
    public StringSupplier getProp() {
        return () -> printerValue;
    }
}
