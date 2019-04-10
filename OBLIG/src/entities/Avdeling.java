package entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "avdeling", schema = "oblig3_jpa")
@NamedQuery(name = "hentAlleAvdelinger", query ="SELECT av FROM Avdeling av")

public class Avdeling {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		private String navn;
		@OneToOne
		@JoinColumn(name = "id")
		private Ansatt sjef;
		
		//@OneToMany(targetEntity=Ansatt.class)
		@OneToMany(mappedBy = "avdeling", fetch = FetchType.EAGER)
		private List<Ansatt> ansatte;
		
		
		public List<Ansatt> getAnsatte() {
			return ansatte;
		}

		public void setAnsatte(List<Ansatt> ansatte) {
			this.ansatte = ansatte;
		}

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
		//d
		public void setNavn(String navn) {
			this.navn= navn;
		}
		
		public Ansatt getSjef() {
			return sjef;
		}
		
		public void setSjef(Ansatt sjef) {
			this.sjef = sjef;
		}
		
		@Override
		public String toString() {
			return String.format("Avdeling: [id: %d, navn: %s, sjef: %d]:"
							+ "\n"+ "\t" + "Ansatte i denne: %s" + "\n", id, navn, sjef, ansatte);
			
			
			
		}
}
