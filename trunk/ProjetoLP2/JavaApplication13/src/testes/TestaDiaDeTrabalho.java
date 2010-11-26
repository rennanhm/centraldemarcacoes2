package testes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Medico.DiaDeTrabalho;
import Medico.Semana;
/**
 *
 * @author Grupo 7
 *
 */
public class TestaDiaDeTrabalho {
	DiaDeTrabalho dia;

	@Before public void constroiDiaDeTrabalho() throws Exception {
		dia = new DiaDeTrabalho(Semana.DOMINGO, "12:00", "15:00");

		
	}
	@Test public void testaExcecaoConstrutorVazio() throws Exception{
		try {
			dia = new DiaDeTrabalho(Semana.DOMINGO, "12:00", "");
			Assert.fail("Espera Excecao1");
		} catch (Exception ex) {
			Assert.assertEquals("Menssagem Incorreta","Horarios invalidos", ex.getMessage());
		}
		try {
			dia = new DiaDeTrabalho(Semana.DOMINGO, "", "12:00");
			Assert.fail("Espera Excecao2");
		} catch (Exception ex) {
			Assert.assertEquals("Menssagem Incorreta","Horarios invalidos", ex.getMessage());
		}
	}
		
	@Test public void testaExcecaoConstrutorHorariosIguais(){
		try {
			dia = new DiaDeTrabalho(Semana.DOMINGO, "12:00", "12:00");
			Assert.fail("Espera Excecao");
		} catch (Exception ex) {
			Assert.assertEquals("Menssagem Incorreta","Horarios invalidos", ex.getMessage());
		}
		
	}
		
	@Test public void testaExcecaoConstrutorHorariosInvalidos(){
		
		try {
			dia = new DiaDeTrabalho(Semana.DOMINGO, "12:a0", "13:00");
			Assert.fail("Espera Excecao");
		} catch (Exception ex) {
			Assert.assertEquals("Menssagem Incorreta","Horarios invalidos", ex.getMessage());
		}
		try {
			dia = new DiaDeTrabalho(Semana.DOMINGO, "12:60", "13:00");
			Assert.fail("Espera Excecao");
		} catch (Exception ex) {
			Assert.assertEquals("Menssagem Incorreta","Horarios invalidos", ex.getMessage());
		}

		try {
			dia = new DiaDeTrabalho(Semana.DOMINGO, "2:00", "1:00");
			Assert.fail("Espera Excecao");
		} catch (Exception ex) {
			Assert.assertEquals("Menssagem Incorreta","Horarios invalidos", ex.getMessage());
		}

	}
	
	@Test public void testaGetDiaSemana() {
		Assert.assertEquals("Dia Da Semana Invalido", Semana.DOMINGO, dia.getDiaSemana());
	}
	@Test public void testaGetEntrou(){
		Assert.assertEquals("Hora de Entrada incorreta", "12:00", dia.getEntrou());
	}
	@Test public void testaGetSaiu(){
		Assert.assertEquals("Hora de Saida Incorreta", "15:00", dia.getSaiu());
	}
	@Test public void testSetEntrou() throws Exception{
		dia.setEntrou("13:00");
		Assert.assertEquals("Hora de Entrada Incorreta", "13:00", dia.getEntrou());
	try{
		dia.setEntrou("");
		Assert.fail("Espera Exececao");
	} catch (Exception ex){
		Assert.assertEquals("Menssagem Incorreta","Horarios invalidos", ex.getMessage());
	}
	}
	@Test public void testSetSaiu() throws Exception{
		dia.setSaiu("16:00");
		Assert.assertEquals("Hora de Saida Incorreta", "16:00", dia.getSaiu());
		try{
			dia.setSaiu("");
			Assert.fail("Espera Excecao");
		}catch (Exception ex) {
			Assert.assertEquals("Menssagem Incorreta","Horarios invalidos", ex.getMessage());
		}
		try{
			dia.setSaiu("12:bs");
			Assert.fail("Espera Excecao");
		}catch (Exception ex) {
			Assert.assertEquals("Menssagem Incorreta","Horarios invalidos", ex.getMessage());
		}

	}
	@Test public void testToString(){
		Assert.assertEquals("Menssagem Incorreta", "12:00 - 15:00", dia.toString());
	}
}


