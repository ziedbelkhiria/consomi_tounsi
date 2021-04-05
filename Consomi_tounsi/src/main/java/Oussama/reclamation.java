package Oussama;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name="T_RECLAMATION")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class reclamation implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	@Column(name="reclamation_id")
	private int id;
	@Temporal (TemporalType.DATE)
	private Date reclamation_date;
	@Column(name="reclamation_status")
	private String status;


	


}
