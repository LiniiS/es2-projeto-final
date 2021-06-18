package br.com.fatec.ads.es.hopeapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatec.ads.es.hopeapi.model.Parceiro;
import br.com.fatec.ads.es.hopeapi.repository.ParceiroRepository;

@Service
public class ParceiroServiceImpl implements ParceiroService {

	@Autowired
	private ParceiroRepository parceiroRepository;
	
	
	@Override
	public List<Parceiro> getAllParceiros() {
		return parceiroRepository.findAll(); //-> retorna a lista de todos par ao controler
	}


	@Override
	public void saveParceiro(Parceiro parceiro) {
		this.parceiroRepository.save(parceiro);
		
	}

	@Override
	public Parceiro getParceiroById(long id) {
		Optional<Parceiro> optional = parceiroRepository.findById(id);
		Parceiro parceiro = null;
		if(optional.isPresent()) {
			parceiro = optional.get();
		}else {
			throw new RuntimeException("Parceiro com id: " + id + "inexistente");
		}
		return parceiro;
	}


	@Override
	public void deleteParceiroById(long id) {
		this.parceiroRepository.deleteById(id);
		
	}

}
