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
@Table(name = "Brand", schema = "public", catalog = "ibmix")
public class Brand {

    @Getter
    @Setter
    @Id
    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Getter
    @Setter
    @Column(name="description",length = 500)
    private String description;

    @Getter
    @Setter
    @Column(name="web",length = 100)
    private String web;

    public Brand() {

    }
}
