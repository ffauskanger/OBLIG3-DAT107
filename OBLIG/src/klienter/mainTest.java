package klienter;


import java.util.List;
import eao.AnsattEAO;
import eao.AvdelingEAO;
import eao.ProsjektDeltakelseEAO;
import eao.ProsjektEAO;
import entities.Ansatt;
import entities.Avdeling;
import entities.Prosjekt;
import entities.ProsjektDeltakelse;

public class mainTest {

	public static void main(String[] args) {

		//AvdelingEAO avdeao = new AvdelingEAO();
		//Avdeling avd = avdeao.finnAvdelingMedId(1);
		//System.out.println(avd);
		
		//Meny meny = new Meny();
		
		ProsjektDeltakelseEAO pdelEAO = new ProsjektDeltakelseEAO();
		ProsjektEAO peao = new ProsjektEAO();
		AnsattEAO eao = new AnsattEAO();
		
		System.out.println(peao.finnProsjektMedId(51).toString());
		//leggTilDeltakelse(pdelEAO);
		/*ff
		List<Prosjekt> prosjekter = peao.hentAlleProsjekter();
		for(Prosjekt p : prosjekter)
		{
			p.toString();
		}*/
		
		
		//Ansatt ans = eao.finnAnsattMedId(1001);
		//Ansatt ans2 = eao.finnAnsattMedId(1002);
		//System.out.println(ans);
		//System.out.println(ans2);
		
		
		//leggTilAnsatt(eao);
		//printAnsatte(eao);
		//finnAnsattMedBrukerNavn(eao, "kris");
		//finnAnsattMedID(eao, 1001);
		//oppdaterAnsatt(eao, 1);
		//finnAnsattMedID(eao, 1);
		
	}
	
	public static void leggTilDeltakelse(ProsjektDeltakelseEAO eao)
	{
		
		ProsjektEAO peao = new ProsjektEAO();
		AnsattEAO aeao = new AnsattEAO();
		Ansatt a = aeao.finnAnsattMedId(1001);
		Prosjekt p = peao.finnProsjektMedId(51);
		ProsjektDeltakelse pDel = new ProsjektDeltakelse(a, p, 50);
		eao.opprettDeltakelse(pDel);
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
	
}
