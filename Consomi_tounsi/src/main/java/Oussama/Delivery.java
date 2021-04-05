package Oussama;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.spring.entity.delivery_man;
import tn.esprit.spring.entity.orders;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="T_DELIVERY")
public class Delivery implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	@Column(name="delivery_id")
	private int id;
	@Temporal (TemporalType.DATE)
	private Date delivery_date;
	@Column(name="delivery_status")
	private String status;
	@Column(name="delivery_price")
	private double price ;
	
	@ManyToOne
	delivery_man delivery_man;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="delivery")
	private Set<orders> orders;
	
	
	
	

}
