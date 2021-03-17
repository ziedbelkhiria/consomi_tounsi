package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Product;

public interface ProductService {
	
	List<Product> retrieveAllProducts();
	
	Product addProduct(Product P);
	
	void deleteProduct(int id);
	
	Product updateProduct(Product P);
	
	Product retrieveProduct(String ProductsId);
	

}
