package ibmix.kickstart.bikeshop.service.implementation;

import ibmix.kickstart.bikeshop.repository.ReceiptRepository;
import ibmix.kickstart.bikeshop.repository.entities.Bicycle;
import ibmix.kickstart.bikeshop.repository.entities.Receipt;
import ibmix.kickstart.bikeshop.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Set;

@Service
public class ReceiptServiceImpl implements ReceiptService {
    @Autowired
    ReceiptRepository receiptRepository;

    public Receipt purchaseBicycles(Set<Bicycle> bicycles) {
        Receipt receipt = new Receipt();
        Date dateOfPurchase = new Date(System.currentTimeMillis());
        double totalPrice = bicycles.stream().mapToDouble(Bicycle::getPrice).sum();

        receipt.setItems(bicycles);
        receipt.setPriceTotal(totalPrice);
        receipt.setDateOfPurchase(dateOfPurchase);

        return receiptRepository.save(receipt);
    }
}
