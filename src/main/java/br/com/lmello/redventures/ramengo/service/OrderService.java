package br.com.lmello.redventures.ramengo.service;

import br.com.lmello.redventures.ramengo.dto.OrderExternalResponse;
import br.com.lmello.redventures.ramengo.dto.OrderRequestDTO;
import br.com.lmello.redventures.ramengo.model.Order;
import br.com.lmello.redventures.ramengo.model.Ramen;
import br.com.lmello.redventures.ramengo.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final RamenService ramenService;
    private final OrderRepository orderRepository;

    private final RestClient restClient = RestClient.create();

    @Value("${ramengo.external.order.url}")
    private String orderExternalServiceURL;

    public Order createOrder(OrderRequestDTO orderDTO) {
        Ramen ramen = ramenService.findByBrothIdAndProteinId(orderDTO.brothId(), orderDTO.proteinId());

        OrderExternalResponse externalResponse = getExternalOrderResponse();

        Order order = new Order(externalResponse.orderId(), ramen);
        orderRepository.save(order);

        return order;
    }

    private OrderExternalResponse getExternalOrderResponse() {
        return restClient
                .post()
                .uri(orderExternalServiceURL)
                .header("x-api-key", "ZtVdh8XQ2U8pWI2gmZ7f796Vh8GllXoN7mr0djNf")
                .retrieve()
                .body(OrderExternalResponse.class);
    }
}
