package br.com.lmello.redventures.ramengo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Table(name = "user_usages")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserUsage {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_user_usage")
    @SequenceGenerator(name = "seq_user_usage", sequenceName = "user_usages_pk_sequence", allocationSize = 1)
    private int id;

    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate date;

    private int usage;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
