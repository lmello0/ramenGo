package br.com.lmello.redventures.ramengo.dto;

import br.com.lmello.redventures.ramengo.model.Protein;

import java.math.BigDecimal;

public record ProteinDTO(
        int id,
        String imageInactive,
        String imageActive,
        String name,
        String description,
        BigDecimal price
) {

    public ProteinDTO(Protein protein) {
        this(
                protein.getId(),
                protein.getImageInactive(),
                protein.getImageActive(),
                protein.getName(),
                protein.getDescription(),
                protein.getPrice()
        );
    }
}
