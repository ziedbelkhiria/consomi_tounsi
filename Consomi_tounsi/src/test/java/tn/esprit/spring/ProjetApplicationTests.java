package tn.esprit.spring;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//import tn.esprit.spring.entity.Products;
import tn.esprit.spring.service.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjetApplicationTests {
	
	@Autowired
	ProductService proservice;

	@Test
	void contextLoads() {
		//Products P = new Products(1,"" )
	}

}
