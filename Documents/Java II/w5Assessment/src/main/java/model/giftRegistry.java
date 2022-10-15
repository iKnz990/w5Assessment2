/**
 * @author Alexander Kelly - akelly3
 * CIS175 - Fall 2022
 * Sep 29, 2022
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 15152
 *
 */
@Entity
@Table(name="gifts")
public class giftRegistry {
@Id
@GeneratedValue
@Column(name="ID")
private int id;
@Column(name="GIFT")
	private String gift;
@Column(name="NAME")
	private String name;
@Column(name="DESCRIPTION")
private String description;
	
public giftRegistry(){
	super();
}
public giftRegistry(String gift, String name, String description) {
	super();
	this.gift = gift;
	this.name = name;
	this.description = description;
	
}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGift() {
		return gift;
	}
	public void setGift(String gift) {
		this.gift = gift;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	@Override
	public String toString() {
		return "giftRegistry [id=" + id + ", gift=" + gift + ", name=" + name + ", description=" + description + "]";
	}
	
	public String returnItemDetails() {
		return this.gift + this.name + this.description;
	}
	
}
