package ibmix.kickstart.bikeshop.repository;

import ibmix.kickstart.bikeshop.repository.entities.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceiptRepository extends JpaRepository<Receipt,Long> {
}
