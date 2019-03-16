package br.com.caelum.financas.modelo;

import java.math.BigDecimal;

public class ValorPorMesEAno {

	private BigDecimal valor;
	private int mes;
	private int ano;
	
	public ValorPorMesEAno(BigDecimal valor, int mes, int ano) {
		super();
		this.valor = valor;
		this.mes = mes;
		this.ano = ano;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}	
}
