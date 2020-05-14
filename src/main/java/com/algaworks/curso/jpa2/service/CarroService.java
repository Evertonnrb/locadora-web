package com.algaworks.curso.jpa2.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.algaworks.curso.jpa2.dao.CarroDao;
import com.algaworks.curso.jpa2.exception.NegocioException;
import com.algaworks.curso.jpa2.model.Carro;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class CarroService implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private CarroDao carroDao;

	@Transactional
	public void salvar(Carro carro) throws NegocioException {
		if (carro.getModelo() == null) {
			throw new NegocioException("Informe o modelo do carro");
		}
		this.carroDao.salvarCarro(carro);
	}

	@Transactional
	public void remover(Carro carro) throws NegocioException {
		this.carroDao.remover(carro.getCodigo());
	}

	public List<Carro> getCarros() {
		return this.carroDao.getCarrros();
	}

	public Carro buscarPorcodigo(Long cod) {
		return this.carroDao.buscarPorCodigo(cod);
	}
}
