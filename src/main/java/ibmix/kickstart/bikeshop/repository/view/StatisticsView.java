package ibmix.kickstart.bikeshop.repository.view;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class StatisticsView {
    @Getter
    @Setter
    private double soldBicyclesValueTotal;

    @Getter
    @Setter
    private List<Color> valuePartitionByColor;
}
