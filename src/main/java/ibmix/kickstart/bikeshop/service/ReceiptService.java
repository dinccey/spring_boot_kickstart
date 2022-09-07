package ibmix.kickstart.bikeshop.service;

import ibmix.kickstart.bikeshop.repository.entities.Bicycle;
import ibmix.kickstart.bikeshop.repository.entities.Receipt;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public interface ReceiptService {
    Receipt purchaseBicycles(Set<Bicycle> bicycles);
}
