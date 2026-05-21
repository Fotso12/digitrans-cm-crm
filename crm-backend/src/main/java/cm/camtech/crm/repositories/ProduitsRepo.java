package cm.camtech.crm.repositories;

import cm.camtech.crm.entities.Produits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitsRepo extends JpaRepository<Produits, Long> {
}