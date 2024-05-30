package br.com.lmello.redventures.ramengo.controller;

import br.com.lmello.redventures.ramengo.dto.OrderRequestDTO;
import br.com.lmello.redventures.ramengo.dto.OrderResponseDTO;
import br.com.lmello.redventures.ramengo.model.Order;
import br.com.lmello.redventures.ramengo.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponseDTO> createOrder(@RequestBody @Valid OrderRequestDTO orderDTO) {
        Order order = orderService.createOrder(orderDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(new OrderResponseDTO(order));
    }
}
