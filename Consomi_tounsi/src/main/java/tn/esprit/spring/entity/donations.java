package tn.esprit.spring.entity;
import javax.persistence.*;
import java.io.Serializable;
@Entity
public class donations implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Donation_ID")
	private Integer id;
	@Column(name="Donation_Quantity")
	private Integer quantity;

}
