package testes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Paciente.EnderecoDoPaciente;

public class TestaEnderecoDoPaciente {
	
	EnderecoDoPaciente endereco;
	
	@Before
	public void testEnderecoDoPaciente() throws Exception {
		endereco = new EnderecoDoPaciente("nome da rua", "complemento", "bairro", "cidade", "estado", "58100-100", 10);
	}
	
	@Test
	public void testaConstrutor(){
		
		try{
			endereco = new EnderecoDoPaciente("", "complemento", "bairro", "cidade", "estado", "58100-100", 10);
			Assert.fail("Esperava excecao de endereco invalido");
		}catch(Exception e){
			Assert.assertEquals("Mensagem incorreta", "Endereco invalido.", e.getMessage());
		}
		
		try{
			endereco = new EnderecoDoPaciente("nome da rua", "complemento", "bairro", "", "estado", "58100-100", 10);
			Assert.fail("Esperava excecao de endereco invalido");
		}catch(Exception e){
			Assert.assertEquals("Mensagem incorreta", "Endereco invalido.", e.getMessage());
		}
		
		try{
			endereco = new EnderecoDoPaciente("nome da rua", "complemento", "bairro", "cidade", "estado", "58100-100", -20);
			Assert.fail("Esperava excecao de endereco invalido");
		}catch(Exception e){
			Assert.assertEquals("Mensagem incorreta", "Endereco invalido.", e.getMessage());
		}
		
	}
	
	@Test
	public void testaCep() {
		
		try{
			endereco = new EnderecoDoPaciente("nome da rua", "complemento", "bairro", "cidade", "estado", "58100-10", 10);
			Assert.fail("Esperava excecao de CEP invalido");
		}catch(Exception e){
			Assert.assertEquals("Mensagem incorreta", "CEP invalido.", e.getMessage());
		}
		
		try{
			endereco = new EnderecoDoPaciente("nome da rua", "complemento", "bairro", "cidade", "estado", "8100-100", 10);
			Assert.fail("Esperava excecao de CEP invalido");
		}catch(Exception e){
			Assert.assertEquals("Mensagem incorreta", "CEP invalido.", e.getMessage());
		}
		
		try{
			endereco = new EnderecoDoPaciente("nome da rua", "complemento", "bairro", "cidade", "estado", "", 10);
			Assert.fail("Esperava excecao de CEP invalido");
		}catch(Exception e){
			Assert.assertEquals("Mensagem incorreta", "CEP invalido.", e.getMessage());
		}
		
		try{
			endereco = new EnderecoDoPaciente("nome da rua", "complemento", "bairro", "cidade", "estado", "510", 10);
			Assert.fail("Esperava excecao de CEP invalido");
		}catch(Exception e){
			Assert.assertEquals("Mensagem incorreta", "CEP invalido.", e.getMessage());
		}
		
	}
	
	@Test
	public void testEndereco() throws Exception{
		
		endereco = new EnderecoDoPaciente("nome da rua", "complemento", "bairro", "cidade", "estado", "58100-100", 10);
		
		Assert.assertEquals("Mensagem Incorreta", "nome da rua", endereco.getRua());
		Assert.assertEquals("Mensagem Incorreta", "complemento", endereco.getComplemento());
		Assert.assertEquals("Mensagem Incorreta", "bairro", endereco.getBairro());
		Assert.assertEquals("Mensagem Incorreta", "cidade", endereco.getCidade());
		Assert.assertEquals("Mensagem Incorreta", "estado", endereco.getEstado());
		Assert.assertEquals("Mensagem Incorreta", "58100-100", endereco.getCep());
		Assert.assertEquals("Mensagem Incorreta", 10, endereco.getNumero());
		
		endereco.setRua("");
		Assert.assertEquals("Mensagem Incorreta", "nome da rua", endereco.getRua());
		
		endereco.setRua("Nova rua do paciente");
		Assert.assertEquals("Mensagem Incorreta", "Nova rua do paciente", endereco.getRua());
		
		endereco.setComplemento("");
		Assert.assertEquals("Mensagem Incorreta", "", endereco.getComplemento());
		
		endereco.setBairro("");
		Assert.assertEquals("Mensagem Incorreta", "bairro", endereco.getBairro());
		
		endereco.setBairro("Novo bairro do paciente");
		Assert.assertEquals("Mensagem Incorreta", "Novo bairro do paciente", endereco.getBairro());
		
		endereco.setCidade("");
		Assert.assertEquals("Mensagem Incorreta", "cidade", endereco.getCidade());
		
		endereco.setCidade("Campina Grande");
		Assert.assertEquals("Mensagem Incorreta", "Campina Grande", endereco.getCidade());
		
		endereco.setEstado("");
		Assert.assertEquals("Mensagem Incorreta", "estado", endereco.getEstado());
		
		endereco.setEstado("Paraiba");
		Assert.assertEquals("Mensagem Incorreta", "Paraiba", endereco.getEstado());
		
		endereco.setCep("");
		Assert.assertEquals("Mensagem Incorreta", "58100-100", endereco.getCep());
		
		endereco.setCep("58555-555");
		Assert.assertEquals("Mensagem Incorreta", "58555-555", endereco.getCep());
		
		endereco.setNumero(-10);
		Assert.assertEquals("Mensagem Incorreta", 10, endereco.getNumero());
		
		endereco.setNumero(333);
		Assert.assertEquals("Mensagem Incorreta", 333, endereco.getNumero());
		
		Assert.assertEquals(
				"Mensagem Incorreta",
				"Rua/avenida: Nova rua do paciente, Complemento: , Bairro: Novo bairro do paciente, Cidade: Campina Grande, Estado: Paraiba, CEP: 58555-555, Numero: 333",
				endereco.toString());

	}

}
