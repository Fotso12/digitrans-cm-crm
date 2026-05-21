package cm.camtech.crm.controllers;

import cm.camtech.crm.dtos.CommandesDto;
import cm.camtech.crm.services.interfaces.CommandesInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commandes")
public class CommandesController {

    private final CommandesInterface commandesInterface;

    public CommandesController(CommandesInterface commandesInterface) {
        this.commandesInterface = commandesInterface;
    }

    @PostMapping
    public CommandesDto save(@RequestBody CommandesDto commandesDto) {
        return commandesInterface.save(commandesDto);
    }

    @PutMapping("/{id}")
    public CommandesDto update(@PathVariable Long id,
                               @RequestBody CommandesDto commandesDto) {
        return commandesInterface.update(id, commandesDto);
    }

    @GetMapping("/{id}")
    public CommandesDto findById(@PathVariable Long id) {
        return commandesInterface.findById(id);
    }

    @GetMapping
    public List<CommandesDto> findAll() {
        return commandesInterface.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        commandesInterface.delete(id);
    }
}