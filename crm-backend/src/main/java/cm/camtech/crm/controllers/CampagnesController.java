package cm.camtech.crm.controllers;

import cm.camtech.crm.dtos.CampagnesDto;
import cm.camtech.crm.services.interfaces.CampagnesInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/campagnes")
public class CampagnesController {

    private final CampagnesInterface campagnesInterface;

    public CampagnesController(CampagnesInterface campagnesInterface) {
        this.campagnesInterface = campagnesInterface;
    }

    @PostMapping
    public CampagnesDto save(@RequestBody CampagnesDto dto) {
        return campagnesInterface.save(dto);
    }

    @PutMapping("/{id}")
    public CampagnesDto update(@PathVariable Long id,
                               @RequestBody CampagnesDto dto) {
        return campagnesInterface.update(id, dto);
    }

    @GetMapping("/{id}")
    public CampagnesDto findById(@PathVariable Long id) {
        return campagnesInterface.findById(id);
    }

    @GetMapping
    public List<CampagnesDto> findAll() {
        return campagnesInterface.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        campagnesInterface.delete(id);
    }
}