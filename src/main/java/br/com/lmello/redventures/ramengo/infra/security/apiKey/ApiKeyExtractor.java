package br.com.lmello.redventures.ramengo.infra.security.apiKey;

import br.com.lmello.redventures.ramengo.infra.exception.MissingHeaderException;
import br.com.lmello.redventures.ramengo.model.User;
import br.com.lmello.redventures.ramengo.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ApiKeyExtractor {
    private final UserService userService;

    public Optional<Authentication> extract(HttpServletRequest request) {
        String providedKey = request.getHeader("x-api-key");

        if (providedKey == null) {
            throw new MissingHeaderException("x-api-key");
        }

        try {
            User user = userService.getUser(providedKey);

            if (!providedKey.equals(user.getApiKey())) {
                return Optional.empty();
            }

            userService.increaseUsage(providedKey);

            return Optional.of(new ApiKeyAuth(providedKey, AuthorityUtils.NO_AUTHORITIES));
        } catch (UsernameNotFoundException e) {
            return Optional.empty();
        }
    }
}
