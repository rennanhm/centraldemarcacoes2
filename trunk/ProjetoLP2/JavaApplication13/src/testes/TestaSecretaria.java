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
import Paciente.EnderecoDoPaciente;
import Paciente.HorarioDeAtendimento;
import Paciente.Paciente;
import Paciente.TelefoneDeContato;
import PlanoDeSaude.PlanoDeSaude;
import Secretaria.Secretaria;

public class TestaSecretaria {
	EnderecoDoPaciente endereco1, endereco2, endereco3, endereco4, endereco5;
	TelefoneDeContato telefone1, telefone2, telefone3, telefone4, telefone5, telefone6, telefone7;
	DiaDeTrabalho diaDeTrabalho1, diaDeTrabalho2, diaDeTrabalho3, diaDeTrabalho4, diaDeTrabalho5;
	PlanoDeSaude plano;
	HorarioDeAtendimento horario1, horario2, horario3, horario4, horario5;
	Medico medico1, medico2, medico3, medico4, medico5;
	Secretaria secretaria;
	Paciente paciente1, paciente2, paciente3, paciente4, paciente5;
	TelefoneDeContato telefones;
	List<Medico> listaDeMedico;
	List<Paciente> listaDePaciente;
	
	@Before public void constroiSecretaria() throws Exception {
		plano = new PlanoDeSaude();
		
	
		
		diaDeTrabalho1 = new DiaDeTrabalho(Semana.DOMINGO, "13:00", "14:00");
		diaDeTrabalho2 = new DiaDeTrabalho(Semana.SEGUNDA, "13:00", "14:00");
		diaDeTrabalho3 = new DiaDeTrabalho(Semana.TERCA, "13:00", "14:00");
		diaDeTrabalho4 = new DiaDeTrabalho(Semana.QUARTA, "13:00", "14:00");
		diaDeTrabalho5 = new DiaDeTrabalho(Semana.QUINTA, "13:00", "14:00");
		
		endereco1 = new EnderecoDoPaciente("Rua1", "Complemento1", "bairro1", "cidade1", "estado1", "11111-111", 11);
		endereco2 = new EnderecoDoPaciente("Rua2", "Complemento2", "bairro2", "cidade2", "estado2", "22222-222", 22);
		endereco3 = new EnderecoDoPaciente("Rua3", "Complemento3", "bairro3", "cidade3", "estado3", "33333-333", 33);
		endereco4 = new EnderecoDoPaciente("Rua4", "Complemento4", "bairro4", "cidade4", "estado4", "44444-444", 44);
		endereco5 = new EnderecoDoPaciente("Rua5", "Complemento5", "bairro5", "cidade5", "estado5", "55555-555", 55);
		
		telefone1 = new TelefoneDeContato("(11)1111-1111");
		telefone2 = new TelefoneDeContato("(44)4444-4444");
		telefone3 = new TelefoneDeContato("(77)7777-7777");
		telefone4 = new TelefoneDeContato("(10)1010-1010");
		telefone5 = new TelefoneDeContato("(14)1414-1414");
		telefone6 = new TelefoneDeContato("(88)8888-8888");
		telefone7 = new TelefoneDeContato("(63)6363-3636");
		
		medico1 = new Medico("Nome do medico um", Especialidade.JOELHO, 50, 25);
		medico2 = new Medico("Nome do medico dois", Especialidade.OMBRO, 20, 10);
		medico3 = new Medico("Nome do medico tres", Especialidade.PUNHO, 40, 20);
		medico4 = new Medico("Nome do medico quadro", Especialidade.JOELHO, 10, 5);
		medico5 = new Medico("Nome do medico cinco", Especialidade.TORNOZELO, 30, 15);
		
		medico1.addDiasDeExpediente(diaDeTrabalho2);
		medico2.addDiasDeExpediente(diaDeTrabalho2);
		medico3.addDiasDeExpediente(diaDeTrabalho4);
		medico4.addDiasDeExpediente(diaDeTrabalho2);
		medico4.addDiasDeExpediente(diaDeTrabalho3);
		medico4.addDiasDeExpediente(diaDeTrabalho5);
		medico5.addDiasDeExpediente(diaDeTrabalho1);
		medico5.addDiasDeExpediente(diaDeTrabalho2);
		medico5.addDiasDeExpediente(diaDeTrabalho3);
		medico5.addDiasDeExpediente(diaDeTrabalho4);
		medico5.addDiasDeExpediente(diaDeTrabalho5);
		
		listaDeMedico = new ArrayList<Medico>();
	
		listaDeMedico.add(medico1);
		listaDeMedico.add(medico2);
		listaDeMedico.add(medico3);
		listaDeMedico.add(medico4);
		listaDeMedico.add(medico5);
		
		paciente1 = new Paciente("Nome do paciente 1", "111.111.111-11", endereco1, telefone1, telefone2, telefone3, "01/01/2001", plano, "emailcontato1@gmail.com", "Telefone residencial", "01/01/2000");
		paciente2 = new Paciente("Nome do paciente 2", "222.222.222-22", endereco2, telefone2, telefone3, telefone4, "02/02/2002", plano, "emailcontato2@gmail.com", "Telefone residencial", "02/02/2001");
		paciente3 = new Paciente("Nome do paciente 3", "333.333.333-33", endereco3, telefone3, telefone4, telefone5,"03/03/2003", plano, "emailcontato3@gmail.com", "Telefone residencial", "03/03/2002");
		paciente4 = new Paciente("Nome do paciente 4", "444.444.444-44", endereco4, telefone4, telefone5, telefone6, "04/04/2004", plano, "emailcontato4@gmail.com", "Telefone residencial", "04/04/2003");
		paciente5 = new Paciente("Nome do paciente 5", "555.555.555-55", endereco5, telefone5, telefone6, telefone7, "05/05/2005", plano, "emailcontato5@gmail.com", "Telefone residencial", "05/05/2004");
		
		
		
		listaDePaciente = new ArrayList<Paciente>();
		
		
		
		horario1 = new HorarioDeAtendimento(1233, true, false);
		horario2 = new HorarioDeAtendimento(2222, false, true);
		horario3 = new HorarioDeAtendimento(1111, true, false);
		horario4 = new HorarioDeAtendimento(4444, false, true);
		horario5 = new HorarioDeAtendimento(5555, true, false);
		
		paciente1.setHorarioDeAtendimento(horario1);
		paciente2.setHorarioDeAtendimento(horario2);
		paciente3.setHorarioDeAtendimento(horario3);
		paciente4.setHorarioDeAtendimento(horario4);
		paciente5.setHorarioDeAtendimento(horario5);
		
		
		listaDePaciente.add(paciente1);
		listaDePaciente.add(paciente2);
		listaDePaciente.add(paciente3);
		listaDePaciente.add(paciente4);
		listaDePaciente.add(paciente5);
		
		secretaria = new Secretaria(listaDeMedico, listaDePaciente);
	}

	@Test public void testaGetListaDePaciente(){
		Assert.assertEquals("Erro no getListaDePaciente", listaDePaciente, secretaria.getListaDePaciente());		
	}
	
	@Test public void testaGetListaDeEspera(){
		Assert.assertTrue("Erro na lista de espera", secretaria.getListaDeEspera().isEmpty());
	}
	
	@Test public void testaGetListaDeMedico(){
		Assert.assertEquals("Erro na lista de medicos", listaDeMedico, secretaria.getListaDeMedico());
	}
	
	@Test public void testaListaDeEspera(){
		Assert.assertTrue("Erro na lista de espera", secretaria.getListaDeEspera().isEmpty());
		secretaria.listaDeEspera(horario2);
		Assert.assertEquals("Erro na lista de espera", 1, secretaria.getListaDeEspera().size());
	}
		
	@Test public void testaMarcaConsulta(){
		Assert.assertTrue("Erro na lista de pacientes que o medico ira atender", medico1.getListaDePacientes().isEmpty());
		secretaria.marcarConsulta(medico1, paciente1);
		secretaria.marcarConsulta(medico1, paciente2);
		secretaria.marcarConsulta(medico1, paciente3);
		Assert.assertEquals("Erro ao armazenar consultas", 3, medico1.getListaDePacientes().size());
		
	}
	
	
	
	@Test public void testaMarcaConsultaPassandoEspecialidade(){
		Assert.assertTrue("Erro ao marcaConsultaPassandoEspecialidade", secretaria.marcarConsultaPassandoEspecialidade(Especialidade.PUNHO, paciente4));
		Assert.assertTrue("Erro na lista de consultas", medico1.getListaDePacientes().isEmpty());
		secretaria.marcarConsulta(medico1, paciente1);
		secretaria.marcarConsulta(medico1, paciente3);
		secretaria.marcarConsulta(medico1, paciente5);
		Assert.assertFalse("Erro na lista de consultas", medico1.getListaDePacientes().isEmpty());
		Assert.assertTrue("Erro na lista de consultas", medico4.getListaDePacientes().isEmpty());
		secretaria.marcarConsultaPassandoEspecialidade(Especialidade.JOELHO, paciente2);
		//Assert.assertEquals("Erro ao marcar consulta passando especialidade", 1, medico4.getListaDePacientes().size());	
	}
	
	
	@Test public void testaRemacarConsulta(){
		Calendar calendario = new GregorianCalendar(2010, 10, 14);
		medico5.addDiasDeExpediente(diaDeTrabalho1);
		Assert.assertTrue("Erro ao marcar consulta", secretaria.marcarConsulta(medico5, paciente1));
		Assert.assertTrue("Erro ao marcar consulta", secretaria.marcarConsulta(medico5, paciente2));
		Assert.assertTrue("Erro ao marcar consulta", secretaria.marcarConsulta(medico5, paciente3));
		Assert.assertTrue("Erro ao marcar consulta", secretaria.marcarConsulta(medico5, paciente4));
		Assert.assertTrue("Erro ao marcar consulta", secretaria.marcarConsulta(medico5, paciente5));
		Assert.assertTrue("Erro ao remarcar", secretaria.remacarConsulta(medico5, calendario));
		
	}
	
	@Test public void testaMarcarConsultaComDataLimite() throws Exception{
		Calendar calendario = new GregorianCalendar(2010, 10, 10);
		medico1 = new Medico("Teste", Especialidade.JOELHO, 60, 20);
		medico1.addDiasDeExpediente(new DiaDeTrabalho(Semana.SEXTA, "12:30", "13:00"));		
		
		Assert.assertTrue("Erro no marcarConsultaComDataLimite", secretaria.marcarConsultaComDataLimite(medico1, paciente2, calendario));
		Assert.assertTrue("Erro no marcarConsultaComDataLimite", secretaria.marcarConsultaComDataLimite(medico1, paciente3, calendario));
		Assert.assertTrue("Erro no marcarConsultaComDataLimite", secretaria.marcarConsultaComDataLimite(medico1, paciente5, calendario));

		//Assert.assertFalse("Erro no marcarConsultaComDataLimite", secretaria.marcarConsultaComDataLimite(medico1, paciente1, calendario));	
	}
	
	@Test public void testaExcluirConsulta(){
		Assert.assertEquals("Erro ao excluir consulta", null, secretaria.excluirConsulta(medico1, horario3));
		medico1.addDiasDeExpediente(diaDeTrabalho4);
		Assert.assertTrue("Erro no marcarConsulta", secretaria.marcarConsulta(medico1, paciente1));
		//Assert.assertEquals("Erro ao excluir consulta", horario3, secretaria.excluirConsulta(medico1, horario3));
	}
	
	
	@Test public void testaMarcarCirurgia(){
		medico1.addDiasDeCirurgia(diaDeTrabalho2);
		Assert.assertTrue(secretaria.marcarCirurgia(medico1, paciente4));
		System.out.println(medico1.getListaDePacientesCirurgia());
		medico4.addDiasDeCirurgia(diaDeTrabalho2);
		Assert.assertTrue(secretaria.marcarCirurgia(medico4, paciente3));
		System.out.println(medico4.getListaDePacientesCirurgia());
	}
	

	
	@Test public void testaNomeDosMedicos(){
		String[] nomeMedicos = new String[5];
		nomeMedicos[0] = medico1.getNomeDoMedico();
		nomeMedicos[1] = medico2.getNomeDoMedico();
		nomeMedicos[2] = medico3.getNomeDoMedico();
		nomeMedicos[3] = medico4.getNomeDoMedico();
		nomeMedicos[4] = medico5.getNomeDoMedico();
		
		//Assert.assertTrue("Erro no nome do medico", nomeMedicos.equals(secretaria.nomeDosMedicos()));
	}
	

}
