package fr.emile.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
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
@Table(name = "order_line")
public final class OrderLine implements IConstant, Serializable {
	
	
	private static final long serialVersionUID = -23153027186502371L;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id; 
	private int quantity;

	
//	=>[TCreateOrderLine.java]:55 : catch myCommentDao.create(comment); org.hibernate.MappingException: Repeated column in mapping for entity: fr.emile.entity.OrderLine column: item_id (should be mapped with insert="false" update="false")
	
	@ManyToOne
	@JoinColumn(name = "order_id", nullable = false)
//	@Transient
	private Order order;
	
	@OneToOne
	@JoinColumn(name = "item_id", nullable = false)
//	@Transient
	private Item item;
	
	
	
	public OrderLine() {
		
		this(DEFAULT_ID,DEFAULT_QUANTITY,null,null);
	}
	
	public OrderLine( int quantity, Order order, Item item) {
		this(DEFAULT_ID,quantity,order,item);
	
	}
	
	public OrderLine(int id, int quantity, Order order, Item item) {
		this.setId ( id);
		this.setQuantity ( quantity);
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

	@Override
	public String toString() {
		return String.format("id[%d]%s  %d x %s", getId(),getOrder().getOrderNumber(),getQuantity(),  getItem().getName());
	}
	
	
}
