package ibmix.kickstart.bikeshop.service.implementation;

import ibmix.kickstart.bikeshop.repository.ReceiptRepository;
import ibmix.kickstart.bikeshop.repository.entities.BicycleModel;
import ibmix.kickstart.bikeshop.repository.entities.ReceiptModel;
import ibmix.kickstart.bikeshop.repository.view.Color;
import ibmix.kickstart.bikeshop.repository.view.StatisticsView;
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
    public StatisticsView getStatistics() {
        HashMap valuesByColor = new HashMap();
        StatisticsView statisticsView = new StatisticsView();
        List<Color> bicycleColorsValuePartition = new ArrayList<>();
        List<ReceiptModel> allReceipts = receiptRepository.findAll();
        double totalSoldValue = allReceipts.stream().mapToDouble(ReceiptModel::getPriceTotal).sum();
        statisticsView.setSoldBicyclesValueTotal(totalSoldValue);
        for (ReceiptModel r: allReceipts) {
            for (BicycleModel b:r.getItems()) {

            }
        }


        return  statisticsView;
    }

    private double calculateColorPercentage(final double colorTotal, final double total){
        return colorTotal / total;
    }
}
