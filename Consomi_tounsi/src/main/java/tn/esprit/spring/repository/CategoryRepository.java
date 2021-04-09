package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Category;




@Repository
public interface CategoryRepository  extends JpaRepository<Category, Long> {
	Category findCategoryById(long id);
	
	
	@Query(value = "SELECT * FROM category WHERE cat_nom=?1", nativeQuery = true)
	public Category findCategoryByName(Category  category);
	
	

}
