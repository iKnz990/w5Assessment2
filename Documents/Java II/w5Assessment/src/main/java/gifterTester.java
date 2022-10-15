import java.util.List;

import controller.gifterHelper;
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
public class gifterTester {

	public static void main(String[] args) {
		gifter bill = new gifter("Bill");
		gifter jim = new gifter("jim");
		gifterHelper gh = new gifterHelper();
		gh.insertItem(bill);
		gh.insertItem(jim);
		
		List<gifter> allGifters = gh.showAllItems();
		for(gifter a: allGifters) {
			System.out.println(a.toString());
		}
	}
}
