package ibmix.kickstart.bikeshop.repository.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@AllArgsConstructor
@Entity
@Table(name = "Bicycle", schema = "public", catalog = "ibmix")
public class BicycleModel {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Getter
    @Setter
    @Column(name="name", length=50, nullable=false)
    private String name;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "brand",referencedColumnName = "name")
    private BrandModel brand;

    @Getter
    @Setter
    @Column(name = "price",nullable = false)
    private double price;

    @Getter
    @Setter
    @Column(name = "color", length = 20)
    private String color;

    public BicycleModel() {

    }
}
