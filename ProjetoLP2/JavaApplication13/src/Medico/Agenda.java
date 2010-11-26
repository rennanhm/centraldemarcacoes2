package Medico;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import Paciente.HorarioDeAtendimento;

/**
 * Classe Agente referente a agenda de um medico que tem a capassidade de pegar
 * listas de Espedientes/Cirurgias, Marcar Conssultas/Retornos/Cirurgia,
 * Excluir, tempos medios de primeiraConssulta e Retorno.
 * 
 * @author Grupo 7
 * 
 */

public class Agenda {
	
	private List<DiaDeTrabalho> diasDeExpediente;
	private List<DiaDeTrabalho> diasDeCirurgia;
	private List<HorarioDeAtendimento> listaPacientes, listaPacientesCirurgia;
	private int tempoPrimeiraConsulta;
	private int tempoConsultaRetorno;

	/**
	 * Constroi uma agenda, passando tempo da primeira consulta e da consulta de
	 * retorno
	 * 
	 * @param tempoPrimeiraConsulta
	 *            Tempo da primeira consulta
	 * @param tempoConsultaRetorno
	 *            Tempo da consulta de retorno
	 */
	public Agenda(int tempoPrimeiraConsulta, int tempoConsultaRetorno) {
		this.tempoPrimeiraConsulta = tempoPrimeiraConsulta;
		this.tempoConsultaRetorno = tempoConsultaRetorno;
		this.diasDeCirurgia = new ArrayList<DiaDeTrabalho>();
		this.diasDeExpediente = new ArrayList<DiaDeTrabalho>();
		this.listaPacientes = new ArrayList<HorarioDeAtendimento>();
		this.listaPacientesCirurgia = new ArrayList<HorarioDeAtendimento>();
	}

	/**
	 * Adiciona um dia para Dias de Cirurgia do medico
	 * 
	 * @param dia
	 *            Dia de plantao
	 */
	public void addDiaDeCirurgia(DiaDeTrabalho dia) {
		diasDeCirurgia.add(dia);
	}

	/**
	 * Acessa Lista com os Dias de Cirurgia do medico.
	 * 
	 * @return lista de dias de cirurgia
	 */
	public List<DiaDeTrabalho> getDiasDeCirurgia() {
		return diasDeCirurgia;
	}

	/**
	 * Acessa a lista de DiasDeExpediente.
	 * 
	 * @return lista de DiasDeExpediente.
	 */
	public List<DiaDeTrabalho> getDiasDeExpediente() {
		return diasDeExpediente;
	}

	/**
	 * Adiciona um dia para Dias de Expediente do medico.
	 * 
	 * @param diaDeTrabalho
	 *            Dia de plantao que deve ser adicionado
	 */
	public void addDiasDeExpediente(DiaDeTrabalho diaDeTrabalho) {
		this.diasDeExpediente.add(diaDeTrabalho);
	}

	/**
	 * Acessa o tempo de uma primeira Consulta.
	 * 
	 * @return tempo de uma primeiro consulta em minutos.
	 */
	public int getTempoPrimeiraConsulta() {
		return tempoPrimeiraConsulta;
	}

	/**
	 * Modifica o tempo de uma primeira Consulta.
	 * 
	 * @param tempoPrimeiraConsulta
	 *            tempo de uma primeira consulta em minutos.
	 */
	public void setTempoPrimeiraConsulta(int tempoPrimeiraConsulta) {
		this.tempoPrimeiraConsulta = tempoPrimeiraConsulta;
	}

	/**
	 * Acessa o tempo de uma consulta de retorno.
	 * 
	 * @return tempo medio de uma consulta de retorno em minutos.
	 */
	public int getTempoConsultaRetorno() {
		return tempoConsultaRetorno;
	}

	/**
	 * Modifica tempo de uma consulta Retorno.
	 * 
	 * @param tempoConsultaRetorno
	 *            Tempo de uma consulta retorno em minutos.
	 */
	public void setTempoConsultaRetorno(int tempoConsultaRetorno) {
		this.tempoConsultaRetorno = tempoConsultaRetorno;
	}

	/**
	 * Acessa a lista de pacientes que marcaram consultas.
	 * 
	 * @return Lista de pacientes
	 */
	public List<HorarioDeAtendimento> getListaPacientesConsulta() {
		return listaPacientes;
	}

	/**
	 * Marca consulta, procura o primeiro dia vago para marcar uma consulta
	 * 
	 * @param horario
	 *            informa numero de identificacao do paciente e se a consulta eh
	 *            de retorno ou primeira consulta
	 * @return True caso a consulta seja marcada com sucesso
	 */
	public boolean marcarConsulta(HorarioDeAtendimento horario) {
		return listaPacientes.add(proximoDiaLivreConsulta(horario));
	}

	/**
	 * Verifica qual o proximo dia livre para marcar uma consulta
	 * 
	 * @param horario
	 *            Informa numero de identificacao do paciente e se a consulta eh
	 *            de retorno ou primeira consulta
	 * @return O horario que sera livre para marcar a consulta
	 */
	public HorarioDeAtendimento proximoDiaLivreConsulta(
			HorarioDeAtendimento horario) {
		int dia = horario.getDiaDoMes();
		int diaDaSemana = horario.getDiaDaSemana();
		int mes = horario.getMes();
		int ano = horario.getAno();
		if (estaAtendendoHoje(diaDaSemana)
				&& !horarioDoDiaEstaCompleto(dia, mes, ano)) {
			horario.setDiaDoMes(dia);
			horario.setAno(ano);
			horario.setMes(mes);
			return horario;
		} else {
			Calendar calendario = horario.getCalendario();
			if ((calendario.get(Calendar.DAY_OF_MONTH) == calendario
					.getActualMaximum(Calendar.DAY_OF_MONTH))) {
				calendario.roll(Calendar.DAY_OF_MONTH, true);
				calendario.roll(Calendar.MONTH, true);
				horario.setCalendario(calendario);
				proximoDiaLivreConsulta(horario);
			} else {
				calendario.roll(Calendar.DAY_OF_MONTH, true);
				horario.setCalendario(calendario);
				proximoDiaLivreConsulta(horario);
			}
		}
		return horario;
	}

	/**
	 * Marca uma cirurgia no primeiro horario vago do medico
	 * 
	 * @param horario
	 *            informa numero de identificacao do paciente
	 * @return True caso tenha marcado com sucesso.
	 */
	public boolean marcarCirurgia(HorarioDeAtendimento horario) {
		return listaPacientesCirurgia.add(proximoDiaLivreCirurgia(horario));
	}

	/**
	 * Verifica qual o proximo dia livre para marcar a cirurgia
	 * 
	 * @param horario
	 *            Informa numero de identificacao do paciente e se a consulta eh
	 *            de retorno ou primeira consulta
	 * @return O horario livre para marcar a cirurgia
	 */
	public HorarioDeAtendimento proximoDiaLivreCirurgia(
			HorarioDeAtendimento horario) {
		int dia = horario.getDiaDoMes();
		int diaDaSemana = horario.getDiaDaSemana();
		int mes = horario.getMes();
		int ano = horario.getAno();
		if (estaEmCirurgia(diaDaSemana)
				&& cirurgiaMarcadaParaHoje(dia, mes, ano)) {
			horario.setDiaDoMes(dia);
			horario.setAno(ano);
			horario.setMes(mes);
			return horario;
		} else {
			Calendar calendario = horario.getCalendario();
			if ((calendario.get(Calendar.DAY_OF_MONTH) == calendario
					.getActualMaximum(Calendar.DAY_OF_MONTH))) {
				calendario.roll(Calendar.DAY_OF_MONTH, true);
				calendario.roll(Calendar.MONTH, true);
				horario.setCalendario(calendario);
				proximoDiaLivreCirurgia(horario);
			} else {
				calendario.roll(Calendar.DAY_OF_MONTH, true);
				horario.setCalendario(calendario);
				proximoDiaLivreCirurgia(horario);
			}
		}
		return horario;
	}

	/**
	 * Acessa a lista de pacientes que marcaram cirurgia.
	 * 
	 * @return Lista de pacientes para cirurgia.
	 */
	public List<HorarioDeAtendimento> getListaPacientesCirurgia() {
		return listaPacientesCirurgia;
	}

	/**
	 * Informar qual o primeiro dia vago do medico
	 * 
	 * @param horario
	 *            informa numero de identificacao do paciente e se a consulta eh
	 *            de retorno ou primeira consulta
	 * @return Calendar com o primeiro dia vago do medico
	 */
	public Calendar primeiroDiaVago(HorarioDeAtendimento horario) {
		int dia = horario.getDiaDoMes();
		int diaDaSemana = horario.getDiaDaSemana();
		int mes = horario.getMes();
		int ano = horario.getAno();
		if (estaAtendendoHoje(diaDaSemana)
				&& !horarioDoDiaEstaCompleto(dia, mes, ano)) {
			horario.setDiaDoMes(dia - 1);
			horario.setAno(ano);
			horario.setMes(mes);
			return horario.getCalendario();
		} else {
			Calendar calendario = horario.getCalendario();
			calendario.roll(Calendar.DAY_OF_MONTH, true);
			horario.setCalendario(calendario);
			return primeiroDiaVago(horario);
		}
	}

	/***
	 * Marca consulta, marca uma consulta apartir de uma data. Eh procurado uma
	 * vaga apartir da data passada
	 * 
	 * @param horario
	 *            informa numero de identificacao do paciente e se a consulta eh
	 *            de retorno ou primeira consulta
	 * @param calendarioNovo
	 *            Marcar uma consulta em um horario vago apartir dessa data
	 * @return True caso tenha marcado com sucesso.
	 */
	public boolean marcarConsulta(HorarioDeAtendimento horario,
			Calendar calendarioNovo) {
		horario.setCalendario(calendarioNovo);
		int dia = horario.getDiaDoMes();
		int diaDaSemana = horario.getDiaDaSemana();
		int mes = horario.getMes();
		int ano = horario.getAno();
		if (estaAtendendoHoje(diaDaSemana)
				&& !horarioDoDiaEstaCompleto(dia, mes, ano)) {
			horario.setDiaDoMes(dia - 1);
			horario.setAno(ano);
			horario.setMes(mes);
			listaPacientes.add(horario);
			return true;
		} else {
			Calendar calendario = horario.getCalendario();
			calendario.roll(Calendar.DAY_OF_MONTH, true);
			horario.setCalendario(calendario);
			marcarConsulta(horario);
			return true;
		}
	}

	/**
	 * Marca uma consulta com uma data limite
	 * 
	 * @param horario
	 *            informa numero de identificacao do paciente e se a consulta eh
	 *            de retorno ou primeira consulta
	 * @param calendarioNovo
	 *            Data limite da marcacao da consulta
	 * @return True caso encontre alguma data ate a data limite, false caso
	 *         constrario
	 */
	public boolean marcarConsultaComDataLimite(HorarioDeAtendimento horario,
			Calendar calendarioNovo) {
		if (horario.getDiaDoMes() == calendarioNovo.get(Calendar.DAY_OF_MONTH)
				&& horario.getMes() == calendarioNovo.get(Calendar.MONTH)) {
			return false;
		}

		int dia = horario.getDiaDoMes();
		int diaDaSemana = horario.getDiaDaSemana();
		int mes = horario.getMes();
		int ano = horario.getAno();
		if (estaAtendendoHoje(diaDaSemana)
				&& !horarioDoDiaEstaCompleto(dia, mes, ano)) {
			horario.setDiaDoMes(dia - 1);
			horario.setAno(ano);
			horario.setMes(mes);
			listaPacientes.add(horario);
			return true;
		} else {
			Calendar calendario = horario.getCalendario();
			if ((calendario.get(Calendar.DAY_OF_MONTH) == calendario
					.getActualMaximum(Calendar.DAY_OF_MONTH))) {
				calendario.roll(Calendar.DAY_OF_MONTH, true);
				calendario.roll(Calendar.MONTH, true);
				horario.setCalendario(calendario);
				return marcarConsultaComDataLimite(horario, calendarioNovo);
			} else {
				calendario.roll(Calendar.DAY_OF_MONTH, true);
				horario.setCalendario(calendario);
				return marcarConsultaComDataLimite(horario, calendarioNovo);
			}
		}
	}

	/**
	 * Verifica se tem alguma cirurgia marcada para o dia passado como parametro
	 * 
	 * @param diaDoMes
	 *            O dia
	 * @param mes
	 *            O mes
	 * @param ano
	 *            O ano
	 * @return Um boolean que representa se a cirurgia esta ou nao marcada
	 */
	public boolean cirurgiaMarcadaParaHoje(int diaDoMes, int mes, int ano) {
		Iterator<HorarioDeAtendimento> iteraHorarios = this
				.getListaPacientesCirurgia().iterator();

		while (iteraHorarios.hasNext()) {
			HorarioDeAtendimento proximoCliente = iteraHorarios.next();
			if (proximoCliente.getMes() == mes
					&& proximoCliente.getDiaDoMes() + 1 == diaDoMes) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Exclui uma consulta
	 * 
	 * @param horario
	 *            - Horario da consulta
	 * @return - Retorna a consulta removida
	 */
	public HorarioDeAtendimento excluirConsulta(HorarioDeAtendimento horario) {
		HorarioDeAtendimento horarioExcluido = null;
		Iterator<HorarioDeAtendimento> it = this.getListaPacientesConsulta()
				.iterator();

		while (it.hasNext()) {
			horarioExcluido = it.next();
			if (horarioExcluido.getNumeroDeIdentificao() == horario
					.getNumeroDeIdentificao() && listaPacientes.remove(horario)) {
				return horarioExcluido;
			}

		}
		return horarioExcluido;
	}

	/**
	 * Exclui uma cirurgia
	 * 
	 * @param horario
	 *            - Horario da cirurgia
	 * @return - Retorna a cirurgia removida
	 */
	public HorarioDeAtendimento excluirCirurgia(HorarioDeAtendimento horario) {
		HorarioDeAtendimento horarioExcluido = null;
		Iterator<HorarioDeAtendimento> it = this.getListaPacientesCirurgia()
				.iterator();

		while (it.hasNext()) {
			horarioExcluido = it.next();
			if (horarioExcluido.getNumeroDeIdentificao() == horario
					.getNumeroDeIdentificao()) {
				listaPacientesCirurgia.remove(horario);
				return horarioExcluido;
			}

		}
		return horarioExcluido;
	}

	/**
	 * To String da agenda
	 */
	public String toString() {
		String string = "";

		if (!listaPacientes.isEmpty()) {
			Iterator<HorarioDeAtendimento> it = listaPacientes.iterator();
			string += "Pacientes agendados para atendimento\n";
			while (it.hasNext()) {
				HorarioDeAtendimento novoHorario = it.next();
				string += novoHorario.toString() + "\n";
			}

		}

		if (!listaPacientesCirurgia.isEmpty()) {
			Iterator<HorarioDeAtendimento> it2 = listaPacientesCirurgia
					.iterator();
			string += "\nPacientes agendados para cirurgia\n";
			while (it2.hasNext()) {
				HorarioDeAtendimento novoHorario = it2.next();
				string += novoHorario.toString() + "\n";
			}
		}

		return string;
	}

	private boolean estaAtendendoHoje(int diaDaSemana) {
		Iterator<DiaDeTrabalho> iteraDiaDeTrabalho = this.getDiasDeExpediente()
				.iterator();
		while (iteraDiaDeTrabalho.hasNext()) {
			DiaDeTrabalho proximoDia = iteraDiaDeTrabalho.next();
			if (proximoDia.getDiaSemana().getPosicaoNaSemana() == diaDaSemana - 1) {
				return true;
			}
		}
		return false;

	}

	private boolean horarioDoDiaEstaCompleto(int diaDoMes, int mes, int ano) {
		Iterator<HorarioDeAtendimento> iteraHorarios = listaPacientes
				.iterator();
		int tempoTotalDeConsultasPorDias = 0;
		int entrou = 0;
		int saiu = 0;

		while (iteraHorarios.hasNext()) {
			HorarioDeAtendimento proximoCliente = iteraHorarios.next();
			if (proximoCliente.getMes() == mes
					&& proximoCliente.getDiaDoMes() == diaDoMes) {
				tempoTotalDeConsultasPorDias += tempoDaConsulta(proximoCliente);
			}
		}

		Iterator<DiaDeTrabalho> iteraSemana = this.getDiasDeExpediente()
				.iterator();

		while (iteraSemana.hasNext()) {
			DiaDeTrabalho proximaSemana = iteraSemana.next();
			entrou = transformaHoraEmMinutos(proximaSemana.getEntrou());
			saiu = transformaHoraEmMinutos(proximaSemana.getSaiu());
		}
		double mediaTotal = saiu - entrou;
		if (tempoTotalDeConsultasPorDias < mediaTotal) {
			return false;
		}
		return true;
	}

	private int tempoDaConsulta(HorarioDeAtendimento horario) {
		if (horario.isPrimeiraConsulta()) {
			return this.getTempoPrimeiraConsulta();
		}
		return this.getTempoConsultaRetorno();
	}

	private int transformaHoraEmMinutos(String hora) {
		String[] horaMedico = hora.split(":");
		return Integer.parseInt(horaMedico[0]) * 60
				+ Integer.parseInt(horaMedico[1]);

	}

	private boolean estaEmCirurgia(int diaDaSemana) {
		Iterator<DiaDeTrabalho> iteraDiasDeCirurgia = this.getDiasDeCirurgia()
				.iterator();
		while (iteraDiasDeCirurgia.hasNext()) {
			DiaDeTrabalho proximoDia = iteraDiasDeCirurgia.next();
			if (proximoDia.getDiaSemana().getPosicaoNaSemana() == diaDaSemana - 1) {
				return true;
			}

		}
		return false;
	}
}