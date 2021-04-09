package tn.esprit.spring.control;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Category;

import tn.esprit.spring.entity.SousCategory;
import tn.esprit.spring.service.CategoryService;


@RestController
@RequestMapping("/api/category")
public class CategoryRestContoller {

	@Autowired
	private CategoryService categoryService ;
	
	

	
	
	@GetMapping("/Category")
    public List<Category> getAllCategory()  {
        return (List<Category>) categoryService.retrieveAllCategory();
    }

    @PostMapping("/add/Category")
    public ResponseEntity<Category> addCategory(@RequestBody Category C)  {
    	Category category= categoryService.addCategory(C);
    	return new ResponseEntity<>( category,  HttpStatus.CREATED);
    }
    
    @PostMapping("/add/souscategory")
    public ResponseEntity<SousCategory> addSousCategory(@RequestBody SousCategory souscategory){
    SousCategory souscategory1 = categoryService.addSousCategory(souscategory);
    	return new ResponseEntity<>( souscategory1,  HttpStatus.CREATED);
    }
    
     
    @PutMapping("/update/Category")
    public ResponseEntity<Category> updateCategory(@RequestBody Category Category) {
         if (Category.getId() != null) {
        	 categoryService.updateCategory(Category);
        }
         return new ResponseEntity<>(Category, HttpStatus.OK);
         
    }
    
    @PutMapping("/update/souscategory")
    public  ResponseEntity<SousCategory> updateSousCategory(@RequestBody SousCategory souscategory){
    	if (souscategory.getId() != null){
    		categoryService.updateSousCategory(souscategory);
    	}
    	 return new ResponseEntity<>(souscategory, HttpStatus.OK );
    }

   
    @GetMapping("/Category/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable Long idCategory) {
        Category category =  categoryService.retrieveCategory(idCategory);
        return new ResponseEntity<>( category, HttpStatus.OK);	
     }

 
    @DeleteMapping("/delete/{id}")
    public void deleteCategory(@PathVariable Long id) {
    	categoryService.deleteCategory(id);
    }
    
   
    @DeleteMapping("/deleteSousCategory/{idScat}")
    public void deleteSousCategory(@PathVariable Long scatId) {
    	categoryService.deleteSousCategory(scatId);
    }
	
    @PutMapping( "/affectSousCatToCat/{idscat}/{idcat}") 
    public ResponseEntity<SousCategory> affectSousCatToCat(@PathVariable("idscat")Long scatId,@PathVariable("idcat") Long catId) {
    SousCategory souscategory =	categoryService.affectSousCatToCat(scatId, catId);
    return new ResponseEntity<>(souscategory, HttpStatus.OK);
		
	}
    
    @GetMapping("/soucategory/{id}")
    public ResponseEntity<SousCategory> getsouscategory(@PathVariable("id") Long sousCategoryId){
    	SousCategory souscategory = categoryService.retrieveSousCategory(sousCategoryId);
    	return new ResponseEntity<>( souscategory, HttpStatus.OK);	
    		
    	
    }
    
   /* @GetMapping("/soucategory/find")
    public ResponseEntity<SousCategory> findSousCategoryByName(@PathVariable("Name") String name){
    	List<SousCategory> list = categoryService.f
    }*/
}

