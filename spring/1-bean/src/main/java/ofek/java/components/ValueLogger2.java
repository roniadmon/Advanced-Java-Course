package ofek.java.components;

import ofek.java.util.StringManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@DependsOn("valueLogger1")
public class ValueLogger2 {
    private static final Logger logger = LoggerFactory.getLogger(ValueLogger2.class);

    private final StringManager stringManager;

    public ValueLogger2(StringManager stringManager) {
        this.stringManager = stringManager;
    }

    @PostConstruct
    public void demo() {
        logger.info("Printing string: '{}'", stringManager.get());
    }
}
