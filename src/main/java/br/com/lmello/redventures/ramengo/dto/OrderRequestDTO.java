package br.com.lmello.redventures.ramengo.dto;

import jakarta.validation.constraints.NotNull;

public record OrderRequestDTO(
        @NotNull
        Integer brothId,

        @NotNull
        Integer proteinId
) {
}
