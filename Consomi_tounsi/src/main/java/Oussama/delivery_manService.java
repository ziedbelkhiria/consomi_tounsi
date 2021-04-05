package Oussama;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.orders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class delivery_manService {
    @Autowired

    delivery_manRepository D;

    public List<delivery_man> retrieveAllDelivery_man() {
        return (List<delivery_man>) D.findAll();
    }


    public delivery_man  addDelivery_man(delivery_man DD) {
        return D.save(DD);}



    public void deleteDelivery_man(int id) {
        Optional<delivery_man> optionaldelivery_man=D.findById(id);
        if (!optionaldelivery_man.isPresent()) {
            throw new IllegalStateException("delivery_man Not Found");
        }
        D.deleteById(id);

    }



    public delivery_man updatedelivery_man(delivery_man DD) {
        return D.save(DD);
    }


    public Optional<delivery_man> Finddelivery_man(int id) {
        return   D.findById(id);
    }


    public Optional<delivery_man> FindDelivery_man(String id) {
        return  D.findById(Integer.parseInt(id));
    }


}
