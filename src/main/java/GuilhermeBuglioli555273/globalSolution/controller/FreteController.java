package GuilhermeBuglioli555273.globalSolution.controller;

import GuilhermeBuglioli555273.globalSolution.Service.FreteService;
import GuilhermeBuglioli555273.globalSolution.dto.FreteDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/restaurantes")
public class FreteController {

    @Autowired
    private FreteService freteService;

    @GetMapping
    public ResponseEntity<List<FreteDto>> getAll() {

        List<FreteDto> dto = freteService.findAllFretes();

        return ResponseEntity.ok(dto);

    }

    @GetMapping("/{id}")
    public ResponseEntity<FreteDto> getOne(@PathVariable Long id) {

        FreteDto dto = freteService.findFreteById(id);

        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<FreteDto> saveRestaurante(@Valid @RequestBody FreteDto dto) {
        dto = freteService.saveFrete(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(dto.getId())
                .toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FreteDto> updateRestaurante(@PathVariable Long id, @Valid @RequestBody FreteDto dto) {

        dto = freteService.updateFrete(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurante(@PathVariable Long id) {
        freteService.deleteFreteById(id);
        return ResponseEntity.noContent().build();
    }

}