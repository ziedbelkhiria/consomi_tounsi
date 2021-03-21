package tn.esprit.spring.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Product;
import tn.esprit.spring.repository.ProductRepository;

@Service
public class ProductServicelmpl implements ProductService  {

	@Autowired	
	public ProductRepository Prodrep;
	
	@Override
	public List<Product> retrieveAllProducts() {
		return Prodrep.findAll();
	}

	@Override
	public Product addProduct(Product P) {
		return Prodrep.save(P);
	}

	@Override
	public void deleteProduct(Long id) {
		Prodrep.deleteById(id);
	}

	@Override
	public Product updateProduct(Product P) {
		return Prodrep.save(P) ;
	}

	@Override
	public Optional<Product> retrieveProduct(Long idProduct) {
		return Prodrep.findById(idProduct);
	}
}
