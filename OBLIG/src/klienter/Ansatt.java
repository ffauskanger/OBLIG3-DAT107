package klienter;

import javax.persistence.*;

@Entity
@Table(name = "ansatt", schema = "oblig3_jpa")
@NamedQuery(name = "hentAllePersoner", query ="SELECT a FROM Ansatt a")

public class Ansatt {
	@Id private Integer id; 
		private String brukernavn;
/*		private String fornavn;
		private String etternavn;
		private Integer ansettelse;
		private String stilling;
		private int mlønn;
		private String avdeling;
	*/
	public Ansatt() {
	}
	
/*	public Ansatt(int id, String brukernavn, String fornavn, String etternavn, int ansettelse,
						String stilling, int ml�nn, String avdeling) {
	}
*/
	public Ansatt(int id, String brukernavn) {
		this.id = id;
		this.brukernavn = brukernavn;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setBrukernavnd(String brukernavn) {
		this.brukernavn = brukernavn;
	}
	
	public String getBrukernavn() {
		return brukernavn;
	}

	public int getId() {
		return id;
	}

	

}
