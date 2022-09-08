package ibmix.kickstart.bikeshop.service.implementation;

import ibmix.kickstart.bikeshop.repository.ReceiptRepository;
import ibmix.kickstart.bikeshop.repository.entities.BicycleModel;
import ibmix.kickstart.bikeshop.repository.entities.ReceiptModel;
import ibmix.kickstart.bikeshop.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class ReceiptServiceImpl implements ReceiptService {

    @Autowired
    private ReceiptRepository receiptRepository;

    public ReceiptModel purchaseBicycles(final Set<BicycleModel> bicycles) {
        ReceiptModel receipt = new ReceiptModel();
        LocalDate dateOfPurchase = LocalDate.now();
        double totalPrice = bicycles.stream().mapToDouble(BicycleModel::getPrice).sum();

        receipt.setItems(bicycles);
        receipt.setPriceTotal(totalPrice);
        receipt.setDateOfPurchase(dateOfPurchase);

        return receiptRepository.save(receipt);
    }

    @Override
    public List<ReceiptModel> getAllReceipts() {
        return receiptRepository.findAll();
    }

    @Override
    public List<ReceiptModel> getReceiptsByDate(final LocalDate date) {
        return receiptRepository.findAllByDateOfPurchase(date);
    }
}
