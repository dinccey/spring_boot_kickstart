package ibmix.kickstart.bikeshop.repository.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class ColorModel {
    @Getter
    @Setter
    private String color;

    @Getter
    @Setter
    private double percentageInRelationToTotalValue;

    @Getter
    @Setter
    private double colorValueSum;

    public ColorModel() {}
}
