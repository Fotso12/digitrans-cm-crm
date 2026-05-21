package cm.camtech.crm.repositories;

import cm.camtech.crm.entities.CampagnesClients;
import cm.camtech.crm.entities.CampagnesClientsPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampagnesClientsRepo extends JpaRepository<CampagnesClients, CampagnesClientsPK> {
}