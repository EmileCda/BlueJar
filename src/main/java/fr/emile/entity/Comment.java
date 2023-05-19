package fr.emile.entity;

import java.io.Serializable;

import fr.emile.common.IConstant;

public class Comment implements IConstant, Serializable {
	private int id; 
	private String  text;
	private Item item;
	private User user;
	
	
	
	

}
