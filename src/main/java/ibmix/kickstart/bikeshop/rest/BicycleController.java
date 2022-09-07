package ibmix.kickstart.bikeshop.rest;

import ibmix.kickstart.bikeshop.repository.entities.Bicycle;
import ibmix.kickstart.bikeshop.repository.entities.Receipt;
import ibmix.kickstart.bikeshop.service.BicycleService;
import ibmix.kickstart.bikeshop.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class BicycleController {

    @Autowired
    private BicycleService bicycleService;

    @Autowired
    private ReceiptService receiptService;

    @PostMapping(value="/bicycles",consumes = "application/json", produces = "application/json")
    public Bicycle newBicycle(@RequestBody final Bicycle bicycle){
        return bicycleService.addBicycle(bicycle);
    }

    @GetMapping(value = "/bicycles",produces = "application/json")
    public @ResponseBody List<Bicycle> getAllBicycles(){
        return bicycleService.getAllBicycles();
    }

    @DeleteMapping(value = "/bicycles/{id}")
    public void deleteBicycle(@PathVariable final Long id){
        bicycleService.deleteBicycle(id);
    }
    @PutMapping(value = "/bicycles")
    public Bicycle updateBicycle(@RequestBody final Bicycle updatedBicycle){
        return bicycleService.updateBicycle(updatedBicycle);
    }
    @GetMapping(value = "/bicycles/{id}")
    public Optional<Bicycle> getBicycle(@PathVariable final Long id){
        return bicycleService.getBicycleById(id);
    }

    @GetMapping(value="/bicycles/brand/{brand}")
    public List<Bicycle> getBicyclesByBrand(@PathVariable final String brand){
        return bicycleService.getBicyclesByBrand(brand);
    }

    @PostMapping(value = "bicycles/purchase")
    public Receipt purchaseBicycles(@RequestBody final Set<Bicycle> bicycles){
        return receiptService.purchaseBicycles(bicycles);
    }


}
