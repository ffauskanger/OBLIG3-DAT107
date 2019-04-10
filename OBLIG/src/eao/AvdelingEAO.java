package eao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
	

}
