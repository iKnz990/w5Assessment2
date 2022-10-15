import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.ListDetailsHelper;
import controller.gifterHelper;
import model.ListDetails;
import model.giftRegistry;
import model.gifter;

/**
 * @author Alexander Kelly - akelly3
 * CIS175 - Fall 2022
 * Oct 10, 2022
 */

/**
 * @author 15152
 *
 */
public class ListDetailsTester {
	
	public static void main(String[] args) {
		
		//Adds a gifter
		gifter bill = new gifter("Bill");
		gifter jim = new gifter("jim");
		
		//calls CRUD
		ListDetailsHelper ldh = new ListDetailsHelper();
		
		//gifts on the list
		giftRegistry puppy = new giftRegistry("puppy","Teddy", "puppy Gifts");
		giftRegistry blanket = new giftRegistry("blanket","Teddy", "blanket Gifts");
		giftRegistry car = new giftRegistry("car","Teddy", "car Gifts");

		gifterHelper sh = new gifterHelper();
		
		
		//insert Jim's Gifts
		List<giftRegistry> jimsGifts = new ArrayList<giftRegistry>();
		jimsGifts.add(puppy);
		//insert Bill's gifts
		List<giftRegistry> billsGifts = new ArrayList<giftRegistry>();
		billsGifts.add(blanket);
		billsGifts.add(car);

		
		//The actual lists
		ListDetails billList = new ListDetails("Bill's Gift List", LocalDate.now(), bill);
		//Gives Bill the Gifts
		billList.setListOfGifts(billsGifts);
		//Give Jim his Gifts.
		ListDetails jimList = new ListDetails("Jim's Gift List", LocalDate.now(), jim);
		jimList.setListOfGifts(jimsGifts);
		
		ldh.insertNewListDetails(jimList);
		ldh.insertNewListDetails(billList);
		
		//lists the new lists.
		List<ListDetails> allLists = ldh.getLists();
		
		for(ListDetails a : allLists) {
			System.out.println(a.toString());
		}
		

	}
}
