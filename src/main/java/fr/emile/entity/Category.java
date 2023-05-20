package fr.emile.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import fr.emile.common.IConstant;



@Entity
@Table(name = "category")
public class Category implements IConstant, Serializable {
	
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id; 
	private String  name;
	private int  discount; // in %
	@Column(name = "is_discount_cumulative")
	private boolean  isDiscountCumulative ;
	
	private String  picture;
	private boolean isDelete;

	public boolean isDelete() {
		return isDelete;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}
	@Transient
	private Item  item;
	
	
	
	public Category() {
		this(DEFAULT_ID,DEFAULT_NAME,0,false,DEFAULT_PICTURE,false);
	}
	
	public Category(String name, int discount, boolean isDiscountCumulative, String picture) {
		this(DEFAULT_ID,name,discount, isDiscountCumulative, picture, false);
	}
	
	
	public Category(int id, String name, int discount, 
			boolean isDiscountCumulative, String picture, 
			boolean isDeleted) {
		this.setId ( id);
		this.setName ( name);
		this.setDiscount ( discount);
		this.setDiscountCumulative ( isDiscountCumulative);
		this.setPicture (picture);
		this.setItem ( item);
		this.setDelete(isDeleted);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public boolean isDiscountCumulative() {
		return isDiscountCumulative;
	}
	public void setDiscountCumulative(boolean isDiscountCumulative) {
		this.isDiscountCumulative = isDiscountCumulative;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return String.format(
				"Id[%d] %s -%s%c%s, %s",
				getId(), getName(), getDiscount(),'%', 
				isDiscountCumulative()?" cumulable": "", 
				getPicture(), isDelete()?"deleted":"" );
	}
		
	
	

}
