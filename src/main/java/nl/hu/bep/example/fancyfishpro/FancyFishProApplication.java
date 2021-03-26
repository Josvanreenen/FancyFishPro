package nl.hu.bep.example.fancyfishpro;

import lombok.extern.log4j.Log4j2;
import nl.hu.bep.example.fancyfishpro.domain.IAquariumBuilder;
import nl.hu.bep.example.fancyfishpro.domain.IAquariumBuilderFactory;
import nl.hu.bep.example.fancyfishpro.domain.TypeBasedAquariumBuilderFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Log4j2
@SpringBootApplication
public class FancyFishProApplication {

    public static void main(String[] args) {
        log.info("FancyFishProApplication initialized");
        IAquariumBuilderFactory factory = TypeBasedAquariumBuilderFactory.getMockInstance();
        IAquariumBuilder builder = factory.createAquariumBuilder();
        builder.setDimensions(30,40,50);
        log.info("not ready yet {}", builder.build());
        builder.setBeddingType("bedding");
        builder.setWaterType("dry water");
        log.info("Should be ready {}", builder.build());
        SpringApplication.run(FancyFishProApplication.class, args);
    }

}
