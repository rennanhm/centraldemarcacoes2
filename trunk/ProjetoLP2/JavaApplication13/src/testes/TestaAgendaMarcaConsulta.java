package testes;
//package Agenda;
//
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//
//import Medico.DiaDeTrabalho;
//import Medico.Especialidade;
//import Medico.HorarioDeAtendimento;
//import Medico.Medico;
//import Medico.Semana;
//
//public class TestaAgendaMarcaConssulta {
//	HorarioDeAtendimento horario1, horario2, horario3, horario4, horario5;
//	Agenda agenda;
//	Medico medico1, medico2;
//	DiaDeTrabalho dia1, dia2, dia3;
//
//	@Before
//	public void constroiAgenda() throws Exception {
//		horario1 = new HorarioDeAtendimento(1234, false, true);
//		horario2 = new HorarioDeAtendimento(4444, false, true);
//		horario3 = new HorarioDeAtendimento(8888, false, true);
//		horario4 = new HorarioDeAtendimento(7777, false, true);
//		horario5 = new HorarioDeAtendimento(9999, true, false);
//		dia3 = new DiaDeTrabalho(Semana.SEXTA, "20:30", "21:30");
//		medico1 = new Medico("Osso Duro de Ruer", Especialidade.JOELHO, 60, 60);
//		medico1.addDiasDeCirurgia(dia3);
//		
//		agenda = new Agenda(medico1);
//	}
//	@Test public void testaMarcaCirurgia() {
//		Assert.assertTrue("Erro no marcar consulta", agenda.getListaClientesCirurgia().isEmpty());
//		agenda.marcarCirurgia(horario1);
//		System.out.println(agenda.getListaClientesCirurgia());
//		Assert.assertFalse("Erro no marcar consulta", agenda.getListaClientesCirurgia().isEmpty());
//		agenda.marcarCirurgia(horario2);
//		Assert.assertEquals("Erro no marcar consulta", 2, agenda.getListaClientesCirurgia().size());
//		agenda.marcarCirurgia(horario3);
//		Assert.assertEquals("Erro ao marcar consulta", 3, agenda.getListaClientesCirurgia().size());
//	}
//}
