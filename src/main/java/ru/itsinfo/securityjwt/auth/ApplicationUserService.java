package ru.itsinfo.securityjwt.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.itsinfo.securityjwt.model.ApplicationUser;
import ru.itsinfo.securityjwt.repository.ApplicationUserRepository;

@Service
public class ApplicationUserService implements UserDetailsService {

    private final ApplicationUserRepository applicationUserRepository;

    @Autowired
    public ApplicationUserService(ApplicationUserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public ApplicationUser loadUserByUsername(String username) throws UsernameNotFoundException {
        return applicationUserRepository
                .findApplicationUserByEmail(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException(String.format("Email %s not found", username))
                );
    }
}

