package ibmix.kickstart.bikeshop.service.implementation;

import ibmix.kickstart.bikeshop.repository.ReceiptRepository;
import ibmix.kickstart.bikeshop.repository.data.BrandStatisticsModel;
import ibmix.kickstart.bikeshop.repository.entities.BicycleModel;
import ibmix.kickstart.bikeshop.repository.entities.ReceiptModel;
import ibmix.kickstart.bikeshop.repository.data.ColorModel;
import ibmix.kickstart.bikeshop.repository.data.StatisticsViewModel;
import ibmix.kickstart.bikeshop.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.*;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    private ReceiptRepository receiptRepository;

    @Override
    public StatisticsViewModel getStatistics() {
        HashMap<String,Double> valuesByColor = new HashMap();
        HashMap<String,Double> valuesByBrand = new HashMap();
        StatisticsViewModel statisticsViewModel = new StatisticsViewModel();

        List<ReceiptModel> allReceipts = receiptRepository.findAll();
        double totalSoldValue = allReceipts.stream().mapToDouble(ReceiptModel::getPriceTotal).sum();

        getSoldValuePerUnit(valuesByColor, allReceipts,0);
        getSoldValuePerUnit(valuesByBrand, allReceipts,1);

        List<ColorModel> bicycleColorsValuePartition = new ArrayList<>();
        valuesByColor.forEach((key, value) -> bicycleColorsValuePartition.add(new ColorModel(key,calculateColorPercentage(value,totalSoldValue),value)));
        List<BrandStatisticsModel> bicycleBrandsValuePartition = new ArrayList<>();
        valuesByBrand.forEach((key, value) -> bicycleBrandsValuePartition.add(new BrandStatisticsModel(key,calculateColorPercentage(value,totalSoldValue),value)));

        statisticsViewModel.setSoldBicyclesValueTotal(totalSoldValue);
        statisticsViewModel.setValuePartitionByColor(bicycleColorsValuePartition);
        statisticsViewModel.setValuePartitionByBrand(bicycleBrandsValuePartition);
        return statisticsViewModel;
    }

    private static void getSoldValuePerUnit(final HashMap<String, Double> values, final List<ReceiptModel> allReceipts, final int mode) {
        Date date = new Date(System.currentTimeMillis());
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        for (ReceiptModel r: allReceipts) {
            calendar.setTime(r.getDateOfPurchase());
            if(calendar.get(Calendar.YEAR) == year){
                for (BicycleModel b:r.getItems()) {
                    String key = "";
                    if(mode == 0) key = b.getColor();
                    else if(mode == 1) key = b.getBrand().getName();
                    calculateValues(values, b, key);
                }
            }
        }
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
