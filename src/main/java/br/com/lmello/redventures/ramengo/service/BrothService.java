package br.com.lmello.redventures.ramengo.service;

import br.com.lmello.redventures.ramengo.model.Broth;
import br.com.lmello.redventures.ramengo.repository.BrothRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrothService {
    private final BrothRepository brothRepository;

    public List<Broth> findAll() {
        return brothRepository.findAll();
    }
}
