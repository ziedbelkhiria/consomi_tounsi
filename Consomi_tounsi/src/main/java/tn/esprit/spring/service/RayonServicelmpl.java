package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Product;
import tn.esprit.spring.entity.Rayon;
import tn.esprit.spring.entity.RayonType;
import tn.esprit.spring.repository.RayonRepository;

@Service

public class RayonServicelmpl implements RayonService {
	
	
	@Autowired
	public RayonRepository rayonrepository;
	
	
	
	@Override
	public List<Rayon> retrieveAllRayon() {
		return (List<Rayon>) rayonrepository.findAll();
	}

	@Override
	public Rayon addRayon(Rayon R) {
		return rayonrepository.save(R);
	}

	@Override
	public void deleteRayon(Long id) {
		rayonrepository.deleteById(id);
		
	}

	@Override
	public Rayon updateRayon(Rayon R) {
		return rayonrepository.save(R);
	}

	@Override
	public Rayon retrieveRayon(Long idRayon) {
		return rayonrepository.findRayonByid(idRayon);
	}

	@Override
	public Rayon classifyProduct(Product product) {
		List<Rayon> listRayon = new ArrayList<>();
		if (product.getCategory().getType() == RayonType.Réfrigérateur) {
		listRayon =	rayonrepository.findRayonByType(RayonType.Réfrigérateur);
		} else {
			listRayon = rayonrepository.findRayonByType(RayonType.normal);}
		
		Rayon rayon = null ;
		for (int i = 0; i < listRayon.size(); i++) {
			rayon = listRayon.get(i);
			if (rayon.getQuantity() < rayon.getMax()) {
			Set<Product> products = rayon.getProduct();
			products.add(product);
			rayon.setProduct(products);
			int quantity = rayon.getQuantity();
			quantity = quantity +1;
			rayon.setQuantity(quantity);
			rayon = rayonrepository.save(rayon);
			break;	
			}
					
		}
		return rayon;
	}

}
