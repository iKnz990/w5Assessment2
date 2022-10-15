/**
 * @author Alexander Kelly - akelly3
 * CIS175 - Fall 2022
 * Oct 10, 2022
 */
package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 15152
 *
 */
@Entity
@Table(name="gifter")
public class gifter {
@Id 
@GeneratedValue
private int id;
private String gifterName;

public gifter() {
	super();
}

public gifter(int id, String gifterName) {
	super();
	this.id = id;
	this.gifterName = gifterName;
}
public gifter(String gifterName) {
	super();
	this.gifterName = gifterName;
}
public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getGifterName() {
	return gifterName;
}

public void setGifterName(String gifterName) {
	this.gifterName = gifterName;
}

@Override
public String toString() {
	return "gifter [id=" + id + ", gifterName=" + gifterName + "]";
}

}
