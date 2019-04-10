package klienter;


import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import eao.AnsattEAO;
import eao.AvdelingEAO;
import entities.Ansatt;
import entities.Avdeling;

public class mainTest {

	public static void main(String[] args) {

		AvdelingEAO avdeao = new AvdelingEAO();
		Avdeling avd = avdeao.finnAvdelingMedId(1);
		System.out.println(avd);

		AnsattEAO eao = new AnsattEAO();
		Ansatt ans = eao.finnAnsattMedId(1001);
		Ansatt ans2 = eao.finnAnsattMedId(1002);
		System.out.println(ans);
		System.out.println(ans2);
		
		
		//leggTilAnsatt(eao);
		//printAnsatte(eao);
		//finnAnsattMedBrukerNavn(eao, "kris");
		//finnAnsattMedID(eao, 1);
		//oppdaterAnsatt(eao, 1);
		//finnAnsattMedID(eao, 1);
		
		/*
	
		DROP SCHEMA IF EXISTS oblig3_jpa CASCADE;

		CREATE SCHEMA oblig3_jpa;
		SET search_path to oblig3_jpa;
		
		
		CREATE TABLE Ansatt
		(
		   id        SERIAL,
		   brukernavn    VARCHAR(4),
		   fornavn	VARCHAR(30),
		   etternavn VARCHAR(30),
		   ansettelse	DATE,
		   stilling	VARCHAR(30),
		   inntekt	INTEGER,
		   avdeling	VARCHAR(30),
		   PRIMARY KEY (id)  
		);
		
		*/

		
	}
/*	
	public static void finnAnsattMedBrukerNavn(AnsattEAO eao, String navn)
	{
		Ansatt a = eao.finnAnsattMedBrukerNavn(navn);
		System.out.println(a.toString());
	}
	
	public static void finnAnsattMedID(AnsattEAO eao, Integer id)
	{
		Ansatt a = eao.finnAnsattMedId(id);
		System.out.println(a.toString());
	}
	
	public static void leggTilAnsatt(AnsattEAO eao)
	{
		java.util.Date dato = new java.util.Date();
        java.sql.Date idag = new java.sql.Date(dato.getTime());
        
        AvdelingEAO evEAO = new AvdelingEAO();
        Avdeling avdeling = evEAO.finnAvdelingMedId(1);
        
		Ansatt a = new Ansatt("oles", "Ole", "Sila", idag, "stilling" , 50, avdeling);
		eao.opprettAnsatt(a);
        
	}
	
	public static void printAnsatte(AnsattEAO eao)
	{
		List<Ansatt> ansatte = eao.hentAlleAnsatte();
		
		for(Ansatt a : ansatte)
		{
			System.out.println(a.toString());
		}
	}
	
	public static void oppdaterAnsatt(AnsattEAO eao, Integer id) 
	{
		Ansatt a = eao.finnAnsattMedId(id);
		a.setBrukernavn("ole");
		eao.oppdaterAnsatt(a);
	}
*/	
}
