package Medico;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Medico.Semana;
/**
 * Objeto Para criacao dos dias de trabalho dos medicos com seus respectivos horarios
 * 
 * @author Grupo7
 *
 */
public class DiaDeTrabalho {
	private String entrou;
	private String saiu;
	private Semana diaSemana;
	/**
	 * Construtor de Dia.
	 * @param diaSemana Enum equivalente ao dia da Semana.
	 * @param entrou Horario de Entrada.
	 * @param saiu Horario de Saida.
	 * @throws Exception
	 */

	public DiaDeTrabalho(Semana diaSemana, String entrou, String saiu) throws Exception{
		int horaEntrou, horaSaiu;
		
		if(testaHorario(entrou)&&testaHorario(saiu)){
			if(!entrou.equals(saiu)){
				this.entrou = entrou;
				this.saiu = saiu;
			}else{
				throw new Exception("Horarios invalidos");
			}
		}else{
			throw new Exception("Horarios invalidos");
		}

		String[] horaMedicoEntrou = entrou.split(":");
		String[] horaMedicoSaiu = saiu.split(":");

		horaEntrou = Integer.parseInt(horaMedicoEntrou[0])* 60+ Integer.parseInt(horaMedicoEntrou[1]);
		horaSaiu = Integer.parseInt(horaMedicoSaiu[0])* 60+ Integer.parseInt(horaMedicoSaiu[1]);

		if (horaSaiu < horaEntrou){
			throw new Exception ("Horario invalidos");
		}


		this.diaSemana = diaSemana;
	}



	/**
	 * Recupera o dia da semana
	 * @return Dia da Semana
	 */
	public Semana getDiaSemana() {
		return diaSemana;
	}
	
	/**
	 * Acesse a hora de inicio de servico.
	 * @return horario de inicio de servico.
	 */
	public String getEntrou() {
		return entrou;
	}
	
	/**
	 * Modifica horario de Inicio de Servico.
	 * @param entrou horario de inicio de servico.
	 * @throws Exception
	 */
	public void setEntrou(String entrou) throws Exception {
		if (entrou.equalsIgnoreCase(this.getSaiu()) || entrou.equals("")){
			throw new Exception("Horarios invalidos");
		}
		this.entrou = entrou;
	}
	
	/**
	 * Acessa o horario de saida de servico.
	 * @return horario de final de servico.
	 */
	public String getSaiu() {
		return saiu;
	}
	
	/**
	 * Modifica horario de saida de servico.
	 * @param saiu horario de saida do servico.
	 * @throws Exception
	 */
	public void setSaiu(String saiu) throws Exception {
		if (this.getEntrou().equalsIgnoreCase(saiu) || saiu.equals("") ){
			throw new Exception("Horarios invalidos");
		}
		else if (testaHorario(saiu)!= true){
			throw new Exception("Horarios invalidos");
		}
		this.saiu = saiu;
	}
	
	/**
	 * To String
	 */
	public String toString(){
		return this.getEntrou() + " - " + this.getSaiu();
	}
	
	
	private boolean testaHorario(String hora){
		Pattern padrao = Pattern.compile("[0-1][0-9]:[0-5][0-9]");
		Matcher pesquisa = padrao.matcher(hora);
		if (pesquisa.matches()){
			return true;
		} else{
			Pattern padrao2 = Pattern.compile("[2][0-4]:[0-5][0-9]");
			Matcher pesquisa2 = padrao2.matcher(hora);
			if (pesquisa2.matches()){
				return true;
			}
		}
		return false;

	}

}
