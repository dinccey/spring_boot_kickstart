package ibmix.kickstart.bikeshop.repository;

import ibmix.kickstart.bikeshop.repository.entities.ReceiptModel;
import org.springframework.data.jpa.repository.JpaRepository;


import java.time.LocalDate;
import java.util.List;

public interface ReceiptRepository extends JpaRepository<ReceiptModel,Long> {
    List<ReceiptModel> findAllByDateOfPurchase(LocalDate date);
}
