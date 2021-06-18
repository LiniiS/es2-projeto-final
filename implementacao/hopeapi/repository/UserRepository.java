package br.com.fatec.ads.es.hopeapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fatec.ads.es.hopeapi.model.User;

/**
 * Essa interface é utilizada para a classe experimental User e que para fins
 * didáticos foi susbtituída pela classe Parceiro.
 * 
 * @author xlnst
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {

	User findByUsername(String username);

}
