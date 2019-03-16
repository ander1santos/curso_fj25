package br.com.caelum.financas.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.Cache;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;


@ApplicationScoped
public class CacheProducer {
	
	@PersistenceUnit
	private EntityManagerFactory emf;
	
	@Produces
	@ApplicationScoped
	public Cache getCache() {
		return emf.getCache();
	}
}
