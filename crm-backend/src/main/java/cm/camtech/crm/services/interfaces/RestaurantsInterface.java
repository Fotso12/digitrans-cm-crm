package cm.camtech.crm.services.interfaces;

import cm.camtech.crm.dtos.RestaurantsDto;
import cm.camtech.crm.entities.Restaurants;

import java.util.List;

public interface RestaurantsInterface {

    RestaurantsDto save(RestaurantsDto restaurantsDto);

    RestaurantsDto update(Long id, RestaurantsDto restaurantsDto);

    RestaurantsDto findById(Long id);

    List<RestaurantsDto> findAll();

    void delete(Long id);

    RestaurantsDto saveRestaurant(RestaurantsDto restaurantsDto);

    void deleteRestaurant(long l);

    List<Restaurants> getAllRestaurants();

    Restaurants getRestaurantById(long l);
}