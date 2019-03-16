package br.com.caelum.financas.mb;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.stat.Statistics;

@Named
@ApplicationScoped
public class EstatisticasBean {

		@Inject
		private EntityManager manager;
		
		private Statistics estatisticas;
	
		public void gera() {
			System.out.println("Gerando estatísticas");
			
			Session session = this.manager.unwrap(Session.class);
			
			this.estatisticas = session.getSessionFactory().getStatistics();
		}

		public Statistics getEstatisticas() {
			return estatisticas;
		}

		public void setEstatisticas(Statistics estatisticas) {
			this.estatisticas = estatisticas;
		}
		
		
}
