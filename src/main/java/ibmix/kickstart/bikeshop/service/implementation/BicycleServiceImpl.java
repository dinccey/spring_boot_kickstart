package ibmix.kickstart.bikeshop.service.implementation;

import ibmix.kickstart.bikeshop.repository.ReceiptRepository;
import ibmix.kickstart.bikeshop.repository.entities.Bicycle;
import ibmix.kickstart.bikeshop.repository.entities.Brand;
import ibmix.kickstart.bikeshop.repository.BicycleRepository;
import ibmix.kickstart.bikeshop.repository.entities.Receipt;
import ibmix.kickstart.bikeshop.service.BicycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BicycleServiceImpl implements BicycleService{

    @Autowired
    BicycleRepository bicycleRepository;

    @Autowired
    ReceiptRepository receiptRepository;

    @Autowired
    private EntityManager entityManager;

    public List<Bicycle> getAllBicycles(){
        return bicycleRepository.findAll();
    }

    public Bicycle addBicycle(Bicycle bicycle){
        Brand brand = entityManager.getReference(Brand.class, bicycle.getBrand().getName());
        bicycle.setBrand(brand);
        return bicycleRepository.save(bicycle);
    }

    public void deleteBicycle(Long id){
        bicycleRepository.deleteById(id);
    }

    public Optional<Bicycle> getBicycleById(Long id){
        return bicycleRepository.findById(id);
    }
    public List<Bicycle> getBicyclesByBrand(String brandName){
        return bicycleRepository.findAllByBrand_Name(brandName);
    }

    public Receipt purchaseBicycles(Set<Bicycle> bicycles) {
        Receipt receipt = new Receipt();
        Date dateOfPurchase = new Date(System.currentTimeMillis());
        double totalPrice = bicycles.stream().mapToDouble(Bicycle::getPrice).sum();

        receipt.setItems(bicycles);
        receipt.setPriceTotal(totalPrice);
        receipt.setDateOfPurchase(dateOfPurchase);

        return receiptRepository.save(receipt);
    }

    public Bicycle updateBicycle(Bicycle updatedBicycle) throws ResponseStatusException {
        Optional<Bicycle> bicycle = bicycleRepository.findById(updatedBicycle.getId());
        if(bicycle.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_MODIFIED,
                    "Bicycle with id"+updatedBicycle.getId()+" does not exist in the database.\n");
        }
        return bicycleRepository.save(updatedBicycle);
    }
}
