package tn.esprit.spring.service;



import java.util.List;
//import java.util.Optional;

//import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entity.Product;
import tn.esprit.spring.repository.ProductRepository;

@Service
public class ProductServicelmpl implements ProductService  {

	@Autowired	
	public ProductRepository Prodrep;
	
	//private static final org.apache.logging.log4j.Logger l= LogManager.getLogger(ProductService.class);

	
	@Override
	public List<Product> retrieveAllProducts() {
		return (List<Product>) Prodrep.findAll();
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
	public Product retrieveProduct(Long idProduct) {
		
		return Prodrep.findProductByid(idProduct);
	}

	@Override
	public List<Product> findProductByNameAndType(String q,String t) {
		
		return Prodrep.findProductByProduct_nameAndProduct_type(q,t);
	}
}
