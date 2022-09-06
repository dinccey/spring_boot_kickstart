package ibmix.kickstart.bikeshop.data.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@AllArgsConstructor
@Entity
@Table(name = "Bicikl", schema = "public", catalog = "ibmix")
public class Bicikl {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Getter
    @Setter
    @Column(name="ime", length=50, nullable=false)
    private String ime;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "marka",referencedColumnName = "naziv")
    private Marka marka;

    @Getter
    @Setter
    @Column(name = "cijena",nullable = false)
    private double cijena;

    @Getter
    @Setter
    @Column(name = "boja", length = 20)
    private String boja;

    public Bicikl() {

    }
}
