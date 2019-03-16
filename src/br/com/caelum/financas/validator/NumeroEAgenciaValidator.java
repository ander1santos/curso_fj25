package br.com.caelum.financas.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.caelum.financas.modelo.Conta;

public class NumeroEAgenciaValidator implements ConstraintValidator<NumeroEAgencia, Conta>{
	
	@Override
	public void initialize(NumeroEAgencia anotacao) {}
	
	@Override
	public boolean isValid(Conta conta, ConstraintValidatorContext ctx) {
		if(conta == null) {
			return true;
		}
		
		boolean agenciaVazia = (conta.getAgencia() == null || conta.getAgencia().trim().isEmpty());
		
		boolean numeroVazio = (conta.getNumero() == null || conta.getNumero().trim().isEmpty());
		
		return !(agenciaVazia ^ numeroVazio);
	}
	
}
