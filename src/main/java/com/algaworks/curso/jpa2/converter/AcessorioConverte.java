package com.algaworks.curso.jpa2.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.algaworks.curso.jpa2.dao.AcessoriosDao;
import com.algaworks.curso.jpa2.model.Acessorios;
import com.algaworks.curso.jpa2.util.cdi.CDIServiceLocator;

//@FacesConverter(forClass = Acessorios.class)
@FacesConverter("acessorioConverter")
public class AcessorioConverte implements Converter {

	private AcessoriosDao acessoriosDao;

	public AcessorioConverte() {
		acessoriosDao = CDIServiceLocator.getBean(AcessoriosDao.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Acessorios tmp = null;
		if (value != null) {
			tmp = acessoriosDao.bucarPorCodigo(new Long(value));
		}
		return tmp;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long valor = ((Acessorios) value).getCodigo();
			String cod = (valor == null ? null : valor.toString());
			return cod;
		}
		return "";
	}

}
