package GuilhermeBuglioli555273.globalSolution.dto;

import GuilhermeBuglioli555273.globalSolution.Modal.Frete;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FreteDto {
    private Long id;

    @NotNull(message = "Frete precisa ter uma data de envio")
    @FutureOrPresent(message = "Data de envio não pode ser uma data passada")
    private LocalDate dataEnvio;

    @NotNull(message = "Frete precisa ter um valor")
    @PositiveOrZero(message = "Valor deve ser um valor positivo e acima de 0")
    private Double valor;

    @NotBlank(message = "Nave para o frete é obrigatório")
    @Size(min = 3, max = 15 , message = "O nome da nave deve ter entre 3 e 15 caracteres")
    private String naveFrete;

    @NotNull(message = "Tempo de viagem é obrigatório")
    @PositiveOrZero(message = "Tempo de viagem não pode ser 0 ou valor negativo")
    private Double tempoViagem;

    public FreteDto(Frete frete ){
        id = frete.getId();
        dataEnvio = frete.getDataEnvio();
        valor = frete.getValor();
        naveFrete = frete.getNaveFrete();
    }
}
