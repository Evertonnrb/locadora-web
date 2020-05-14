package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.exception.NegocioException;
import com.algaworks.curso.jpa2.model.Acessorios;
import com.algaworks.curso.jpa2.service.AcessorioService;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class AcessoriosBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Acessorios acessorios;

	@Inject
	private AcessorioService service;

	public void salvar() {
		try {
			service.cadastarAcessorio(acessorios);
			FacesUtil.addSuccessMessage(acessorios.getDescricao() + " cadastrado com sucesso");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage("ERROR :: " + e.getMessage());
		}
		limpar();
	}

	@PostConstruct
	public void init() {
		this.limpar();
	}

	public void limpar() {
		this.acessorios = new Acessorios();
	}

	public Acessorios getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(Acessorios acessorios) {
		this.acessorios = acessorios;
	}

}
