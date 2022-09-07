package ibmix.kickstart.bikeshop.data.repositories;

import ibmix.kickstart.bikeshop.data.entities.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceiptRepository extends JpaRepository<Receipt,Long> {
}
