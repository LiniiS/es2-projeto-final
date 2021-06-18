package br.com.fatec.ads.es.hopeapi.model;

public enum PortePet {

	PEQUENO("Pequeno"), //Peso menor que 9kg
	MEDIO("Médio"),  //Peso entre 9 e 22kg
	GRANDE("Grande"),   //Peso entre 20 e 40kg
	GIGANTE("Gigante"); //Peso acima de 40kg

	private final String displayText;

	PortePet(String displayText) {
	    this.displayText = displayText;
	}

	public String getDisplayText() {
	    return displayText;
	}
	
	
}
