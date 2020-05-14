package com.algaworks.curso.jpa2.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.algaworks.curso.jpa2.dao.ModeloCarroDao;
import com.algaworks.curso.jpa2.model.ModeloCarro;
import com.algaworks.curso.jpa2.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = ModeloCarro.class)
public class ModeloCarroConverter implements Converter {

	private ModeloCarroDao modeloCarroDao;

	public ModeloCarroConverter() {
		modeloCarroDao = CDIServiceLocator.getBean(ModeloCarroDao.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		ModeloCarro modeloEncontrado = null;
		if (value != null) {
			modeloEncontrado = modeloCarroDao.buscarPorCodigo(new Long(value));
		}
		return modeloEncontrado;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((ModeloCarro) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());
			return retorno;
		}
		return null;
	}

}
