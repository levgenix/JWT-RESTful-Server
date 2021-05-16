package ru.itsinfo.securityjwt;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // TODO: 16.05.2021
    public @PostConstruct void init() {

    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT) // строгая стратегия соответствия
                .setFieldMatchingEnabled(true) // включение сопоставления полей
                .setSkipNullEnabled(true) // пропуск нулловых полей
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE); // задание приватного уровня доступа к полям
        return mapper;
    }
}
