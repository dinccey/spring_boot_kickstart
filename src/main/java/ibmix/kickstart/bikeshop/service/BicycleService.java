package ibmix.kickstart.bikeshop.service;

import ibmix.kickstart.bikeshop.repository.entities.BicycleModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BicycleService {
    BicycleModel addBicycle(BicycleModel bicycle);

    List<BicycleModel> getAllBicycles();

    void deleteBicycle(Long id);

    BicycleModel updateBicycle(BicycleModel updatedBicycle);

    Optional<BicycleModel> getBicycleById(Long id);

    List<BicycleModel> getBicyclesByBrand(String brand);


}
