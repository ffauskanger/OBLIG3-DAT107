package eao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entities.Ansatt;
import entities.Avdeling;

public class AvdelingEAO {
	
private EntityManagerFactory emf;
	
    public AvdelingEAO() 
    {
        emf = Persistence.createEntityManagerFactory("AnsattPersistenceUnit");
    }
    
    public Avdeling finnAvdelingMedId(int id) {
        EntityManager em = emf.createEntityManager();
       // Avdeling a = null;

        try {
           return em.find(Avdeling.class, id);
        } finally {
            em.close();
        }
       // return a;
    }
	
    
public void opprettAvdeling(Avdeling a) {
		
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

}
