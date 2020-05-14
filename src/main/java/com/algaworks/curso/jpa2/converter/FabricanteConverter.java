package com.algaworks.curso.jpa2.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.algaworks.curso.jpa2.dao.FabricanteDao;
import com.algaworks.curso.jpa2.model.Fabricante;
import com.algaworks.curso.jpa2.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Fabricante.class)
public class FabricanteConverter implements Converter {

	private FabricanteDao fabricanteDao;

	public FabricanteConverter() {
		fabricanteDao = CDIServiceLocator.getBean(FabricanteDao.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Fabricante fabricanteEncontrado = null;
		if (value != null) {
			fabricanteEncontrado = fabricanteDao.encontrarPorCodido(new Long(value));
		}
		return fabricanteEncontrado;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long cod = ((Fabricante) value).getCodigo();
			String retorno = (cod == null ? null : cod.toString());
			return retorno;
		}
		return null;
	}

}
