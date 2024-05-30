package br.com.lmello.redventures.ramengo.repository;

import br.com.lmello.redventures.ramengo.model.Protein;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProteinRepository extends JpaRepository<Protein, Integer> {
}
