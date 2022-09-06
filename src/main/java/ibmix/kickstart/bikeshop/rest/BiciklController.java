package ibmix.kickstart.bikeshop.rest;

import ibmix.kickstart.bikeshop.data.entities.Bicikl;
import ibmix.kickstart.bikeshop.data.entities.Marka;
import ibmix.kickstart.bikeshop.data.repositories.BiciklRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;

@RestController
public class BiciklController {

    @Autowired
    BiciklRepository biciklRepository;

    @Autowired
    EntityManager entityManager;

    @GetMapping("/greeting")
    public String greeting() {
        return "Hello World!";
    }

    @PostMapping(value="/bicikli",consumes = "application/json", produces = "application/json")
    public Bicikl newBicikl(@RequestBody Bicikl bicikl){
        Marka marka = entityManager.getReference(Marka.class,bicikl.getMarka().getNaziv());
        bicikl.setMarka(marka);
        return biciklRepository.save(bicikl);
    }
}
