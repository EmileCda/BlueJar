package fr.emile.entity;

import java.io.Serializable;
import java.util.List;

import fr.emile.common.IConstant;

public class Item implements IConstant, Serializable {
	
	private int id; 
	private String  name;
	private String  description;
	private double price;
	private double discount; // in %
	private int  inventory; 
	private boolean  isSalable; 
	private String  picture ;
	private String  video;
	private Category  category;
	private List<Comment> commentList;
	 
	

}
