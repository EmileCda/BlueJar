package fr.emile.entity;

import java.io.Serializable;

import fr.emile.common.IConstant;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "address")
public class Address implements  IConstant, Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	private int number;
	
	@Column(name = "number_type")
	private String numberType;
	private String street;
	@Column(name = "street_type")
	private String streetType;
	private String city;
	@Column(name = "zip_code")
	private String zipCode;
	@Column(name = "is_valide")
	private Boolean isValide;
	
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	

	public Address() {
		
		this( DEFAULT_ID,0,"","","","","",true);

		
	};

	public Address( int number, String numberType, String street, String streetType, String city, String zipCode) {
		 
		this( DEFAULT_ID,number,  numberType,  street,  streetType,city, zipCode , true);
	}

	
	public Address(int id, int number, String numberType, String street, String streetType, String city, String zipCode,
			Boolean isValide) {
		this.setId ( id);
		this.setNumber ( number);
		this.setNumberType ( numberType);
		this.setStreet ( street);
		this.setStreetType ( streetType);
		this.setCity ( city);
		this.setZipCode ( zipCode);
		this.setValide ( isValide);
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public String getNumberType() {
		return numberType;
	}


	public void setNumberType(String numberType) {
		this.numberType = numberType;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getStreetType() {
		return streetType;
	}


	public void setStreetType(String streetType) {
		this.streetType = streetType;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getZipCode() {
		return zipCode;
	}


	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}


	public Boolean isValide() {
		return isValide;
	}


	public void setValide(Boolean isValide) {
		this.isValide = isValide;
	}




	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return String.format(
				"Id[%s], %d%s, %s %s %s %s, %s",
				getId(), getNumber(), (getNumberType().length()>0)?" "+getNumberType():"", getStreet(), getStreetType(), getZipCode(), getCity(),
				isValide() ? "valide": "non-valide" );
	}
	
	
	
}
