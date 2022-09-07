package ibmix.kickstart.bikeshop.service;

import ibmix.kickstart.bikeshop.repository.view.StatisticsView;
import org.springframework.stereotype.Service;

@Service
public interface StatisticsService {
    StatisticsView getStatistics();
}
