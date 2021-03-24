package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entity.Stocks;

public interface stockService {
	
List<Stocks> retrieveAllStocks();
	
	Stocks addStocks(Stocks S);
	
	void deleteStocks(Long id);
	
	Stocks updateStocks(Stocks S);
	
	Optional<Stocks> retrieveStocks(Long StocksId);
	

}
