package tn.esprit.spring.service;

import java.util.List;


import tn.esprit.spring.entity.Stocks;

public interface stockService {
	
List<Stocks> retrieveAllStocks();
	
	Stocks addStocks(Stocks S);
	
	void deleteStocks(int id);
	
	Stocks updateStocks(Stocks S);
	
	Stocks retrieveProducts(String StocksId);
	

}
