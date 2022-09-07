package ibmix.kickstart.bikeshop.service.implementation;

import ibmix.kickstart.bikeshop.repository.ReceiptRepository;
import ibmix.kickstart.bikeshop.repository.entities.BicycleModel;
import ibmix.kickstart.bikeshop.repository.entities.ReceiptModel;
import ibmix.kickstart.bikeshop.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Set;

@Service
public class ReceiptServiceImpl implements ReceiptService {
    @Autowired
    ReceiptRepository receiptRepository;

    public ReceiptModel purchaseBicycles(Set<BicycleModel> bicycles) {
        ReceiptModel receipt = new ReceiptModel();
        Date dateOfPurchase = new Date(System.currentTimeMillis());
        double totalPrice = bicycles.stream().mapToDouble(BicycleModel::getPrice).sum();

        receipt.setItems(bicycles);
        receipt.setPriceTotal(totalPrice);
        receipt.setDateOfPurchase(dateOfPurchase);

        return receiptRepository.save(receipt);
    }
}
