package br.com.lmello.redventures.ramengo.dto;

import br.com.lmello.redventures.ramengo.model.Broth;

import java.math.BigDecimal;

public record BrothDTO(
        int id,
        String imageInactive,
        String imageActive,
        String name,
        String description,
        BigDecimal price
) {
    public BrothDTO(Broth broth) {
        this(
                broth.getId(),
                broth.getImageInactive(),
                broth.getImageActive(),
                broth.getName(),
                broth.getDescription(),
                broth.getPrice()
        );
    }
}
