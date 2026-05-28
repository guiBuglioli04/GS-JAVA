package GuilhermeBuglioli555273.globalSolution.dto;

import GuilhermeBuglioli555273.globalSolution.Modal.Frete;
import GuilhermeBuglioli555273.globalSolution.Modal.Item;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {
    private Long id;
    @NotBlank(message = "Nome do item é obrigatório")
    @Size(min = 3, max = 40 , message = "O nome deve ter entre 3 e 40 caracteres")
    private String nome;

    @NotNull(message = "Peso do item é obrigatório")
    @PositiveOrZero(message = "Peso precisa ser positivo e acima de 0")
    private Double peso;

    @NotNull(message = "Volume do item é obrigatório")
    @PositiveOrZero(message = "Volume precisa ser positivo e acima de 0")
    private Double volume;

    @NotNull(message = "Data de validade precisa ter uma data")
    @FutureOrPresent(message = "Data de validade não pode ser uma data passada")
    private LocalDate dataValidade;

    @NotNull(message = "O campo frete é obrigatório")
    private FreteDto frete;

    public ItemDto(Item item ){
        id = item.getId();
        nome = item.getNome();
        peso = item.getPeso();
        volume = item.getVolume();
        dataValidade = item.getDataValidade();
        frete = new FreteDto(item.getFrete());
    }
}
