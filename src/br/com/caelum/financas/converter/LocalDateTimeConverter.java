package br.com.caelum.financas.converter;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("localDateTimeConverter")
public class LocalDateTimeConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {

		if(arg2 == null || arg2.isEmpty()){
			return null;
		}

		try{
			return LocalDateTime.parse(arg2.trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").withZone(ZoneId.systemDefault()));
		}
		catch (DateTimeParseException e) {
			throw new ConverterException("O formato da data deve ser dd/MM/yyyy HH:mm:ss.");
		}

	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {

		if(arg2 == null){
			return "";
		}

		LocalDateTime data = (LocalDateTime) arg2;
		return data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").withZone(ZoneId.systemDefault()));
	}

}
