package nl.hu.bep.example.fancyfishpro.config;

import com.zaxxer.hikari.*;
import lombok.extern.log4j.Log4j2;
import nl.hu.bep.example.fancyfishpro.model.MyUser;
import nl.hu.bep.example.fancyfishpro.repositories.IUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@Log4j2
public class DatabaseConfig {


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
            String toFind = "username";
            log.info("validating context for startup");
            if (repository.findByUsername(toFind)==null)
            log.info("Preloading " + repository.save(new MyUser("username", "password")));
            else log.info("user {} was available", toFind);
        };
    }
}