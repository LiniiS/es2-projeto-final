package br.com.fatec.ads.es.hopeapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatec.ads.es.hopeapi.model.Animal;
import br.com.fatec.ads.es.hopeapi.repository.AnimalRepository;

@Service
public class AnimalServiceImpl implements AnimalService{

	
	@Autowired
	private AnimalRepository animalRepository;
	
	@Override
	public List<Animal> getAllAnimais() {
		return animalRepository.findAll();
	}

	@Override
	public void saveAnimal(Animal animal) {
		this.animalRepository.save(animal);
		
	}

	@Override
	public Animal getAnimalById(long id) {
		Optional<Animal> optional = animalRepository.findById(id);
		Animal animal = null;
		if(optional.isPresent()) {
			animal = optional.get();
		}else {
			throw new RuntimeException("Animal não encontrado! Id :: " + id);
		}
			
		return animal;
	}

	@Override
	public void deleteAnimalById(long id) {
		this.animalRepository.deleteById(id);
	}
	


}
