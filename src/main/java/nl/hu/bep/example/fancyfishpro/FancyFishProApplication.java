package nl.hu.bep.example.fancyfishpro;

import nl.hu.bep.example.fancyfishpro.domain.IAquariumBuilder;
import nl.hu.bep.example.fancyfishpro.domain.IAquariumBuilderFactory;
import nl.hu.bep.example.fancyfishpro.domain.TypeBasedAquariumBuilderFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FancyFishProApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(FancyFishProApplication.class);

    public static void main(String[] args) {
        LOGGER.info("FancyFishProApplication initialized");
        IAquariumBuilderFactory factory = TypeBasedAquariumBuilderFactory.getMockInstance();
        IAquariumBuilder builder = factory.createAquariumBuilder();
        builder.setDimensions(30,40,50);
        LOGGER.info("not ready yet {}", builder.build());
        builder.setBeddingType("bedding");
        builder.setWaterType("dry water");
        LOGGER.info("Should be ready {}", builder.build());
        SpringApplication.run(FancyFishProApplication.class, args);
    }

}
