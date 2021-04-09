package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.SousCategory;

@Repository
public interface SousCategoryRepository extends JpaRepository<SousCategory,Long>{

	@Query(value = "SELECT * FROM T_SOUS_CATEGORY WHERE SousCategory_nom=?1", nativeQuery = true)
	public SousCategory findSousCategoryByName(String name);
	
	@Query(value = "SELECT * FROM T_SOUS_CATEGORY WHERE T_SOUS_CATEGORY_category_id =?1", nativeQuery = true)
	public List<SousCategory> findByIdCategorys(Long Id);
	
	SousCategory findSousCategoryById(Long Id);
}
