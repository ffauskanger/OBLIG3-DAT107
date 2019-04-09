package klienter;


import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import eao.AnsattEAO;
import entities.Ansatt;

public class mainTest {

	public static void main(String[] args) {
		
		AnsattEAO eao = new AnsattEAO();
		
		
		//printAnsatte(eao);
		//leggTilAnsatt(eao);
		//finnAnsattMedBrukerNavn(eao, "kris");
		finnAnsattMedID(eao, 2);
		
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
		   mlønn	INTEGER,
		   avdeling	VARCHAR(30),
		   PRIMARY KEY (id)  
		);
		
		*/

		
	}
	
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
		Ansatt a = new Ansatt("kris", "per", "chris", idag, "stilling" , 50, "avdeling");
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

}
