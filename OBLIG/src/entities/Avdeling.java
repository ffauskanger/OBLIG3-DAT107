package entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "avdeling", schema = "oblig3_jpa")
@NamedQuery(name = "hentAlleAvdelinger", query ="SELECT av FROM Avdeling av")

public class Avdeling {
	@Id private int id;
		private String navn;
		private int ansattSinSjef; //foreign key
	
		
		public Avdeling() {
		}
		
		public Avdeling(int id, String navn, int ansattSinSjef) {
			this.id = id;
			this.navn = navn;
			this.ansattSinSjef = ansattSinSjef;
		}
		
		public int getId() {
			return id;
		}
		
		public void setId(int id) {
			this.id = id;
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
