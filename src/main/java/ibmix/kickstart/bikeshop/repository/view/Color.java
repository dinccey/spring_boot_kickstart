package ibmix.kickstart.bikeshop.repository.view;

import lombok.Getter;
import lombok.Setter;

public class Color {
    @Getter
    @Setter
    private String color;

    @Getter
    @Setter
    private double percentageInRelationToTotalValue;

    @Getter
    @Setter
    private double colorValueSum;
}
