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

import tn.esprit.spring.entity.Stocks;
import tn.esprit.spring.service.stockService;

@RestController
@RequestMapping("/api")
public class StockRestController {
	@Autowired
	private stockService stockService;

	@RequestMapping("/")
    public String home() {
        return "Hello World!";
    }
	
	@GetMapping("/Stocks")
    public List<Stocks> getAllStocks()  {
        return (List<Stocks>) stockService.retrieveAllStocks();
    }

    @PostMapping("/Stocks")
    void addStocks(@RequestBody Stocks  stocks )  {
    	stockService.addStocks(stocks );
    }
     
    @PutMapping("/Stocks")
    public void updateStocks(@RequestBody Stocks Stocks) {
         if (Stocks.getId() != null) {
        	 stockService.updateStocks(Stocks);
        }
         
    }

   
    @GetMapping("/Stock/{id}")
    public Optional<Stocks> getStocks(@PathVariable Long StocksId) {
        return stockService.retrieveStocks(StocksId);
     }

 
    @DeleteMapping("/Stock/{id}")
    public void deleteStocks(@PathVariable Long id) {
    	stockService.deleteStocks(id);
    }
	

}
