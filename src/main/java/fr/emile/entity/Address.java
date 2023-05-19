package fr.emile.entity;

import java.io.Serializable;

import fr.emile.common.IConstant;

public class Address implements  IConstant, Serializable {
	private int id; 
	private int number;
	
	private String numberType;
	private String street;
	private String streetType;
	private String city;
	private String zipCode;
	private Boolean isValide;
	private Boolean isDeleted;
	
	
	// one user many address
	private User user;
	
	
	
}
