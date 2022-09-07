package ibmix.kickstart.bikeshop.rest;

import ibmix.kickstart.bikeshop.data.entities.Bicycle;
import ibmix.kickstart.bikeshop.data.entities.Brand;
import ibmix.kickstart.bikeshop.data.repositories.BicycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@RestController
public class BicycleController {

    @Autowired
    private BicycleRepository bicycleRepository;

    @Autowired
    private EntityManager entityManager;

    @PostMapping(value="/bicycles",consumes = "application/json", produces = "application/json")
    public Bicycle newBicycle(@RequestBody final Bicycle bicycle){
        Brand brand = entityManager.getReference(Brand.class, bicycle.getBrand().getName());
        bicycle.setBrand(brand);
        return bicycleRepository.save(bicycle);
    }

    @GetMapping(value = "/bicycles",produces = "application/json")
    public @ResponseBody List<Bicycle> getAllBicycles(){
        return bicycleRepository.findAll();
    }

    @DeleteMapping(value = "/bicycles/{id}")
    public void deleteBicycle(@PathVariable final Long id){
        bicycleRepository.deleteById(id);
    }
    @PutMapping(value = "/bicycles")
    public Bicycle updateBicycle(@RequestBody final Bicycle updatedBicycle){
        Optional<Bicycle> bicycle = bicycleRepository.findById(updatedBicycle.getId());
        if(bicycle.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_MODIFIED,
                    "Bicycle with id"+updatedBicycle.getId()+" does not exist in the database.\n");
        }
        return bicycleRepository.save(updatedBicycle);
    }
    @GetMapping(value = "/bicycles/{id}")
    public Optional<Bicycle> getBicycle(@PathVariable final Long id){
        return bicycleRepository.findById(id);
    }

}
