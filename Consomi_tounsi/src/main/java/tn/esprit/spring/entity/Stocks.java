package tn.esprit.spring.entity;

import java.io.Serializable;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="T_STOCKS")
public class Stocks implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	@Column(name="stock_id")
	private Long id;
	@Column(name="stock_remaining_quantity")
	private int stock_remaining_quantity;
	public Stocks(Long id, int stock_remaining_quantity) {
		super();
		this.id = id;
		this.stock_remaining_quantity = stock_remaining_quantity;
	}
	public Stocks(long id, int stock_remaining_quantity2) {
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getStock_remaining_quantity() {
		return stock_remaining_quantity;
	}
	public void setStock_remaining_quantity(int stock_remaining_quantity) {
		this.stock_remaining_quantity = stock_remaining_quantity;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + stock_remaining_quantity;
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
		Stocks other = (Stocks) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (stock_remaining_quantity != other.stock_remaining_quantity)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Stocks [id=" + id + ", stock_remaining_quantity=" + stock_remaining_quantity + "]";
	}
	
	
	
	
}