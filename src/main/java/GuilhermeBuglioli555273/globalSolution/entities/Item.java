package GuilhermeBuglioli555273.globalSolution.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "tb_item")
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Double peso;
    private Double volume;
    private LocalDate dataValidade;

    @ManyToOne
    @JoinColumn(name = "frete_id", nullable = false)
    private Frete frete;
}
