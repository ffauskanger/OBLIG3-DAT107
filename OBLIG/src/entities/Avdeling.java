package entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "avdeling", schema = "oblig3_jpa")
@NamedQuery(name = "hentAlleAvdelinger", query ="SELECT av FROM Avdeling av")

public class Avdeling {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		private String navn;
		private Ansatt sjef; //foreign key
		
		@OneToMany(targetEntity=Ansatt.class)
		private List<Ansatt> ansatte;
		
		public Avdeling() {
		}
		
		public Avdeling(String navn, Ansatt sjef) {
			this.navn = navn;
			this.sjef = sjef;
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
		
		public Ansatt getSjef() {
			return sjef;
		}
		
		public void setSjef(Ansatt sjef) {
			this.sjef = sjef;
		}
		
}
