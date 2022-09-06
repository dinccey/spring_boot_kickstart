package ibmix.kickstart.bikeshop.data.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@AllArgsConstructor
@Entity
@Table(name = "Marka", schema = "public", catalog = "ibmix")
public class Marka {

    @Getter
    @Setter
    @Id
    @Column(name = "naziv", nullable = false, length = 20)
    private String naziv;

    @Getter
    @Setter
    @Column(name="opis",length = 500)
    private String opis;

    @Getter
    @Setter
    @Column(name="web",length = 100)
    private String web;

    public Marka() {

    }
}
