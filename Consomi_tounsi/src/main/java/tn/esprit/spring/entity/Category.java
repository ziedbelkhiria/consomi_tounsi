package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="T_CATEGORY")
public class Category implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	@Column(name="category_id")
	private Long id;
	@Column(name="Category_Name")
	private String name;
	@Column(name="Category_capacity")
	private String capacity;
	
	@Enumerated(EnumType.STRING)
	RayonType Rtype;
	
	@OneToMany (cascade = CascadeType.ALL, mappedBy="category" ,fetch = FetchType.EAGER)
	private Set<Product> product;
	
	@OneToMany(mappedBy="category",cascade = CascadeType.ALL)
	private Set<SousCategory> souscategory;
	
	public Category() {
		super();
	}



	public Category(Set<Product> product) {
		super();
		this.product = product;
	}



	public Category(Long id, String name, String capacity, tn.esprit.spring.entity.RayonType type) {
		super();
		this.id = id;
		this.name = name;
		this.capacity = capacity;
		Rtype = type;
	}



	public Set<Product> getProduct() {
		return product;
	}



	public void setProduct(Set<Product> product) {
		this.product = product;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getCapacity() {
		return capacity;
	}



	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}



	public RayonType getType() {
		return Rtype;
	}



	public void setType(RayonType type) {
		Rtype = type;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Rtype == null) ? 0 : Rtype.hashCode());
		result = prime * result + ((capacity == null) ? 0 : capacity.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Category other = (Category) obj;
		if (Rtype != other.Rtype)
			return false;
		if (capacity == null) {
			if (other.capacity != null)
				return false;
		} else if (!capacity.equals(other.capacity))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", capacity=" + capacity + ", Type=" + Rtype + "]";
	}
	
}
