package ibmix.kickstart.bikeshop.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public interface StatisticsService {
    HashMap<String, Object> getStatistics();
}
