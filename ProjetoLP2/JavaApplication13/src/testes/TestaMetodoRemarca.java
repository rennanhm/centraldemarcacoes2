package testes;

import org.junit.*;

import Medico.*;
import Paciente.*;

public class TestaMetodoRemarca {
	Medico medico;
	DiaDeTrabalho diaDeTrabalho;
	HorarioDeAtendimento horario;

	@Before	public void constroiMedico() throws Exception{
		medico = new Medico("Rodolfo", Especialidade.JOELHO, 30,30);
		horario = new HorarioDeAtendimento(2444,true, false);
		diaDeTrabalho = new DiaDeTrabalho(Semana.DOMINGO, "12:00","13:00");
		medico.addDiasDeExpediente(diaDeTrabalho);
	}
 
	@Test public void testaRemarcaConsulta(){
	   Assert.assertTrue(medico.marcarConsulta(horario));
	   //medico.
	   System.out.println(medico.getListaDePacientes().get(0));
	   
	}
}
