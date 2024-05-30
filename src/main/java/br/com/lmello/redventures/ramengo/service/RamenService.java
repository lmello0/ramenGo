package br.com.lmello.redventures.ramengo.service;

import br.com.lmello.redventures.ramengo.infra.exception.NotFoundException;
import br.com.lmello.redventures.ramengo.model.Ramen;
import br.com.lmello.redventures.ramengo.repository.RamenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RamenService {

    private final RamenRepository repository;

    public Ramen findByBrothIdAndProteinId(Integer brothId, Integer proteinId) {
        Optional<Ramen> ramen = repository.findByBrothIdAndProteinId(brothId, proteinId);

        if (ramen.isEmpty()) {
            throw new NotFoundException("Ramen not found");
        }

        return ramen.get();
    }
}
