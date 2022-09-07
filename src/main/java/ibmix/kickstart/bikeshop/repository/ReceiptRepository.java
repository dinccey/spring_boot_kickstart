package ibmix.kickstart.bikeshop.repository;

import ibmix.kickstart.bikeshop.repository.entities.ReceiptModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceiptRepository extends JpaRepository<ReceiptModel,Long> {
}
