package br.com.fatec.ads.es.hopeapi.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Classe que modela o Animal, objeto fundamental do modelo de negócio. Para fins
 * didáticos essa classe foi criada de forma simples para atender a
 * implementaçaõ simplificada do CRUD
 * 
 * @author xlnst
 *
 */
@Entity
public class Animal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome_pet")
	private String nomeDoPet;
	private String cidade;

	@Column(name = "dt_acolhimento")
	private LocalDate dataDeAcolhimento;

	@Column(name = "contato_acolhedor")
	private String contatoDoAcolhedor;

	@Column(name = "porte_animal")

	@Enumerated(EnumType.STRING)
	private PortePet porteDoAnimal;

	@Enumerated(EnumType.STRING)
	private SexoPet sexo;

	@Column(name = "url_imagem")
	private String urlImagem;

	private TipoPet tipoAnimal;

	private String descricao;

//	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyy");

	public Animal() {
	}

	public Animal(Long id, String nomeDoPet, String cidade, LocalDate dataDeAcolhimento, String contatoDoAcolhedor,
			PortePet porteDoAnimal, SexoPet sexo, String urlImagem, String descricao, StatusPet status,
			TipoPet tipoAnimal) {
		super();
		this.id = id;
		this.nomeDoPet = nomeDoPet;
		this.cidade = cidade;
		this.dataDeAcolhimento = dataDeAcolhimento;
		this.contatoDoAcolhedor = contatoDoAcolhedor;
		this.porteDoAnimal = porteDoAnimal;
		this.sexo = sexo;
		this.urlImagem = urlImagem;
		this.descricao = descricao;
		this.status = status;
		this.setTipoAnimal(tipoAnimal);
	}

	private StatusPet status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeDoPet() {
		return nomeDoPet;
	}

	public void setNomeDoPet(String nomeDoPet) {
		this.nomeDoPet = nomeDoPet;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public LocalDate getDataDeAcolhimento() {
		return dataDeAcolhimento;
	}

	public void setDataDeAcolhimento(LocalDate dataDeAcolhimento) {
		this.dataDeAcolhimento = dataDeAcolhimento;
	}

	public String getContatoDoAcolhedor() {
		return contatoDoAcolhedor;
	}

	public void setContatoDoAcolhedor(String contatoDoAcolhedor) {
		this.contatoDoAcolhedor = contatoDoAcolhedor;
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

	public TipoPet getTipoAnimal() {
		return tipoAnimal;
	}

	public void setTipoAnimal(TipoPet tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}

}
