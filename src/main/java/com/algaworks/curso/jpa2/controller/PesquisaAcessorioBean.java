package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.dao.AcessoriosDao;
import com.algaworks.curso.jpa2.exception.NegocioException;
import com.algaworks.curso.jpa2.model.Acessorios;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaAcessorioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private AcessoriosDao acessoriosDao;

	private List<Acessorios> acessorios = new ArrayList<Acessorios>();

	private Acessorios acessorioSelecionado;

	public void excluir() {
		try {
			acessoriosDao.excluir(acessorioSelecionado);
			this.acessorios.remove(acessorioSelecionado);
			FacesUtil.addSuccessMessage("Acessório cadastrado");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage("Erro "+e.getMessage());
		}
	}

	@PostConstruct
	public void init() {
		acessorios = acessoriosDao.getAcessorios();
	}

	public List<Acessorios> getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(List<Acessorios> acessorios) {
		this.acessorios = acessorios;
	}

	public Acessorios getAcessorioSelecionado() {
		return acessorioSelecionado;
	}

	public void setAcessorioSelecionado(Acessorios acessorioSelecionado) {
		this.acessorioSelecionado = acessorioSelecionado;
	}

}
