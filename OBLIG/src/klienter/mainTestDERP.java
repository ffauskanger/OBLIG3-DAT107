package klienter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Ansatt;
import entities.Avdeling;
import entities.Prosjekt;

public class mainTestDERP {
	
	public static void main(String[] args) {
		Avdeling avd = AvdelingInfo(1);
		System.out.println(avd.getAnsattSinSjef());
		System.out.println(avd.getNavn());
		System.out.println(avd.getId());
		
		Prosjekt pro = ProsjektInfo(901);
		
		System.out.println(pro.getId());
		System.out.println(pro.getBeskirvelse());
		
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
}
