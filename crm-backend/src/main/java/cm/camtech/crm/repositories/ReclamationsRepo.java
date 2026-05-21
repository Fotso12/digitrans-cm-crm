package cm.camtech.crm.repositories;

import cm.camtech.crm.entities.Reclamations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReclamationsRepo extends JpaRepository<Reclamations, Long> {
}