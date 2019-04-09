package eao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entities.Ansatt;

public class AnsattEAO {
	
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
	
	/*
	public static Ansatt finnAnsattMedBrukerNavn(String brukernavn) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AnsattPersistenceUnit");
        EntityManager em = emf.createEntityManager();
        Ansatt a = null;

        try {
            a = em.find(Ansatt.class, brukernavn);
        } finally {
            em.close();
        }
        return a;
    }*/
	
	public static List<Ansatt> hentAlleAnsatte() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AnsattPersistenceUnit");
        EntityManager em = emf.createEntityManager();
        List<Ansatt> ansatte = null;

        try {
			TypedQuery<Ansatt> query = em.createNamedQuery("hentAlleAnsatte", Ansatt.class);
			ansatte = query.getResultList();
        } finally {
            em.close();
        }
        return ansatte;
    }
	
	public void opprettAnsatt(Ansatt a) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("AnsattPersistenceUnit");
        EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			em.persist(a);
			tx.commit();
		
		} catch (Throwable e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}
	/*
	public void oppdaterAnsatt(Ansatt a) {

		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("AnsattPersistenceUnit");
	     EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			Ansatt q = em.merge(a);
			
			boolean x = a.getBrukernavn().equals("X");
			if (x) p.setNavn("Tull");	//Virker ikke siden p er detached
			if (x) q.setNavn("Tull");	//Virker siden q er managed
			em.getTransaction().commit();
		
		} catch (Throwable e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}*/
}
