package ibmix.kickstart.bikeshop.rest;

import ibmix.kickstart.bikeshop.data.entities.Bicycle;
import ibmix.kickstart.bikeshop.data.entities.Brand;
import ibmix.kickstart.bikeshop.data.repositories.BicycleRepository;
import ibmix.kickstart.bikeshop.service.BicycleService;
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
    private BicycleService bicycleService;

    @PostMapping(value="/bicycles",consumes = "application/json", produces = "application/json")
    public Bicycle newBicycle(@RequestBody final Bicycle bicycle){
        return bicycleService.addBicycle(bicycle);
    }

    @GetMapping(value = "/bicycles",produces = "application/json")
    public @ResponseBody List<Bicycle> getAllBicycles(){
        return bicycleService.getAllBicycles();
    }

    @DeleteMapping(value = "/bicycles/{id}")
    public void deleteBicycle(@PathVariable final Long id){
        bicycleService.deleteBicycle(id);
    }
    @PutMapping(value = "/bicycles")
    public Bicycle updateBicycle(@RequestBody final Bicycle updatedBicycle){
        return bicycleService.updateBicycle(updatedBicycle);
    }
    @GetMapping(value = "/bicycles/{id}")
    public Optional<Bicycle> getBicycle(@PathVariable final Long id){
        return bicycleService.getOneBicycle(id);
    }

    @GetMapping(value="/bicycles/brand/{brand}")
    public List<Bicycle> getBicyclesByBrand(@PathVariable final String brand){
        return bicycleService.getBicyclesByBrand(brand);
    }



}
