package br.com.lmello.redventures.ramengo.repository;

import br.com.lmello.redventures.ramengo.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {
}
