package br.com.fatec.ads.es.hopeapi.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Classe experimental: classe que modela o Usuário e para fins didáticos essa
 * classe foi substituída pela classe Parceiro. Essa classe será reestruturada
 * para imlementar o CRUD dentro das complexidades da autenticação e integração
 * com o usuário.
 * 
 * @author xlnst
 *
 */
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
@Table(name = "users") // parceiros
public class User {

	@Id
	@JsonIgnore
	private String username;
	@JsonIgnore
	private String password;
	private Boolean enabled; // habilitado no bd

	@Email
	private String email;

	// um parceiro(user) pode gerir um ou mais animais(pets)
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
	private List<Pet> pets;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<Pet> getPets() {
		return pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
