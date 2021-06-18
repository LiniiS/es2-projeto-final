package br.com.fatec.ads.es.hopeapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.fatec.ads.es.hopeapi.model.Pet;
/**
 * Interface experimental utilizada para atender as requisições relativas à classe
 * experimental Pet.
 * 
 * @author xlnst
 */
@Service
public interface PetService {

	List<Pet> getAllPets();
	
	void savePet(Pet pet);
	
	Pet getPetById(long id);
	
	
	void deletePetById(long id);
}
