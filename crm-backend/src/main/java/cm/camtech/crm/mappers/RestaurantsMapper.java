package cm.camtech.crm.mappers;

import cm.camtech.crm.dtos.RestaurantsDto;
import cm.camtech.crm.entities.Restaurants;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RestaurantsMapper {

    RestaurantsDto toDto(Restaurants restaurants);

    Restaurants toEntity(RestaurantsDto restaurantsDto);
}