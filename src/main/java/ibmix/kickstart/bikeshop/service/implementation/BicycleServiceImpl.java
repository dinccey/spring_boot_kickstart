package ibmix.kickstart.bikeshop.service.implementation;

import ibmix.kickstart.bikeshop.repository.entities.BicycleModel;
import ibmix.kickstart.bikeshop.repository.entities.BrandModel;
import ibmix.kickstart.bikeshop.repository.BicycleRepository;
import ibmix.kickstart.bikeshop.service.BicycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Service
public class BicycleServiceImpl implements BicycleService{

    @Autowired
    private BicycleRepository bicycleRepository;

    @Autowired
    private EntityManager entityManager;

    public List<BicycleModel> getAllBicycles(){
        return bicycleRepository.findAll();
    }

    public BicycleModel addBicycle(final BicycleModel bicycle){
        BrandModel brand = entityManager.getReference(BrandModel.class, bicycle.getBrand().getName());
        bicycle.setBrand(brand);
        return bicycleRepository.save(bicycle);
    }

    public void deleteBicycle(final Long id){
        bicycleRepository.deleteById(id);
    }

    public Optional<BicycleModel> getBicycleById(final Long id){
        return bicycleRepository.findById(id);
    }
    public List<BicycleModel> getBicyclesByBrand(final String brandName){
        return bicycleRepository.findAllByBrand_Name(brandName);
    }

    public BicycleModel updateBicycle(final BicycleModel updatedBicycle) throws ResponseStatusException {
        Optional<BicycleModel> bicycle = bicycleRepository.findById(updatedBicycle.getId());
        if(bicycle.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_MODIFIED,
                    "Bicycle with id"+updatedBicycle.getId()+" does not exist in the database.\n");
        }
        return bicycleRepository.save(updatedBicycle);
    }
}
