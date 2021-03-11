package nl.hu.bep.example.fancyfishpro;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FancyFishProApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(FancyFishProApplication.class);

    public static void main(String[] args) {
        LOGGER.info("FancyFishProApplication initialized");
        SpringApplication.run(FancyFishProApplication.class, args);
    }

}
