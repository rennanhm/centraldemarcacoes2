package testes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Paciente.EnderecoDoPaciente;
import Paciente.Paciente;
import Paciente.TelefoneDeContato;
import PlanoDeSaude.PlanoDeSaude;


//Testa excecoes do construtor
public class TestaPaciente {
	
	Paciente paciente;
	PlanoDeSaude plano = new PlanoDeSaude();
	EnderecoDoPaciente endereco;
	TelefoneDeContato foneResidencial;
	TelefoneDeContato foneComercial;
	TelefoneDeContato foneCelular;
	
	@Before
	public void testaEndereco() throws Exception {
		endereco = new EnderecoDoPaciente("Rua perto do centro", "", "Centro", "Campina Grande", "Paraiba", "58100-100", 100);
	}
	
	@Before
	public void testaTelefoneResidencial() throws Exception {
		foneResidencial = new TelefoneDeContato("(83)3333-0000");
	}
	
	@Before
	public void testaTelefoneComercial() throws Exception {
		foneComercial = new TelefoneDeContato("(83)1414-1414");
	}
	
	@Before
	public void testaTelefoneCelular() throws Exception {
		foneCelular = new TelefoneDeContato("(11)3636-3636");
	}
	
	@Test
	public void testaNomeDoPaciente() {
								
		try {
			paciente = new Paciente("", "450.254.268-03", endereco,
					foneResidencial, foneComercial, foneCelular,
					"05/04/1985", plano, "paciente@gmail.com",
					"Telefone celular", "10/10/2010");
			Assert.fail("Esperava excessao de nome incorreto");
		} catch (Exception e) {
			Assert.assertEquals("O nome do paciente nao pode ser nulo ou vazio.", e.getMessage());
		}
						
	}
	
	@Test
	public void testaCpfDoPaciente(){
		
		try {
			paciente = new Paciente("Maria da Silva", "", endereco,
					foneResidencial, foneComercial, foneCelular,
					"05/04/1985", plano, "paciente@gmail.com",
					"Telefone celular", "10/10/2010");
			Assert.fail("Esperava excessao de cpf invalido");
		} catch (Exception e) {
			Assert.assertEquals("CPF invalido.", e.getMessage());
		}
		
		try {
			paciente = new Paciente("Maria da Silva", "45.254.268-07", endereco,
					foneResidencial, foneComercial, foneCelular,
					"05/04/1985", plano, "paciente@gmail.com",
					"Telefone celular", "10/10/2010");
			Assert.fail("Esperava excessao de cpf invalido");
		} catch (Exception e) {
			Assert.assertEquals("CPF invalido.", e.getMessage());
		}
		
		try {
			paciente = new Paciente("Maria da Silva", "450.25.268-07", endereco,
					foneResidencial, foneComercial, foneCelular,
					"05/04/1985", plano, "paciente@gmail.com",
					"Telefone celular", "10/10/2010");
			Assert.fail("Esperava excessao de cpf invalido");
		} catch (Exception e) {
			Assert.assertEquals("CPF invalido.", e.getMessage());
		}
		
		try {
			paciente = new Paciente("Maria da Silva", "450.254.26-07", endereco,
					foneResidencial, foneComercial, foneCelular,
					"05/04/1985", plano, "paciente@gmail.com",
					"Telefone celular", "10/10/2010");
			Assert.fail("Esperava excessao de cpf invalido");
		} catch (Exception e) {
			Assert.assertEquals("CPF invalido.", e.getMessage());
		}
		
		try {
			paciente = new Paciente("Maria da Silva", "450.254.268-0", endereco,
					foneResidencial, foneComercial, foneCelular,
					"05/04/1985", plano, "paciente@gmail.com",
					"Telefone celular", "10/10/2010");
			Assert.fail("Esperava excessao de cpf invalido");
		} catch (Exception e) {
			Assert.assertEquals("CPF invalido.", e.getMessage());
		}
		
	}
	
	
	@Test
	public void testaDataDeNascimento(){
		
		try {
			paciente = new Paciente("Maria da Silva", "450.254.268-03", endereco,
					foneResidencial, foneComercial, foneCelular,
					"05/041985", plano, "paciente@gmail.com",
					"Telefone celular", "10/10/2010");
			Assert.fail("Esperava excessao de data invalida");
		} catch (Exception e) {
			Assert.assertEquals("Data de nascimento invalida.", e.getMessage());
		}
		
		try {
			paciente = new Paciente("Maria da Silva", "450.254.268-03", endereco,
					foneResidencial, foneComercial, foneCelular,
					"5/4/198", plano, "paciente@gmail.com",
					"Telefone celular", "10/10/2010");
			Assert.fail("Esperava excessao de data invalida");
		} catch (Exception e) {
			Assert.assertEquals("Data de nascimento invalida.", e.getMessage());
		}
		
		try {
			paciente = new Paciente("Maria da Silva", "450.254.268-03", endereco,
					foneResidencial, foneComercial, foneCelular,
					"32/10/1985", plano, "paciente@gmail.com",
					"Telefone celular", "10/10/2010");
			Assert.fail("Esperava excessao de data invalida");
		} catch (Exception e) {
			Assert.assertEquals("Data de nascimento invalida.", e.getMessage());
		}
		
		try {
			paciente = new Paciente("Maria da Silva", "450.254.268-03", endereco,
					foneResidencial, foneComercial, foneCelular,
					"31/15/1985", plano, "paciente@gmail.com",
					"Telefone celular", "10/10/2010");
			Assert.fail("Esperava excessao de data invalida");
		} catch (Exception e) {
			Assert.assertEquals("Data de nascimento invalida.", e.getMessage());
		}
		
		try {
			paciente = new Paciente("Maria da Silva", "450.254.268-03", endereco,
					foneResidencial, foneComercial, foneCelular,
					"30/02/2011", plano, "paciente@gmail.com",
					"Telefone celular", "10/10/2010");
			Assert.fail("Esperava excessao de data invalida");
		} catch (Exception e) {
			Assert.assertEquals("Data de nascimento invalida.", e.getMessage());
		}
		
		
		//Testa meses que nao apresentam 31 dias
		
		try {
			paciente = new Paciente("Maria da Silva", "450.254.268-03", endereco,
					foneResidencial, foneComercial, foneCelular,
					"31/11/1985", plano, "paciente@gmail.com",
					"Telefone celular", "10/10/2010");
			Assert.fail("Esperava excessao de data invalida");
		} catch (Exception e) {
			Assert.assertEquals("Data de nascimento invalida.", e.getMessage());
		}
		
		try {
			paciente = new Paciente("Maria da Silva", "450.254.268-03", endereco,
					foneResidencial, foneComercial, foneCelular,
					"31/04/1985", plano, "paciente@gmail.com",
					"Telefone celular", "10/10/2010");
			Assert.fail("Esperava excessao de data invalida");
		} catch (Exception e) {
			Assert.assertEquals("Data de nascimento invalida.", e.getMessage());
		}
		
		//Testa se o mes de fevereiro pode ou nao ter 29 dias
		
		try {
			paciente = new Paciente("Maria da Silva", "450.254.268-03", endereco,
					foneResidencial, foneComercial, foneCelular,
					"29/02/2010", plano, "paciente@gmail.com",
					"Telefone celular", "10/10/2010");
			Assert.fail("Esperava excessao de data invalida");
		} catch (Exception e) {
			Assert.assertEquals("Data de nascimento invalida.", e.getMessage());
		}
		
		try {
			paciente = new Paciente("Maria da Silva", "450.254.268-03", endereco,
					foneResidencial, foneComercial, foneCelular,
					"29/02/1985", plano, "paciente@gmail.com",
					"Telefone celular", "10/10/2010");
			Assert.fail("Esperava excessao de data invalida");
		} catch (Exception e) {
			Assert.assertEquals("Data de nascimento invalida.", e.getMessage());
		}
		
	}
	
	
	@Test
	public void testaEmailDoPaciente(){
		
		try {
			paciente = new Paciente("Maria da Silva", "450.254.268-03", endereco,
					foneResidencial, foneComercial, foneCelular,
					"05/04/1985", plano, "",
					"Telefone celular", "10/10/2010");
			Assert.fail("Esperava excessao de email invalido");
		} catch (Exception e) {
			Assert.assertEquals("Email invalido.", e.getMessage());
		}
		
		try {
			paciente = new Paciente("Maria da Silva", "450.254.268-03", endereco,
					foneResidencial, foneComercial, foneCelular,
					"05/04/1985", plano, "paciente",
					"Telefone celular", "10/10/2010");
			Assert.fail("Esperava excessao de email invalido");
		} catch (Exception e) {
			Assert.assertEquals("Email invalido.", e.getMessage());
		}
		
		try {
			paciente = new Paciente("Maria da Silva", "450.254.268-03", endereco,
					foneResidencial, foneComercial, foneCelular,
					"05/04/1985", plano, "pacientegmail.com",
					"Telefone celular", "10/10/2010");
			Assert.fail("Esperava excessao de email invalido");
		} catch (Exception e) {
			Assert.assertEquals("Email invalido.", e.getMessage());
		}
		
		try {
			paciente = new Paciente("Maria da Silva", "450.254.268-03", endereco,
					foneResidencial, foneComercial, foneCelular,
					"05/04/1985", plano, "paciente@gmail",
					"Telefone celular", "10/10/2010");
			Assert.fail("Esperava excessao de email invalido");
		} catch (Exception e) {
			Assert.assertEquals("Email invalido.", e.getMessage());
		}
		
		try {
			paciente = new Paciente("Maria da Silva", "450.254.268-03", endereco,
					foneResidencial, foneComercial, foneCelular,
					"05/04/1985", plano, "@gmail.com.br",
					"Telefone celular", "10/10/2010");
			Assert.fail("Esperava excessao de email invalido");
		} catch (Exception e) {
			Assert.assertEquals("Email invalido.", e.getMessage());
		}
		
		try {
			paciente = new Paciente("Maria da Silva", "450.254.268-03", endereco,
					foneResidencial, foneComercial, foneCelular,
					"05/04/1985", plano, "brunna*@gmail.com.br",
					"Telefone celular", "10/10/2010");
			Assert.fail("Esperava excessao de email invalido");
		} catch (Exception e) {
			Assert.assertEquals("Email invalido.", e.getMessage());
		}
		
		try {
			paciente = new Paciente("Maria da Silva", "450.254.268-03", endereco,
					foneResidencial, foneComercial, foneCelular,
					"05/04/1985", plano, "#brunna#@gmail.com.br",
					"Telefone celular", "10/10/2010");
			Assert.fail("Esperava excessao de email invalido");
		} catch (Exception e) {
			Assert.assertEquals("Email invalido.", e.getMessage());
		}
		
		try {
			paciente = new Paciente("Maria da Silva", "450.254.268-03", endereco,
					foneResidencial, foneComercial, foneCelular,
					"05/04/1985", plano, "brunna;@gmail.com.br",
					"Telefone celular", "10/10/2010");
			Assert.fail("Esperava excessao de email invalido");
		} catch (Exception e) {
			Assert.assertEquals("Email invalido.", e.getMessage());
		}
		
	}
	
	@Test
	public void testaFormaDeContato(){
		
		try {
			paciente = new Paciente("Maria da Silva", "450.254.268-03", endereco,
					foneResidencial, foneComercial, foneCelular,
					"05/04/1985", plano, "paciente@yahoo.com.br",
					"", "10/10/2010");
			Assert.fail("Esperava excessao de forma de contato invalida");
		} catch (Exception e) {
			Assert.assertEquals("Forma de contato invalida.", e.getMessage());
		}
		
		
		try {
			paciente = new Paciente("Maria da Silva", "450.254.268-03", endereco,
					foneResidencial, foneComercial, foneCelular,
					"05/04/1985", plano, "paciente@yahoo.com.br",
					"carta", "10/10/2010");
			Assert.fail("Esperava excessao de forma de contato invalida");
		} catch (Exception e) {
			Assert.assertEquals("Forma de contato invalida.", e.getMessage());
		}
		
	}
	
	@Test
	public void testaDataDaUltimaVisita(){
		
		try {
			paciente = new Paciente("Maria da Silva", "450.254.268-03", endereco,
					foneResidencial, foneComercial, foneCelular, "05/04/1985", plano, "brunna@gmail.com.br", "Telefone celular", "50/12/2010");
			Assert.fail("Esperava excecao de data da utima visita invalida");
		}catch (Exception e){
			Assert.assertEquals("Data da ultima visita invalida.", e.getMessage());
		}
		
	}

}


