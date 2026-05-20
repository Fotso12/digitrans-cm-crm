package cm.camtech.crm.controllers;

import cm.camtech.crm.dtos.UtilisateursDto;
import cm.camtech.crm.services.interfaces.UtilisateursInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateursController {

    private final UtilisateursInterface utilisateursInterface;

    public UtilisateursController(UtilisateursInterface utilisateursInterface) {
        this.utilisateursInterface = utilisateursInterface;
    }

    @PostMapping
    public UtilisateursDto save(@RequestBody UtilisateursDto utilisateursDto) {
        return utilisateursInterface.save(utilisateursDto);
    }

    @PutMapping("/{id}")
    public UtilisateursDto update(@PathVariable Long id,
                                  @RequestBody UtilisateursDto utilisateursDto) {
        return utilisateursInterface.update(id, utilisateursDto);
    }

    @GetMapping("/{id}")
    public UtilisateursDto findById(@PathVariable Long id) {
        return utilisateursInterface.findById(id);
    }

    @GetMapping
    public List<UtilisateursDto> findAll() {
        return utilisateursInterface.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        utilisateursInterface.delete(id);
    }
}