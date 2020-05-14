package com.algaworks.curso.jpa2.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.algaworks.curso.jpa2.dao.ModeloCarroDao;
import com.algaworks.curso.jpa2.exception.NegocioException;
import com.algaworks.curso.jpa2.model.ModeloCarro;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class ModeloCarroService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ModeloCarroDao dao;
	
	@Transactional
	public void mergeModeloCarro(ModeloCarro modeloCarro) throws NegocioException {
		if (modeloCarro.getDescricao() == null && modeloCarro.getDescricao().trim().equals("")) {
			throw new NegocioException("Modelo deve ser informado");
		}
		if(modeloCarro.getFabricante() == null) {
			throw new NegocioException("Fabricante deve ser informado");
		}
		dao.merge(modeloCarro);
	}

	@Transactional
	public void excluirModeloCarro(ModeloCarro modeloCarro) throws NegocioException {
		dao.excluir(modeloCarro);
	}

	public List<ModeloCarro> getTodosModelos() throws NegocioException {
		return dao.getCarros();
	}
}
