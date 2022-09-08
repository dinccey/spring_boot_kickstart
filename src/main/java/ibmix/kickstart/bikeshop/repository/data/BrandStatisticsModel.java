package ibmix.kickstart.bikeshop.repository.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class BrandStatisticsModel {
    @Getter
    @Setter
    private String brand;

    @Getter
    @Setter
    private double percentageInRelationToTotalValue;

    @Getter
    @Setter
    private double colorValueSum;

    public BrandStatisticsModel() {}
}
