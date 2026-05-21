package cm.camtech.crm.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtConfig {

    @Value("${security.jwt.secret:ChangeThisSecretKeyForProd}")
    private String secret;

    @Value("${security.jwt.expiration:86400000}")
    private long expirationMs;

    public String getSecret() {
        return secret;
    }

    public long getExpirationMs() {
        return expirationMs;
    }
}
