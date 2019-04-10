package eao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

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


public List<Avdeling> hentAlleAvdelinger() {
    EntityManager em = emf.createEntityManager();
    List<Avdeling> avdelinger = null;

    try {
		TypedQuery<Avdeling> query = em.createNamedQuery("hentAlleAvdelinger", Avdeling.class);
		avdelinger = query.getResultList();
    } finally {
        em.close();
    }
    return avdelinger;
}
}
