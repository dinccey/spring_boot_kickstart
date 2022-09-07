package ibmix.kickstart.bikeshop.repository;

import ibmix.kickstart.bikeshop.repository.entities.BicycleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BicycleRepository extends JpaRepository<BicycleModel,Long> {
    List<BicycleModel> findAllByBrand_Name(String brandName);
}
