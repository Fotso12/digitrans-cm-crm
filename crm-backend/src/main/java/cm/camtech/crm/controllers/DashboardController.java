package cm.camtech.crm.controllers;

import cm.camtech.crm.repositories.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {
    private final ClientsRepo clientsRepo;
    private final CommandesRepo commandesRepo;
    private final ProduitsRepo produitsRepo;
    private final ReclamationsRepo reclamationsRepo;
    private final CampagnesRepo campagnesRepo;
    private final UtilisateursRepo utilisateursRepo;
    private final RestaurantsRepo restaurantsRepo;

    public DashboardController(
            ClientsRepo clientsRepo,
            CommandesRepo commandesRepo,
            ProduitsRepo produitsRepo,
            ReclamationsRepo reclamationsRepo,
            CampagnesRepo campagnesRepo,
            UtilisateursRepo utilisateursRepo,
            RestaurantsRepo restaurantsRepo) {
        this.clientsRepo = clientsRepo;
        this.commandesRepo = commandesRepo;
        this.produitsRepo = produitsRepo;
        this.reclamationsRepo = reclamationsRepo;
        this.campagnesRepo = campagnesRepo;
        this.utilisateursRepo = utilisateursRepo;
        this.restaurantsRepo = restaurantsRepo;
    }

    @GetMapping("/stats")
    public Map<String, Long> getStats() {
        Map<String, Long> stats = new HashMap<>();
        stats.put("clients", clientsRepo.count());
        stats.put("commandes", commandesRepo.count());
        stats.put("produits", produitsRepo.count());
        stats.put("reclamations", reclamationsRepo.count());
        stats.put("campagnes", campagnesRepo.count());
        stats.put("utilisateurs", utilisateursRepo.count());
        stats.put("restaurants", restaurantsRepo.count());
        return stats;
    }
}
