package br.com.caelum.financas.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.AccessTimeout;
import javax.ejb.Schedule;
import javax.ejb.ScheduleExpression;
import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;

@Stateless
//@Singleton
@AccessTimeout(50000)
public class Agendador {

	@Resource
	private TimerService timerService;

	private static int totalCriado;

	public void executa() {
		System.out.printf("%d instancias criadas %n", totalCriado);

		// simulando demora de 4s na execucao
		try {
			System.out.printf("Executando %s %n", this);
			Thread.sleep(4000);
		} catch (InterruptedException e) {
		}
	}
	
	/*@PostConstruct
	public void posContrucao() {
		System.out.println("Criando agendador");
		totalCriado++;
	}*/
	
	@PreDestroy
	public void preDestruicao() {
		System.out.println("Destruindo agendador");
		
	}
	
	//@PostConstruct
	public void agenda(String expressaoMinutos, String expressaoSegundos){
		ScheduleExpression exp = new ScheduleExpression();
		exp.hour("*");
		exp.minute(expressaoMinutos);
		exp.second(expressaoSegundos);
		
		TimerConfig tc = new TimerConfig();
		tc.setInfo(exp.toString());
		tc.setPersistent(false);
		
		this.timerService.createCalendarTimer(exp,tc);
		
		System.out.println("Agendamento: " + exp);
		
	}
	
	@Timeout
	public void verificacaoPeriodoNovasContas(Timer timer){
		System.out.println(timer.getInfo());
	}
	
	/*@Schedule(hour="*",minute="1",second="0",persistent=false)
	public void enviarEmailCadaMinuto(){
		System.out.println("Enviando email a cada minuto");
	}*/
	

}
