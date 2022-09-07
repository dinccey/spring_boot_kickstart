package ibmix.kickstart.bikeshop.service;

import ibmix.kickstart.bikeshop.repository.entities.BicycleModel;
import ibmix.kickstart.bikeshop.repository.entities.ReceiptModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
@Service
public interface ReceiptService {
    ReceiptModel purchaseBicycles(Set<BicycleModel> bicycles);

    List<ReceiptModel> getAllReceipts();
}
