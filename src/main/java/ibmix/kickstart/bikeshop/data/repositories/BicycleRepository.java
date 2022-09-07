package ibmix.kickstart.bikeshop.data.repositories;

import ibmix.kickstart.bikeshop.data.entities.Bicycle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BicycleRepository extends JpaRepository<Bicycle,Long> {
    List<Bicycle> findAllByBrand_Name(String brandName);
}
