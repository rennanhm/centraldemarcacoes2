package testes;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Paciente.HorarioDeAtendimento;

public class TestaHorarioDeAtendimento {
	Calendar calendario1;
	Calendar calendario2;
	Integer numeroDeIndentificacao;
	
	HorarioDeAtendimento horario;
	
	@Before public void constroiHorarioDeAtendimento(){
		calendario1 = new GregorianCalendar();
		calendario2 = new GregorianCalendar(2020, 10, 20);
		numeroDeIndentificacao = 1234;
		horario = new HorarioDeAtendimento(1234, false, true);
	}

	@Test public void testaGetDia(){
		Assert.assertEquals("Erro no getDias", calendario1.get(Calendar.DAY_OF_WEEK) ,horario.getDiaDaSemana());
	}
	
	@Test public void testaSetDia(){
		horario.setDiaDaSemana(1);
		Assert.assertEquals("Erro no setDias", 1, horario.getDiaDaSemana());
	}
	
	@Test public void testaGetMes(){
		Assert.assertEquals("Erro no getMes", calendario1.get(Calendar.DAY_OF_MONTH), horario.getDiaDoMes());
	}
	
	@Test public void testaToString(){
		Assert.assertEquals("Erro no toString", "Numero de indentificacao :1234\nDia : 8\nMes: 11", horario.toString());
	}
	
	@Test public void testaSetMes(){
		horario.setDiaDoMes(10);
		Assert.assertEquals("Erro no setMes", 10, horario.getDiaDoMes());
	}
	
	@Test public void testaGetAno(){
		Assert.assertEquals("Erro no getAno", calendario1.get(Calendar.YEAR), horario.getAno());
	}
	
	@Test public void testaSetAno(){
		horario.setAno(2014);
		Assert.assertEquals("Erro no setAno", 2014, horario.getAno());
	}
	
	@Test public void testaGetCalendario(){
		Assert.assertEquals("Erro no getCalendario", calendario1, horario.getCalendario());
	}
	
	@Test public void testaSetCalendario(){
		horario.setCalendario(calendario2);
		Assert.assertEquals("Erro no setCalendario", calendario2, horario.getCalendario());
		
	}
	
	@Test public void testaNumeroDeIndentificacao(){
		Assert.assertEquals("Erro no numero de indentificacao", 1234, horario.getNumeroDeIdentificao());
	}
	
	@Test public void testaIsRetorno(){
		Assert.assertTrue("Erro no isRetorno", horario.isRetorno());
	}
	
	@Test public void testaIsPrimeiraConsulta(){
		Assert.assertFalse("Erro no isRetorno", horario.isPrimeiraConsulta());
	}
	
}
