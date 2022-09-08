package ibmix.kickstart.bikeshop.service.implementation;

import ibmix.kickstart.bikeshop.repository.ReceiptRepository;
import ibmix.kickstart.bikeshop.repository.entities.BicycleModel;
import ibmix.kickstart.bikeshop.repository.entities.ReceiptModel;
import ibmix.kickstart.bikeshop.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    private ReceiptRepository receiptRepository;

    @Override
    public HashMap<String, Object> getStatistics() {
        HashMap<String,Double> valuesByColor = new HashMap();
        HashMap<String,Double> valuesByBrand = new HashMap();
        HashMap<String, Object> statisticsView = new HashMap<>();

        List<ReceiptModel> allReceipts = receiptRepository.findAll();
        double totalSoldValue = allReceipts.stream().mapToDouble(ReceiptModel::getPriceTotal).sum();

        getSoldValuePerUnit_Color(valuesByColor, allReceipts);
        getSoldValuePerUnit_Brand(valuesByBrand, allReceipts);

        valuesByColor.forEach((key,value)->valuesByColor.put(key,calculateColorPercentage(value,totalSoldValue)));
        valuesByBrand.forEach((key,value)->valuesByBrand.put(key,calculateColorPercentage(value,totalSoldValue)));

        statisticsView.put("totalSoldValue",totalSoldValue);
        statisticsView.put("partByColor",valuesByColor);
        statisticsView.put("partByBrand",valuesByBrand);

        return statisticsView;
    }

    private static void getSoldValuePerUnit_Brand(final HashMap<String, Double> values, final List<ReceiptModel> allReceipts) {
        allReceipts.forEach((r)->{
            if(r.getDateOfPurchase().getYear() == LocalDate.now().getYear()){
                r.getItems().forEach((b)->{
                    String key = b.getBrand().getName();
                    calculateValues(values, b, key);
                });
            }
        });
    }

    private static void getSoldValuePerUnit_Color(final HashMap<String, Double> values, final List<ReceiptModel> allReceipts) {
        allReceipts.forEach((r)->{
            if(r.getDateOfPurchase().getYear() == LocalDate.now().getYear()){
                r.getItems().forEach((b)->{
                    String key = b.getColor();
                    calculateValues(values, b, key);
                });
            }
        });
    }

    private static void calculateValues(final HashMap<String, Double> values,final BicycleModel b, final String key) {
        if(values.containsKey(key)){
            double priceValue = values.get(key);
            values.put(key, priceValue + b.getPrice());
        } else{
            values.put(key, b.getPrice());
        }
    }

    private double calculateColorPercentage(final double colorTotal, final double total){
        return (colorTotal / total)*100;
    }
}
