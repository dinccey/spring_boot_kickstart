package ibmix.kickstart.bikeshop.repository.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@AllArgsConstructor
@Entity
@Table(name = "Receipt", schema = "public", catalog = "ibmix")
public class ReceiptModel {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Getter
    @Setter
    @Column(name="date_of_purchase", nullable = false)
    private Date dateOfPurchase;

    @Getter
    @Setter
    @ManyToMany
    @JoinTable(
            name = "receipt_bicycles",
            joinColumns = @JoinColumn(name = "receipt_id"),
            inverseJoinColumns = @JoinColumn(name = "bicycle_id"))
    private Set<BicycleModel> items;

    @Getter
    @Setter
    @Column(name = "price_total")
    private double priceTotal;

    public ReceiptModel() {

    }
}
