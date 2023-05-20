package fr.emile.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import fr.emile.common.IConstant;
import fr.emile.enums.Gender;
import fr.emile.utils.Utils;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "bank_card")
public final class BankCard implements IConstant, Serializable {

	private static final long serialVersionUID = -4788640537420336265L;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	@Column(name = "owner_gender")
	private Gender ownerGender;
	@Column(name = "owner_firstname")
	private String ownerFirstname;
	@Column(name = "owner_lastname")
	private String ownerLastname;
	@Transient
	private String cardClairNumber;
	@Column(name = "card_number")
	private byte[] cardNumber;
	@Transient
	private Date expiryDateJava;

	@Column(name = "expiry_date")
	private java.sql.Date expiryDate;
	@Transient
	private String clairCrypto;
	private byte[] cryptogram;
	@Column(name = "is_valide")
	private boolean isValid;
	@Column(name = "is_deleted")
	private boolean isDeleted;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	public BankCard() {
		this(DEFAULT_ID, DEFAULT_GENDER, DEFAULT_FIRSTNAME, DEFAULT_LASTNAME, DEFAULT_BANK_CARD_NUMBER, 
				DEFAULT_DATE,
				DEFAULT_BANK_CARD_CRYPTO, true, false);
	}

	public BankCard(String cardClairNumber, Date expiryDateJava, String clairCrypto) {

		this(DEFAULT_ID, DEFAULT_GENDER, DEFAULT_FIRSTNAME, DEFAULT_LASTNAME, cardClairNumber, expiryDateJava,
				clairCrypto, true, false);

	}

	public BankCard(Gender ownerGender, String ownerFirstname, String ownerLastname, String cardClairNumber,
			Date expiryDateJava, String clairCrypto) {

		this(DEFAULT_ID, ownerGender, ownerFirstname, ownerLastname, cardClairNumber, expiryDateJava, clairCrypto, true,
				false);

	}

	public BankCard(int id, Gender ownerGender, String ownerFirstname, String ownerLastname, String cardClairNumber,
			Date expiryDateJava, String clairCrypto, boolean isValid, boolean isDeleted) {
		this.setId(id);
		this.setOwnerGender(ownerGender);
		this.setOwnerFirstname(ownerFirstname);
		this.setOwnerLastname(ownerLastname);
		this.setCardClairNumber(cardClairNumber);
		this.setCardNumber(cardNumber);
		this.setExpiryDateJava(expiryDateJava);
		this.setExpiryDate(expiryDate);
		this.setClairCrypto(clairCrypto);
		this.setCryptogram(cryptogram);
		this.setValid(isValid);
		this.setDeleted(isDeleted);
	}

	// -------------------------------------------------------------------------------------------------
	public void encrypt() {
		this.setCardNumber(Code.encrypt(this.getCardClairNumber(), BC_KEY));
		this.setCryptogram(Code.encrypt(this.getClairCrypto(), BC_KEY));
		this.setExpiryDate(Utils.toSqlDate(this.getExpiryDateJava()));
	}

	// -------------------------------------------------------------------------------------------------
	public void decrypt() {

		this.setCardClairNumber(Code.decrypt2String(this.getCardNumber(), BC_KEY));
		this.setClairCrypto(Code.decrypt2String(this.getCryptogram(), BC_KEY));
		this.setExpiryDateJava(Utils.toJavaDate(this.getExpiryDate()));
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Gender getOwnerGender() {
		return this.ownerGender;
	}

	public void setOwnerGender(Gender ownerGender) {
		this.ownerGender = ownerGender;
	}

	public String getOwnerFirstname() {
		return ownerFirstname;
	}

	public void setOwnerFirstname(String ownerFirstname) {
		this.ownerFirstname = ownerFirstname;
	}

	public String getOwnerLastname() {
		return ownerLastname;
	}

	public void setOwnerLastname(String ownerLastname) {
		this.ownerLastname = ownerLastname;
	}

	public String getCardClairNumber() {
		return this.cardClairNumber;
	}

	public void setCardClairNumber(String cardClairNumber) {
		this.cardClairNumber = cardClairNumber;
	}

	public byte[] getCardNumber() {
		return this.cardNumber;
	}

	public void setCardNumber(byte[] cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Date getExpiryDateJava() {
		return this.expiryDateJava;
	}

	public void setExpiryDateJava(Date expiryDateJava) {
		this.expiryDateJava = expiryDateJava;
	}

	public java.sql.Date getExpiryDate() {
		return this.expiryDate;
	}

	public void setExpiryDate(java.sql.Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getClairCrypto() {
		return this.clairCrypto;
	}

	public void setClairCrypto(String clairCrypto) {
		this.clairCrypto = clairCrypto;
	}

	public byte[] getCryptogram() {
		return this.cryptogram;
	}

	public void setCryptogram(byte[] cryptogram) {
		this.cryptogram = cryptogram;
	}

	public boolean isValid() {
		return this.isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public boolean isDeleted() {
		return this.isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		

		this.user = user;
	}

	@Override
	public String toString() {
		return String.format("id[%d] %s %s %s [%s][{%s} exp %s %s,%s", getId(), getOwnerGender().getTitle(),
				getOwnerFirstname(), getOwnerLastname(), getCardClairNumber(), getClairCrypto(),
				Utils.date2String(getExpiryDateJava(), "MM/yy"), (isValid() ? "" : "pas ") + "valide",
				isDeleted() ? "" : "pas " + "delete");
	}

}
