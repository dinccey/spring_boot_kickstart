package ibmix.kickstart.bikeshop.data.repositories;

import ibmix.kickstart.bikeshop.data.entities.Bicycle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BiciklRepository extends JpaRepository<Bicycle,Long> {
}
