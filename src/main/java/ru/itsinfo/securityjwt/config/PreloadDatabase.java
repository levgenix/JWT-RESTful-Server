package ru.itsinfo.securityjwt.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.itsinfo.securityjwt.model.TestEntity;
import ru.itsinfo.securityjwt.repository.AppRepository;

import java.util.Random;

/**
 * Pre-load test data.
 */
@Configuration
@Slf4j
public class PreloadDatabase {

    // TODO: 16.05.2021 move to tests
    @Bean
    CommandLineRunner initTestData(AppRepository appRepository) {
        return args -> {

            log.info("Preloading " + appRepository.save(new TestEntity("Name1", "a@a.com", true)));
            log.info("Preloading " + appRepository.save(new TestEntity("Name2", "b@b.org", false)));
            log.info("Preloading " + appRepository.save(new TestEntity("Name3", "c@ccc.cn", true)));

            Random random = new Random();
            int i = 0;
            for (; i < 15 ; i++) {
                appRepository.save(new TestEntity(Long.toHexString(random.nextLong()), Long.toHexString(random.nextLong()), random.nextBoolean()));
            }
            log.info("IN initTestData - {} records successfully load in database", i + 3);
        };
    }
}
