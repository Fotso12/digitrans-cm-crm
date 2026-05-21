package cm.camtech.crm.repositories;

import cm.camtech.crm.entities.Commandes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandesRepo extends JpaRepository<Commandes, Long> {
}