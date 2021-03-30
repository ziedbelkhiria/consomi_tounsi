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

//import org.hibernate.annotations.BatchSize;

@Entity
@Table(name="T_PRODUCTS")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy= GenerationType.AUTO)
	@Column(name="product_id")
	private Long id;
	private String productType;
	private String productName ;
	private String product_category ;
	private double product_price ;
	@Column(name="code619",length=13)
	
	private Long code_a_barre ;
	
	
	
	
	public Long getCode_a_barre() {
		return code_a_barre;
	}
	public void setCode_a_barre(Long code_a_barre) {
		this.code_a_barre = code_a_barre;
	}
	public Product(Long code_a_barre) {
		super();
		this.code_a_barre = code_a_barre;
	}
	public Product() {
		super();
	}
	public Product(String product_type, String product_name, String product_category, double product_price) {
		super();
		this.productType = product_type;
		this.productName = product_name;
		this.product_category = product_category;
		this.product_price = product_price;
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
		return productType;
	}
	public void setProduct_type(String product_type) {
		this.productType = product_type;
	}
	public String getProduct_name() {
		return productName;
	}
	public void setProduct_name(String product_name) {
		this.productName = product_name;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code_a_barre == null) ? 0 : code_a_barre.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((product_category == null) ? 0 : product_category.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(product_price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((productType == null) ? 0 : productType.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (code_a_barre == null) {
			if (other.code_a_barre != null)
				return false;
		} else if (!code_a_barre.equals(other.code_a_barre))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (product_category == null) {
			if (other.product_category != null)
				return false;
		} else if (!product_category.equals(other.product_category))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (Double.doubleToLongBits(product_price) != Double.doubleToLongBits(other.product_price))
			return false;
		if (productType == null) {
			if (other.productType != null)
				return false;
		} else if (!productType.equals(other.productType))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", product_type=" + productType + ", product_name=" + productName
				+ ", product_category=" + product_category + ", product_price=" + product_price + ", code_a_barre="
				+ code_a_barre + "]";
	}

}