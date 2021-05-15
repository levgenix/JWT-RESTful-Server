package ru.itsinfo.securityjwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);

        web.ignoring()
        // Spring Security should completely ignore URLs starting with /resources/
        .antMatchers("/resources/**");

        System.out.println("ignoring: " + web.ignoring());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);

        //http.authorizeRequests().anyRequest().authenticated().and().formLogin().and().httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);

        // TODO: 15.05.2021 auth from database
        auth
            // enable in memory based authentication with a user named
            // "user" and "admin"
            .inMemoryAuthentication()
                .withUser("user").password("$2y$12$kajGwWdpqNWJd.gbLDdPWuZyksRux/PwLmtCicr0KUDIVWDlFp0f6").roles("USER")
                .and()
                .withUser("admin").password("$2y$12$RLx8jsrTNsx045aceILa4eFYsw/LQq1E4bVPMXhS.blFh.SjPOb0m").roles("USER", "ADMIN");
    }

    // Expose the UserDetailsService as a Bean
    @Bean
    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return super.userDetailsServiceBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }
}
