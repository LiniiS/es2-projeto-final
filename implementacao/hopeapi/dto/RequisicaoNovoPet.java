package br.com.fatec.ads.es.hopeapi.dto;

import br.com.fatec.ads.es.hopeapi.model.Pet;
import br.com.fatec.ads.es.hopeapi.model.PortePet;
import br.com.fatec.ads.es.hopeapi.model.SexoPet;
import br.com.fatec.ads.es.hopeapi.model.StatusPet;

import javax.validation.constraints.NotBlank;

public class RequisicaoNovoPet {

	//vai mapear somente os dados necessários cm os names dos inputs do html
	
	@NotBlank //NotBlank.requisicaoNovoPet.nomePet=campo n pode ser em branco
	private String nomePet;
	@NotBlank
	private String cidade;
	@NotBlank
	private String urlImagem;
	
	@NotBlank
	private String sexo;
	@NotBlank
	private String porteDoAnimal;
	
	@NotBlank
	private String urlContato;
	
	private String descricao;
	
	public String getNomePet() {
		return nomePet;
	}
	public void setNomePet(String nomePet) {
		this.nomePet = nomePet;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUrlImagem() {
		return urlImagem;
	}
	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}
	public String getUrlContato() {
		return urlContato;
	}
	public void setUrlContato(String urlContato) {
		this.urlContato = urlContato;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getPorteDoAnimal() {
		return porteDoAnimal;
	}
	public void setPorteDoAnimal(String porteDoAnimal) {
		this.porteDoAnimal = porteDoAnimal;
	}
	
	public Pet toPet() {
		Pet pet = new Pet();
		pet.setNomePet(nomePet);
		pet.setCidade(cidade);
		pet.setUrlDoContato(urlContato);
		pet.setUrlImagem(urlImagem);
		pet.setDescricao(descricao);
	//	pet.setPorteDoAnimal(porteDoAnimal);
	//	pet.setSexo(sexo);
		pet.setPorteDoAnimal(PortePet.valueOf(porteDoAnimal));
		pet.setSexo(SexoPet.valueOf(sexo));
		
		
		//todo pet recem cadastrado receberá status aguardando
		pet.setStatus(StatusPet.AGUARDANDO);
		
		return pet;
	}
	
	
	
}
