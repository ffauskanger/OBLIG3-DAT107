package entities;

import java.util.List;
//d
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "prosjekt", schema = "oblig3_jpa")
@NamedQuery(name = "hentAlleProsjekt", query = " SELECT p FROM Prosjekt p")

public class Prosjekt {

	@Id private int id;
		private String navn;
		private String beskrivelse;

		public List<ProsjektDeltakelse> getDeltagelser() {
			return deltagelser;
		}

		public void setDeltagelser(List<ProsjektDeltakelse> deltagelser) {
			this.deltagelser = deltagelser;
		}

		public String getBeskrivelse() {
			return beskrivelse;
		}
		@OneToMany(mappedBy = "prosjekt")
		private List<ProsjektDeltakelse> deltagelser;
		
		public Prosjekt() {
		}

		public Prosjekt(String navn, String beskrivelse) {
			this.navn = navn;
			this.beskrivelse = beskrivelse;
		}
		
		public void setNavn(String navn) {
			this.navn = navn;
		}
		
		public String getNavn() {
			return navn;
		}	
		
		public void setBeskrivelse(String beskrivelse) {
			this.beskrivelse = beskrivelse;
		}
		
		public String getBeskirvelse() {
			return beskrivelse;
		}	
		
		public void setId(int id) {
			this.id = id;
		}
		
		public int getId() {
			return id;
		}
		@Override
		public String toString() {
			return String.format("Prosjekt: [id: %d, navn: %s, beskrivelse: %s]:", id, navn, beskrivelse);
			
			
			
		}

}
