package testes;



import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Medico.DiaDeTrabalho;
import Medico.Especialidade;
import Medico.Medico;
import Medico.Semana;
import Paciente.HorarioDeAtendimento;

public class TestaMedico {
	Medico medico, medico2;
	HorarioDeAtendimento horario1, horario2;
	DiaDeTrabalho dia, dia2;

	

	@Before public void constroiMedico() throws Exception {
		horario1 = new HorarioDeAtendimento(1234, true, false);
		horario2 = new HorarioDeAtendimento(4567, false, true);
		dia = new DiaDeTrabalho(Semana.QUARTA, "14:00", "15:00");
		dia2 = new DiaDeTrabalho(Semana.QUINTA, "10:00", "12:00");
		medico = new Medico("OssoDuroDeRoer", Especialidade.JOELHO, 30, 20);
		medico2 = new Medico();
	}

	@Test public void testaGetEspecialidade(){
		Assert.assertEquals("Erro na especialidade", Especialidade.JOELHO, medico.getEspecialidade());
	}

	@Test public void testaGetListaDePacientes() throws Exception {
		List<HorarioDeAtendimento> listaDePacientes = new ArrayList<HorarioDeAtendimento>();
		medico.addDiasDeExpediente(new DiaDeTrabalho(Semana.QUARTA, "13:00", "14:00"));
		listaDePacientes.add(horario1);
		listaDePacientes.add(horario2);
		Assert.assertTrue("Erro ao adicionar consulta", medico.marcarConsulta(horario1));
		Assert.assertTrue("Erro ao adicionar consulta", medico.marcarConsulta(horario2));
		
		Assert.assertEquals("Erro no getListaDePacientes", listaDePacientes, medico.getListaDePacientes());
	}
	
	@Test public void testaGetNomeMedico(){
		Assert.assertEquals("Erro no nome do medico", "OssoDuroDeRoer", medico.getNomeDoMedico());
	}
	
	@Test public void testaSetMedico() throws Exception{
		medico.setNomeDoMedico("novo nome");
		Assert.assertEquals("Erro no set medico", "novo nome", medico.getNomeDoMedico());
		
	}

	@Test public void testaGetTempoDaPrimeiraConsulta(){
		Assert.assertEquals("Erro ao armazenar primeira consulta", 30, medico.getTempoPrimeiraConsulta());
	}

	@Test public void testaGetTempoConsultaRetorno(){
		Assert.assertEquals("Erro ao armazenar constula retorno", 20, medico.getTempoConsultaRetorno());
	}

	@Test public void testaSetPrimeiraConsulta(){
		medico.setTempoPrimeiraConsulta(20);
		Assert.assertEquals("Erro ao mudar primeira consulta", 20, medico.getTempoPrimeiraConsulta());
	}

	@Test public void testaSetTempoConsultaRetorno(){
		medico.setTempoConsultaRetorno(10);
		Assert.assertEquals("Erro ao mudar consulta retorno", 10, medico.getTempoConsultaRetorno());
	}

	@Test public void testaAdicionaHorario() throws Exception {
		medico.addDiasDeCirurgia(new DiaDeTrabalho(Semana.DOMINGO, "12:00", "15:00"));
		Assert.assertEquals("Erro ao armazenar", 1, medico.getDiasDeCirurgia().size());
		medico.addDiasDeCirurgia(new DiaDeTrabalho(Semana.SABADO, "13:00", "17:00"));
		Assert.assertEquals("Erro ao armazenar", 2, medico.getDiasDeCirurgia().size());
		medico.addDiasDeCirurgia(new DiaDeTrabalho(Semana.DOMINGO, "12:00", "20:00"));
		Assert.assertEquals("Erro ao armazenar", 3, medico.getDiasDeCirurgia().size());
	}


	@Test(expected = Exception.class)
	public void testMedicoNomeEstranho() throws Exception {
		Assert.assertEquals("Nome do medico incorreto.", "OssoDuroDeRoer", medico.getNomeDoMedico());
		medico = new Medico("0s5oDuro0eRo7r", Especialidade.JOELHO, 30, 20);
	}

	@Test public void testaDelDiaDeExpediente() throws Exception{
		medico.addDiasDeExpediente(new DiaDeTrabalho(Semana.DOMINGO, "12:00", "20:00"));
		medico.addDiasDeExpediente(new DiaDeTrabalho(Semana.SEGUNDA, "08:00", "12:00"));
		medico.addDiasDeExpediente(new DiaDeTrabalho(Semana.TERCA, "09:00", "12:00"));
		medico.delDiaDeExpediente(Semana.SEGUNDA);
		Assert.assertEquals("Erro ao armazenar", 2, medico.getDiasDeExpediente().size());
	}

	@Test public void testaDelDiaDeCirurgia() throws Exception{
		medico.addDiasDeCirurgia(new DiaDeTrabalho(Semana.DOMINGO, "12:00", "20:00"));
		medico.addDiasDeCirurgia(new DiaDeTrabalho(Semana.SEGUNDA, "08:00", "12:00"));
		medico.addDiasDeCirurgia(new DiaDeTrabalho(Semana.TERCA, "09:00", "12:00"));
		medico.delDiaDeCirurgia(Semana.SEGUNDA);
		Assert.assertEquals("Erro ao armazenar", 2, medico.getDiasDeCirurgia().size());
	}

	@Test public void testaSetEspecialidade(){
		medico.setEspecialidade(Especialidade.OMBRO);
		Assert.assertEquals(Especialidade.OMBRO, medico.getEspecialidade());
	}

	@Test public void testaToString(){
		Assert.assertEquals("incorreto", "O nome do medico eh: OssoDuroDeRoer\nA especialidade: JOELHO\nO tempo que demora na primeira consulta eh: 30 minutos\nO tempo que demora na consulta de retorno eh: 20 minutos", medico.toString());
		medico.addDiasDeCirurgia(dia);
		medico.addDiasDeExpediente(dia);
		Assert.assertEquals("incorreto", "O nome do medico eh: OssoDuroDeRoer\nA especialidade: JOELHO\nIntervencoes Cirurgicas: QUARTA - 14:00 as 15:00\nDias de Atendimentos: QUARTA - 14:00 as 15:00\nO tempo que demora na primeira consulta eh: 30 minutos\nO tempo que demora na consulta de retorno eh: 20 minutos", medico.toString());
	}
	
	
	
	@Test public void testaPrimeiroDiaVago() throws Exception {
		Calendar calendario = new GregorianCalendar();
		Semana semana = Semana.values()[calendario.get(Calendar.DAY_OF_WEEK)-1];
	
		medico.addDiasDeExpediente(new DiaDeTrabalho(semana, "12:00", "14:00"));
		Assert.assertEquals("Erro ao pegar primeiro dia livre", 1, calendario.compareTo(medico.primeiroDiaLivre()));
		medico.marcarConsulta(new HorarioDeAtendimento());
		
	}
	
	@Test public void testaMarcarConsultaComDataLimite() throws Exception {
		Calendar calendario = new GregorianCalendar(2010, 10, 7);
		medico.addDiasDeExpediente(new DiaDeTrabalho(Semana.SEXTA, "12:00", "14:00"));
		Assert.assertFalse("Erro no marcar consulta com data limite", medico.marcarConsultaComDataLimite(horario1, calendario));
		Assert.assertTrue("Erro ao marcar consulta com data limite", medico.marcarConsulta(horario1));
	}
	
	@Test public void testaMarcarConsultaPassandoData() throws Exception {
		Calendar calendario = new GregorianCalendar(2010, 10, 7);
		medico.addDiasDeExpediente(new DiaDeTrabalho(Semana.SEXTA, "12:00", "14:00"));
		Assert.assertTrue("Erro ao marcar consulta", medico.marcarConsulta(horario1, calendario));
	}
	
	@Test public void testaAgendaMedico(){
		medico.addDiasDeExpediente(dia);
		medico.addDiasDeCirurgia(dia);
		Assert.assertTrue("Erro ao marcar dia de cirurgia", medico.marcarCirurgia(horario2));
		Assert.assertTrue("Erro ao marcar dia de consulta", medico.marcarConsulta(horario1));
		Assert.assertEquals("Erro ao imprimir agenda do medico", "Pacientes agendados para atendimento\nNumero de indentificacao :1234\nDia : 10\nMes: 11\n\nPacientes agendados para cirurgia\nNumero de indentificacao :4567\nDia : 10\nMes: 11\n", medico.agendaMedico());
		
	}
	
	
	@Test public void testaExcluirConsulta(){
		Assert.assertEquals("Erro ao excluir consulta", null, medico.excluirConsulta(horario1));
		medico.addDiasDeExpediente(dia);
		Assert.assertTrue("Erro ao marcar dia de consulta", medico.marcarConsulta(horario1));
		Assert.assertEquals("Erro ao excluir consulta", horario1, medico.excluirConsulta(horario1));
	}
	
	
	@Test public void testaExcluirCirurgia(){
		Assert.assertEquals("Erro ao excluir cirurgia", null, medico.excluirCirurgia(horario1));
		medico.addDiasDeCirurgia(dia);
		Assert.assertTrue("Erro ao marcar dia de cirurgia", medico.marcarCirurgia(horario1));
		Assert.assertEquals("Erro ao excluir cirurgia", horario1, medico.excluirCirurgia(horario1));
	}
	
}
