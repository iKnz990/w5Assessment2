/**
 * @author Alexander Kelly - akelly3
 * CIS175 - Fall 2022
 * Oct 10, 2022
 */
package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author 15152
 *
 */
@Entity
public class ListDetails {
	@Id
	@GeneratedValue
private int id;
private String listName;
private LocalDate tripDate;
@ManyToOne (cascade=CascadeType.PERSIST)
private gifter gifter;
@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
private List<giftRegistry> listOfGifts;


public ListDetails() {
	super();
}

public ListDetails(int id, String listName, LocalDate tripDate, gifter gifter, List<giftRegistry> listOfGifts) {
	super();
	this.id = id;
	this.listName =listName;
	this.tripDate = tripDate;
	this.gifter = gifter;
	this.listOfGifts = listOfGifts;
}

public ListDetails(String listName, LocalDate tripDate, gifter gifter, List<giftRegistry> listOfGifts) {
	super();
	this.listName = listName;
	this.tripDate = tripDate;
	this.gifter = gifter;
	this.listOfGifts = listOfGifts;
}

public ListDetails(String listName, LocalDate tripDate, gifter gifter) {
	super();
	this.listName = listName;
	this.tripDate = tripDate;
	this.gifter = gifter;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getListName() {
	return listName;
}

public void setListName(String listName) {
	this.listName = listName;
}

public LocalDate getTripDate() {
	return tripDate;
}

public void setTripDate(LocalDate tripDate) {
	this.tripDate = tripDate;
}

public gifter getGifter() {
	return gifter;
}

public void setGifter(gifter gifter) {
	this.gifter = gifter;
}

public List<giftRegistry> getListOfGifts() {
	return listOfGifts;
}

public void setListOfGifts(List<giftRegistry> listOfGifts) {
	this.listOfGifts = listOfGifts;
}

@Override
public String toString() {
	return "ListDetails [id=" + id + ", listName=" + listName + ", tripDate=" + tripDate + ", gifter=" + gifter
			+ ", listOfGifts=" + listOfGifts + "]";
}

















}
