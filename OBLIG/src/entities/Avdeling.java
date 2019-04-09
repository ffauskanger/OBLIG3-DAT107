package entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "avdeling", schema = "oblig3_jpa")
@NamedQuery(name = "hentAlleAvdelinger", query ="SELECT av FROM Avdeling av")

public class Avdeling {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int avdid;
		private String navn;
		private Ansatt ansattSinSjef; //foreign key
	
		private List<Ansatt> ansatte;
		public Avdeling() {
		}
		
		public Avdeling(int avdid, String navn, Ansatt ansattSinSjef) {
			this.avdid = avdid;
			this.navn = navn;
			this.Ansatt = ansattSinSjef;
		}
		
		public int getId() {
			return avdid;
		}
		
		public void setId(int id) {
			this.avdid = avdid;
		}
		
		public String getNavn() {
			return navn;
		}
		
		public void setNavn(String navn) {
			this.navn= navn;
		}
		
		public int getAnsattSinSjef() {
			return ansattSinSjef;
		}
		
		public void setAnsattSinSjef(int ansattSinSjef) {
			this.ansattSinSjef = ansattSinSjef;
		}
		
}
