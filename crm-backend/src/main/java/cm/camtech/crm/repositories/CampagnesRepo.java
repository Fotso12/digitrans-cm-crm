package cm.camtech.crm.repositories;

import cm.camtech.crm.entities.Campagnes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampagnesRepo extends JpaRepository<Campagnes, Long> {
}