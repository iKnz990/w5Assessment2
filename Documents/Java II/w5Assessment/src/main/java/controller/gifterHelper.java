/**
 * @author Alexander Kelly - akelly3
 * CIS175 - Fall 2022
 * Oct 10, 2022
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.giftRegistry;
import model.gifter;

/**
 * @author 15152
 *
 */
public class gifterHelper {
static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("w5Assessment");

public void insertItem(gifter gf) {
	EntityManager em = emfactory.createEntityManager();
	em.getTransaction().begin();
	em.persist(gf);
	em.getTransaction().commit();
	em.close();
}


@SuppressWarnings("unchecked")
public List<gifter> showAllItems(){
	EntityManager em = emfactory.createEntityManager();
	List<gifter> allGifters = em.createQuery("SELECT s FROM gifter s").getResultList();
	return allGifters;


}


/**
 * @param gifterName
 * @return
 */
public gifter findGifter(String giftToLookUp) {
	EntityManager em = emfactory.createEntityManager();
	em.getTransaction().begin();
	TypedQuery<gifter> typedQuery = em.createQuery("select sh from gifter sh where sh.gifterName = :selectedName", gifter.class);
	
	typedQuery.setParameter("selectedName", giftToLookUp);
	typedQuery.setMaxResults(1);
	
	gifter foundGifter;
	try {
		foundGifter = typedQuery.getSingleResult();
	} catch (NoResultException ex) {
		foundGifter = new gifter(giftToLookUp);
	}
	em.close();
	
	return foundGifter;
}

}