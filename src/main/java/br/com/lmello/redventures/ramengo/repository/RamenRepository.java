package br.com.lmello.redventures.ramengo.repository;

import br.com.lmello.redventures.ramengo.model.Ramen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RamenRepository extends JpaRepository<Ramen, Integer> {
    Optional<Ramen> findByBrothIdAndProteinId(Integer brothId, Integer proteinId);
}
