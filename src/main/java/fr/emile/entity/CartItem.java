package fr.emile.entity;

import java.io.Serializable;

import fr.emile.common.IConstant;

public class CartItem  implements IConstant, Serializable {


	
	private int id;
	private Item item;
	private int quantity;
	private User user; 
	
	
}
