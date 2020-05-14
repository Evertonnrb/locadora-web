package com.algaworks.curso.jpa2.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.algaworks.curso.jpa2.dao.CarroDao;
import com.algaworks.curso.jpa2.model.Carro;
import com.algaworks.curso.jpa2.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Carro.class)
public class CarroConverter implements Converter{

	private CarroDao carroDao;
	
	public CarroConverter() {
		carroDao = CDIServiceLocator.getBean(CarroDao.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Carro tmp = null;
		if(value != null) {
			tmp = carroDao.buscarPorCodigo(new Long(value));
		}
		return tmp;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null) {
			Long id = ((Carro)value).getCodigo();
			String cod = (id != null ? null : id.toString());
			return cod;
		}
		return null;
	}

}
