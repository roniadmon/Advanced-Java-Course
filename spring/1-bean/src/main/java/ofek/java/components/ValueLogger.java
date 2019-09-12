package ofek.java.components;

import ofek.java.util.Printer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ValueLogger {
    private static final Logger logger = LoggerFactory.getLogger(ValueLogger.class);

    @Autowired
    private Printer printer;

    @PostConstruct
    public void demo() {
        logger.info("Printing string: '{}'", printer.getStr());
    }
}
