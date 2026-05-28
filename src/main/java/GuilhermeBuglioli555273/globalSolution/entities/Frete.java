package GuilhermeBuglioli555273.globalSolution.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "tb_frete")
public class Frete {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataEnvio;
    private Double valor;
    private String naveFrete;
    private Double tempoViagem;
    @OneToMany(mappedBy = "frete")
    private List<Item> itens;
}
