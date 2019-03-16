package br.com.caelum.financas.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.financas.exception.ValorInvalidoException;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.modelo.ValorPorMesEAno;

@Stateless
public class MovimentacaoDao {

	@Inject //@PersistenceContext
	private EntityManager manager;

	public void adiciona(Movimentacao movimentacao) {
		this.manager.joinTransaction();
		this.manager.persist(movimentacao);
		
		if(movimentacao.getValor().compareTo(BigDecimal.ZERO) < 0) {
			throw new ValorInvalidoException("Movimentacao negativa");
		}
	}

	public Movimentacao busca(Integer id) {
		this.manager.joinTransaction();
		return this.manager.find(Movimentacao.class, id);
	}

	public List<Movimentacao> lista() {
		return this.manager.createQuery("select m from Movimentacao m", Movimentacao.class).getResultList();
	}

	public void remove(Movimentacao movimentacao) {
		Movimentacao movimentacaoParaRemover = this.manager.find(Movimentacao.class, movimentacao.getId());
		this.manager.remove(movimentacaoParaRemover);
	}
	
	public void altera(Movimentacao mov) {
		this.manager.merge(mov);
	}
	
	public List<Movimentacao> listaTodasMovimentacoes(Conta conta){
		
		String jpql = "select m from Movimentacao m where m.conta = :conta order by m.valor desc";
		
		TypedQuery<Movimentacao> query = this.manager.createQuery(jpql,Movimentacao.class);
		query.setParameter("conta", conta);
		
		return query.getResultList();
	}
	
	public List<Movimentacao> listaPorValorETipo(BigDecimal valor,TipoMovimentacao tipo){
		String str = "select m from Movimentacao m where m.valor <= :valor and m.tipoMovimentacao = :tipo";
		
		TypedQuery<Movimentacao> q = this.manager.createQuery(str,Movimentacao.class);
		
		q.setParameter("valor", valor);
		q.setParameter("tipo", tipo);
		
		q.setHint("org.hibernate.cacheable", "true");
		
		return q.getResultList();
	}
	
	public BigDecimal somarTotalMovimentado(Conta conta, TipoMovimentacao tipo) {
		String str = "select sum(m.valor) from Movimentacao m where m.conta = :conta and m.tipoMovimentacao = : tipo";
		
		TypedQuery<BigDecimal> tq = this.manager.createQuery(str,BigDecimal.class);
		tq.setParameter("conta", conta);
		tq.setParameter("tipo",tipo);
		
		return tq.getSingleResult();
	}
	
	public List<Movimentacao> buscaMovimentacoesContaTitular(String titular){
		String str= "select m from Movimentacao m where m.conta.titular like :titular";
		
		TypedQuery<Movimentacao> tq = this.manager.createQuery(str,Movimentacao.class);
		tq.setParameter("titular", "%" + titular + "%");
		
		return tq.getResultList();
		
	}
	
	public List<ValorPorMesEAno> listaMesesComMovimentacoes(Conta conta, TipoMovimentacao tipo){
		
		String str = "select "
				+ "new br.com.caelum.financas.modelo.ValorPorMesEAno(sum(m.valor),month(m.data),year(m.data)) "
				+ "from Movimentacao m "
				+ "where m.conta = :conta "
				+ "and m.tipoMovimentacao = :tipo "
				+ "group by year(m.data), month(m.data) "
				+ "order by sum(m.valor) desc";
		
		TypedQuery<ValorPorMesEAno> tq = manager.createQuery(str,ValorPorMesEAno.class);
		
		tq.setParameter("conta", conta);
		tq.setParameter("tipo", tipo);
		
		return tq.getResultList();
		
	}
	
	public List<Movimentacao> listaComCategorias(){
		String str = "select distinct m from Movimentacao m join fetch m.categorias";
		
		TypedQuery tp = manager.createQuery(str,Movimentacao.class);
		
		return tp.getResultList();
	}

}
