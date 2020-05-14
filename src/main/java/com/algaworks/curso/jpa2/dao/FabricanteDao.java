package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.model.Fabricante;

public class FabricanteDao implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public void salvar(Fabricante fabricante) {
		manager.merge(fabricante);
	}
	
	public Fabricante encontrarPorCodido(Long cod) {
		return manager.find(Fabricante.class, cod);
	}
	
	@SuppressWarnings("unchecked")
	public List<Fabricante> getFabricantes(){
		return manager.createQuery("from Fabricante").getResultList();
	}
	
	public void excluir(Fabricante fabricante) {
		fabricante = manager.find(Fabricante.class, fabricante.getCodigo());
		manager.remove(fabricante);
		manager.flush();
	}
	
}
