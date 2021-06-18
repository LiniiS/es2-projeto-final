package br.com.fatec.ads.es.hopeapi.model;

public enum StatusPet {
	AGUARDANDO("Aguardando"), //sem manifestação de interesse na adoção
	TRANSICAO("Em transição"),  //potencial adoção em curso
	ADOTADO("Adotado");   //pet adotado e entregue ao novo dono

	private final String displayText;

	StatusPet(String displayText) {
	    this.displayText = displayText;
	}

	public String getDisplayText() {
	    return displayText;
	}
	
	
}


