package cm.camtech.crm.servicesTest;

import cm.camtech.crm.dtos.RestaurantsDto;
import cm.camtech.crm.entities.Restaurants;
import cm.camtech.crm.mappers.RestaurantsMapper;
import cm.camtech.crm.repositories.RestaurantsRepo;
import cm.camtech.crm.services.implementations.RestaurantsService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RestaurantsServiceTest {

    @Mock
    private RestaurantsRepo restaurantsRepo;

    @Mock
    private RestaurantsMapper restaurantsMapper;

    @InjectMocks
    private RestaurantsService restaurantsService;

    private Restaurants restaurants;
    private RestaurantsDto restaurantsDto;

    @BeforeEach
    void setUp() {

        restaurants = new Restaurants();
        restaurants.setId(1L);

        restaurantsDto = new RestaurantsDto();
        restaurantsDto.setId(1L);
    }

    @Test
    void testGetAllRestaurants() {

        List<Restaurants> liste = new ArrayList<>();
        liste.add(restaurants);

        when(restaurantsRepo.findAll()).thenReturn(liste);

        List<Restaurants> resultat = restaurantsService.getAllRestaurants();

        assertNotNull(resultat);
        assertEquals(1, resultat.size());

        verify(restaurantsRepo, times(1)).findAll();
    }

    @Test
    void testGetRestaurantById() {

        when(restaurantsRepo.findById(1L)).thenReturn(Optional.of(restaurants));

        Restaurants resultat = restaurantsService.getRestaurantById(1L);

        assertNotNull(resultat);

        verify(restaurantsRepo, times(1)).findById(1L);
    }

    @Test
    void testSaveRestaurant() {

        when(restaurantsMapper.toEntity(restaurantsDto)).thenReturn(restaurants);
        when(restaurantsRepo.save(restaurants)).thenReturn(restaurants);
        when(restaurantsMapper.toDto(restaurants)).thenReturn(restaurantsDto);

        RestaurantsDto resultat = restaurantsService.saveRestaurant(restaurantsDto);

        assertNotNull(resultat);

        verify(restaurantsRepo, times(1)).save(restaurants);
    }

    @Test
    void testDeleteRestaurant() {

        doNothing().when(restaurantsRepo).deleteById(1L);

        restaurantsService.deleteRestaurant(1L);

        verify(restaurantsRepo, times(1)).deleteById(1L);
    }
}