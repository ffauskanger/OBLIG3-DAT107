package klienter;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import eao.AnsattEAO;
import eao.AvdelingEAO;
import eao.ProsjektEAO;
import entities.Ansatt;
import entities.Avdeling;
import entities.Prosjekt;

public class Meny {
	
	ProsjektEAO pEAO;
	AnsattEAO anEAO;
	AvdelingEAO avEAO;
	
	public Meny()
	{
		pEAO = new ProsjektEAO();
		anEAO = new AnsattEAO();
		avEAO = new AvdelingEAO();
	}	
	
	
	public void start()
	{
		boolean aktiv = true;
		while(aktiv)
		{
			menyPrint();
			Integer input = Integer.parseInt(hentInput());
			switch(input)
			{
			case 0: aktiv = false; break;
			case 1: ansattMeny(); break;
			case 2: avdelingMeny(); break;
			case 3: prosjektMeny(); break;
			default: System.out.println("Feil input!"); break;
			}
		}
		
	}
	
	
	public String hentInput()
	{
		Scanner scan = new Scanner(System.in);
		return scan.nextLine();
	}
	

	public void ansattMeny()
	{
		boolean aktiv = true;
		while(aktiv)
		{
			ansattPrint();
			Integer input = Integer.parseInt(hentInput());
			switch(input)
			{
			case 0: aktiv = false; break;
			case 1: finnAnsattMedBrukerNavn(); break;
			case 2: finnAnsattMedID(); break;
			case 3: printAnsatte(); break;
			case 4: oppdaterAnsatt(); break;
			case 5: leggTilAnsatt(); break;
			default: System.out.println("Feil input!"); break;
			}
		}
		
	}
	
	public void avdelingMeny()
	{
		boolean aktiv = true;
		while(aktiv)
		{
			avdelingPrint();
			Integer input = Integer.parseInt(hentInput());
			switch(input)
			{
			case 0: aktiv = false; break;
			case 1: finnAvdelingMedID(); break;
			case 2: printAvdeling(); break;
			case 3: oppdaterAvdelingForAnsatt(); break;
			case 4: leggTilAvdeling(); break;
			default: System.out.println("Feil input!"); break;
			}
		}
	}
	
	public void prosjektMeny()
	{
		boolean aktiv = true;
		while(aktiv)
		{
			prosjektPrint();
			Integer input = Integer.parseInt(hentInput());
			switch(input)
			{
			case 0: aktiv = false; break;
			case 1: System.out.println("Prosjektdeltakelse"); break;
			case 2: printProsjekt(); break;
			case 3: System.out.println("Føre timer for ansatt"); break;
			case 4: leggTilProsjekt(); break;
			default: System.out.println("Feil input!"); break;
			}
		}
	}
	
	
	public void menyPrint()
	{
		System.out.println("--MENY--");
		System.out.println("0: Avslutt");
		System.out.println("1: Ansatt");
		System.out.println("2: Avdeling");
		System.out.println("3: Prosjekt");
		System.out.print("Tast inn ditt valg: ");
	}
	
	public void ansattPrint()
	{
		System.out.println("--ANSATT--");
		System.out.println("0: Tilbake");
		System.out.println("1: Søk etter ansatt med brukernavn");
		System.out.println("2: Søk etter ansatt med ID");
		System.out.println("3: List alle ansatte");
		System.out.println("4: Oppdater ansatt stilling eller inntekt");
		System.out.println("5: Legg til ny ansatt");
		System.out.print("Tast inn ditt valg: ");
	}
	
	public void avdelingPrint()
	{
		System.out.println("--AVDELING--");
		System.out.println("0: Tilbake");
		System.out.println("1: Søk på avdeling med ID");
		System.out.println("2: Print alle avdelinger");
		System.out.println("3: Oppdatere hvilken avdeling en ansatt jobber på");
		System.out.println("4: Legge til ny avdeling");
		System.out.print("Tast inn ditt valg: ");
	}
	
	public void prosjektPrint()
	{
		System.out.println("--PROSJEKT--");
		System.out.println("0: Tilbake");
		System.out.println("1: Registrere prosjektdeltakelse");
		System.out.println("2: List informasjon om prosjekt");
		System.out.println("3: Føre timer for en ansatt");
		System.out.println("4: Legge til nytt prosjekt");
		System.out.print("Tast inn ditt valg: ");
	}
	
	
	
	public void finnAnsattMedBrukerNavn()
	{
		System.out.print("Tast inn navn til ansatt: ");
		String navn = hentInput();
		Ansatt a = anEAO.finnAnsattMedBrukerNavn(navn);
		System.out.println(a.toString());
	}
	
	public void finnAnsattMedID()
	{
		System.out.print("Tast inn ID til en ansatt: ");
		Integer id = Integer.parseInt(hentInput());
		Ansatt a = anEAO.finnAnsattMedId(id);
		System.out.println(a.toString());
	}
	
	public void leggTilAnsatt()
	{
		java.util.Date dato = new java.util.Date();
        java.sql.Date idag = new java.sql.Date(dato.getTime());
        
        System.out.print("Brukernavn til ansatt: ");
		String brukernavn = hentInput();
        System.out.print("Fornavn til ansatt: ");
		String fornavn = hentInput();
		System.out.print("Etternavn til ansatt: ");
		String etternavn = hentInput();
		System.out.print("Stilling til ansatt: ");
		String stilling = hentInput();
		System.out.print("Inntekt til ansatt: ");
		Integer inntekt = Integer.parseInt(hentInput());
		System.out.print("Avdeling til ansatt (ID): ");
		Integer avdelingID = Integer.parseInt(hentInput());
        
        Avdeling avdeling = avEAO.finnAvdelingMedId(avdelingID);

		Ansatt a = new Ansatt(brukernavn,fornavn,etternavn,idag,stilling,inntekt,avdeling);
		anEAO.opprettAnsatt(a);
        
	}
	
	public void printAnsatte()
	{
		List<Ansatt> ansatte = anEAO.hentAlleAnsatte();
		
		for(Ansatt a : ansatte)
		{
			System.out.println(a.toString());
		}
	}

	public void oppdaterAnsatt() 
	{
		System.out.print("Hvilken ansatt vil du endre? (ID): ");
		Integer id = Integer.parseInt(hentInput());
		Ansatt a = anEAO.finnAnsattMedId(id);
		
		boolean aktiv = true;
		while(aktiv)
		{
			System.out.println("Hva vil du endre på?");
			System.out.println("0: Ingenting");
			System.out.println("1: Inntekt");
			System.out.println("2: Stilling");
			
			Integer input = Integer.parseInt(hentInput());
			switch(input)
			{
				case 0: aktiv = false; break;
				case 1: oppdaterInntekt(a); aktiv = false; break;
				case 2: oppdaterStilling(a); aktiv = false; break; 
				default: System.out.println("Feil input!"); break;
			}
		}
	}
	
	public void oppdaterStilling(Ansatt a)
	{
		System.out.print("Hva vil du endre stillingen til: ");
		String stilling = hentInput();
		a.setStilling(stilling);
		anEAO.oppdaterAnsatt(a);
		
	}
	
	public void oppdaterInntekt(Ansatt a)
	{
		System.out.print("Hva vil du endre inntekten til: ");
		Integer inntekt = Integer.parseInt(hentInput());
		a.setInntekt(inntekt);
		anEAO.oppdaterAnsatt(a);
	}
	
	public void leggTilAvdeling()
	{
		System.out.print("Navn til avdeling: ");
		String navn = hentInput();
		System.out.print("Hvilken ansatt er sjef? (ID): ");
		Integer sjefID = Integer.parseInt(hentInput());
		
		Ansatt sjef = anEAO.finnAnsattMedId(sjefID);
		
		Avdeling a = new Avdeling(navn, sjef);
		avEAO.opprettAvdeling(a);
        
	}
	
	
	public void printAvdeling()
	{
		
		List<Avdeling> avdelinger = avEAO.hentAlleAvdelinger();
		
		for(Avdeling a : avdelinger)
		{
			System.out.println(a.toString());
		}
	}
	
	public void oppdaterAvdelingForAnsatt()
	{
		System.out.print("Hvilken ansatt gjelder det? (ID): ");
		Integer ansattID = Integer.parseInt(hentInput());
		
		Ansatt a = anEAO.finnAnsattMedId(ansattID);
		System.out.print("Hvilken avdeling skal den ansatte være? (ID): ");
		Integer avdelingID = Integer.parseInt(hentInput());
		
		Avdeling avdeling = avEAO.finnAvdelingMedId(avdelingID);
		a.setAvdeling(avdeling);
		
		anEAO.oppdaterAnsatt(a);
		
	}
	
	public void finnAvdelingMedID()
	{
		System.out.print("Hvilken avdeling gjelder det? (ID): ");
		Integer avdelingID = Integer.parseInt(hentInput());
		Avdeling avdeling = avEAO.finnAvdelingMedId(avdelingID);
		
		System.out.println(avdeling.toString());

		
	}
	
	public void leggTilProsjekt()
	{
		System.out.print("Hvilket navn har prosjektet?: ");
		String navn = hentInput();
		
		System.out.print("Hvilken beskrivelse har prosjektet?: ");
		String beskrivelse = hentInput();
		
		Prosjekt p = new Prosjekt(navn, beskrivelse);
		
		pEAO.opprettProsjekt(p);
	}
	
	
	public void printProsjekt()
	{
		System.out.print("Hvilket prosjekt skal printes? (ID): ");
		Integer pID = Integer.parseInt(hentInput());
		
		Prosjekt p = pEAO.finnProsjektMedId(pID);
		System.out.println(p.toString());

	}
}
