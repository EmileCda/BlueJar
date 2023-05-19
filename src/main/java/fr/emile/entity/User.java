package fr.emile.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import fr.emile.common.IConstant;
import fr.emile.enums.Gender;
import fr.emile.enums.Profile;
import fr.emile.utils.DataTest;
import fr.emile.utils.Utils;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "user")
public class User implements IConstant {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	private Gender gender;
	private String firstname;
	private String lastname;
	@Transient
	private Date birthdate;
	private java.sql.Date birthdateSql;
	private Boolean isActif;
	private Profile profile;
	private String email;
	@Transient
	private String pass;
	@Lob
	private byte[] encryptpass;

	private String phone;
	@Transient
	private List<Address> addressList;
	@Transient
	private List<Order> orderList;
	@Transient
	private List<BankCard> bankCardList;
	@Transient
	private List<Comment> commentList;
	@Transient
	private List<Item> itemList; // meaning cart

	private Boolean isDeleted;

	public User() {
		this(DEFAULT_ID, DEFAULT_GENDER, DEFAULT_FIRSTNAME, DEFAULT_LASTNAME, NULL_DATE, false, DEFAULT_PROFILE,
				DEFAULT_EMAIL, DEFAULT_PASS, null, DEFAULT_PHONE, null, null, null, null, null, false);
	}

	public User(Gender gender, String firstname, String lastname, Date birthdate, Profile profile, String email,
			String pass, String phone) {

		this(DEFAULT_ID, gender, firstname, lastname, birthdate, true, profile, email, pass, null, phone, null, null,
				null, null, null, false);

	}

	public User(int id, Gender gender, String firstname, String lastname, Date birthdate, Boolean isActif,
			Profile profile, String email, String pass, byte[] encryptPass, String phone, List<Address> addressList,
			List<Order> orderList, List<BankCard> bankCardList, List<Comment> commentList, List<Item> itemList,
			Boolean isDeleted) {
		this.setId(id);
		this.setGender(gender);
		this.setFirstname(firstname);
		this.setLastname(lastname);
		this.setBirthdate(birthdate);
		this.setIsActif(isActif);
		this.setProfile(profile);
		this.setEmail(email);
		this.setPass(pass);
		this.setEncryptPass(encryptPass);
		this.setPhone(phone);
		this.setIsDeleted(isDeleted);
		this.addressList = new ArrayList<Address>();
		this.orderList = new ArrayList<Order>();
		this.bankCardList = new ArrayList<BankCard>();
		this.commentList = new ArrayList<Comment>();
		this.itemList = new ArrayList<Item>();
		this.setAddressList(addressList);
		this.setOrderList(orderList);
		this.setBankCardList(bankCardList);
		this.setCommentList(commentList);
		this.setItemList(itemList);

	}

	// -------------------------------------------------------------------------------------------------
	public void encrypt() {

		this.setEncryptPass(Code.encrypt(this.getPass(),PASS_KEY));
		this.setBirthdateSql(Utils.toSqlDate(this.getBirthdate()));
	}

	// -------------------------------------------------------------------------------------------------
	public void decrypt() {

		this.setBirthdate(Utils.toJavaDate(this.getBirthdateSql()));
		this.setPass(Code.decrypt2String(this.getEncryptPass(),PASS_KEY));
	}

	// -------------------------------------------------------------------------------------------------
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Boolean getIsActif() {
		return isActif;
	}

	public void setIsActif(Boolean isActif) {
		this.isActif = isActif;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public byte[] getEncryptPass() {
		return encryptpass;
	}

	public void setEncryptPass(byte[] encryptPass) {
		this.encryptpass = encryptPass;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	public List<BankCard> getBankCardList() {
		return bankCardList;
	}

	public void setBankCardList(List<BankCard> bankCardList) {
		this.bankCardList = bankCardList;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public java.sql.Date getBirthdateSql() {
		return birthdateSql;
	}

	public void setBirthdateSql(java.sql.Date birthdateSql) {
		this.birthdateSql = birthdateSql;
	}

	@Override
	public String toString() {
		return String.format("id:%d [%s] %s %s %s, née %s %s profil %s %b tel :%s  del:%b]", getId(),
				getPass(),
				getGender().getTitle(), getFirstname(), getLastname(), Utils.date2String(getBirthdate(), "dd/MM/yyyy"),
				getIsActif(), getProfile().getName(), getEmail(), getPhone(), getIsDeleted());
	}

}
