package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_USER")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	
	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	@Column(name="user_id")
	private int id;
	@Column(name="user_Fist_Name")
	private String Firstname ;
	@Column(name="user_Last_Name")
	private String Lasttname ;
	@Column(name="user_Adresse")
	private String Adress;
	@Column(length=8)
	private long telnum;
	@Column(name="user_Password", length=10)
	private String password;
	public User(int id, String firstname, String lasttname, String adress, long telnum, String password) {
		super();
		this.id = id;
		Firstname = firstname;
		Lasttname = lasttname;
		Adress = adress;
		this.telnum = telnum;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return Firstname;
	}
	public void setFirstname(String firstname) {
		Firstname = firstname;
	}
	public String getLasttname() {
		return Lasttname;
	}
	public void setLasttname(String lasttname) {
		Lasttname = lasttname;
	}
	public String getAdress() {
		return Adress;
	}
	public void setAdress(String adress) {
		Adress = adress;
	}
	public long getTelnum() {
		return telnum;
	}
	public void setTelnum(long telnum) {
		this.telnum = telnum;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Adress == null) ? 0 : Adress.hashCode());
		result = prime * result + ((Firstname == null) ? 0 : Firstname.hashCode());
		result = prime * result + ((Lasttname == null) ? 0 : Lasttname.hashCode());
		result = prime * result + id;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + (int) (telnum ^ (telnum >>> 32));
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
		User other = (User) obj;
		if (Adress == null) {
			if (other.Adress != null)
				return false;
		} else if (!Adress.equals(other.Adress))
			return false;
		if (Firstname == null) {
			if (other.Firstname != null)
				return false;
		} else if (!Firstname.equals(other.Firstname))
			return false;
		if (Lasttname == null) {
			if (other.Lasttname != null)
				return false;
		} else if (!Lasttname.equals(other.Lasttname))
			return false;
		if (id != other.id)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (telnum != other.telnum)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", Firstname=" + Firstname + ", Lasttname=" + Lasttname + ", Adress=" + Adress
				+ ", telnum=" + telnum + ", password=" + password + "]";
	}

	

}
