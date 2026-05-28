package GuilhermeBuglioli555273.globalSolution.controller;

import GuilhermeBuglioli555273.globalSolution.Service.ItemService;
import GuilhermeBuglioli555273.globalSolution.dto.ItemDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/itens")
public class ItemController {

    @Autowired
    private ItemService ItemService;

    @GetMapping
    public ResponseEntity<List<ItemDto>> getAll() {

        List<ItemDto> dto = ItemService.findAllItems();

        return ResponseEntity.ok(dto);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemDto> getOne(@PathVariable Long id) {

        ItemDto dto = ItemService.findItemById(id);

        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ItemDto> saveItem(@Valid @RequestBody ItemDto dto) {
        dto = ItemService.saveItem(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(dto.getId())
                .toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemDto> updateItem(@PathVariable Long id, @Valid @RequestBody ItemDto dto) {

        dto = ItemService.updateItem(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        ItemService.deleteItemById(id);
        return ResponseEntity.noContent().build();
    }
}