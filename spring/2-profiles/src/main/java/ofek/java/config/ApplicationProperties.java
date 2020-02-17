package ofek.java.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "application")
public class ApplicationProperties {
    private String printerValue;

    public String getPrinterValue() {
        return printerValue;
    }

    public ApplicationProperties setPrinterValue(String printerValue) {
        this.printerValue = printerValue;
        return this;
    }
}
