package br.com.fatec.ads.es.hopeapi.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.fatec.ads.es.hopeapi.model.Pet;
import br.com.fatec.ads.es.hopeapi.model.StatusPet;

/**
 * Essa interface é utilizada para a classe experimental Pet que foi substituída
 * pela classe Animal.
 * 
 * @author xlnst
 *
 */
@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

	@Cacheable("pets")
	List<Pet> findByStatus(StatusPet status, Pageable sort);

	@Query("select p from Pet p join p.user u where u.username = :username")
	List<Pet> findAllByUsuario(@Param("username") String username);

	@Query("select p from Pet p join p.user u where u.username = :username and p.status = :status")
	List<Pet> findByStatusAndUser(@Param("status") StatusPet status, @Param("username") String username);

}
