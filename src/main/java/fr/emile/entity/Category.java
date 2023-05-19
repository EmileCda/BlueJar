package fr.emile.entity;

import java.io.Serializable;

import fr.emile.common.IConstant;

public class Category implements IConstant, Serializable {
	private int id; 
	private String  name;
	private double  discount; // in %
	private boolean  isDiscountCumulative ;
	
	private String  picture;
	private Item  item;
		
	

}
