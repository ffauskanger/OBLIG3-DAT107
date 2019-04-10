package eao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entities.Ansatt;
import entities.Avdeling;
import entities.Prosjekt;
import entities.ProsjektDeltakelse;

public class ProsjektEAO {

	
	private EntityManagerFactory emf;
	
    public ProsjektEAO() 
    {
        emf = Persistence.createEntityManagerFactory("AnsattPersistenceUnit");
    }   
    

    public Prosjekt finnProsjektMedId(int id) {
        EntityManager em = emf.createEntityManager();
       // Avdeling a = null;

        try {
           return em.find(Prosjekt.class, id);
        } finally {
            em.close();
        }
       // return a;
    }
	
    
    public List<Prosjekt> hentAlleProsjekter() {
        EntityManager em = emf.createEntityManager();
        List<Prosjekt> prosjekter = null;

        try {
			TypedQuery<Prosjekt> query = em.createNamedQuery("hentAlleProsjekt", Prosjekt.class);
			prosjekter = query.getResultList();
        } finally {
            em.close();
        }
        return prosjekter;
    }
    
    
    public void opprettProsjekt(Prosjekt p) {
		
        EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			em.persist(p);
			tx.commit();
		
		} catch (Throwable e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}
}
