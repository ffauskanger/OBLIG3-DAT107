package entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.ManyToOne;

@Entity
@Table(schema = "oblig3_jpa")
@IdClass(ProsjektDeltakelsePK.class)

public class ProsjektDeltakelse {

	private int timer;
	@Id
	@ManyToOne
	@JoinColumn(name = "ansatt_Id")
	private Ansatt ansatt;

	@Id
	@ManyToOne
	@JoinColumn(name = "prosjekt_Id")
	private Prosjekt prosjekt;
	
	public ProsjektDeltakelse() {
	}
	
	public ProsjektDeltakelse(Ansatt ansatt, Prosjekt prosjekt, int timer) {
		 this.ansatt = ansatt;
		 this.prosjekt = prosjekt;
		 this.timer = timer;
		 
		 //legge til prosjekt og ansatt her, istedenfor i EAO
	}
	

	public String toString() {
		return prosjekt.getNavn();
	}
	
	
	
	
}
