package klienter;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entities.Ansatt;

public class mainTest {

	public static void main(String[] args) {
		
		String jpql = "SELECT a FROM Ansatt a";
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("AnsattPersistenceUnit");
		
		EntityManager em = emf.createEntityManager();
		
		System.out.println("Kobler til database...");
		
		try {
			TypedQuery<Ansatt> query = em.createQuery(jpql, Ansatt.class);
			List<Ansatt> ansatte = query.getResultList();
			
			for (Ansatt a : ansatte) {
				System.out.println("Id: " + a.getId());
				System.out.println("Brukernavn: " + a.getBrukernavn());
			}
		} finally {
			em.close();
		}
		
		System.out.println("Ferdig!");
	}

}
