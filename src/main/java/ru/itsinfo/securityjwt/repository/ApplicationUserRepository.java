package ru.itsinfo.securityjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import ru.itsinfo.securityjwt.model.ApplicationUser;

import java.util.Optional;

//@PreAuthorize("hasRole('ROLE_USER')")
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {

    Optional<ApplicationUser> findApplicationUserByEmail(String email);

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    <S extends ApplicationUser> S save(S entity);

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void deleteById(Long aLong);
}
