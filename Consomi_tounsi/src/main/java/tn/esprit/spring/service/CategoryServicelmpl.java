package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Category;
import tn.esprit.spring.repository.CategoryRepository;

@Service
public class CategoryServicelmpl implements CategoryService {

	
	@Autowired
	public CategoryRepository categpryrep;
	
	@Override
	public List<Category> retrieveAllCategory() {
		return categpryrep.findAll();
	}

	@Override
	public Category addCategory(Category C) {
		
		return categpryrep.save(C) ;
	}

	@Override
	public void deleteCategory(Long id) {
		categpryrep.deleteById(id);
		
	}

	@Override
	public Category updateCategory(Category C) {
		
		return categpryrep.save(C);
	}

	@Override
	public Optional<Category> retrieveCategory(Long idCategory) {
		
		return categpryrep.findById(idCategory);
	}

}
