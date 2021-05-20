package ru.itsinfo.securityjwt.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itsinfo.securityjwt.model.ApplicationGrantedAuthority;
import ru.itsinfo.securityjwt.model.ApplicationUser;
import ru.itsinfo.securityjwt.model.TestEntity;
import ru.itsinfo.securityjwt.repository.ApplicationRoleRepository;
import ru.itsinfo.securityjwt.repository.ApplicationUserRepository;
import ru.itsinfo.securityjwt.repository.TestEntityRepository;

import java.util.HashSet;
import java.util.Random;

/**
 * Pre-load test data.
 */
@Configuration
@Slf4j
public class PreloadDatabase {

    @Bean
    CommandLineRunner initTestData(TestEntityRepository testEntityRepository,
                                   ApplicationUserRepository applicationUserRepository,
                                   ApplicationRoleRepository applicationRoleRepository,
                                   PasswordEncoder passwordEncoder) {
        return args -> {

            log.info("Preloading " + testEntityRepository.save(new TestEntity("Name1", "a@a.com", true)));
            log.info("Preloading " + testEntityRepository.save(new TestEntity("Name2", "b@b.org", false)));
            log.info("Preloading " + testEntityRepository.save(new TestEntity("Name3", "c@ccc.cn", true)));

            Random random = new Random();
            int i = 0;
            for (; i < 15 ; i++) {
                testEntityRepository.save(new TestEntity(Long.toHexString(random.nextLong()), Long.toHexString(random.nextLong()), random.nextBoolean()));
            }
            log.info("IN initTestData - {} records successfully load in database", i + 3);


            SecurityContextHolder.getContext().setAuthentication(
                    new UsernamePasswordAuthenticationToken("system", "system",
                            AuthorityUtils.createAuthorityList("ROLE_ADMIN")));

            var roleAdmin = new ApplicationGrantedAuthority("ROLE_ADMIN");
            log.info("IN initTestData - {} successfully load in database", applicationRoleRepository.save(roleAdmin));

            var roleUser = new ApplicationGrantedAuthority("ROLE_USER");
            log.info("IN initTestData - {} successfully load in database", applicationRoleRepository.save(roleUser));

            var roleGuest = new ApplicationGrantedAuthority("ROLE_GUEST");
            log.info("IN initTestData - {} successfully load in database", applicationRoleRepository.save(roleGuest));


            var adminRoles = new HashSet<ApplicationGrantedAuthority>();
            adminRoles.add(roleAdmin);

            var userAdmin = new ApplicationUser("Admin",
                    "Aminych",
                    "admin@mail.com",
                    passwordEncoder.encode("password"),
                    adminRoles,
                    true, true, true, true);
            log.info("IN initTestData - {} successfully load in database", applicationUserRepository.save(userAdmin));

            var userRoles = new HashSet<ApplicationGrantedAuthority>();
            userRoles.add(roleUser);
            userRoles.add(roleGuest);

            var userUser = new ApplicationUser("User",
                    "Userovich",
                    "user@mail.com",
                    passwordEncoder.encode("password"),
                    userRoles,
                    true, true, true, true);
            log.info("IN initTestData - {} successfully load in database", applicationUserRepository.save(userUser));

            SecurityContextHolder.clearContext();
        };
    }
}
