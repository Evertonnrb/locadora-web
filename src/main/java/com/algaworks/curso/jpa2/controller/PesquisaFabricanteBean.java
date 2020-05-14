package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.exception.NegocioException;
import com.algaworks.curso.jpa2.model.Fabricante;
import com.algaworks.curso.jpa2.service.ConsultaFabricanteService;
import com.algaworks.curso.jpa2.util.jpa.Transactional;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaFabricanteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ConsultaFabricanteService fabricanteDao;

	
	
	private List<Fabricante> fabricantes = new ArrayList<Fabricante>();

	private Fabricante fabricanteSelecionado;

	@PostConstruct
	public void init() {
		fabricantes = fabricanteDao.getFabricantes();
	}

	@Transactional
	public void excluir() {
		try {
			fabricanteDao.excluir(fabricanteSelecionado);
			FacesUtil.addSuccessMessage("Fabricante "+fabricanteSelecionado.getNome()+" excluído com sucesso");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
		init();
	}

	public Fabricante getFabricanteSelecionado() {
		return fabricanteSelecionado;
	}

	public void setFabricanteSelecionado(Fabricante fabricanteSelecionado) {
		this.fabricanteSelecionado = fabricanteSelecionado;
	}

	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}
}
