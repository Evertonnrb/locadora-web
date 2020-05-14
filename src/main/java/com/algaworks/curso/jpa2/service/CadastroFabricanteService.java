package com.algaworks.curso.jpa2.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.algaworks.curso.jpa2.dao.FabricanteDao;
import com.algaworks.curso.jpa2.exception.NegocioException;
import com.algaworks.curso.jpa2.model.Fabricante;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class CadastroFabricanteService implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private FabricanteDao fabricanteDao;
	
	@Transactional
	public void cadastrarFabricante(Fabricante fabricante) throws NegocioException {
		if(fabricante.getNome() == null || fabricante.getNome().trim().equals("")) {
			throw new NegocioException("Nome fabricante é requerido");
		}
		this.fabricanteDao.salvar(fabricante);
	}

}
