package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.dao.FabricanteDao;
import com.algaworks.curso.jpa2.exception.NegocioException;
import com.algaworks.curso.jpa2.model.Fabricante;
import com.algaworks.curso.jpa2.model.ModeloCarro;
import com.algaworks.curso.jpa2.service.ModeloCarroService;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class ModeloCarroBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ModeloCarroService service;
	
	@Inject
	private FabricanteDao fabricanteDao;
	
	private ModeloCarro modeloCarro;

	private List<Fabricante> fabricantes;

	public void salvar() {
		try {
			this.service.mergeModeloCarro(modeloCarro);
			FacesUtil.addSuccessMessage("Modelo "+modeloCarro.getDescricao()+" cadastrado");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage("Erro :: " + e.getMessage());
		}
		this.limpar();
	}

	@PostConstruct
	public void init() {
		this.limpar();
		fabricantes = fabricanteDao.getFabricantes();
	}

	public void limpar() {
		modeloCarro = new ModeloCarro();
	}

	public ModeloCarro getModeloCarro() {
		return modeloCarro;
	}

	public void setModeloCarro(ModeloCarro modeloCarro) {
		this.modeloCarro = modeloCarro;
	}

	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}
}
