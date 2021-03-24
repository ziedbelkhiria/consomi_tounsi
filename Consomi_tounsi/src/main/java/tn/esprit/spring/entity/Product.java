package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="T_PRODUCTS")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	@Column(name="product_id")
	private Long id;
	private String product_type;
	private String product_name ;
	private String product_category ;
	private double product_price ;
	
	
	
	public Product(Long id, String product_type, String product_name, String product_category, double product_price) {
		super();
		this.id = id;
		this.product_type = product_type;
		this.product_name = product_name;
		this.product_category = product_category;
		this.product_price = product_price;
	}
	public Product(long id, String product_tupe, String product_name, String product_category) {
		// TODO Auto-generated constructor stub
	}
	@ManyToOne
	Category category;
	
	@ManyToOne
	Stocks stocks;
	

	@ManyToOne
	Provider provider;
	
	@OneToMany (cascade = CascadeType.ALL, mappedBy="Product")
	private Set<orders> orders;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProduct_type() {
		return product_type;
	}
	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_category() {
		return product_category;
	}
	public void setProduct_category(String product_category) {
		this.product_category = product_category;
	}
	public double getProduct_price() {
		return product_price;
	}
	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}

}