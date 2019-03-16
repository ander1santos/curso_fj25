package br.com.caelum.financas.mb;

import java.math.BigDecimal;
import java.util.List;

import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Movimentacao;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class CriteriaBean {
	
	@Inject
	private MovimentacaoDao movDao;
	
	private List<Movimentacao> movimentacoes;
	private BigDecimal soma;
	
	private String titular;
	

	public void listarTodasAsMovimentacoes() {
		
		this.movimentacoes = this.movDao.listaTodasComCriteria();
	}

	public void somaMovimentacoesDoTitular() {
		this.soma = movDao.somaMovimentacoesDoTitular(this.titular);
	}
	
	public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}
	
	public BigDecimal getSoma() {
		return soma;
	}
	
	public String getTitular() {
		return titular;
	}
	
	public void setTitular(String titular) {
		this.titular = titular;
	}
}
