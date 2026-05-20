package cm.camtech.crm.services.implementations;

import cm.camtech.crm.dtos.RestaurantsDto;
import cm.camtech.crm.entities.Restaurants;
import cm.camtech.crm.mappers.RestaurantsMapper;
import cm.camtech.crm.repositories.RestaurantsRepo;
import cm.camtech.crm.services.interfaces.RestaurantsInterface;
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

        Restaurants restaurants = restaurantsMapper.toEntity(restaurantsDto);

        return restaurantsMapper.toDto(
                restaurantsRepo.save(restaurants)
        );
    }

    @Override
    public RestaurantsDto update(Long id, RestaurantsDto restaurantsDto) {

        Restaurants restaurants = restaurantsMapper.toEntity(restaurantsDto);

        restaurants.setId(id);

        return restaurantsMapper.toDto(
                restaurantsRepo.save(restaurants)
        );
    }

    @Override
    public RestaurantsDto findById(Long id) {

        return restaurantsRepo.findById(id)
                .map(restaurantsMapper::toDto)
                .orElse(null);
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

        restaurantsRepo.deleteById(id);
    }
}