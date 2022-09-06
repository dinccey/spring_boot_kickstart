package ibmix.kickstart.bikeshop.rest;

import ibmix.kickstart.bikeshop.data.entities.Bicycle;
import ibmix.kickstart.bikeshop.data.entities.Brand;
import ibmix.kickstart.bikeshop.data.repositories.BiciklRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;

@RestController
public class BiciklController {

    @Autowired
    BiciklRepository biciklRepository;

    @Autowired
    EntityManager entityManager;

    @PostMapping(value="/bicycles",consumes = "application/json", produces = "application/json")
    public Bicycle newBicycle(@RequestBody Bicycle bicycle){
        Brand brand = entityManager.getReference(Brand.class, bicycle.getBrand().getName());
        bicycle.setBrand(brand);
        return biciklRepository.save(bicycle);
    }
}
