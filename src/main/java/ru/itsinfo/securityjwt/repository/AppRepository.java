package ru.itsinfo.securityjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itsinfo.securityjwt.model.TestDto;

public interface AppRepository extends JpaRepository<TestDto, Long> {

//    Optional<UserDetails> findByEmail(String email);
}
