package com.algaworks.curso.jpa2.dao;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.algaworks.curso.jpa2.model.Carro;
import com.algaworks.curso.jpa2.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Carro.class)
public class CarroConverter implements Converter {

	private CarroDao carroDao;

	public CarroConverter() {
		carroDao = CDIServiceLocator.getBean(CarroDao.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Carro c = null;
		if (value != null) {
			c = carroDao.buscarPorCodigo(new Long(value));
		}
		return c;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long valor = ((Carro) value).getCodigo();
			String cod = (valor == null ? null : valor.toString());
			return cod;
		}
		return null;
	}

}
