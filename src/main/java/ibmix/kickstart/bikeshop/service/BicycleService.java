package ibmix.kickstart.bikeshop.service;

import ibmix.kickstart.bikeshop.repository.entities.Bicycle;
import ibmix.kickstart.bikeshop.repository.entities.Receipt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public interface BicycleService {
    Bicycle addBicycle(Bicycle bicycle);

    List<Bicycle> getAllBicycles();

    void deleteBicycle(Long id);

    Bicycle updateBicycle(Bicycle updatedBicycle);

    Optional<Bicycle> getBicycleById(Long id);

    List<Bicycle> getBicyclesByBrand(String brand);

    Receipt purchaseBicycles(Set<Bicycle> bicycles);
}
