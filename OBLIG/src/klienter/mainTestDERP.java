package klienter;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import eao.AnsattEAO;
import entities.Ansatt;
import entities.Avdeling;
import entities.Prosjekt;

public class mainTestDERP {
	
	public static void main(String[] args) {

		AnsattEAO eao = new AnsattEAO();
		
		//printAnsatte(eao);
	}
	  public static Ansatt finnAnsattMedId(int id) {
	        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AnsattPersistenceUnit");
	        EntityManager em = emf.createEntityManager();
	        Ansatt a = null;

	        try {
	            a = em.find(Ansatt.class, id);
	        } finally {
	            em.close();
	        }
	        return a;
	    }

	  public static Avdeling AvdelingInfo(int id) {
		  EntityManagerFactory emf = Persistence.createEntityManagerFactory("AnsattPersistenceUnit");
	        EntityManager em = emf.createEntityManager();
	        Avdeling a = null;

	        try {
	            a = em.find(Avdeling.class, id);
	        } finally {
	            em.close();
	        }
	        return a;
		  
	  }
	  
	  public static Prosjekt ProsjektInfo(int id) {
		  EntityManagerFactory emf = Persistence.createEntityManagerFactory("AnsattPersistenceUnit");
	        EntityManager em = emf.createEntityManager();
	        Prosjekt a = null;

	        try {
	            a = em.find(Prosjekt.class, id);
	        } finally {
	            em.close();
	        }
	        return a;
		  
	  }
/*	  
	  public static void printAnsatte(AnsattEAO eao)
		{
			List<Ansatt> ansatte = eao.hentAlleAnsatte();
			
			for(Ansatt a : ansatte)
			{
				System.out.println(a.toString());
			}
		}
*/		
}
