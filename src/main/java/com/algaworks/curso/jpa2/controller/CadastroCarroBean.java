package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.dao.AcessoriosDao;
import com.algaworks.curso.jpa2.dao.ModeloCarroDao;
import com.algaworks.curso.jpa2.exception.NegocioException;
import com.algaworks.curso.jpa2.model.Acessorios;
import com.algaworks.curso.jpa2.model.Carro;
import com.algaworks.curso.jpa2.model.ModeloCarro;
import com.algaworks.curso.jpa2.service.CarroService;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroCarroBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Carro carro;

	@Inject
	private CarroService carroService;

	@Inject
	private AcessoriosDao acessoriosDao;

	@Inject
	private ModeloCarroDao modelos;

	private List<Acessorios> acessorios;

	private List<ModeloCarro> modeloCarros;

	public void salvar() {
		try {
			carroService.salvar(carro);
			FacesUtil.addSuccessMessage("Cadastrado realizado");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage("ERROR :: " + e.getMessage());
		}
	}

	@PostConstruct
	public void init() {
		this.limpar();
		this.modeloCarros = modelos.getCarros();
		this.acessorios = acessoriosDao.getAcessorios();
	}

	public void limpar() {
		carro = new Carro();
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public List<Acessorios> getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(List<Acessorios> acessorios) {
		this.acessorios = acessorios;
	}

	public List<ModeloCarro> getModeloCarros() {
		return modeloCarros;
	}

	public void setModeloCarros(List<ModeloCarro> modeloCarros) {
		this.modeloCarros = modeloCarros;
	}
}
