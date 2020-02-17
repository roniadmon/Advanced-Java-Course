package ofek.java.components;

import ofek.java.util.StringManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class ValueLogger1 {
    private static final Logger logger = LoggerFactory.getLogger(ValueLogger1.class);

    private final StringManager stringManager;

    public ValueLogger1(StringManager stringManager) {
        this.stringManager = stringManager;
    }

    @PostConstruct
    public void demo() {
        logger.info("Printing string: '{}'", stringManager.get());
        stringManager.set("B");
        logger.info("Printing string: '{}'", stringManager.get());
    }
}
