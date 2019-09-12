package ofek.java.config;

import ofek.java.util.Printer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class PrinterPropertyConfiguration {
    @Value("${printer-value:null}")
    private String printerValue;

    @Bean
    @Primary
    @ConditionalOnProperty(value = "printer-value", havingValue = "C")
    @Scope("singleton")
    public Printer printerDynamic() {
        return new Printer() {
            @Override
            public String getStr() {
                return printerValue;
            }
        };
    }
}
