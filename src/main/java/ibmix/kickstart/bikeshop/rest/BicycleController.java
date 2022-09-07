package ibmix.kickstart.bikeshop.rest;

import ibmix.kickstart.bikeshop.repository.entities.BicycleModel;
import ibmix.kickstart.bikeshop.repository.entities.ReceiptModel;
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
    public BicycleModel newBicycle(@RequestBody final BicycleModel bicycle){
        return bicycleService.addBicycle(bicycle);
    }

    @GetMapping(value = "/bicycles",produces = "application/json")
    public @ResponseBody List<BicycleModel> getAllBicycles(){
        return bicycleService.getAllBicycles();
    }

    @DeleteMapping(value = "/bicycles/{id}")
    public void deleteBicycle(@PathVariable final Long id){
        bicycleService.deleteBicycle(id);
    }
    @PutMapping(value = "/bicycles")
    public BicycleModel updateBicycle(@RequestBody final BicycleModel updatedBicycle){
        return bicycleService.updateBicycle(updatedBicycle);
    }
    @GetMapping(value = "/bicycles/{id}")
    public Optional<BicycleModel> getBicycle(@PathVariable final Long id){
        return bicycleService.getBicycleById(id);
    }

    @GetMapping(value="/bicycles/brand/{brand}")
    public List<BicycleModel> getBicyclesByBrand(@PathVariable final String brand){
        return bicycleService.getBicyclesByBrand(brand);
    }

    @PostMapping(value = "bicycles/purchase")
    public ReceiptModel purchaseBicycles(@RequestBody final Set<BicycleModel> bicycles){
        return receiptService.purchaseBicycles(bicycles);
    }


}
