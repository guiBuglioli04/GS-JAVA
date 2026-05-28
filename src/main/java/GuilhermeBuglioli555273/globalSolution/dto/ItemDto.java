package GuilhermeBuglioli555273.globalSolution.dto;

import GuilhermeBuglioli555273.globalSolution.entities.Item;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
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

    @NotBlank(message = "Peso do item é obrigatório")
    @PositiveOrZero(message = "Peso precisa ser positivo e acima de 0")
    private Double peso;

    @NotBlank(message = "Volume do item é obrigatório")
    @PositiveOrZero(message = "Volume precisa ser positivo e acima de 0")
    private Double volume;

    @NotBlank(message = "Data de validade precisa ter uma data")
    @FutureOrPresent(message = "Data de validade não pode ser uma data passada")
    private LocalDate dataValidade;

    @NotBlank(message = "O campo frete é obrigatório")
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
