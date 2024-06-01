package br.com.lmello.redventures.ramengo.controller;

import br.com.lmello.redventures.ramengo.dto.OrderRequestDTO;
import br.com.lmello.redventures.ramengo.dto.OrderResponseDTO;
import br.com.lmello.redventures.ramengo.model.Order;
import br.com.lmello.redventures.ramengo.service.OrderService;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    private final Gson gson;

    @PostMapping
    public ResponseEntity<OrderResponseDTO> createOrder(@RequestBody String orderDTO) {
        OrderRequestDTO parsedRequest;

        parsedRequest = gson.fromJson(orderDTO, OrderRequestDTO.class);

        Order order = orderService.createOrder(parsedRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(new OrderResponseDTO(order));
    }
}
