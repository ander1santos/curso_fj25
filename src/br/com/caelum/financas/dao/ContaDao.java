package br.com.caelum.financas.dao;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

import br.com.caelum.financas.modelo.Conta;
//import br.com.caelum.financas.modelo.Movimentacao;

//@TransactionManagement(TransactionManagementTypablablae.BEAN)
@Stateless
public class ContaDao {

	@Inject 
	//@PersistenceContext
	EntityManager manager;

	//@Resource
	//private UserTransaction ut;
	
	public void adiciona(Conta conta) {
		
//		try {
//			this.ut.begin();
//		} catch (Exception e) {
//			throw new EJBException(e);
//		}
		
		this.manager.persist(conta);
		
//		try {
//			this.ut.commit();
//		} catch (Exception e) {
//			try {
//				this.ut.rollback();
//			} catch (Exception e2) {
//				throw new EJBException(e2);
//			}
//			throw new EJBException(e);
//		}
	}

	public Conta busca(Integer id) {
		return this.manager.find(Conta.class, id);
	}

	public List<Conta> lista() {
		return this.manager.createQuery("select c from Conta c", Conta.class)
				.getResultList();
	}

	public void remove(Conta conta) {
		//TODO
		//this.manager.createQuery("delete from Movimentacao m where m.conta = " + conta.getId(), Movimentacao.class);
		
		Conta contaParaRemover = this.manager.find(Conta.class, conta.getId());
		this.manager.remove(contaParaRemover);
	}
	
	public void altera(Conta conta) {
		
//		try {
//			this.ut.begin();
//		} catch (Exception e) {
//			throw new EJBException(e);
//		}
		
		this.manager.merge(conta);
		
//		try {
//			this.ut.commit();
//		} catch (Exception e) {
//			try {
//				this.ut.rollback();
//			} catch (Exception e2) {
//				throw new EJBException(e2);
//			}
//			throw new EJBException(e);
//		}
	}
	
	public int trocaNomeDoBanco(String bancoAntigo, String bancoNovo) {
		String jpql = "update Conta c set c.banco = :bancoNovo where c.banco = :bancoAntigo";
		
		Query q = this.manager.createQuery(jpql);
		q.setParameter("bancoAntigo", bancoAntigo);
		q.setParameter("bancoNovo", bancoNovo);
		
		return q.executeUpdate();
	}

}




