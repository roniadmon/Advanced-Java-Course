package ofek.java.config;

import ofek.java.util.Printer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.context.annotation.*;

@Configuration
public class PrinterAConfiguration {
    @Bean
    @Scope("singleton")
    public Printer printerA() {
        return new Printer() {
            @Override
            public String getStr() {
                return "A";
            }
        };
    }
}
