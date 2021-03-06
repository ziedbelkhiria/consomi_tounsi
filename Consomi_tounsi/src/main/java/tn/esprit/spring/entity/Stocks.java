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
	private int id;
	private int stock_remaining_quantity;
	
	
	
	public int getStock_remaining_quantity() {
		return stock_remaining_quantity;
	}
	public void setStock_remaining_quantity(int stock_remaining_quantity) {
		this.stock_remaining_quantity = stock_remaining_quantity;
	}
}