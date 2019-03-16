package br.com.caelum.financas.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.financas.dao.GerenteDao;
import br.com.caelum.financas.modelo.Gerente;
import br.com.caelum.financas.modelo.GerenteConta;

@Named
@ViewScoped
public class GerentesBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private GerenteDao gerenteDao;
	
	private List<Gerente> gerentes;
	
	private Gerente gerente = new GerenteConta();

	private void limpaFormularioDoJSF() {
		this.gerente = new GerenteConta();
		
	}
	
	public void grava() {
		System.out.println("Gravando o gerente");
		
		if(this.gerente.getId() == null) {
			gerenteDao.adiciona(this.gerente);
		}
		else {
			gerenteDao.alterar(this.gerente);
		}
		
		this.gerentes = gerenteDao.listar();
		
		limpaFormularioDoJSF();
	}
	
	public void remove() {
		System.out.println("Removendo o gerente");
		
		gerenteDao.remover(gerente);
		
		this.gerentes = gerenteDao.listar();
		
		limpaFormularioDoJSF();
	}

	public List<Gerente> getGerentes() {
		if(this.gerentes == null) {
			this.gerentes = gerenteDao.listar();
		}
		
		return gerentes;
	}

	public void setGerentes(List<Gerente> gerentes) {
		this.gerentes = gerentes;
	}

	public Gerente getGerente() {
		return gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}
	
	

}
