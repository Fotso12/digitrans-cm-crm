package cm.camtech.crm.controllers;

import cm.camtech.crm.dtos.ProduitsDto;
import cm.camtech.crm.services.interfaces.ProduitsInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produits")
public class ProduitsController {

    private final ProduitsInterface produitsInterface;

    public ProduitsController(ProduitsInterface produitsInterface) {
        this.produitsInterface = produitsInterface;
    }

    @PostMapping
    public ProduitsDto save(@RequestBody ProduitsDto produitsDto) {
        return produitsInterface.save(produitsDto);
    }

    @PutMapping("/{id}")
    public ProduitsDto update(@PathVariable Long id,
                              @RequestBody ProduitsDto produitsDto) {
        return produitsInterface.update(id, produitsDto);
    }

    @GetMapping("/{id}")
    public ProduitsDto findById(@PathVariable Long id) {
        return produitsInterface.findById(id);
    }

    @GetMapping
    public List<ProduitsDto> findAll() {
        return produitsInterface.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        produitsInterface.delete(id);
    }
}