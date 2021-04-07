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

import tn.esprit.spring.entity.Category;
import tn.esprit.spring.service.CategoryService;


@RestController
@RequestMapping("/api/category")
public class CategoryRestContoller {

	@Autowired
	private CategoryService categoryService ;

	@RequestMapping("/")
    public String home() {
        return "Hello World!";
    }
	
	@GetMapping("/Category")
    public List<Category> getAllCategory()  {
        return (List<Category>) categoryService.retrieveAllCategory();
    }

    @PostMapping("/Category")
    void addCategory(@RequestBody Category Category)  {
    	categoryService.addCategory(Category);
    }
     
    @PutMapping("/Category")
    public void updateCategory(@RequestBody Category Category) {
         if (Category.getId() != null) {
        	 categoryService.updateCategory(Category);
        }
         
    }

   
    @GetMapping("/Category/{id}")
    public Category getCategory(@PathVariable Long idCategory) {
        return  categoryService.retrieveCategory(idCategory);
     }

 
    @DeleteMapping("/Category/{id}")
    public void deleteCategory(@PathVariable Long id) {
    	categoryService.deleteCategory(id);
    }
	

}

