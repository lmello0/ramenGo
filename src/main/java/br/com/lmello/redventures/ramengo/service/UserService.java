package br.com.lmello.redventures.ramengo.service;

import br.com.lmello.redventures.ramengo.infra.exception.MaxLimitReachedException;
import br.com.lmello.redventures.ramengo.model.User;
import br.com.lmello.redventures.ramengo.model.UserUsage;
import br.com.lmello.redventures.ramengo.repository.UserRepository;
import br.com.lmello.redventures.ramengo.repository.UserUsageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final UserUsageRepository userUsageRepository;

    public User getUser(String apiKey) {
        return userRepository
                .findByApiKey(apiKey)
                .orElseThrow(() -> new UsernameNotFoundException("Key not found"));
    }

    @Transactional
    public void increaseUsage(String apiKey) {
        User user = userRepository
                .findByApiKey(apiKey)
                .orElseThrow(() -> new UsernameNotFoundException("Key not found"));

        Optional<UserUsage> usageOptional = user.getUsage()
                .stream()
                .filter(p -> p.getDate().isEqual(LocalDate.now()))
                .findFirst();

        UserUsage usage;
        if (usageOptional.isPresent()) {
            usage = usageOptional.get();

            if (usage.getUsage() >= user.getUsageQuota() && user.getUsageQuota() != -1) {
                throw new MaxLimitReachedException(apiKey, user.getUsageQuota());
            }

            usage.setUsage(usage.getUsage() + 1);
        } else {
            usage = new UserUsage();

            usage.setUsage(1);
            usage.setDate(LocalDate.now());
            usage.setUser(user);

            user.getUsage().add(usage);
        }

        userUsageRepository.save(usage);
    }
}
