package fr.emile.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import fr.emile.common.IConstant;

public class Order implements IConstant, Serializable {
	private int id; 
	private String orderNumber;
	
	private Date  createDate;
	private Date  deliveryDate;
	
	private double  totalDiscount;
	private double shippingCosts;
	private double grandTotal;
	private Address deliveryAddress;
	private Address billingAddress;
	private BankCard bankCardUsed;
	private User user;
	private List<OrderLine> orderLine;  

	
}
