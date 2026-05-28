package GuilhermeBuglioli555273.globalSolution.services;

import GuilhermeBuglioli555273.globalSolution.entities.Frete;
import GuilhermeBuglioli555273.globalSolution.repositories.FreteRepository;
import GuilhermeBuglioli555273.globalSolution.dto.FreteDto;
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
public class FreteService {
    @Autowired
    private FreteRepository repository;

    @Transactional(readOnly = true)
    public List<FreteDto> findAllFretes() {

        return repository.findAll()
                .stream().map(FreteDto::new).toList();
    }

    @Transactional(readOnly = true)
    public FreteDto findFreteById(Long id) {

        Frete restaurante = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado. ID: " + id)

        );

        return new FreteDto(restaurante);
    }

    @Transactional
    public FreteDto saveFrete(FreteDto inputDto) {

        Frete frete = new Frete();
        toDto(frete,inputDto);
        frete = repository.save(frete);
        return new FreteDto(frete);
    }
    @Transactional
    public FreteDto updateFrete(Long id, FreteDto freteDto) {

        try {
            Frete frete = repository.getReferenceById(id);
            toDto(frete,freteDto);
            frete = repository.save(frete);
            return new FreteDto(frete);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado. ID: " + id);

        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void deleteFreteById(Long id) {

        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso nao encontrado. ID: " + id);
        }

        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(
                    "Não foi possivel excluir Frete. Existem itens associadas a ele"
            );
        }
    }
    private void toDto(Frete frete, FreteDto dto){
        frete.setNaveFrete(dto.getNaveFrete());
        frete.setValor(dto.getValor());
        frete.setTempoViagem(dto.getTempoViagem());
        frete.setDataEnvio(dto.getDataEnvio());
    }
}
