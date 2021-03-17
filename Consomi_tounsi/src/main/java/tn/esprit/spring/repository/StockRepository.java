package tn.esprit.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import tn.esprit.spring.entity.Stocks;



@Repository
public interface StockRepository extends JpaRepository<Stocks, Integer> {
	Optional<Stocks> findById(long parseLong);

}
