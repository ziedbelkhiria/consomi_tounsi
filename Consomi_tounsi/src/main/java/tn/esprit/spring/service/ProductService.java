package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entity.Product;

public interface ProductService {
	
	List<Product> retrieveAllProducts();
	
	Product addProduct(Product P);
	
	void deleteProduct(Long id);
	
	Product updateProduct(Product P);
	
	Optional<Product> retrieveProduct(Long idProduct);
	

}
