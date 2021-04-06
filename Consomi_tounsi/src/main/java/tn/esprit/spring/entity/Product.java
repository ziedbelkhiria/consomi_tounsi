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
	private String product_type;
	private String product_name ;
	
	
	private double product_price ;
	@Column(name="code619",length=13)
	
	private Long code_a_barre ;
	public Product(Category category) {
		super();
		this.category = category;
	}
	
	
	
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
		this.product_type = product_type;
		this.product_name = product_name;
		
		this.product_price = product_price;
	}
	@ManyToOne
	Category category;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	Stocks stocks;
	

	@ManyToOne
	Provider provider;
	
	@OneToMany (cascade = CascadeType.ALL, mappedBy="Product")
	private Set<orders> orders;
	
	@ManyToOne
	Rayon rayon;
	
	
	
	public Category getCategory() {
		return category;
	}



	public void setCategory(Category category) {
		this.category = category;
	}



	public Stocks getStocks() {
		return stocks;
	}



	public void setStocks(Stocks stocks) {
		this.stocks = stocks;
	}



	public Provider getProvider() {
		return provider;
	}



	public void setProvider(Provider provider) {
		this.provider = provider;
	}



	public Set<orders> getOrders() {
		return orders;
	}



	public void setOrders(Set<orders> orders) {
		this.orders = orders;
	}



	public Rayon getRayon() {
		return rayon;
	}



	public void setRayon(Rayon rayon) {
		this.rayon = rayon;
	}



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
		
		result = prime * result + ((product_name == null) ? 0 : product_name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(product_price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((product_type == null) ? 0 : product_type.hashCode());
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
		
		if (product_name == null) {
			if (other.product_name != null)
				return false;
		} else if (!product_name.equals(other.product_name))
			return false;
		if (Double.doubleToLongBits(product_price) != Double.doubleToLongBits(other.product_price))
			return false;
		if (product_type == null) {
			if (other.product_type != null)
				return false;
		} else if (!product_type.equals(other.product_type))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", product_type=" + product_type + ", product_name=" + product_name
				+ ", product_category="  + ", product_price=" + product_price + ", code_a_barre="
				+ code_a_barre + "]";
	}

}