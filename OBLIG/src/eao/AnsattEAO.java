package eao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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

}
