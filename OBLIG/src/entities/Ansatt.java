package entities;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "ansatt", schema = "oblig3_jpa")
@NamedQuery(name = "hentAlleAnsatte", query ="SELECT a FROM Ansatt a")

public class Ansatt {
		@Id     
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id; 
		private String brukernavn;
		private String fornavn;
		private String etternavn;
		private Date ansettelse;
		private String stilling;
		private Integer inntekt;
		@ManyToOne
		@JoinColumn(name = "id", insertable=false, updatable=false)
		private Avdeling avdeling;
		
	public Ansatt() {
	}
	
	public Ansatt(String brukernavn, String fornavn, String etternavn, Date ansettelse, String stilling, int inntekt, Avdeling avdeling) {
		this.brukernavn = brukernavn;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.ansettelse = ansettelse;
		this.stilling = stilling;
		this.inntekt = inntekt;
		this.avdeling = avdeling;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setBrukernavn(String brukernavn) {
		this.brukernavn = brukernavn;
	}
	
	public String getBrukernavn() {
		return brukernavn;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString()
	{
        
		return String.format("Ansatt: id=%d, brukernavn=%s, fornavn=%s, etternavn=%s, ansettelse=%s, stilling=%s, inntekt=%d, avdeling=%s", id, brukernavn, fornavn, etternavn, ansettelse.toString(), stilling, inntekt, avdeling.getNavn());
	}

}
