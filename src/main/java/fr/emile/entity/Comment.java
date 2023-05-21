package fr.emile.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fr.emile.common.IConstant;




@Entity
@Table(name = "comment")
public class Comment implements IConstant, Serializable {

	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id; 
	private String  text;
	private int   grade ; // from 0 to 5 
	
	
	@ManyToOne
	@JoinColumn(name = "item_id", nullable = false)
	private Item item;

	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	
	public Comment() {
		this(DEFAULT_ID,DEFAULT_TEXT,DEFAULT_GRADE);
	}
	public Comment(String text, int note) {

		this(DEFAULT_ID,text,note);
	}
	
	public Comment(int id, String text, int note) {
		this.setId ( id);
		this.setText ( text);
		this.setGrade ( note);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	public int getGrade() {
		
		
		return grade;
	}

	public void setGrade(int grade) {
		if(grade <0) grade = 0 ; 
		else if (grade >5) grade = 5 ;
		
		this.grade = grade;
	}

	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return String.format("id[%d] %s stars: %s", getId(), getGrade(), getText());
	}

	
	
	
	
	

}
