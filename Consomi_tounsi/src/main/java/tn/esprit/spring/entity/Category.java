package tn.esprit.spring.entity;

import java.io.Serializable;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	@Column(name="Category_type")
	private String type;
	
	public Category(long id, String name, String capacity, String type){
		super();
	}
	public Category(Long id, String name, String capacity, String type) {
		super();
		this.id = id;
		this.name = name;
		this.capacity = capacity;
		this.type = type;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + ((capacity == null) ? 0 : capacity.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", capacity=" + capacity + ", type=" + type + "]";
	}
	
	
	
	

}
