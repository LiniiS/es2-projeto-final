package br.com.fatec.ads.es.hopeapi.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Adocao {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate dataDeAdocao; //pelo novo dono
	private StatusPet status;
	private String comentario;
	
	@ManyToOne(fetch= FetchType.LAZY, cascade = CascadeType.ALL) //muitos cadastros para um pet, até fechar com um usuario
	@JsonIgnore //evitar a serialização 
	private Pet pet;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataDeAdocao() {
		return dataDeAdocao;
	}

	public void setDataDeAdocao(LocalDate dataDeAdocao) {
		this.dataDeAdocao = dataDeAdocao;
	}

	public StatusPet getStatus() {
		return status;
	}

	public void setStatus(StatusPet status) {
		this.status = status;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String descricao) {
		this.comentario = descricao;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}
	
	
}
