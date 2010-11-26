package testes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Paciente.TelefoneDeContato;

public class TestaTelefoneDeContato {
	
	TelefoneDeContato telefone;
	
	@Before
	public void test() throws Exception{
		telefone = new TelefoneDeContato("(83)3322-1010");
	}
	
	@Before
	public void test2() throws Exception{
		telefone = new TelefoneDeContato("");
	}
	
	
	@Test
	public void testaTelefone(){
		
		try{
			telefone = new TelefoneDeContato("(83)3-1010");
			Assert.fail("Esperava excecao de telefone residencial invalido");
		}catch(Exception e){
			Assert.assertEquals("Telefone residencial invalido", e.getMessage());
		}
		
		try{
			telefone = new TelefoneDeContato("(8)3322-1010");
			Assert.fail("Esperava excecao de telefone residencial invalido");
		}catch(Exception e){
			Assert.assertEquals("Telefone residencial invalido", e.getMessage());
		}
		
		try{
			telefone = new TelefoneDeContato("(83)3322-101");
			Assert.fail("Esperava excecao de telefone residencial invalido");
		}catch(Exception e){
			Assert.assertEquals("Telefone residencial invalido", e.getMessage());
		}
		
		try{
			telefone = new TelefoneDeContato("833322-1010");
			Assert.fail("Esperava excecao de telefone residencial invalido");
		}catch(Exception e){
			Assert.assertEquals("Telefone residencial invalido", e.getMessage());
		}
		
		try{
			telefone = new TelefoneDeContato("(83)3322-10101");
			Assert.fail("Esperava excecao de telefone residencial invalido");
		}catch(Exception e){
			Assert.assertEquals("Telefone residencial invalido", e.getMessage());
		}
		
	}
	
	
	@Test
	public void testTelefone() throws Exception{
		
		telefone = new TelefoneDeContato("(83)3322-1010");
		
		Assert.assertEquals("(83)3322-1010", telefone.getTelefone());
		
		telefone.setTelefone("(78)asdv-1234");
		Assert.assertEquals("(83)3322-1010", telefone.getTelefone());
		
		telefone.setTelefone("(11)3333-9999");
		Assert.assertEquals("(11)3333-9999", telefone.getTelefone());
		
		Assert.assertEquals("Telefone: (11)3333-9999", telefone.toString());
		
		telefone.setTelefone("");
		Assert.assertEquals("", telefone.getTelefone());
		Assert.assertEquals("Telefone: ", telefone.toString());
		
	}

}
