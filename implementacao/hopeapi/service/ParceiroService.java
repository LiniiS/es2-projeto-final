package br.com.fatec.ads.es.hopeapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.fatec.ads.es.hopeapi.model.Parceiro;

@Service
public interface ParceiroService {

	List<Parceiro> getAllParceiros();
	
	void saveParceiro(Parceiro parceiro);
	
	Parceiro getParceiroById(long id);
	
	void deleteParceiroById(long id);
}