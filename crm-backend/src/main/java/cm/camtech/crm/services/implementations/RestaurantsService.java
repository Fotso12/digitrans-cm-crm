package cm.camtech.crm.services.implementations;

import cm.camtech.crm.dtos.RestaurantsDto;
import cm.camtech.crm.entities.Restaurants;
import cm.camtech.crm.mappers.RestaurantsMapper;
import cm.camtech.crm.repositories.RestaurantsRepo;
import cm.camtech.crm.services.interfaces.RestaurantsInterface;
import cm.camtech.crm.exceptions.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantsService implements RestaurantsInterface {

    private final RestaurantsRepo restaurantsRepo;
    private final RestaurantsMapper restaurantsMapper;

    public RestaurantsService(RestaurantsRepo restaurantsRepo,
                              RestaurantsMapper restaurantsMapper) {
        this.restaurantsRepo = restaurantsRepo;
        this.restaurantsMapper = restaurantsMapper;
    }

    @Override
    public RestaurantsDto save(RestaurantsDto restaurantsDto) {

        if (restaurantsDto == null) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Données de restaurant invalides");
        }

        Restaurants restaurants = restaurantsMapper.toEntity(restaurantsDto);

        return restaurantsMapper.toDto(
                restaurantsRepo.save(restaurants)
        );
    }

    @Override
    public RestaurantsDto update(Long id, RestaurantsDto restaurantsDto) {

        if (id == null) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Identifiant de restaurant invalide");
        }
        if (!restaurantsRepo.existsById(id)) {
            throw new ApiException(HttpStatus.NOT_FOUND, "Restaurant introuvable");
        }

        Restaurants restaurants = restaurantsMapper.toEntity(restaurantsDto);

        restaurants.setId(id);

        return restaurantsMapper.toDto(
                restaurantsRepo.save(restaurants)
        );
    }

    @Override
    public RestaurantsDto findById(Long id) {

        if (id == null) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Identifiant de restaurant invalide");
        }

        return restaurantsRepo.findById(id)
                .map(restaurantsMapper::toDto)
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "Restaurant introuvable"));
    }

    @Override
    public List<RestaurantsDto> findAll() {

        return restaurantsRepo.findAll()
                .stream()
                .map(restaurantsMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {

        if (id == null) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Identifiant de restaurant invalide");
        }
        if (!restaurantsRepo.existsById(id)) {
            throw new ApiException(HttpStatus.NOT_FOUND, "Restaurant introuvable");
        }

        restaurantsRepo.deleteById(id);
    }
   
    @Override
    public RestaurantsDto saveRestaurant(RestaurantsDto restaurantsDto) {
        return save(restaurantsDto);
    }

    @Override
    public void deleteRestaurant(long l) {
        delete(l);
    }

    @Override
    public java.util.List<Restaurants> getAllRestaurants() {
        return restaurantsRepo.findAll();
    }

    @Override
    public Restaurants getRestaurantById(long l) {
        return restaurantsRepo.findById(l)
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "Restaurant introuvable"));
    }
}