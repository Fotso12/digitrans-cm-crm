package cm.camtech.crm.controllers;

import cm.camtech.crm.dtos.ReclamationsDto;
import cm.camtech.crm.services.interfaces.ReclamationsInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reclamations")
public class ReclamationsController {

    private final ReclamationsInterface reclamationsInterface;

    public ReclamationsController(ReclamationsInterface reclamationsInterface) {
        this.reclamationsInterface = reclamationsInterface;
    }

    @PostMapping
    public ReclamationsDto save(@RequestBody ReclamationsDto reclamationsDto) {
        return reclamationsInterface.save(reclamationsDto);
    }

    @PutMapping("/{id}")
    public ReclamationsDto update(@PathVariable Long id,
                                  @RequestBody ReclamationsDto reclamationsDto) {
        return reclamationsInterface.update(id, reclamationsDto);
    }

    @GetMapping("/{id}")
    public ReclamationsDto findById(@PathVariable Long id) {
        return reclamationsInterface.findById(id);
    }

    @GetMapping
    public List<ReclamationsDto> findAll() {
        return reclamationsInterface.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        reclamationsInterface.delete(id);
    }
}