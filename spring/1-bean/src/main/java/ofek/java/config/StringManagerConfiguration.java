package ofek.java.config;

import ofek.java.util.StringManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class StringManagerConfiguration {
    @Primary
    @Bean
    public StringManager stateless() {
        return new StringManager() {
            @Override
            public String get() {
                return "A";
            }

            @Override
            public void set(String s) {
            }
        };
    }

    //@Primary
    //@Scope(SCOPE_PROTOTYPE)
    @Bean
    public StringManager stateful() {
        return new StringManager() {
            String s = "A";

            @Override
            public String get() {
                return s;
            }

            @Override
            public void set(String s) {
                this.s = s;
            }
        };
    }
}
