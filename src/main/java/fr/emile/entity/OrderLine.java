package fr.emile.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import fr.emile.common.IConstant;

public final class OrderLine implements IConstant, Serializable {
	
	
	private static final long serialVersionUID = -23153027186502371L;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id; 
	private int quantity;
	private double unitPrice;
	private int discount;

	
//	@ManyToOne
//	@JoinColumn(name = "item_id", nullable = false)
	@Transient
	private Order order;
	
//	@OneToOne
//	@JoinColumn(name = "item_id", nullable = false)
	@Transient
	private Item item;
	
	
	
	public OrderLine() {
		
		this(DEFAULT_ID,DEFAULT_QUANTITY,DEFAULT_PRICE,DEFAULT_DISCOUNT,null,null);
	}
	public OrderLine(int id, int quantity, double unitPrice, int discount, Order order, Item item) {
		this.setId ( id);
		this.setQuantity ( quantity);
		this.setUnitPrice ( unitPrice);
		this.setDiscount ( discount);
		this.setOrder ( order);
		this.setItem ( item);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	
	
}
