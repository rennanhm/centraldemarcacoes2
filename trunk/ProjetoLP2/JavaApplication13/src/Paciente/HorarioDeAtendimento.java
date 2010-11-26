package Paciente;

import java.util.Calendar;
import java.util.GregorianCalendar;

import PlanoDeSaude.PlanoDeSaude;

/**
 * Cria um horario de atendimento a partir do numero de identificacao do
 * paciente e do tipo de consulta que ele quer, se retorno ou consulta.
 * 
 * @author Grupo 7
 * 
 */
public class HorarioDeAtendimento {
	private final int AJUSTE_CALENDARIO = 1;
	private int numeroDeIdentificao;
	private Calendar calendario;
	private boolean retorno;
	private boolean primeiraConsulta;
	private PlanoDeSaude planoDeSaude;

	/**
	 * Cria um horario de atendimento.
	 */
	public HorarioDeAtendimento() {
		this.calendario = new GregorianCalendar();
	}

	/**
	 * Cria uma horario de antendimento passando o plano de saude
	 * 
	 * @param planoDeSaude
	 *            Plano de Saude
	 */
	public HorarioDeAtendimento(PlanoDeSaude planoDeSaude) {
		this.planoDeSaude = planoDeSaude;
	}

	/**
	 * Recebe como parametros o numero de identificacao e booleans que indicam
	 * se o paciente eh primeira consulta ou consulta de retorno.
	 * 
	 * @param numeroDeIdentificacao
	 *            Numero de identificacao do paciente
	 * @param primeiraConsulta
	 *            Um boolean que representa se eh primeira consulta ou nao
	 * @param retorno
	 *            Um boolean que representa se eh retorno ou nao
	 */
	public HorarioDeAtendimento(int numeroDeIdentificacao,
			boolean primeiraConsulta, boolean retorno) {
		this.calendario = new GregorianCalendar();
		this.numeroDeIdentificao = numeroDeIdentificacao;
		this.retorno = retorno;
		this.primeiraConsulta = primeiraConsulta;
	}

	/**
	 * Retorna o plano de saude utilizado
	 * 
	 * @return Plano de Saude
	 */
	public PlanoDeSaude getPlanoDeSaude() {
		return planoDeSaude;
	}

	/**
	 * Muda o plano de saude atual para o passado como parametro
	 * 
	 * @param planoDeSaude
	 *            Novo plano de saude
	 */
	public void setPlanoDeSaude(PlanoDeSaude planoDeSaude) {
		this.planoDeSaude = planoDeSaude;
	}

	/**
	 * Retorna um inteiro que representa o dia da semana.
	 * 
	 * @return Dia da semana.
	 */
	public int getDiaDaSemana() {
		return calendario.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * Muda o numero de identificacao do paciente para o passado como parametro
	 * 
	 * @param numeroDeIdentificao
	 *            Novo nuemro de identificacao
	 */
	public void setNumeroDeIdentificao(int numeroDeIdentificao) {
		this.numeroDeIdentificao = numeroDeIdentificao;
	}

	/**
	 * Muda o dia da semana para o passado como parametro.
	 * 
	 * @param dia
	 *            Novo dia da semana.
	 */
	public void setDiaDaSemana(int dia) {
		calendario.set(Calendar.DAY_OF_WEEK, dia);
	}

	/**
	 * Retorna o dia do mes.
	 * 
	 * @return Dia do mes.
	 */
	public int getDiaDoMes() {
		return calendario.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * Muda o dia do mes para o passado como parametro.
	 * 
	 * @param diaDoMes
	 *            Novo dia do mes.
	 */
	public void setDiaDoMes(int diaDoMes) {
		calendario.set(Calendar.DAY_OF_MONTH, diaDoMes);
	}

	/**
	 * Retorna um numero que representa o mes.
	 * 
	 * @return Mes.
	 */
	public int getMes() {
		return calendario.get(Calendar.MONTH);
	}

	/**
	 * Muda o mes para o passado como parametro.
	 * 
	 * @param mes
	 *            Numero que representa o novo mes.
	 */
	public void setMes(int mes) {
		calendario.set(Calendar.MONTH, mes);
	}

	/**
	 * Retorna o ano.
	 * 
	 * @return Ano.
	 */
	public int getAno() {
		return calendario.get(Calendar.YEAR);
	}

	/**
	 * Muda o ano para o passado como parametro.
	 * 
	 * @param ano
	 *            Novo ano.
	 */
	public void setAno(int ano) {
		calendario.set(Calendar.YEAR, ano);
	}

	/**
	 * Retorna o calendario.
	 * 
	 * @return Calendario.
	 */
	public Calendar getCalendario() {
		return calendario;
	}

	/**
	 * Muda o calendario atual para o passado como parametro.
	 * 
	 * @param calendario
	 *            Novo calendario que sera usado.
	 */
	public void setCalendario(Calendar calendario) {
		this.calendario = calendario;
	}

	/**
	 * Retorna o numero de identificacao do paciente.
	 * 
	 * @return Numero de identificacao do paciente.
	 */
	public int getNumeroDeIdentificao() {
		return numeroDeIdentificao;
	}

	/**
	 * Retorna um boolean que indica se eh consulta de retorno ou nao.
	 * 
	 * @return Retorna true se eh retorno, false caso contrario.
	 */
	public boolean isRetorno() {
		return retorno;
	}

	/**
	 * Retorna um boolean que indica se eh primeira consulta ou nao.
	 * 
	 * @return Retorna true se eh primeira consulta, false caso contrario.
	 */
	public boolean isPrimeiraConsulta() {
		return primeiraConsulta;
	}

	/**
	 * Retorna uma string que representa o objeto
	 */
	public String toString() {
		return "Numero de indentificacao :" + this.getNumeroDeIdentificao()
				+ "\nDia : " + this.getDiaDoMes() + "\nMes: "
				+ (getMes() + AJUSTE_CALENDARIO);
	}

}
