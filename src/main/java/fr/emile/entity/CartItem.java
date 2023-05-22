package fr.emile.entity;

import java.io.Serializable;

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



@Entity
@Table(name = "cart_item")
public class CartItem  implements IConstant, Serializable {


	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	private int quantity;

	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
//	@Transient
	private User user; 
	
	@OneToOne
	@JoinColumn(name = "item_id", nullable = false)
//	@Transient
	private Item item;
	
	
	
	
	
	public CartItem() {
		this(DEFAULT_ID, DEFAULT_QUANTITY,null, null);
	}

	public CartItem(int quantity) {
		this(DEFAULT_ID, quantity,null, null);
	}

	public CartItem(int id, int quantity, User user, Item item) {
		this.id = id;
		this.quantity = quantity;
		this.user = user;
		this.item = item;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	@Override
	public String toString() {
		return String.format("Id[%d] %s x %d [%s]", 
				getId(),
				getItem().getName(),
				getQuantity(),
				getUser().getFullName());
				
	}
	
	
	
	
}
