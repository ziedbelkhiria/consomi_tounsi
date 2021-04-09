package tn.esprit.spring.service;

import java.util.List;


import tn.esprit.spring.entity.Category;
import tn.esprit.spring.entity.SousCategory;


public interface CategoryService {
	
List<Category> retrieveAllCategory();
	
 	Category addCategory(Category C);
 	
	void deleteCategory(Long id);
	
	Category updateCategory(Category C);
	
	Category retrieveCategory(Long idCategory);
	
	//*********Sous_Category********//
	
	List<SousCategory> retrieveAllSousCategory();
	
	SousCategory addSousCategory(SousCategory souscategory);
	
	void deleteSousCategory(Long sousCategoryId);
	 
	SousCategory retrieveSousCategory(Long sousCategoryId);
	
	SousCategory updateSousCategory(SousCategory souscategory);
	
	//public SousCategory findByOne(Long scatId);
	
	List<SousCategory> findSousCategoryByCategory(Long Id);
	
	SousCategory affectSousCatToCat(Long scatId, Long catId);

}
