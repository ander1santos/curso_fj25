package br.com.caelum.financas.mb;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.caelum.financas.modelo.Gerente;

@Named
@ViewScoped
public class GerentesBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Gerente gerente;

	private void limpaFormularioDoJSF() {
		this.gerente = new Gerente();
	}

}
