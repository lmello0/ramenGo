package br.com.lmello.redventures.ramengo.repository;

import br.com.lmello.redventures.ramengo.model.UserUsage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserUsageRepository extends JpaRepository<UserUsage, Integer> {
}
