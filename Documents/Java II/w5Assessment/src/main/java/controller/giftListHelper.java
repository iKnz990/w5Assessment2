/**
 * @author Alexander Kelly - akelly3
 * CIS175 - Fall 2022
 * Sep 29, 2022
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


import model.giftRegistry;

/**
 * @author 15152
 *
 */
public class giftListHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("w5Assessment");
	
	public void insertItem(giftRegistry gr) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(gr);
		em.getTransaction().commit();
		em.close();
	}
	
public void deleteItem(giftRegistry toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<giftRegistry>typedQuery = em.createQuery("select li from giftRegistry li where li.name = :selectedName and li.gift = :selectedGift and li.description = :selectedDescription", giftRegistry.class);
		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedName", toDelete.getName());
		typedQuery.setParameter("selectedGift", toDelete.getGift());
		typedQuery.setParameter("selectedDescription", toDelete.getDescription());
		//only one result
		typedQuery.setMaxResults(1);
		//get the result and save into a new list item
		giftRegistry result = typedQuery.getSingleResult();
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
}

public List<giftRegistry> showAllItems(){
	EntityManager em = emfactory.createEntityManager();
	List<giftRegistry> allGifts = em.createQuery("SELECT i FROM giftRegistry i").getResultList();
	return allGifts;
}

public giftRegistry searchForItemById(int idToEdit) {
	// TODO Auto-generated method stub
	EntityManager em = emfactory.createEntityManager();
	em.getTransaction().begin();
	giftRegistry found = em.find(giftRegistry.class, idToEdit);
	em.close();
	return found;
}


public void updateItem(giftRegistry toEdit) {
	// TODO Auto-generated method stub
	EntityManager em = emfactory.createEntityManager();
	em.getTransaction().begin();
	em.merge(toEdit);
	em.getTransaction().commit();
	em.close();
}

public void cleanUp() {
	emfactory.close();
}

}
