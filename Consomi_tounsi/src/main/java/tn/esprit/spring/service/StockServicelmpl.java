package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entity.Stocks;

import tn.esprit.spring.repository.StockRepository;

public class StockServicelmpl implements stockService {
	
@Autowired
	
	public StockRepository Stockrep;

	@Override
	public List<Stocks> retrieveAllStocks() {
		// TODO Auto-generated method stub
		return Stockrep.findAll();
	}

	@Override
	public Stocks addStocks(Stocks S) {
		// TODO Auto-generated method stub
		return Stockrep.save(S);
	}

	@Override
	public void deleteStocks(int id) {
		// TODO Auto-generated method stub
		Stockrep.deleteById(id);
	}

	@Override
	public Stocks updateStocks(Stocks S) {
		// TODO Auto-generated method stub
		return Stockrep.save(S);
	}

	@Override
	public Stocks retrieveProducts(String StocksId) {
		// TODO Auto-generated method stub
		return Stockrep.findById(Long.parseLong(StocksId)).orElse(null);
	}
	

}
