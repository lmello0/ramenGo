package br.com.lmello.redventures.ramengo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ramens")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ramen {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ramen_seq")
    @SequenceGenerator(name = "ramen_seq", sequenceName = "proteins_pk_sequence", allocationSize = 1)
    private int id;
    private String description;
    private String image;

    @ManyToOne
    private Broth broth;

    @ManyToOne
    private Protein protein;
}
