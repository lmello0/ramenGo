package br.com.lmello.redventures.ramengo.controller;

import br.com.lmello.redventures.ramengo.dto.ProteinDTO;
import br.com.lmello.redventures.ramengo.model.Protein;
import br.com.lmello.redventures.ramengo.service.ProteinService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("proteins")
@RequiredArgsConstructor
public class ProteinController {
    private final ProteinService proteinService;

    @GetMapping
    public ResponseEntity<List<ProteinDTO>> getProteins() {
        List<Protein> proteins = proteinService.findAll();

        List<ProteinDTO> returnProteins = proteins
                .stream()
                .map(ProteinDTO::new)
                .toList();

        return ResponseEntity.ok(returnProteins);
    }
}
