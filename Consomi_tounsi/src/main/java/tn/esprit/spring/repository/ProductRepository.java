package tn.esprit.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>  {

	

	
	Optional<Product> findById(long parseLong);

	

}
