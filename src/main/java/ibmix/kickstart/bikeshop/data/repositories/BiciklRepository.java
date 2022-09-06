package ibmix.kickstart.bikeshop.data.repositories;

import ibmix.kickstart.bikeshop.data.entities.Bicikl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BiciklRepository extends JpaRepository<Bicikl,Long> {
}
