package ibmix.kickstart.bikeshop.rest;

import ibmix.kickstart.bikeshop.repository.data.StatisticsViewModel;
import ibmix.kickstart.bikeshop.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @GetMapping(value = "/statistics",produces = "application/json")
    public StatisticsViewModel getStatistics(){
        return statisticsService.getStatistics();
    }
}
