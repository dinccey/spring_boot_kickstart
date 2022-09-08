package ibmix.kickstart.bikeshop.service.implementation;

import ibmix.kickstart.bikeshop.repository.ReceiptRepository;
import ibmix.kickstart.bikeshop.repository.entities.BicycleModel;
import ibmix.kickstart.bikeshop.repository.entities.ReceiptModel;
import ibmix.kickstart.bikeshop.repository.data.ColorModel;
import ibmix.kickstart.bikeshop.repository.data.StatisticsViewModel;
import ibmix.kickstart.bikeshop.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    private ReceiptRepository receiptRepository;

    @Override
    public StatisticsViewModel getStatistics() {
        HashMap<String,Double> valuesByColor = new HashMap();
        StatisticsViewModel statisticsViewModel = new StatisticsViewModel();

        List<ReceiptModel> allReceipts = receiptRepository.findAll();
        double totalSoldValue = allReceipts.stream().mapToDouble(ReceiptModel::getPriceTotal).sum();
        statisticsViewModel.setSoldBicyclesValueTotal(totalSoldValue);
        getSoldValuePerColor(valuesByColor, allReceipts);
        List<ColorModel> bicycleColorsValuePartition = new ArrayList<>();
        valuesByColor.forEach((key, value) -> bicycleColorsValuePartition.add(new ColorModel(key,calculateColorPercentage(value,totalSoldValue),value)));
        statisticsViewModel.setValuePartitionByColorModel(bicycleColorsValuePartition);
        return statisticsViewModel;
    }

    private static void getSoldValuePerColor(HashMap<String, Double> valuesByColor, List<ReceiptModel> allReceipts) {
        for (ReceiptModel r: allReceipts) {
            for (BicycleModel b:r.getItems()) {
                if(valuesByColor.containsKey(b.getColor())){
                    double priceValue = valuesByColor.get(b.getColor());
                    valuesByColor.put(b.getColor(), priceValue + b.getPrice());
                } else{
                    valuesByColor.put(b.getColor(), b.getPrice());
                }
            }
        }
    }

    private double calculateColorPercentage(final double colorTotal, final double total){
        return (colorTotal / total)*100;
    }
}
