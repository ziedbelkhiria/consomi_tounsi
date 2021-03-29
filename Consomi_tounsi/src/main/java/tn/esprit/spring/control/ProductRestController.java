package tn.esprit.spring.control;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Product;
import tn.esprit.spring.service.ProductService;

@Controller
@RequestMapping("/api")
public class ProductRestController {
	@Autowired
	public ProductService productService;
	

	public ProductRestController(ProductService productService) {
		super();
		this.productService = productService;
	}

		
	
	
	@GetMapping("/produits")
    public ResponseEntity<List<Product>> getAllProduits()  {
         List<Product> P = productService.retrieveAllProducts();
         return new ResponseEntity<>( P, HttpStatus.OK);
         
    }

    @PostMapping("/add")
    public ResponseEntity<Product> addProduit(@RequestBody Product product)  {
    Product P=	productService.addProduct(product);
    return new ResponseEntity<>( P,  HttpStatus.CREATED);
    
    }
     
    @PutMapping("/produits")
    public void updateProduit(@RequestBody Product product) {
         if (product.getId() != null) {
             productService.updateProduct(product);
        }
         
    }
    @GetMapping("/produits/{id}")
    public Optional<Product> getProduit(@PathVariable Long id) {
        return  productService.retrieveProduct(id);
     }
    @DeleteMapping("/produits/{id}")
    public void deleteProduit(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
	

}
