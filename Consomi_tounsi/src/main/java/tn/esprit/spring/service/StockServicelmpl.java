package tn.esprit.spring.service;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Stocks;

import tn.esprit.spring.repository.StockRepository;
@Service
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
	public void deleteStocks(Long id) {
		 Stockrep.deleteById(id);
		
	}

	@Override
	public Stocks updateStocks(Stocks S) {
		// TODO Auto-generated method stub
		return Stockrep.save(S);
	}



	@Override
	public Stocks retrieveStocks(Long StocksId) {
		
		return Stockrep.findStockByid(StocksId);
	}

	
	

}
