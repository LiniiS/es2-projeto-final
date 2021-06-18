package br.com.fatec.ads.es.hopeapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatec.ads.es.hopeapi.model.Pet;
import br.com.fatec.ads.es.hopeapi.repository.PetRepository;

/**
 * Classe experimental utilizada para atender as requisições relativas à classe
 * experimental Pet.
 * 
 * @author xlnst
 *
 */
@Service
public class PetServiceImpl implements PetService {

	@Autowired
	private PetRepository petRepository;

	@Override
	public List<Pet> getAllPets() {
		return petRepository.findAll();
	}

	@Override
	public Pet getPetById(long id) {
		Optional<Pet> optional = petRepository.findById(id);
		Pet pet = null;
		if (optional.isPresent()) {
			pet = optional.get();
		} else {
			throw new RuntimeException("Pet não encontrado! Id:" + id);
		}
		return pet;

	}

	@Override
	public void savePet(Pet pet) {
		this.petRepository.save(pet);
	}

	@Override
	public void deletePetById(long id) {
		this.petRepository.deleteById(id);

	}

}
