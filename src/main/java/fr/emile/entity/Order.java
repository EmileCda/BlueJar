package fr.emile.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import fr.emile.common.IConstant;
import fr.emile.utils.Utils;

@Entity
@Table(name = "client_order")
public  final class Order implements IConstant, Serializable {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	@Column(name = "order_number")
	private String orderNumber;

	@Column(name = "create_date_sql")
	private java.sql.Date createDateSql;
	@Column(name = "delivery_date_sql")
	private java.sql.Date deliveryDateSql;

	
	@Transient
	private Date createDate;
	@Transient
	private Date deliveryDate;

	@Column(name = "total_discount")
	private float totalDiscount; // in value (not in%)
	@Column(name = "shipping_costs")
	private float shippingCosts;
	@Column(name = "grand_total")
	private float grandTotal;

	@OneToOne
	@JoinColumn(name = "delivery_address_id", nullable = false)
//	@Transient
	private Address deliveryAddress;
	
	@OneToOne
	@JoinColumn(name = "billing_address_id", nullable = false)
//	@Transient
	private Address billingAddress;

	@OneToOne
	@JoinColumn(name = "bank_card_used_id", nullable = false)
//	@Transient
	private BankCard bankCardUsed;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
//	@Transient
	private User user;

//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "Order", fetch = FetchType.LAZY)
	@Transient
	private List<OrderLine> orderLine = null;

	public Order() {
		this(DEFAULT_ID, DEFAULT_ORDER_NUMBER, DEFAULT_DATE, DEFAULT_DATE, DEFAULT_DOUBLE_VALUE, DEFAULT_DOUBLE_VALUE,
				DEFAULT_DOUBLE_VALUE, null, null, null, null, null);
	}

	public Order(String orderNumber) {
		this(DEFAULT_ID, orderNumber, DATE_NOW, DEFAULT_DELIVERY_DATE, DEFAULT_DOUBLE_VALUE, DEFAULT_DOUBLE_VALUE,
				DEFAULT_DOUBLE_VALUE, null, null, null, null, null);
	}

	public Order(int id, String orderNumber, Date createDate, Date deliveryDate, float totalDiscount,
			float shippingCosts, float grandTotal, Address deliveryAddress, Address billingAddress,
			BankCard bankCardUsed, User user, List<OrderLine> orderLine) {
		this.id = id;
		this.orderNumber = orderNumber;
		this.createDate = createDate;
		this.deliveryDate = deliveryDate;
		this.totalDiscount = totalDiscount;
		this.shippingCosts = shippingCosts;
		this.grandTotal = grandTotal;
		this.deliveryAddress = deliveryAddress;
		this.billingAddress = billingAddress;
		this.bankCardUsed = bankCardUsed;
		this.user = user;
		this.orderLine = orderLine;
	}

	
	public void encode() {

		this.setDeliveryDateSql(Utils.toSqlDate(this.getDeliveryDate()));
		this.setCreateDateSql(Utils.toSqlDate(this.getCreateDate()));
	}

	// -------------------------------------------------------------------------------------------------
	public void decode() {

		this.setDeliveryDate(Utils.toJavaDate(this.getDeliveryDateSql()));
		this.setCreateDate(Utils.toJavaDate(this.getCreateDateSql()));
		this.getBankCardUsed().decrypt();
		
	}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public double getTotalDiscount() {
		return totalDiscount;
	}

	public void setTotalDiscount(float totalDiscount) {
		this.totalDiscount = totalDiscount;
	}

	public float getShippingCosts() {
		return shippingCosts;
	}

	public void setShippingCosts(float shippingCosts) {
		this.shippingCosts = shippingCosts;
	}

	public float getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(float grandTotal) {
		this.grandTotal = grandTotal;
	}

	public Address getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(Address deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public BankCard getBankCardUsed() {
		return bankCardUsed;
	}

	public void setBankCardUsed(BankCard bankCardUsed) {
		this.bankCardUsed = bankCardUsed;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrderLine> getOrderLine() {
		return orderLine;
	}

	public void setOrderLine(List<OrderLine> orderLine) {
		this.orderLine = orderLine;
	}

	public java.sql.Date getCreateDateSql() {
		return createDateSql;
	}

	public void setCreateDateSql(java.sql.Date createDateSql) {
		this.createDateSql = createDateSql;
	}

	public java.sql.Date getDeliveryDateSql() {
		return deliveryDateSql;
	}

	public void setDeliveryDateSql(java.sql.Date deliveryDateSql) {
		this.deliveryDateSql = deliveryDateSql;
	}

	@Override
	public String toString() {
		
//		double value = 10.2 /2;
//		System.out.printf("%.2f\n",value);
		return String.format("id[%d] %s  crea %s  liv %s reduction %2.2f  transport %2.2f "
				+ "total %2.2f  add Liv %s "
				+ "add Fact %s carte [%s] "
				+ "nom [%s]",
				
				getId(), getOrderNumber(), 
				Utils.date2String( getCreateDate(),"dd/MM/yyyy"), 
				Utils.date2String( getDeliveryDate(),"dd/MM/yyyy"),
				getTotalDiscount(), 
				getShippingCosts(),	
				getGrandTotal(), 
				getDeliveryAddress().toString(), 
				getBillingAddress().toString(), 
				getBankCardUsed().getCardClairNumber(), 
				getUser().getFullName()
				);
	}

}
