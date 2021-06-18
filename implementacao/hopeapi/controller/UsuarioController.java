package br.com.fatec.ads.es.hopeapi.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fatec.ads.es.hopeapi.model.Pet;
import br.com.fatec.ads.es.hopeapi.model.StatusPet;
import br.com.fatec.ads.es.hopeapi.repository.PetRepository;
/**
 * Classe experimental: criada no início do projeto e será continuada para ser
 * utilizada na aplicação, para fins didáticos a classe foi substituída pela
 * classe ParceiroController
 * @author xlnst
 *
 */
@Controller
@RequestMapping("usuario")
public class UsuarioController {

	@Autowired //spring injeta/conecta os dados
	private PetRepository petRepository;
	
	@GetMapping("home")
	public String home(Model model, Principal principal) {
		List<Pet> pets = petRepository.findAllByUsuario(principal.getName());
		//enviará pra view
		model.addAttribute("pets", pets);
		return "usuario/home";
	}
/*	
	@GetMapping("/aguardando") //receber via pathVariable
	public String aguardando(Model model) {
		List<Pet> pets = petRepository.findByStatus(StatusPet.AGUARDANDO); //receber o status do usuario
		model.addAttribute("pets", pets);
		return "home";
	}
*/
	@GetMapping("pets/{status}") //receber via pathVariable
	public String defineStatus(@PathVariable("status") String status, Model model, Principal principal) {
		//receber o status e nome do usuario, utilizar value of pra pegar a conversão
		List<Pet> pets = petRepository.findByStatusAndUser(
										StatusPet.valueOf(status.toUpperCase()),
										principal.getName()); 
		model.addAttribute("pets", pets);
		model.addAttribute("status", status);//mapeia o status e retorna para ser acessado na view
		return "usuario/home";
	}
	
	//redirecionadno pra home caso seja acessada uma rota não mapeada
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/usuario/home"; 
	}
	
}
