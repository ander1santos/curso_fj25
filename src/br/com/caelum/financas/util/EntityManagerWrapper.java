package br.com.caelum.financas.util;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.metamodel.Metamodel;

public class EntityManagerWrapper implements EntityManager {
	
	private EntityManager manager;
	
	public EntityManagerWrapper(EntityManager manager) {
		this.manager = manager;
	}

	public void clear() {
		manager.clear();
	}

	public void close() {
		manager.close();
	}

	public boolean contains(Object arg0) {
		return manager.contains(arg0);
	}

	public <T> EntityGraph<T> createEntityGraph(Class<T> arg0) {
		return manager.createEntityGraph(arg0);
	}

	public EntityGraph<?> createEntityGraph(String arg0) {
		return manager.createEntityGraph(arg0);
	}

	public <T> TypedQuery<T> createNamedQuery(String arg0, Class<T> arg1) {
		return manager.createNamedQuery(arg0, arg1);
	}

	public Query createNamedQuery(String arg0) {
		return manager.createNamedQuery(arg0);
	}

	public StoredProcedureQuery createNamedStoredProcedureQuery(String arg0) {
		return manager.createNamedStoredProcedureQuery(arg0);
	}

	public Query createNativeQuery(String arg0, Class arg1) {
		return manager.createNativeQuery(arg0, arg1);
	}

	public Query createNativeQuery(String arg0, String arg1) {
		return manager.createNativeQuery(arg0, arg1);
	}

	public Query createNativeQuery(String arg0) {
		return manager.createNativeQuery(arg0);
	}

	public Query createQuery(CriteriaDelete arg0) {
		return manager.createQuery(arg0);
	}

	public <T> TypedQuery<T> createQuery(CriteriaQuery<T> arg0) {
		return manager.createQuery(arg0);
	}

	public Query createQuery(CriteriaUpdate arg0) {
		return manager.createQuery(arg0);
	}

	public <T> TypedQuery<T> createQuery(String arg0, Class<T> arg1) {
		return manager.createQuery(arg0, arg1);
	}

	public Query createQuery(String arg0) {
		return manager.createQuery(arg0);
	}

	public StoredProcedureQuery createStoredProcedureQuery(String arg0, Class... arg1) {
		return manager.createStoredProcedureQuery(arg0, arg1);
	}

	public StoredProcedureQuery createStoredProcedureQuery(String arg0, String... arg1) {
		return manager.createStoredProcedureQuery(arg0, arg1);
	}

	public StoredProcedureQuery createStoredProcedureQuery(String arg0) {
		return manager.createStoredProcedureQuery(arg0);
	}

	public void detach(Object arg0) {
		manager.detach(arg0);
	}

	public <T> T find(Class<T> arg0, Object arg1, LockModeType arg2, Map<String, Object> arg3) {
		return manager.find(arg0, arg1, arg2, arg3);
	}

	public <T> T find(Class<T> arg0, Object arg1, LockModeType arg2) {
		return manager.find(arg0, arg1, arg2);
	}

	public <T> T find(Class<T> arg0, Object arg1, Map<String, Object> arg2) {
		return manager.find(arg0, arg1, arg2);
	}

	public <T> T find(Class<T> arg0, Object arg1) {
		return manager.find(arg0, arg1);
	}

	public void flush() {
		manager.flush();
	}

	public CriteriaBuilder getCriteriaBuilder() {
		return manager.getCriteriaBuilder();
	}

	public Object getDelegate() {
		return manager.getDelegate();
	}

	public EntityGraph<?> getEntityGraph(String arg0) {
		return manager.getEntityGraph(arg0);
	}

	public <T> List<EntityGraph<? super T>> getEntityGraphs(Class<T> arg0) {
		return manager.getEntityGraphs(arg0);
	}

	public EntityManagerFactory getEntityManagerFactory() {
		return manager.getEntityManagerFactory();
	}

	public FlushModeType getFlushMode() {
		return manager.getFlushMode();
	}

	public LockModeType getLockMode(Object arg0) {
		return manager.getLockMode(arg0);
	}

	public Metamodel getMetamodel() {
		return manager.getMetamodel();
	}

	public Map<String, Object> getProperties() {
		return manager.getProperties();
	}

	public <T> T getReference(Class<T> arg0, Object arg1) {
		return manager.getReference(arg0, arg1);
	}

	public EntityTransaction getTransaction() {
		return manager.getTransaction();
	}

	public boolean isJoinedToTransaction() {
		return manager.isJoinedToTransaction();
	}

	public boolean isOpen() {
		return manager.isOpen();
	}

	public void joinTransaction() {
		manager.joinTransaction();
	}

	public void lock(Object arg0, LockModeType arg1, Map<String, Object> arg2) {
		manager.lock(arg0, arg1, arg2);
	}

	public void lock(Object arg0, LockModeType arg1) {
		manager.lock(arg0, arg1);
	}

	public <T> T merge(T arg0) {
		return manager.merge(arg0);
	}

	public void persist(Object arg0) {
		manager.persist(arg0);
	}

	public void refresh(Object arg0, LockModeType arg1, Map<String, Object> arg2) {
		manager.refresh(arg0, arg1, arg2);
	}

	public void refresh(Object arg0, LockModeType arg1) {
		manager.refresh(arg0, arg1);
	}

	public void refresh(Object arg0, Map<String, Object> arg1) {
		manager.refresh(arg0, arg1);
	}

	public void refresh(Object arg0) {
		manager.refresh(arg0);
	}

	public void remove(Object arg0) {
		manager.remove(arg0);
	}

	public void setFlushMode(FlushModeType arg0) {
		manager.setFlushMode(arg0);
	}

	public void setProperty(String arg0, Object arg1) {
		manager.setProperty(arg0, arg1);
	}

	public <T> T unwrap(Class<T> arg0) {
		return manager.unwrap(arg0);
	}
	
	
}
