package Oussama;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryService {
    @Autowired

    DeliveryRepository D;

    public List<Delivery> retrieveAllDelivery() {
        return (List<Delivery>) D.findAll();
    }


    public Delivery  addDelivery(Delivery DD) {
        return D.save(DD);
    }


    public void deleteDelivery(int id) {
        Optional<Delivery> optionalDelivery=D.findById(id);
        if (!optionalDelivery.isPresent()) {
            throw new IllegalStateException("Delivery Not Found");
        }
        D.deleteById(id);

    }


    public void deleteDelivery(String id) {
        D.deleteById(Integer.parseInt(id));
    }


    public Delivery updateDelivery(Delivery DD) {
        return D.save(DD);
    }


    public Optional<Delivery> FindDelivery(int id) {
        return   D.findById(id);
    }


    public Optional<Delivery> FindDelivery(String id) {
        return  D.findById(Integer.parseInt(id));
    }

}
