package ibmix.kickstart.bikeshop.rest;

import ibmix.kickstart.bikeshop.repository.entities.ReceiptModel;
import ibmix.kickstart.bikeshop.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class ReceiptController {

    @Autowired
    private ReceiptService receiptService;

    @GetMapping(value = "/receipts", produces = "application/json")
    public List<ReceiptModel> getAllReceipts(){
        return receiptService.getAllReceipts();
    }

    @GetMapping(value = "receipts/date/{date}",produces = "application/json")
    public List<ReceiptModel> getReceiptsByDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                   final LocalDate date){
        return receiptService.getReceiptsByDate(date);
    }
}
