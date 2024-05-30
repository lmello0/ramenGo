package br.com.lmello.redventures.ramengo.service;

import br.com.lmello.redventures.ramengo.model.Protein;
import br.com.lmello.redventures.ramengo.repository.ProteinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProteinService {
    private final ProteinRepository proteinRepository;

    public List<Protein> findAll() {
        return proteinRepository.findAll();
    }
}
