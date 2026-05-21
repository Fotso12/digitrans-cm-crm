package cm.camtech.crm.controllers;

import cm.camtech.crm.dtos.LignesCommandesDto;
import cm.camtech.crm.services.interfaces.LignesCommandesInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lignes-commandes")
public class LignesCommandesController {

    private final LignesCommandesInterface lignesCommandesInterface;

    public LignesCommandesController(LignesCommandesInterface lignesCommandesInterface) {
        this.lignesCommandesInterface = lignesCommandesInterface;
    }

    @PostMapping
    public LignesCommandesDto save(@RequestBody LignesCommandesDto dto) {
        return lignesCommandesInterface.save(dto);
    }

    @PutMapping("/{id}")
    public LignesCommandesDto update(@PathVariable Long id,
                                     @RequestBody LignesCommandesDto dto) {
        return lignesCommandesInterface.update(id, dto);
    }

    @GetMapping("/{id}")
    public LignesCommandesDto findById(@PathVariable Long id) {
        return lignesCommandesInterface.findById(id);
    }

    @GetMapping
    public List<LignesCommandesDto> findAll() {
        return lignesCommandesInterface.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        lignesCommandesInterface.delete(id);
    }
}