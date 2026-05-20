package cm.camtech.crm.services.interfaces;

import cm.camtech.crm.dtos.RestaurantsDto;

import java.util.List;

public interface RestaurantsInterface {

    RestaurantsDto save(RestaurantsDto restaurantsDto);

    RestaurantsDto update(Long id, RestaurantsDto restaurantsDto);

    RestaurantsDto findById(Long id);

    List<RestaurantsDto> findAll();

    void delete(Long id);
}