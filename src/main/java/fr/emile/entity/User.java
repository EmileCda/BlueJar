package fr.emile.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import fr.emile.common.IConstant;
import fr.emile.enums.Gender;
import fr.emile.enums.Profile;
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
	private Date birthdateJava;
	private java.sql.Date birthdate;
	@Column(name = "is_actif")
	private Boolean isActif;
	private Profile profile;
	private String email;
	@Transient
	private String clearPass;
	@Lob
	private byte[] pass;

	private String phone;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
	private List<Address> addressList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
//	@Transient
	private List<BankCard> bankCardList;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
//	@Transient
	private List<CartItem> cartItemList; // meaning cart : item + quantity

	
	@OneToMany(cascade = CascadeType.DETACH, mappedBy = "user", fetch = FetchType.LAZY)
//	@Transient
	private List<Order> orderList;
	
	@OneToMany(cascade = CascadeType.DETACH, mappedBy = "user", fetch = FetchType.LAZY)
//	@Transient
	private List<Comment> commentList = null;


	public User() {
		this(DEFAULT_ID, DEFAULT_GENDER, DEFAULT_FIRSTNAME, DEFAULT_LASTNAME, NULL_DATE, false, DEFAULT_PROFILE,
				DEFAULT_EMAIL, DEFAULT_PASS, null, DEFAULT_PHONE, null, null, null, null, null);
	}

	public User(Gender gender, String firstname, String lastname, Date birthdate, Profile profile, String email,
			String pass, String phone) {

		this(DEFAULT_ID, gender, firstname, lastname, birthdate, true, profile, email, pass, null, phone, null, null,
				null, null, null);

	}

	public User(User copyUser) {

		this(copyUser.getId(), copyUser.getGender(), copyUser.getFirstname(), copyUser.getLastname(),
				copyUser.getBirthdateJava(), copyUser.getIsActif(), copyUser.getProfile(), copyUser.getEmail(),
				copyUser.getClearPass(), copyUser.getPass(), copyUser.getPhone(), copyUser.getAddressList(),
				copyUser.getOrderList(), copyUser.getBankCardList(), copyUser.getCommentList(), copyUser.getCartItemList());

	}

	public User(int id, Gender gender, String firstname, String lastname, Date birthdate, Boolean isActif,
			Profile profile, String email, String clearPass, byte[] pass, String phone, List<Address> addressList,
			List<Order> orderList, List<BankCard> bankCardList, List<Comment> commentList, List<CartItem> cartItemList
		) {
		this.setId(id);
		this.setGender(gender);
		this.setFirstname(firstname);
		this.setLastname(lastname);
		this.setBirthdateJava(birthdate);
		this.setIsActif(isActif);
		this.setProfile(profile);
		this.setEmail(email);
		this.setClearPass(clearPass);
		this.setPass(pass);
		this.setPhone(phone);
		this.setAddressList(addressList);
		this.setOrderList(orderList);
		this.setBankCardList(bankCardList);
		this.setCommentList(commentList);
		this.setCartItemList(cartItemList);


	}

	// -------------------------------------------------------------------------------------------------
	public void encrypt() {

		this.setPass(Code.encrypt(this.getClearPass(), PASS_KEY));
		this.setBirthdate(Utils.toSqlDate(this.getBirthdateJava()));
		for (BankCard bankCard : this.getBankCardList()) {
			bankCard.encrypt();
		}
	}

	// -------------------------------------------------------------------------------------------------
	public void decrypt() {

		this.setBirthdateJava(Utils.toJavaDate(this.getBirthdate()));
		this.setClearPass(Code.decrypt2String(this.getPass(), PASS_KEY));
		for (BankCard bankCard : this.getBankCardList()) {
			bankCard.decrypt();
		}
		
	}

	// -------------------------------------------------------------------------------------------------
	public void addCardItem(CartItem cartItem) {

		if (this.cartItemList == null)
			this.cartItemList = new ArrayList<CartItem>();
		
		cartItem.setUser(this);
		this.cartItemList.add(cartItem);
	}
	// -------------------------------------------------------------------------------------------------
	public void addAddress(Address address) {

		if (this.addressList == null)
			this.addressList = new ArrayList<Address>();
		
		address.setUser(this);
		this.addressList.add(address);
	}
	// -------------------------------------------------------------------------------------------------
	public void addComment(Comment comment) {

		if (this.commentList == null) {
			commentList = new ArrayList<Comment>();

		}
		comment.setUser(this);
		
		this.getCommentList().add(comment);

	}
	// -------------------------------------------------------------------------------------------------
	public void addBankCard(BankCard bankCard) {

		
		if (this.bankCardList == null)
			this.bankCardList= new ArrayList<BankCard>();

		bankCard.setUser(this);
		bankCard.setOwnerGender(this.getGender());
		bankCard.setOwnerFirstname(this.getFirstname());
		bankCard.setOwnerLastname(this.getLastname());
		
		this.bankCardList.add(bankCard);
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
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public Boolean getIsActif() {
		return isActif;
	}

	public void setIsActif(Boolean isActif) {
		this.isActif = isActif;
	}

	public Profile getProfile() {
		return this.profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Address> getAddressList() {
		return this.addressList;
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

	

	
	public List<CartItem> getCartItemList() {
		return cartItemList;
	}

	public void setCartItemList(List<CartItem> cartItemList) {
		this.cartItemList = cartItemList;
	}

	public Date getBirthdateJava() {
		return birthdateJava;
	}

	public void setBirthdateJava(Date birthdateJava) {
		this.birthdateJava = birthdateJava;
	}

	public java.sql.Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(java.sql.Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getClearPass() {
		return clearPass;
	}

	public void setClearPass(String clearPass) {
		this.clearPass = clearPass;
	}

	public byte[] getPass() {
		
		return this.pass;
	}

	public void setPass(byte[] pass) {
		this.pass = pass;
	}

	public String getFullName() {

		return String.format("%s%s %s", 
		 getGender().getTitle()!=""? getGender().getTitle()+" ":"", getFirstname(), getLastname());
	}

	@Override
	public String toString() {

		String stringDisplay = "";
		stringDisplay += String.format("id:%d [%s] %s, né%s le %s profil:%s, %s %s tel: %s\n", getId(),
				getClearPass(), 
				this.getFullName(),
				getGender().getTitle(), getFirstname(), getLastname(),
				getGender().getId()==1 ?"e":"",
				Utils.date2String(getBirthdateJava(), "dd/MM/yyyy"), getProfile().getName(),
				getIsActif() ? "actif" : "non-actif", getEmail(), getPhone());


		if ((this.getAddressList() != null) && (this.getAddressList().size() >0)) {
			
			stringDisplay += "Adresse : \n";
			
			for (Address address : getAddressList()) {
				stringDisplay += "\t" + address.toString() + "\n";
			}
		}
		
		if ((this.getBankCardList() != null) && (this.getBankCardList().size() >0)) {
			stringDisplay += "Carte de paiement : \n";
			
			for (BankCard bankCard : getBankCardList()) {
				stringDisplay += "\t" + bankCard .toString() + "\n";
			}
		}

		return stringDisplay;

	}

}
