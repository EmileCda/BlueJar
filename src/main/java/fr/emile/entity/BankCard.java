package fr.emile.entity;

import java.io.Serializable;
import java.util.Date;

import fr.emile.common.IConstant;
import fr.emile.enums.Gender;

public class BankCard implements IConstant, Serializable {

	
	private int id;
	private Gender ownerGender;  
	private String ownerFirstName;  
	private String ownerLastName;  
	private String cardNumber;
	private byte[] encryptCardNumber;
	private Date expiryDate;
	private String crypto;
	private byte[] encrypCryptogram;
	private User user;
	private boolean isValid;
	private boolean isDeleted;
}

