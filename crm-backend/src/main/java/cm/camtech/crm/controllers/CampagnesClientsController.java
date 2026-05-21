package cm.camtech.crm.controllers;

import cm.camtech.crm.dtos.CampagnesClientsDto;
import cm.camtech.crm.services.interfaces.CampagnesClientsInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/campagnes-clients")
public class CampagnesClientsController {

    private final CampagnesClientsInterface campagnesClientsInterface;

    public CampagnesClientsController(CampagnesClientsInterface campagnesClientsInterface) {
        this.campagnesClientsInterface = campagnesClientsInterface;
    }

    @PostMapping
    public CampagnesClientsDto save(@RequestBody CampagnesClientsDto dto) {
        return campagnesClientsInterface.save(dto);
    }

    @GetMapping("/{campagneId}/{clientId}")
    public CampagnesClientsDto findById(@PathVariable Long campagneId,
                                        @PathVariable Long clientId) {
        return campagnesClientsInterface.findById(campagneId, clientId);
    }

    @GetMapping
    public List<CampagnesClientsDto> findAll() {
        return campagnesClientsInterface.findAll();
    }

    @DeleteMapping("/{campagneId}/{clientId}")
    public void delete(@PathVariable Long campagneId,
                       @PathVariable Long clientId) {
        campagnesClientsInterface.delete(campagneId, clientId);
    }
}