package br.com.lmello.redventures.ramengo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "broths")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Broth {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "broth_seq")
    @SequenceGenerator(name = "broth_seq", sequenceName = "broths_pk_sequence", allocationSize = 1)
    private int id;
    private String imageInactive;
    private String imageActive;
    private String name;
    private String description;
    private BigDecimal price;
}
