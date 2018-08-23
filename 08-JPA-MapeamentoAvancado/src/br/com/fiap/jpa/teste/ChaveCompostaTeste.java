package br.com.fiap.jpa.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.ConsultaDAO;
import br.com.fiap.jpa.dao.impl.ConsultaDAOImpl;
import br.com.fiap.jpa.entity.Consulta;
import br.com.fiap.jpa.entity.Medico;
import br.com.fiap.jpa.entity.Paciente;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class ChaveCompostaTeste {

	public static void main(String[] args) {
		//Cadastrar o médico, paciente e a consulta
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		Medico medico = new Medico(123, "Drauzio", "Geral", 120000, 123);
		
		Paciente paciente = new Paciente("Maria", 
				new GregorianCalendar(1990, Calendar.MARCH, 2));
		
		Consulta consulta = new Consulta(medico, paciente, 
				Calendar.getInstance(), "2A", true);
		
		ConsultaDAO dao = new ConsultaDAOImpl(em);
		try {
			dao.inserir(consulta);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
		}
		
		em.close();
		fabrica.close();
	}
	
}
