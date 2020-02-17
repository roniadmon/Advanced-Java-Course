package ofek.java.components;

import ofek.java.util.StringSupplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class ValueLogger {
    private static final Logger logger = LoggerFactory.getLogger(ValueLogger.class);

    private final StringSupplier stringSupplier;

    public ValueLogger(StringSupplier stringSupplier) {
        this.stringSupplier = stringSupplier;
    }

    @PostConstruct
    public void demo() {
        logger.info("PROPERTY VALUE IS {}", stringSupplier.get());
    }
}
