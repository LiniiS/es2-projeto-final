package br.com.fatec.ads.es.hopeapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.fatec.ads.es.hopeapi.model.Animal;

@Service
public interface AnimalService {
	
	List<Animal> getAllAnimais();

	void saveAnimal(Animal animal);

	Animal getAnimalById(long id);

	void deleteAnimalById(long id);

}
