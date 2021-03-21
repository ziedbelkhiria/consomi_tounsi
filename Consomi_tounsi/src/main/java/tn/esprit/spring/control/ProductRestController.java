package tn.esprit.spring.control;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Product;
import tn.esprit.spring.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductRestController {
	@Autowired
	private ProductService productService;

	@RequestMapping("/")
    public String home() {
        return "Hello World!";
    }
	
	@GetMapping("/produits")
    public List<Product> getAllProduits()  {
        return (List<Product>) productService.retrieveAllProducts();
    }

    @PostMapping("/produits")
    void addProduit(@RequestBody Product product)  {
    	productService.addProduct(product);
    }
     
    @PutMapping("/produits")
    public void updateProduit(@RequestBody Product product) {
         if (product.getId() != null) {
             productService.updateProduct(product);
        }
         
    }

   
    @GetMapping("/produits/{id}")
    public Optional<Product> getProduit(@PathVariable Long idProduct) {
        return  productService.retrieveProduct(idProduct);
     }

 
    @DeleteMapping("/produits/{id}")
    public void deleteProduit(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
	

}
