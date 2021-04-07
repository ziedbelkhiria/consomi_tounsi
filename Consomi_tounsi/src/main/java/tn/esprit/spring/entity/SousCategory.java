package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "T_SOUS_CATEGORY")
public class SousCategory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SousCategory_Id")
	private Long Id;
	@Column(name = "SousCategory_nom")
	private String Nom;
	@Column(name = "SousCategory_description")
	private String Description;
	
	
	@OneToMany(mappedBy="souscat")
	private List<Product> product;
	@JsonIgnore
	@ManyToOne
	private Category category;

	public SousCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SousCategory(Long idSousCat, String snom, String sdescription, Category category) {
		super();
		Id = idSousCat;
		Nom = snom;
		Description = sdescription;
		this.category = category;
	}

	public Long getIdSousCat() {
		return Id;
	}

	public void setIdSousCat(Long idSousCat) {
		Id = idSousCat;
	}

	public String getSnom() {
		return Nom;
	}

	public void setSnom(String snom) {
		Nom = snom;
	}

	public String getSdescription() {
		return Description;
	}

	public void setSdescription(String sdescription) {
		Description = sdescription;
	}


	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "SousCategory [IdSousCat=" + Id + ", Snom=" + Nom + ", Sdescription=" + Description
				+ ",category=" + category + "]";
	}
	
	
	
}
