package ibmix.kickstart.bikeshop.rest;

import ibmix.kickstart.bikeshop.repository.entities.ReceiptModel;
import ibmix.kickstart.bikeshop.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReceiptController {

    @Autowired
    private ReceiptService receiptService;

    @GetMapping(value = "/receipts", produces = "application/json")
    public List<ReceiptModel> getAllReceipts(){
        return receiptService.getAllReceipts();
    }
}
