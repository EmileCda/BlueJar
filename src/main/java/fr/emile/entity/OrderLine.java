package fr.emile.entity;

import java.io.Serializable;
import java.util.Date;

import fr.emile.common.IConstant;

public class OrderLine implements IConstant, Serializable {
	private int id; 
	private int quantity;
	private double unitPrice;
	private double discount;
	private Order order;
	private Item item;
	
}
