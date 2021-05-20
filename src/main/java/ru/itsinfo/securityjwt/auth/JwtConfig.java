package ru.itsinfo.securityjwt.auth;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

@ConfigurationProperties(prefix = "jwt")
@Configuration
@Data
@NoArgsConstructor
public class JwtConfig {

    public final String TOKEN_PREFIX = "Bearer ";

    private String secretKey;
    private Integer tokenExpirationDays;

    public String getAuthorizationHeaderName() {
        return HttpHeaders.AUTHORIZATION;
    }
}
