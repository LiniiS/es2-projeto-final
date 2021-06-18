package br.com.fatec.ads.es.hopeapi.model;

public enum SexoPet {
	
	MACHO("Macho"), 
	FEMEA("Fêmea"); 
	
	private final String displayText;

	SexoPet(String displayText) {
	    this.displayText = displayText;
	}

	public String getDisplayText() {
	    return displayText;
	}

}
