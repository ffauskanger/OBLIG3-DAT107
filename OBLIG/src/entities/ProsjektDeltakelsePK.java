package entities;

public class ProsjektDeltakelsePK {
	private int ansatt;
	private int prosjekt;
	
	public ProsjektDeltakelsePK() {
	}
	
	public ProsjektDeltakelsePK(int ansattId, int prosjektId) {
		this.ansatt = ansattId;
		this.prosjekt = prosjektId; 
	}
	

}
