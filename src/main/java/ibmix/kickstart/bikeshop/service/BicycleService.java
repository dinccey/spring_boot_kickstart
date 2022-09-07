package ibmix.kickstart.bikeshop.service;

import ibmix.kickstart.bikeshop.data.entities.Bicycle;
import ibmix.kickstart.bikeshop.data.entities.Brand;
import ibmix.kickstart.bikeshop.data.repositories.BicycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
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
