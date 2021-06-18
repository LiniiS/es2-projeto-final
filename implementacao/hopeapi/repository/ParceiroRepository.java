package br.com.fatec.ads.es.hopeapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.fatec.ads.es.hopeapi.model.Parceiro;

@Repository
public interface ParceiroRepository extends JpaRepository<Parceiro, Long> {


	@Query("SELECT u FROM User u WHERE u.email =?1")
	Optional<Parceiro> findParceiroByEmail(String email);

}
