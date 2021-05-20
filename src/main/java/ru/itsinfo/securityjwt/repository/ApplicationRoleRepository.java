package ru.itsinfo.securityjwt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import ru.itsinfo.securityjwt.model.ApplicationGrantedAuthority;

@PreAuthorize("hasRole('ROLE_USER')")
public interface ApplicationRoleRepository extends CrudRepository<ApplicationGrantedAuthority, Long> {

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    <S extends ApplicationGrantedAuthority> S save(S entity);
}
