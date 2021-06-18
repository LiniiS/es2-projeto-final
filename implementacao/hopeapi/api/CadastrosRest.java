package br.com.fatec.ads.es.hopeapi.api;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fatec.ads.es.hopeapi.dto.RequisicaoNovaAdocao;
import br.com.fatec.ads.es.hopeapi.model.Adocao;
import br.com.fatec.ads.es.hopeapi.model.Pet;
import br.com.fatec.ads.es.hopeapi.repository.PetRepository;

@RestController
@RequestMapping("/api/cadastros")
public class CadastrosRest {

	//buscar o pet no BD, vincular um cadastro de adoção
	
	@Autowired
	private PetRepository petRepository;
	
	
	@PostMapping
	public Adocao solicitarCadastroAdocao(@Valid @RequestBody RequisicaoNovaAdocao requisicao) {
		
		Optional<Pet> petBuscado = petRepository.findById(requisicao.getPetId());
		if(!petBuscado.isPresent()) {
			return null; //verificar outra forma de retornar melhor
		}
		Pet pet = petBuscado.get();
		
		Adocao novo = requisicao.toCadastro();
		novo.setPet(pet);
//		pet.getCadastroDeAdocao().add(novo);
		petRepository.save(pet);
		
		
		return novo;
	}
	
}
