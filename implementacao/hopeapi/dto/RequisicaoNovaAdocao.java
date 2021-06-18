package br.com.fatec.ads.es.hopeapi.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import br.com.fatec.ads.es.hopeapi.model.Adocao;

public class RequisicaoNovaAdocao {

	//precisa setar o Status do pet = ADOTADO
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
	@NotNull
	private Long petId;
	
	@Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$")
	@NotNull
	private String dataDeAdocao;
	private String comentario;
	
	
	public Long getPetId() {
		return petId;
	}
	public void setPetId(Long petId) {
		this.petId = petId;
	}
	
	public String getDataDeAdocao() {
		return dataDeAdocao;
	}
	public void setDataDeAdocao(String dataDeAdocao) {
		this.dataDeAdocao = dataDeAdocao;
	}
	
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public Adocao toCadastro() {
		Adocao cadastro = new Adocao();
		cadastro.setDataDeAdocao(LocalDate.parse(dataDeAdocao, formatter));
		cadastro.setComentario(this.comentario);
		
		return cadastro;
	}
	
	
}
