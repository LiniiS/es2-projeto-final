package br.com.fatec.ads.es.hopeapi.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fatec.ads.es.hopeapi.model.Pet;
import br.com.fatec.ads.es.hopeapi.model.StatusPet;
import br.com.fatec.ads.es.hopeapi.repository.PetRepository;

@RestController
@RequestMapping("/api/pets")
public class PetsRest {

	@Autowired
	private PetRepository petRepository;
	
	//retornar o json, n retorna a view
	@GetMapping("aguardando")
	public List<Pet> getPetsAguardandoAdocao(){
	
		Sort sort = Sort.by("id").descending();
		PageRequest paginacao = PageRequest.of(0,  5, sort);
		
		return petRepository.findByStatus(StatusPet.AGUARDANDO, paginacao);
	}
}
