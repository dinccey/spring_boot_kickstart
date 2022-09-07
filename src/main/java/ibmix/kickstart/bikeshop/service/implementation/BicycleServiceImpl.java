package ibmix.kickstart.bikeshop.service.implementation;

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

public class BicycleServiceImpl implements BicycleService{
    @Autowired
    BicycleRepository repository;
    @Autowired
    private EntityManager entityManager;

    public List<Bicycle> getAllBicycles(){
        return repository.findAll();
    }

    public Bicycle addBicycle(Bicycle bicycle){
        Brand brand = entityManager.getReference(Brand.class, bicycle.getBrand().getName());
        bicycle.setBrand(brand);
        return repository.save(bicycle);
    }

    public void deleteBicycle(Long id){
        repository.deleteById(id);
    }

    public Optional<Bicycle> getOneBicycle(Long id){
        return repository.findById(id);
    }
    public List<Bicycle> getBicyclesByBrand(String brandName){
        return repository.findAllByBrand_Name(brandName);
    }

    public Bicycle updateBicycle(Bicycle updatedBicycle) throws ResponseStatusException {
        Optional<Bicycle> bicycle = repository.findById(updatedBicycle.getId());
        if(bicycle.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_MODIFIED,
                    "Bicycle with id"+updatedBicycle.getId()+" does not exist in the database.\n");
        }
        return repository.save(updatedBicycle);
    }
}
