package testes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import PlanoDeSaude.PlanoDeSaude;



/**
 * 
 * @author Grupo 7;
 *
 */
public class TestaPlanoDeSaude {
	PlanoDeSaude planoA, planoB;

	@Before public void constroiPlano() throws Exception {
		planoA = new PlanoDeSaude("Unimed", 30.0, "(83)1234-1234");
		planoB = new PlanoDeSaude();
	}
	
	@Test public void testaGetNome() {
		Assert.assertEquals("Erro ao armazenar nome do plano", "Unimed", planoA.getNomeDoPlano());
		Assert.assertEquals("Erro ao armazenar nome do plano", "Particular", planoB.getNomeDoPlano());
	}
		
	@Test public void testaValorDoPlano(){
		Assert.assertEquals("Erro ao armazenar valor do plano", 30.0, planoA.getPrecoDoPlano(), 0.001);
		Assert.assertEquals("Erro ao armazenar valor do plano", null, planoB.getPrecoDoPlano());
	}
	
	@Test public void testaTelefoneDoPlano(){
		Assert.assertEquals("Erro ao armazenar telefone do plano", "(83)1234-1234", planoA.getTelefoneDoPlano());
		Assert.assertEquals("Erro ao mostrar numero de telefone", null, planoB.getTelefoneDoPlano());
	}
	
	@Test public void testaSetTelefone() throws Exception {
		planoA.setTelefoneDoPlano("(11)3112-2211");
		Assert.assertEquals("Erro ao mudar telefone", "(11)3112-2211", planoA.getTelefoneDoPlano());
	}
	
}
