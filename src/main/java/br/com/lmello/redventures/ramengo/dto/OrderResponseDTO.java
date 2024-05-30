package br.com.lmello.redventures.ramengo.dto;

import br.com.lmello.redventures.ramengo.model.Order;

public record OrderResponseDTO(
        String id,
        String description,
        String image
) {
    public OrderResponseDTO(Order order) {
        this(
                String.valueOf(order.getId()),
                order.getRamen().getDescription(),
                order.getRamen().getImage()
        );
    }
}
