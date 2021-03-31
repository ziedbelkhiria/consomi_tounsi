package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Product;
import tn.esprit.spring.entity.Rayon;
import tn.esprit.spring.entity.Type;
import tn.esprit.spring.repository.RayonRepository;

@Service
public class RayonServicelmpl implements RayonService {
	
	@Autowired
	RayonRepository RayonRep;

	@Override
	public List<Rayon> retrieveAllRayon() {
		return (List<Rayon>) RayonRep.findAll();
	}

	@Override
	public Rayon addRayon(Rayon R) {
		return RayonRep.save(R);
	}

	@Override
	public void deleteRayon(Long id) {
		RayonRep.deleteById(id);
		
	}

	@Override
	public Rayon updateRayon(Rayon R) {
		return RayonRep.save(R);
	}

	@Override
	public Rayon retrieveRayon(Long idRayon) {
		return RayonRep.findRayonByid(idRayon);
	}

	@Override
	public Rayon classifyProduct(Product product) {
		List<Rayon> listRayon = new ArrayList<>();
		if (product.getCategory().getType() == Type.Réfrigérateur) {
		listRayon =	RayonRep.findRayonByType(Type.Réfrigérateur);
		} else {
			listRayon = RayonRep.findRayonByType(Type.normal);
		}
		Rayon rayon = null;
		for (int i = 0; i < listRayon.size(); i++) {
			rayon = listRayon.get(i);
			if (rayon.getQuantity() < rayon.getMax()) {
			Set<Product> products = rayon.getProduct();
			products.add(product);
			rayon.setProduct(products);
			int quantity = rayon.getQuantity();
			quantity = quantity +1;
			rayon.setQuantity(quantity);
			rayon = RayonRep.save(rayon);
			break;	
			}
					
		}
		return rayon;
	}

}
