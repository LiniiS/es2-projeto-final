package br.com.fatec.ads.es.hopeapi.model;

public enum TipoPet {
	
	GATO("Gato"), 
	CACHORRO("Cachorro"); 
	
	private final String displayText;

	TipoPet(String displayText) {
	    this.displayText = displayText;
	}

	public String getDisplayText() {
	    return displayText;
	}

}
