package br.com.lmello.redventures.ramengo.controller;

import br.com.lmello.redventures.ramengo.dto.BrothDTO;
import br.com.lmello.redventures.ramengo.model.Broth;
import br.com.lmello.redventures.ramengo.service.BrothService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("broths")
@RequiredArgsConstructor
public class BrothController {
    private final BrothService brothService;

    @GetMapping
    public ResponseEntity<List<BrothDTO>> getBroths() {
        List<Broth> broths = brothService.findAll();

        List<BrothDTO> returnBroths = broths
                .stream()
                .map(BrothDTO::new)
                .toList();

        return ResponseEntity.ok(returnBroths);
    }
}
