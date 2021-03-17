package tn.esprit.spring.service;



import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entity.Product;
import tn.esprit.spring.repository.ProductRepository;

public class ProductServicelmpl implements ProductService  {

	@Autowired
	
	public ProductRepository Prodrep;
	
	@Override
	public List<Product> retrieveAllProducts() {
		
		return Prodrep.findAll();
	}

	@Override
	public Product addProduct(Product P) {
		// TODO Auto-generated method stub
		return Prodrep.save(P);
	}

	@Override
	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		Prodrep.deleteById(id);
	}

	@Override
	public Product updateProduct(Product P) {
		// TODO Auto-generated method stub
		return Prodrep.save(P) ;
	}

	
	

	@Override
	public Product retrieveProduct(String ProductsId) {
		// TODO Auto-generated method stub
		
	return Prodrep.findById(Long.parseLong(ProductsId)).orElse(null); 
	}
}
