package micro.naut.util;

import io.micronaut.security.authentication.providers.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.inject.Singleton;

import static micro.naut.util.JSONUtils.BCRYPT_PASSWORD_ENCODER;

/**
 * Created by Karanbir Singh on 1/27/2019.
 **/
@Singleton
public class BcryptPasswordEncoderService implements PasswordEncoder {

    private BCryptPasswordEncoder bCryptPasswordEncoder = BCRYPT_PASSWORD_ENCODER;

    @Override
    public String encode(String rawPassword) {
        return bCryptPasswordEncoder.encode(rawPassword);
    }

    @Override
    public boolean matches(String rawPassword, String encodedPassword) {
        return bCryptPasswordEncoder.matches(rawPassword, encodedPassword);
    }
}
