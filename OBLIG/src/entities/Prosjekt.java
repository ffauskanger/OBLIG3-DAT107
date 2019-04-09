package entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "prosjekt", schema = "oblig3_jpa")
@NamedQuery(name = "hentAlleProsjekt", query = " SELECT p FROM Prosjekt p")

public class Prosjekt {

	@Id private int id;
		private String navn;
		private String beskrivelse;
		private String deltakelse; //Usikker, her skal:  Hvilke ansatte som deltar/ har deltatt m/rolle og antall arbeidstimer
		
		public Prosjekt() {
			
		}

		public Prosjekt(String navn, String beskrivelse, String deltakelse) {
			this.navn = navn;
			this.beskrivelse = beskrivelse;
			this.deltakelse = deltakelse; 
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

}
