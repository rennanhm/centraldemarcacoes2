package Medico;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import Medico.DiaDeTrabalho;
import Paciente.HorarioDeAtendimento;

/**
 * Classe de Medico. Que tem a capacidade de criar o medico com seus horarios e
 * suas respectivas Especialidades.
 * 
 * @author Grupo 7
 * 
 */
public class Medico implements Serializable {
	
	private static final transient long serialVersionUID = 1L;
	private Agenda agenda;
	private String nomeDoMedico;
	private Especialidade especialidade;

	/**
	 * Construtor de um Medico Base para testes
	 */
	public Medico() {
	}

	/**
	 * Construtor de Medico.
	 * 
	 * @param nomeDoMedico
	 *            nome do medico.
	 * @param especialidade
	 *            Enum especilidade do medico.
	 * @param tempoPrimeiraConsulta
	 *            Estimativa do tempo da primeira conssulta em minutos.
	 * @param tempoConsultaRetorno
	 *            Estimativa do tempo de conssultas retorno em minutos.
	 * @throws Exception
	 */
	public Medico(String nomeDoMedico, Especialidade especialidade,
			int tempoPrimeiraConsulta, int tempoConsultaRetorno)
			throws Exception {
		verificaNome(nomeDoMedico);
		this.nomeDoMedico = nomeDoMedico;
		this.especialidade = especialidade;
		this.agenda = new Agenda(tempoPrimeiraConsulta, tempoConsultaRetorno);

	}

	/**
	 * Retorna a agenda do medico.
	 * 
	 * @return agenda.
	 */
	public Agenda getAgenda() {
		return agenda;
	}

	/**
	 * Acessa Lista com os Dias de Cirurgia do medico.
	 * 
	 * @return lista de dias de cirurgia
	 */
	public List<DiaDeTrabalho> getDiasDeCirurgia() {
		return this.getAgenda().getDiasDeCirurgia();
	}

	/**
	 * Adiciona um dia para Dias de Cirurgia do medico
	 * 
	 * @param diaDeTrabalho
	 *            Dia de plantao
	 */
	public void addDiasDeCirurgia(DiaDeTrabalho diaDeTrabalho) {
		this.getAgenda().addDiaDeCirurgia(diaDeTrabalho);
	}

	/**
	 * Acessa a lista de DiasDeExpediente.
	 * 
	 * @return lisda de DiasDeExpediente.
	 */
	public List<DiaDeTrabalho> getDiasDeExpediente() {
		return this.getAgenda().getDiasDeExpediente();
	}

	/**
	 * Adiciona um dia para Dias de Expediente do medico.
	 * 
	 * @param diaDeTrabalho
	 *            Dia de plantao que deve ser adicionado
	 */
	public void addDiasDeExpediente(DiaDeTrabalho diaDeTrabalho) {
		this.getAgenda().addDiasDeExpediente(diaDeTrabalho);
	}

	/**
	 * Deleta Dia de trabalho do medico no Expediente.
	 * 
	 * @param diaSemana
	 *            Enum equivalente ao dia da semana.
	 */
	public void delDiaDeExpediente(Semana diaSemana) {
		Iterator<DiaDeTrabalho> iteraExpediente = this.getAgenda()
				.getDiasDeExpediente().iterator();

		while (iteraExpediente.hasNext()) {
			DiaDeTrabalho proximoDia = iteraExpediente.next();
			if (proximoDia.getDiaSemana().equals(diaSemana)) {
				this.getAgenda().getDiasDeExpediente().remove(proximoDia);
				break;
			}
		}
	}

	/**
	 * Deleta Dia de trabalho do medico no Expediente.
	 * 
	 * @param diaSemana
	 *            Enum equivalente ao dia da semana.
	 */
	public void delDiaDeCirurgia(Semana diaSemana) {
		Iterator<DiaDeTrabalho> iteraCirurgia = this.getAgenda()
				.getDiasDeCirurgia().iterator();

		while (iteraCirurgia.hasNext()) {
			DiaDeTrabalho proximoDia = iteraCirurgia.next();
			if (proximoDia.getDiaSemana().equals(diaSemana)) {
				this.getAgenda().getDiasDeCirurgia().remove(proximoDia);
				break;
			}
		}
	}

	/**
	 * Acessa o tempo de uma primeira Consulta.
	 * 
	 * @return tempo de uma primeiro consulta em minutos.
	 */
	public int getTempoPrimeiraConsulta() {
		return this.getAgenda().getTempoPrimeiraConsulta();
	}

	/**
	 * Modifica o tempo de uma primeira Consulta.
	 * 
	 * @param tempoPrimeiraConsulta
	 *            tempo de uma primeira conssulta em minutos.
	 */
	public void setTempoPrimeiraConsulta(int tempoPrimeiraConsulta) {
		this.getAgenda().setTempoPrimeiraConsulta(tempoPrimeiraConsulta);
	}

	/**
	 * Acessa a lista de pacientes que marcaram consulta.
	 * 
	 * @return Lista de pacientes com consulta marcada.
	 */
	public List<HorarioDeAtendimento> getListaDePacientes() {
		return this.getAgenda().getListaPacientesConsulta();
	}

	/**
	 * Acessa a lista de pacientes que marcaram cirurgia
	 * 
	 * @return Lista de pacientes com cirurgia
	 */
	public List<HorarioDeAtendimento> getListaDePacientesCirurgia() {
		return this.getAgenda().getListaPacientesCirurgia();
		// TODO arrumar o nome
	}

	/**
	 * Acessa o tempo de uma consulta de retorno.
	 * 
	 * @return tempo medio de uma consulta de retorno em minutos.
	 */
	public int getTempoConsultaRetorno() {
		return this.getAgenda().getTempoConsultaRetorno();
	}

	/**
	 * Modifica tempo de uma consulta Retorno.
	 * 
	 * @param tempoConsultaRetorno
	 *            Tempo de uma consulta retorno em minutos.
	 */
	public void setTempoConsultaRetorno(int tempoConsultaRetorno) {
		this.getAgenda().setTempoConsultaRetorno(tempoConsultaRetorno);
	}

	/**
	 * Acessa o nome do medico.
	 * 
	 * @return nome do medico.
	 */
	public String getNomeDoMedico() {
		return nomeDoMedico;
	}

	/**
	 * Modifica nome do Medico.
	 * 
	 * @param nomeDoMedico
	 *            Nome do medico.
	 * @throws Exception
	 */
	public void setNomeDoMedico(String nomeDoMedico) throws Exception {
		verificaNome(nomeDoMedico);
		this.nomeDoMedico = nomeDoMedico;
	}

	/**
	 * Acessa a especialidade do medico.
	 * 
	 * @return Especialidade
	 */
	public Especialidade getEspecialidade() {
		return especialidade;
	}

	/**
	 * Modifica Especialidade do medico.
	 * 
	 * @param especialidade
	 */
	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	/**
	 * ToString
	 */
	@Override
	public String toString() {
		return "O nome do medico eh: " + this.getNomeDoMedico()
				+ "\nA especialidade: " + this.getEspecialidade()
				+ imprimirHorarios()
				+ "\nO tempo que demora na primeira consulta eh: "
				+ this.getTempoPrimeiraConsulta() + " minutos"
				+ "\nO tempo que demora na consulta de retorno eh: "
				+ this.getTempoConsultaRetorno() + " minutos" + "\n\n"
				+ this.agendaMedico();
	}

	/**
	 * Imprime a agenda do medico
	 */
	public String agendaMedico() {
		return this.agenda.toString();
	}

	/**
	 * Marca consulta, procura o primeiro dia vago para marcar uma consulta
	 * 
	 * @param horario
	 *            informa numero de identificacao do paciente e se a consulta eh
	 *            de retorno ou primeira consulta
	 * @return True caso a consulta seja marcada com sucesso, falso caso
	 *         contrario
	 */
	public boolean marcarConsulta(HorarioDeAtendimento horario) {
		return this.getAgenda().marcarConsulta(horario);
	}

	/**
	 * Marca cirurgia, procura o primeiro dia vago para marcar uma cirurgia
	 * 
	 * @param horario
	 *            - informa numero de identificacao do paciente e sobre a
	 *            cirurgia
	 * @return Retorna agenda
	 */
	public boolean marcarCirurgia(HorarioDeAtendimento horario) {
		return this.getAgenda().marcarCirurgia(horario);
	}

	/**
	 * Informar qual o primeiro dia vago do medico
	 * 
	 * @return Calendar com o primeiro dia vago do medico
	 */
	public Calendar primeiroDiaLivre() {
		return this.getAgenda().primeiroDiaVago(new HorarioDeAtendimento());
	}

	/**
	 * Marca consulta, marca uma consulta apartir de uma data. Eh procurado uma
	 * vaga apartir da data passada
	 * 
	 * @param horario
	 *            informa numero de identificacao do paciente e se a consulta eh
	 *            de retorno ou primeira consulta
	 * @param calendario
	 *            Marcar uma consulta em um horario vago apartir dessa data
	 * @return True caso tenha marcado com sucesso, falso caso contrario
	 */
	public boolean marcarConsulta(HorarioDeAtendimento horario,
			Calendar calendario) {
		return this.getAgenda().marcarConsulta(horario, calendario);
	}

	/**
	 * Marca uma consulta com uma data limite
	 * 
	 * @param horario
	 *            informa numero de identificacao do paciente e se a consulta eh
	 *            de retorno ou primeira consulta
	 * @param calendario
	 *            Data limite da marcacao da consulta
	 * @return True caso encontre alguma data ate a data limite, false caso
	 *         contrario
	 */
	public boolean marcarConsultaComDataLimite(HorarioDeAtendimento horario,
			Calendar calendario) {
		return this.getAgenda()
				.marcarConsultaComDataLimite(horario, calendario);
	}

	/**
	 * Exclui uma consulta a partir do horario
	 * 
	 * @param horario
	 *            - Horario com as informacoes do paciente
	 * @return - Retorna a consulta removida
	 */
	public HorarioDeAtendimento excluirConsulta(HorarioDeAtendimento horario) {
		return this.getAgenda().excluirConsulta(horario);
	}

	/**
	 * Verifica o proximo dia de cirurgia que sera livre
	 * @param horario Horario com as informacoes do paciente
	 * @return Retorna o dia que sera livre para marcar cirurgia
	 */
	public HorarioDeAtendimento proximoDiaLivreCirurgia(
			HorarioDeAtendimento horario) {
		return this.getAgenda().proximoDiaLivreCirurgia(horario);
	}

	/**
	 * Exclui uma cirurgia a partir do horario
	 * 
	 * @param horario
	 *            - Horario com as informacoes do pacientes
	 * @return - Retorna a cirurgia removida
	 */
	public HorarioDeAtendimento excluirCirurgia(HorarioDeAtendimento horario) {
		return this.getAgenda().excluirCirurgia(horario);
	}

	
	private String imprimirHorarios() {
		String diasDeTralhoMedico = "";

		if (!this.getAgenda().getDiasDeCirurgia().isEmpty()
				|| !!this.getAgenda().getDiasDeExpediente().isEmpty()) {

			if (!this.getAgenda().getDiasDeCirurgia().isEmpty()) {
				diasDeTralhoMedico += "\nIntervencoes Cirurgicas: ";
				for (int i = 0; i < this.getAgenda().getDiasDeCirurgia().size(); i++) {
					diasDeTralhoMedico += this.getAgenda().getDiasDeCirurgia()
							.get(i).getDiaSemana()
							+ " - "
							+ this.getAgenda().getDiasDeCirurgia().get(i)
									.getEntrou()
							+ " as "
							+ this.getAgenda().getDiasDeCirurgia().get(i)
									.getSaiu();
				}
			}
		}

		if (!this.getAgenda().getDiasDeExpediente().isEmpty()) {
			diasDeTralhoMedico += "\nDias de Atendimentos: ";
			for (int i = 0; i < this.getAgenda().getDiasDeExpediente().size(); i++) {
				diasDeTralhoMedico += this.getAgenda().getDiasDeExpediente()
						.get(i).getDiaSemana()
						+ " - "
						+ this.getAgenda().getDiasDeExpediente().get(i)
								.getEntrou()
						+ " as "
						+ this.getAgenda().getDiasDeExpediente().get(i)
								.getSaiu();
			}
		}

		return diasDeTralhoMedico;
	}

	private void verificaNome(String nome) throws Exception {
		if (nome.trim().length() == 0) {
			throw new Exception("Nome nao pode ser vazio");
		}
		for (int i = 0; i < nome.length(); i++) {
			if (Character.isDigit(nome.charAt(i)) == true) {
				throw new Exception("Nome nao pode conter numeros");
			}
		}
	}

}
