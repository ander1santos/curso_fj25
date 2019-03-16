package br.com.caelum.financas.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Gerente;

@Stateless
public class GerenteDao {
	
	@Inject
	private EntityManager manager;
	
	public void adiciona(Gerente gerente) {
		this.manager.joinTransaction();
		this.manager.persist(gerente);
	}
	
	public Gerente busca(Integer id) {
		return this.manager.find(Gerente.class, id);
	}
	
	public List<Gerente> listar(){
		
		return this.manager.createQuery("select g from Gerente g", Gerente.class).getResultList();
	}
	
	public void remover(Gerente gerente) {
		Gerente gerenteRemove = this.manager.find(Gerente.class, gerente.getId());
		this.manager.remove(gerenteRemove);
		
	}
	
	public void alterar(Gerente gerente) {
		this.manager.merge(gerente);
	}
}
