package testes;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Medico.Agenda;
import Medico.DiaDeTrabalho;
import Medico.Semana;
import Paciente.HorarioDeAtendimento;


public class TestaAgenda {
	Agenda agenda;
	DiaDeTrabalho dia;
	HorarioDeAtendimento horario1, horario2, horario3, horario4, horario5, horario6, horario7;

	@Before
	public void constroiAgenda() throws Exception {
		horario1 = new HorarioDeAtendimento(1234, true, false);
		horario2 = new HorarioDeAtendimento(1534, true, false);
		horario3 = new HorarioDeAtendimento(3333, true, false);
		horario4 = new HorarioDeAtendimento(4444, false, true);
		horario5 = new HorarioDeAtendimento(5555, false, true);
		horario6 = new HorarioDeAtendimento(4444, false, true);
		horario7 = new HorarioDeAtendimento(5555, false, true);
		dia = new DiaDeTrabalho(Semana.TERCA, "12:00", "13:00");
		agenda = new Agenda(30, 20);
	}
	
	@Test 
	public void testaGetDiasDeCirurgias(){
		Assert.assertTrue("Erro no getDiasDeCirurgias", agenda.getDiasDeCirurgia().isEmpty());          
	}

	@Test public void testaAddDiasDeCirurgias(){
		agenda.addDiaDeCirurgia(dia);
		Assert.assertFalse("Erro no addDiasDeCirurgias", agenda.getDiasDeCirurgia().isEmpty());
	}

	@Test public void testaGetDiasDeExpediente(){
		Assert.assertTrue("Erro no getExpediente", agenda.getDiasDeExpediente().isEmpty());
	}

	@Test public void testaAddDiasDeExpediente(){
		agenda.addDiasDeExpediente(dia);
		Assert.assertFalse("Erro no addDiasDeExpediente", agenda.getDiasDeExpediente().isEmpty());
	}       

	@Test public void testaGetTempoPrimeiraConsulta(){
		Assert.assertEquals("Erro no getTempoDePrimeiraConsulta", 30, agenda.getTempoPrimeiraConsulta());
	}

	@Test public void testaSetTempoPrimeiraConsulta(){
		agenda.setTempoPrimeiraConsulta(5);
		Assert.assertEquals("Erro no setTempoPrimeiraConsulta", 5, agenda.getTempoPrimeiraConsulta());
	}

	@Test public void testaGetTempoConsultaRetorno(){
		Assert.assertEquals("Erro no getTempoConsultaRetorno", 20, agenda.getTempoConsultaRetorno());
	}

	@Test public void testaSetTempoConsultaRetorno(){
		agenda.setTempoConsultaRetorno(30);
		Assert.assertEquals("Erro no setTempoPrimeiraConsulta", 30, agenda.getTempoConsultaRetorno());
	}

	@Test public void testaGetListaPaciente(){
		Assert.assertTrue("Erro no getListaPaciente", agenda.getListaPacientesConsulta().isEmpty());
	}
	
	@Test public void testaMarcaConsulta(){
		agenda.addDiasDeExpediente(dia);
		Assert.assertTrue("Erro ao marcarConsulta", agenda.marcarConsulta(horario1));
		Assert.assertTrue("Erro ao marcar 2 consultas", agenda.marcarConsulta(horario2));
		Assert.assertTrue("Erro ao marcar passar de um dia pro outro", agenda.marcarConsulta(horario4));
		Assert.assertTrue("Erro ao marcar consulta de retorno", agenda.marcarConsulta(horario3));
	}
	
	@Test public void testaMarcarCirurgia(){
		agenda.addDiaDeCirurgia(dia);
		Assert.assertTrue("Erro ao marcar cirurgias", agenda.marcarCirurgia(horario1));
		Assert.assertTrue("Erro ao marcar 2 cirurgias", agenda.marcarCirurgia(horario2));
	}

	@Test public void testaPrimeiroDiaVago(){
		Calendar calendario = new GregorianCalendar(2000, 04, 21);
		Calendar calendario2 = new GregorianCalendar(2011, 04, 21);
		agenda.addDiasDeExpediente(dia);
		agenda.marcarConsulta(horario1);
		agenda.marcarConsulta(horario2);
		agenda.marcarConsulta(horario3);
		agenda.marcarConsulta(horario4);
		System.out.println(calendario.compareTo(agenda.primeiroDiaVago(horario2)));
		System.out.println(calendario2.compareTo(agenda.primeiroDiaVago(horario2)));
		System.out.println(calendario2.compareTo(agenda.primeiroDiaVago(horario3)));
		
	
	}
	
	@Test public void testaMarcarMaisDeUmMesDeCirurgia(){
		agenda.addDiaDeCirurgia(dia);
		Assert.assertTrue("Erro ao marcar dia de cirurgia", agenda.marcarCirurgia(horario1));
		Assert.assertTrue("Erro ao marcar dia de cirurgia", agenda.marcarCirurgia(horario2));
		Assert.assertTrue("Erro ao marcar dia de cirurgia",agenda.marcarCirurgia(horario3));
		Assert.assertTrue("Erro ao marcar dia de cirurgia",agenda.marcarCirurgia(horario4));
		Assert.assertTrue("Erro ao marcar dia de cirurgia",agenda.marcarCirurgia(horario5));
		Assert.assertTrue("Erro ao marcar dia de cirurgia",agenda.marcarCirurgia(horario6));
		Assert.assertTrue("Erro ao marcar dia de cirurgia",agenda.marcarCirurgia(horario7));
	}
	
	@Test public void testaMarcarConsultaPassandoDia(){
		Calendar calendario = new GregorianCalendar(2010, 10, 13);
		agenda.addDiasDeExpediente(dia);
		Assert.assertTrue("Erro ao marcar consulta passando o dia", agenda.marcarConsulta(horario1, calendario));
		
	}
	
	@Test public void testaMarcarConsultaComDataLimite(){
		Calendar calendario1, calendario2;
		calendario1 = new GregorianCalendar(2010, 10, 10);
		calendario2 = new GregorianCalendar(2010, 10, 7);
		agenda.addDiasDeExpediente(dia);
		Assert.assertTrue("Erro ao tentar marcar consulta com dia limite", agenda.marcarConsultaComDataLimite(horario1, calendario1));
		Assert.assertFalse("Erro ao tentar marcar consulta com dia limite", agenda.marcarConsultaComDataLimite(horario3, calendario2));
		
		
	}
	
	
	@Test public void testaMarcarMaisDeUmMesConsulta(){
		agenda.addDiasDeExpediente(dia);
		Assert.assertTrue("Erro ao marcar dia de consulta", agenda.marcarConsulta(horario1));
		Assert.assertTrue("Erro ao marcar dia de consulta", agenda.marcarConsulta(horario2));
		Assert.assertTrue("Erro ao marcar dia de consulta",agenda.marcarConsulta(horario3));
		Assert.assertTrue("Erro ao marcar dia de consulta",agenda.marcarConsulta(horario4));
		Assert.assertTrue("Erro ao marcar dia de consulta",agenda.marcarConsulta(horario5));
		Assert.assertTrue("Erro ao marcar dia de consulta",agenda.marcarConsulta(horario6));
		Assert.assertTrue("Erro ao marcar dia de consulta",agenda.marcarConsulta(horario7));
	}
	
	@Test public void testaExcluirConsulta(){
		Assert.assertEquals("Erro ao excluir consulta", null, agenda.excluirConsulta(horario1));
		agenda.addDiasDeExpediente(dia);
		Assert.assertTrue("Erro ao marcar dia de consulta", agenda.marcarConsulta(horario1));
		Assert.assertEquals("Erro ao excluir consulta", horario1, agenda.excluirConsulta(horario1));
		
	}
	
	@Test public void testaExcluirCirurgia(){
		Assert.assertEquals("Erro ao excluir cirurgia", null, agenda.excluirCirurgia(horario5));
		agenda.addDiaDeCirurgia(dia);
		Assert.assertTrue("Erro ao marcar dia de cirurgia", agenda.marcarCirurgia(horario5));
		Assert.assertEquals("Erro ao excluir cirurgia", horario5, agenda.excluirCirurgia(horario5));
		
	}
	
	
	@Test public void testaToString(){
		agenda.addDiasDeExpediente(dia);
		agenda.addDiaDeCirurgia(dia);
		Assert.assertTrue("Erro ao marcar dia de cirurgia", agenda.marcarCirurgia(horario1));
		Assert.assertTrue("Erro ao marcar dia de cirurgia", agenda.marcarCirurgia(horario2));
		Assert.assertTrue("Erro ao marcar dia de cirurgia", agenda.marcarConsulta(horario1));
		Assert.assertTrue("Erro ao marcar dia de cirurgia", agenda.marcarConsulta(horario2));
		
		Assert.assertEquals("Erro no to String", "Pacientes agendados para atendimento\nNumero de indentificacao :1234\nDia : 9\nMes: 11\nNumero de indentificacao :1534\nDia : 16\nMes: 11\n\nPacientes agendados para cirurgia\nNumero de indentificacao :1234\nDia : 9\nMes: 11\nNumero de indentificacao :1534\nDia : 16\nMes: 11\n", agenda.toString());
	}
	
	@Test public void testaProximoDiaLivreDeCirurgia(){
		agenda.addDiaDeCirurgia(dia);
		System.out.println(agenda.proximoDiaLivreCirurgia(horario1));
		agenda.marcarCirurgia(horario1);
		System.out.println(agenda.getListaPacientesCirurgia());
	}
	
	
	@Test public void testaProximoDiaLivreDeConsulta(){
		System.out.println("Dias consulta");
		agenda.addDiasDeExpediente(dia);
		System.out.println(agenda.proximoDiaLivreConsulta(horario1));
		agenda.marcarConsulta(horario1);
		System.out.println(agenda.getListaPacientesConsulta());
	}
	
	
}