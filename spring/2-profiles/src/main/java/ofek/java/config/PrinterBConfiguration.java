package ofek.java.config;

import ofek.java.util.Printer;
import org.springframework.context.annotation.*;

@Profile("B")
@Configuration
public class PrinterBConfiguration {
    @Bean
    @Primary
    @Scope("prototype")
    public Printer printerB() {
        return new Printer() {
            @Override
            public String getStr() {
                return "B";
            }
        };
    }
}
