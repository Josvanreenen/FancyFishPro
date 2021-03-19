package nl.hu.bep.example.fancyfishpro.config;

import com.zaxxer.hikari.*;
import nl.hu.bep.example.fancyfishpro.model.MyUser;
import nl.hu.bep.example.fancyfishpro.repositories.IUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;
import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseConfig.class);

    @Value("${spring.datasource.url}")
    private String dbUrl;
    @Value("${spring.datasource.username}")
    private String dbUser;
    @Value("${spring.datasource.password}")
    private String dbPass;

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(dbUrl);
        config.setUsername(dbUser);
        config.setPassword(dbPass);
        return new HikariDataSource(config);
    }

    @Bean
    CommandLineRunner initDatabase(IUserRepository repository){
        return args -> {
            LOGGER.info("Preloading " + repository.save(new MyUser("username", "password")));
        };
    }
}