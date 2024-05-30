package br.com.lmello.redventures.ramengo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "order_seq")
    @SequenceGenerator(name = "order_seq", sequenceName = "orders_pk_sequence", allocationSize = 1)
    private int id;

    @ManyToOne
    private Ramen ramen;
}
