package ibmix.kickstart.bikeshop.rest;

import ibmix.kickstart.bikeshop.data.entities.Bicycle;
import ibmix.kickstart.bikeshop.data.entities.Brand;
import ibmix.kickstart.bikeshop.data.repositories.BicycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.List;

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
}
