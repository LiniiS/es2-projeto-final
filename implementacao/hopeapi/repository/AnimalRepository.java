package br.com.fatec.ads.es.hopeapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fatec.ads.es.hopeapi.model.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long>{

}
