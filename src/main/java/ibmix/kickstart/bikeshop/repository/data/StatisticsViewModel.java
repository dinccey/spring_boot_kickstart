package ibmix.kickstart.bikeshop.repository.data;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class StatisticsViewModel {
    @Getter
    @Setter
    private double soldBicyclesValueTotal;

    @Getter
    @Setter
    private List<ColorModel> valuePartitionByColorModel;
}
