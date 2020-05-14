package com.algaworks.curso.jpa2.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.algaworks.curso.jpa2.dao.AcessoriosDao;
import com.algaworks.curso.jpa2.exception.NegocioException;
import com.algaworks.curso.jpa2.model.Acessorios;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class AcessorioService implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private AcessoriosDao acessoriosDao;

	@Transactional
	public void cadastarAcessorio(Acessorios acessorios) throws NegocioException {
		if(acessorios.getDescricao() == null && acessorios.getDescricao().trim().equals("")) {
			throw new NegocioException("Informe a descrição do acessório");
		}
		acessoriosDao.salvarAcessorio(acessorios);
	}
	
	public List<Acessorios> listarAcessorios(){
		return acessoriosDao.getAcessorios();
	}
	
	
}
