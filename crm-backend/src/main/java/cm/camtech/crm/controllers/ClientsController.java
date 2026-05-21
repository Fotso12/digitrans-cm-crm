package cm.camtech.crm.controllers;

import cm.camtech.crm.dtos.ClientsDto;
import cm.camtech.crm.services.interfaces.ClientsInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientsController {

    private final ClientsInterface clientsInterface;

    public ClientsController(ClientsInterface clientsInterface) {
        this.clientsInterface = clientsInterface;
    }

    @PostMapping
    public ClientsDto save(@RequestBody ClientsDto clientsDto) {
        return clientsInterface.save(clientsDto);
    }

    @PutMapping("/{id}")
    public ClientsDto update(@PathVariable Long id,
                             @RequestBody ClientsDto clientsDto) {
        return clientsInterface.update(id, clientsDto);
    }

    @GetMapping("/{id}")
    public ClientsDto findById(@PathVariable Long id) {
        return clientsInterface.findById(id);
    }

    @GetMapping
    public List<ClientsDto> findAll() {
        return clientsInterface.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        clientsInterface.delete(id);
    }
}