package tn.esprit.spring.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Category;
import tn.esprit.spring.entity.SousCategory;
import tn.esprit.spring.repository.CategoryRepository;
import tn.esprit.spring.repository.SousCategoryRepository;

@Service
public class CategoryServicelmpl implements CategoryService {

	
	@Autowired
	public CategoryRepository categoryrep;
	
	@Autowired
	SousCategoryRepository souscategoryrepo;
	
	@Override
	public List<Category> retrieveAllCategory() {
		return categoryrep.findAll();
	}

	@Override
	public Category addCategory(Category C) {
		
		return categoryrep.save(C) ;
	}

	@Override
	public void deleteCategory(Long id) {
		categoryrep.deleteById(id);
		
	}

	@Override
	public Category updateCategory(Category C) {
		
		return categoryrep.save(C);
	}

	@Override
	public Category retrieveCategory(Long idCategory) {
		
		return categoryrep.findCategoryById(idCategory);
	}
	//***********Sous_Category*********//

	@Override
	public List<SousCategory> retrieveAllSousCategory() {
		// TODO Auto-generated method stub
		return souscategoryrepo.findAll();
	}

	@Override
	public SousCategory addSousCategory(SousCategory souscategory) {
		//Category category = categoryrep.findCategoryByName(souscategory.getCategory());
		//souscategory.setCategory(category);
		return	souscategoryrepo.save(souscategory);
		
	}

	@Override
	public void deleteSousCategory(Long sousCategoryId) {
		
		souscategoryrepo.delete(souscategoryrepo.findById(sousCategoryId).get());	
		
	}

	@Override
	public SousCategory  retrieveSousCategory(Long sousCategoryId) {
		return souscategoryrepo.findSousCategoryById(sousCategoryId);
	}
	
	

/*	@Override
	public SousCategory findByOne(Long scatId) {
		
		return souscategoryrepo.getOne(scatId);
	}*/

	@Override
	public List<SousCategory> findSousCategoryByCategory(Long Id) {
		
		return souscategoryrepo.findByIdCategorys(Id);
	}

	@Override
	public SousCategory affectSousCatToCat(Long scatId, Long catId) {
		Category category = categoryrep.findById(catId).get();
		SousCategory SousCategory = souscategoryrepo.findById(scatId).get();
		
		SousCategory.setCategory(category);
	 return souscategoryrepo.save(SousCategory);
		
	}

	@Override
	public SousCategory updateSousCategory(SousCategory souscategory) {
		
		return  souscategoryrepo.save(souscategory);
	}
	
	

}
