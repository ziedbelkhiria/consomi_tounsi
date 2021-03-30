package tn.esprit.spring.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	 Product findProductByid(Long id);
	 List<Product> findProductByProduct_nameAndProduct_type(String q);
    
}
