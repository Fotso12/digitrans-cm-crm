package cm.camtech.crm.repositories;

import cm.camtech.crm.entities.LignesCommandes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LignesCommandesRepo extends JpaRepository<LignesCommandes, Long> {
}