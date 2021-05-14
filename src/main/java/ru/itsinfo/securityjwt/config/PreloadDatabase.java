package ru.itsinfo.securityjwt.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.itsinfo.securityjwt.model.TestDto;
import ru.itsinfo.securityjwt.repository.AppRepository;

@Configuration
public class PreloadDatabase {

    private static final Logger log = LoggerFactory.getLogger(PreloadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(AppRepository appRepository) {
        return args -> {
            log.info("Preloading " + appRepository.save(new TestDto("a@a.com", true)));
            log.info("Preloading " + appRepository.save(new TestDto("b@b.org", false)));
        };
    }
}
