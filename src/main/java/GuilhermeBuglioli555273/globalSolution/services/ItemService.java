package GuilhermeBuglioli555273.globalSolution.services;

import GuilhermeBuglioli555273.globalSolution.entities.Frete;
import GuilhermeBuglioli555273.globalSolution.entities.Item;
import GuilhermeBuglioli555273.globalSolution.repositories.FreteRepository;
import GuilhermeBuglioli555273.globalSolution.repositories.ItemRepository;
import GuilhermeBuglioli555273.globalSolution.dtos.ItemDto;
import GuilhermeBuglioli555273.globalSolution.exceptions.DatabaseException;
import GuilhermeBuglioli555273.globalSolution.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class ItemService {
    @Autowired
    private ItemRepository repository;

    @Autowired
    private FreteRepository freteRepository;


    @Transactional(readOnly = true)
    public List<ItemDto> findAllItems() {

    return repository.findAll()
                .stream().map(ItemDto::new).toList();
    }

    @Transactional(readOnly = true)
    public ItemDto findItemById(Long id) {

        Item item = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado. ID: " + id)

        );

        return new ItemDto(item);
    }

    @Transactional
    public ItemDto saveItem(ItemDto inputDto) {

        Item Item = new Item();
        toDto(Item,inputDto);
        Item = repository.save(Item);
        return new ItemDto(Item);
    }
    @Transactional
    public ItemDto updateItem(Long id, ItemDto ItemDto) {

        try {
            Item Item = repository.getReferenceById(id);
            toDto(Item,ItemDto);
            Item = repository.save(Item);
            return new ItemDto(Item);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado. ID: " + id);

        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void deleteItemById(Long id) {

        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso nao encontrado. ID: " + id);
        }

        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(
                    "Não foi possivel excluir Item. Existem itens associadas a ele"
            );
        }
    }
    private void toDto(Item Item, ItemDto dto){
        Item.setPeso(dto.getPeso());
        Item.setNome(dto.getNome());
        Item.setVolume(dto.getVolume());
        Item.setDataValidade(dto.getDataValidade());

        Frete frete = freteRepository.getReferenceById(Item.getFrete().getId());
        Item.setFrete(frete);
    }
}
