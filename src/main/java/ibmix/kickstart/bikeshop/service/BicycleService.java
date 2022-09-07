package ibmix.kickstart.bikeshop.service;

import ibmix.kickstart.bikeshop.repository.entities.Bicycle;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BicycleService {
    Bicycle addBicycle(Bicycle bicycle);

    List<Bicycle> getAllBicycles();

    void deleteBicycle(Long id);

    Bicycle updateBicycle(Bicycle updatedBicycle);

    Optional<Bicycle> getOneBicycle(Long id);

    List<Bicycle> getBicyclesByBrand(String brand);
}
