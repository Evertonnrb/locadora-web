package com.algaworks.curso.jpa2.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.model.Carro;

public class CarroDao {

	@Inject
	private EntityManager manager;
	
	public void salvarCarro(Carro carro) {
		manager.merge(carro);
	}
	
	@SuppressWarnings("unchecked")
	public List<Carro> getCarrros(){
		return manager.createQuery("from Carro").getResultList();
	}
	
	public Carro buscarPorCodigo(Long cod) {
		return manager.find(Carro.class, cod);
	}
	
	public void remover(Long cod) {
		manager.remove(cod);
	}
}
