package eao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entities.ProsjektDeltakelse;

public class ProsjektDeltakelseEAO {
	
	 private EntityManagerFactory emf;
		
	    public ProsjektDeltakelseEAO() 
	    {
	        emf = Persistence.createEntityManagerFactory("AnsattPersistenceUnit");
	    }
	    
	    
		
		public void opprettDeltakelse(ProsjektDeltakelse p) {
			
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
