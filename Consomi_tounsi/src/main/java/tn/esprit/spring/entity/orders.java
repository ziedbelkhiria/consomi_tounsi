package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import Oussama.Delivery;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="T_Orders")
public class orders implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Orders_id;
	@Temporal(TemporalType.DATE)
	private Date order_date;
	public float weight;
	
	@OneToOne
	private paiments Paiments;
	
	@ManyToOne
	Delivery delivery;
	
	@ManyToOne
	customer customer;
	
	@ManyToOne
	Product Product;
	
	

	
	
	

}
