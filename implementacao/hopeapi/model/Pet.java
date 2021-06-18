package br.com.fatec.ads.es.hopeapi.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Classe experimental: classe que modela o Animal e para fins didáticos essa
 * classe foi substituída pela classe Animal. Essa classe será reestruturada
 * para imlementar o CRUD dentro das complexidades da autenticação e integração com o usuário.
 * 
 * @author xlnst
 *
 */

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
public class Pet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nomePet; // nome do bichinho
	private String cidade; // cidade
	private LocalDate dataDeAcolhimento; // data que o pet foi acolhido
	private String urlDoContato; // t.me/ContatoDoParceiro

	@Enumerated(EnumType.STRING)
	private TipoPet tipoAnimal; // gato/dog

	@Enumerated(EnumType.STRING)
	private PortePet porteDoAnimal; // mini, pequeno, medio, grande

	@Enumerated(EnumType.STRING)
	private SexoPet sexo; // macho/fêmea

	private String urlImagem;
	private String descricao; // area livre pra descrever detalhes do pet

	private String dataDeAdocao;

	@Enumerated(EnumType.STRING)
	private StatusPet status; // situação atual do pet (adotado, em transição e aguardando)

	// muitos pets serão geridos por um unico user(parceiro)
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	private User user;

//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pet", fetch = FetchType.LAZY, orphanRemoval = true)
//	@JsonIgnore
//	private List<Adocao> cadastroDeAdocao; //um pet pode passar por muitas tentativas ate´ser adotado
//	
	public String getNomePet() {
		return nomePet;
	}

	public void setNomePet(String nomePet) {
		this.nomePet = nomePet;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String localizacao) {
		this.cidade = localizacao;
	}

	public LocalDate getDataDeAcolhimento() {
		return dataDeAcolhimento;
	}

	public void setDataDeAcolhimento(LocalDate dataDeAcolhimento) {
		this.dataDeAcolhimento = dataDeAcolhimento;
	}

	public String getUrlDoContato() {
		return urlDoContato;
	}

	public void setUrlDoContato(String urlDoContato) {
		this.urlDoContato = urlDoContato;
	}

	public String getUrlImagem() {
		return urlImagem;
	}

	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public StatusPet getStatus() {
		return status;
	}

	public void setStatus(StatusPet status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	public List<Adocao> getCadastroDeAdocao() {
//		return cadastroDeAdocao;
//	}
//	public void setCadastroDeAdocao(List<Adocao> cadastroDeAdocao) {
//		this.cadastroDeAdocao = cadastroDeAdocao;
//	}
	public String getDataDeAdocao() {
		return dataDeAdocao;
	}

	public void setDataDeAdocao(String dataDeAdocao) {
		this.dataDeAdocao = dataDeAdocao;
	}

	public PortePet getPorteDoAnimal() {
		return porteDoAnimal;
	}

	public void setPorteDoAnimal(PortePet porteDoAnimal) {
		this.porteDoAnimal = porteDoAnimal;
	}

	public SexoPet getSexo() {
		return sexo;
	}

	public void setSexo(SexoPet sexo) {
		this.sexo = sexo;
	}

	public TipoPet getTipoAnimal() {
		return tipoAnimal;
	}

	public void setTipoAnimal(TipoPet tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}

}
