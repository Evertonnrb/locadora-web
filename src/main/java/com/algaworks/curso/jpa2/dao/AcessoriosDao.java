package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.algaworks.curso.jpa2.exception.NegocioException;
import com.algaworks.curso.jpa2.model.Acessorios;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class AcessoriosDao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public void salvarAcessorio(Acessorios acessorios) {
		this.manager.merge(acessorios);
	}

	@SuppressWarnings("unchecked")
	public List<Acessorios> getAcessorios() {
		return manager.createQuery("from Acessorios").getResultList();
	}

	public Acessorios buscarPorCod(Long cod) {
		return manager.find(Acessorios.class, cod);
	}

	@Transactional
	public void excluir(Acessorios acessorios) throws NegocioException {
		acessorios = buscarPorCod(acessorios.getCodigo());
		try {
			manager.remove(acessorios);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Error : " + e.getMessage());
		}
	}

	public Acessorios bucarPorCodigo(Long cod) {
		return manager.find(Acessorios.class, cod);
	}

}
