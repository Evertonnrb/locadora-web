package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.model.ModeloCarro;

public class ModeloCarroDao implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;

	public ModeloCarro buscarPorCodigo(Long cod) {
		return entityManager.find(ModeloCarro.class, cod);
	}
	
	public void merge(ModeloCarro carro) {
		entityManager.merge(carro);
	}
	
	@SuppressWarnings("unchecked")
	public List<ModeloCarro> getCarros(){
		return entityManager.createQuery("from ModeloCarro").getResultList();
	}
	
	public void excluir(ModeloCarro modeloCarro) {
		modeloCarro = buscarPorCodigo(modeloCarro.getCodigo());
		entityManager.remove(modeloCarro);
		entityManager.flush();
	}
}
