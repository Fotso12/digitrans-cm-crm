package cm.camtech.crm.repositories;

import cm.camtech.crm.entities.Restaurants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantsRepo extends JpaRepository<Restaurants, Long> {
}