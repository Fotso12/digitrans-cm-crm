package cm.camtech.crm.controllers;

import cm.camtech.crm.dtos.RestaurantsDto;
import cm.camtech.crm.services.interfaces.RestaurantsInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantsController {

    private final RestaurantsInterface restaurantsInterface;

    public RestaurantsController(RestaurantsInterface restaurantsInterface) {
        this.restaurantsInterface = restaurantsInterface;
    }

    @PostMapping
    public RestaurantsDto save(@RequestBody RestaurantsDto restaurantsDto) {
        return restaurantsInterface.save(restaurantsDto);
    }

    @PutMapping("/{id}")
    public RestaurantsDto update(@PathVariable Long id,
                                 @RequestBody RestaurantsDto restaurantsDto) {
        return restaurantsInterface.update(id, restaurantsDto);
    }

    @GetMapping("/{id}")
    public RestaurantsDto findById(@PathVariable Long id) {
        return restaurantsInterface.findById(id);
    }

    @GetMapping
    public List<RestaurantsDto> findAll() {
        return restaurantsInterface.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        restaurantsInterface.delete(id);
    }
}