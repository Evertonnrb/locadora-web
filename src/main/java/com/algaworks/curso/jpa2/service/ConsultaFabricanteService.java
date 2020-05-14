package com.algaworks.curso.jpa2.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.algaworks.curso.jpa2.dao.FabricanteDao;
import com.algaworks.curso.jpa2.exception.NegocioException;
import com.algaworks.curso.jpa2.model.Fabricante;

public class ConsultaFabricanteService implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private FabricanteDao fabricanteDao;

	
	public void excluir(Fabricante fabricante) throws NegocioException {
		fabricanteDao.excluir(fabricante);
	}
	
	public List<Fabricante> getFabricantes() {
		return fabricanteDao.getFabricantes();
	}
}
