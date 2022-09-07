package ibmix.kickstart.bikeshop.data.repositories;

import ibmix.kickstart.bikeshop.data.entities.Bicycle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BicycleRepository extends JpaRepository<Bicycle,Long> {
    @Query("SELECT b FROM Bicycle b WHERE b.brand.name = ?1")
    List<Bicycle> bicyclesByBrand(final String brandName);
}
