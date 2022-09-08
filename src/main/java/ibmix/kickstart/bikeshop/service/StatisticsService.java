package ibmix.kickstart.bikeshop.service;

import ibmix.kickstart.bikeshop.repository.data.StatisticsViewModel;
import org.springframework.stereotype.Service;

@Service
public interface StatisticsService {
    StatisticsViewModel getStatistics();
}
