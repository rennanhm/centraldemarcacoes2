package Secretaria;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import Medico.Especialidade;
import Medico.Medico;
import Paciente.HorarioDeAtendimento;
import Paciente.Paciente;
import PlanoDeSaude.PlanoDeSaude;

/**
 * Classe Secretaria usada para ter acesso a listas De Pacientes e de medicos te
 * todo hospital, Marcar conssulta/Cirurgia/Retorno, manipular lista de espera e
 * etc..
 * 
 * @author Grupo 7
 * 
 */
public class Secretaria {
	private List<Medico> listaDeMedico;
	private List<Paciente> listaDePaciente;
	private List<HorarioDeAtendimento> listaDeEspera;
	private List<PlanoDeSaude> listaDePlanoDeSaude;

	/**
	 * Constroi uma secretaria, a partir da lista de medico e da lista de
	 * paciente
	 * 
	 * @param listaDeMedico
	 *            Lista de medicos
	 * @param listaDePaciente
	 *            Lista de Paciente
	 */
	public Secretaria(List<Medico> listaDeMedico, List<Paciente> listaDePaciente) {
		this.listaDeMedico = listaDeMedico;
		this.listaDePaciente = listaDePaciente;
		this.listaDeEspera = new ArrayList<HorarioDeAtendimento>();
	}

	/**
	 * Cria um objeto secretaria a partir lista de medico, da lista de paciente
	 * e da lista de plano de saude
	 * 
	 * @param listaDeMedico
	 *            Lista de Medicos
	 * @param listaDePaciente
	 *            Lista de Pacientes
	 * @param listaDePlanoDeSaude
	 *            Lista de Plano de Saude
	 */
	public Secretaria(List<Medico> listaDeMedico,
			List<Paciente> listaDePaciente,
			List<PlanoDeSaude> listaDePlanoDeSaude) {
		this.listaDeMedico = listaDeMedico;
		this.listaDePaciente = listaDePaciente;
		this.listaDePlanoDeSaude = listaDePlanoDeSaude;
		this.listaDeEspera = new ArrayList<HorarioDeAtendimento>();
	}

	/**
	 * Retorna a lista de planos de saude
	 * 
	 * @return Lista de planos de saude
	 */
	public List<PlanoDeSaude> getListaDePlanoDeSaude() {
		return listaDePlanoDeSaude;
	}

	/**
	 * Muda a lista de planos de saude para a passada como parametro
	 * 
	 * @param novoPlano
	 *            Nova lista de plano de saude
	 */
	public void setListaDePlanoDeSaude(List<PlanoDeSaude> novoPlano) {
		listaDePlanoDeSaude = novoPlano;
	}

	/**
	 * Recupera a lista de paciente
	 * 
	 * @return Lista de paciente
	 */
	public List<Paciente> getListaDePaciente() {
		return listaDePaciente;
	}

	/**
	 * Recupera a lista de espera
	 * 
	 * @return Lista de espera
	 */
	public List<HorarioDeAtendimento> getListaDeEspera() {
		return listaDeEspera;
	}

	/**
	 * Recupera lista de medico
	 * 
	 * @return Lista de medico
	 */
	public List<Medico> getListaDeMedico() {
		return listaDeMedico;
	}

	/**
	 * Marca uma consulta passando um medico em especifico
	 * 
	 * @param medico
	 *            Medico que se deve marcar a consulta
	 * @return True caso seja marcado com sucesso, falso caso contrario
	 */
	public boolean marcarConsulta(Medico medico, Paciente paciente) {
		return medico.marcarConsulta(paciente.getHorarioDeAtendimento());
	}

	/**
	 * Marca uma consulta passando um medico especifico, o paciente e a data que
	 * se deseja marcar a consulta
	 * 
	 * @param medico
	 *            Medico que sera marcada as consultas
	 * @param paciente
	 *            Paciente a ser consultado pelo medico
	 * @param calendario
	 *            Dia em que sera marcada a consulta
	 * @return Um boolean que representa se foi possivel ou nao marcar a
	 *         consulta
	 */
	public boolean marcarConsulta(Medico medico, Paciente paciente,
			Calendar calendario) {
		return medico.marcarConsulta(paciente.getHorarioDeAtendimento(),
				calendario);
	}

	/**
	 * Marca uma consulta passando uma especialidade, eh procurado o medico que
	 * atende aquela especialidade e que tem o primeiro dia vago
	 * 
	 * @param especialidade
	 *            Especialidade da consulta
	 * @return True caso seja marcado com sucesso, falso caso contrario
	 */
	public boolean marcarConsultaPassandoEspecialidade(
			Especialidade especialidade, Paciente paciente) {
		return marcarConsulta(melhorMedicoComHorarioVago(especialidade),
				paciente);
	}

	/**
	 * Marca uma consulta com uma data limite
	 * 
	 * @param medico Medico 
	 * @param paciente Nome do paciente
	 * @param calendario
	 *            Data limite da marcacao da consulta
	 * @return True caso encontre alguma data ate a data limite, false caso
	 *         contrario
	 */
	public boolean marcarConsultaComDataLimite(Medico medico,
			Paciente paciente, Calendar calendario) {
		return medico.marcarConsultaComDataLimite(
				paciente.getHorarioDeAtendimento(), calendario);
	}

	/**
	 * Remarca as consultas que foram excluidas
	 * 
	 * @param medico
	 *            Medico que sera marcada as consultas
	 * @param calendario
	 *            Marcar uma consulta em um horario vago apartir dessa data
	 * @return True caso tenha remarcado todas as consultas com sucesso, false
	 *         caso contrario
	 */
	public boolean remacarConsulta(Medico medico, Calendar calendario) {
		List<HorarioDeAtendimento> pacientesDesmarcados = excluiTodasAsConsultasDoDia(
				medico, calendario);
		for (HorarioDeAtendimento horario : pacientesDesmarcados) {
			medico.marcarConsulta(horario, calendario);
		}
		return true;
	}

	/**
	 * Exclui as consultas de um determinado dia
	 * 
	 * @param medico
	 *            Medico que sera desmarcado as consultas
	 * @param calendario
	 *            Dia que deve ser excluida as consultas
	 * @return Consultas que foram excluidas
	 */
	public List<HorarioDeAtendimento> excluiTodasAsConsultasDoDia(
			Medico medico, Calendar calendario) {
		List<HorarioDeAtendimento> listaDePacientesDoDia = mostraHorariosDoDia(
				medico, calendario);
		medico.getListaDePacientes().removeAll(listaDePacientesDoDia);
		return listaDePacientesDoDia;
	}

	/**
	 * Adiciona horario em lista de espera
	 * 
	 * @param horario
	 *            informa numero de identificacao do paciente e se a consulta eh
	 *            de retorno ou primeira consulta
	 */
	public void listaDeEspera(HorarioDeAtendimento horario) {
		this.listaDeEspera.add(horario);
	}

	/**
	 * Exclui uma consulta de um determinado medico
	 * 
	 * @param medico
	 *            - O medico que vai ser removido a consulta
	 * @param horario
	 *            - Horario da consulta com informacoes do paciente
	 * @return - A consulta removida
	 */
	public HorarioDeAtendimento excluirConsulta(Medico medico,
			HorarioDeAtendimento horario) {
		return medico.excluirConsulta(horario);
	}

	/**
	 * Marca uma cirurgia para um medico especifico
	 * 
	 * @param medico
	 *            Medico que sera marcada a cirurgia
	 * @param paciente
	 *            Paciente que marcara a cirurgia com o medico.
	 * @return Um boolean que representa se foi possivel ou nao marcar a
	 *         cirurgia
	 */
	public boolean marcarCirurgia(Medico medico, Paciente paciente) {
		Especialidade especialidade = medico.getEspecialidade();

		List<Medico> listaDeMedicoPorEspecialidade = new ArrayList<Medico>();
		Iterator<Medico> id = this.getListaDeMedico().iterator();

		while (id.hasNext()) {
			Medico novoMedico = id.next();

			if (novoMedico.getEspecialidade().equals(especialidade)) {
				listaDeMedicoPorEspecialidade.add(novoMedico);
			}
		}

		Iterator<Medico> id2 = listaDeMedicoPorEspecialidade.iterator();

		HorarioDeAtendimento horarioLivreDoMedico = medico
				.proximoDiaLivreCirurgia(paciente.getHorarioDeAtendimento());

		while (id2.hasNext()) {
			Medico novoMedico = id2.next();
			if (!mesmaHoraCirurgia(novoMedico, horarioLivreDoMedico)) {
				return medico
						.marcarCirurgia(paciente.getHorarioDeAtendimento());
			} else {
				Calendar calendario = horarioLivreDoMedico.getCalendario();
				if ((calendario.get(Calendar.DAY_OF_MONTH) == calendario
						.getActualMaximum(Calendar.DAY_OF_MONTH))) {
					calendario.roll(Calendar.DAY_OF_MONTH, true);
					calendario.roll(Calendar.MONTH, true);
					horarioLivreDoMedico.setCalendario(calendario);
					paciente.setHorarioDeAtendimento(horarioLivreDoMedico);
					return marcarCirurgia(medico, paciente);
				} else {
					calendario.roll(Calendar.DAY_OF_MONTH, true);
					horarioLivreDoMedico.setCalendario(calendario);
					paciente.setHorarioDeAtendimento(horarioLivreDoMedico);
					return marcarCirurgia(medico, paciente);
				}
			}
		}
		return medico.marcarCirurgia(horarioLivreDoMedico);
	}

	/**
	 * Retorna o medico que tem o horario vago mais proximo a data atual
	 * 
	 * @param especialidade
	 *            Especialidade dos medicos que vao ter o horario verificado
	 * @return Medico com horario livre mais proximo da data atual
	 */
	public Medico melhorMedicoComHorarioVago(Especialidade especialidade) {
		Medico melhorMedico = new Medico();
		Medico medicoReferencia;

		List<Medico> listaDeMedicoPorEspecialidade = new ArrayList<Medico>();
		Iterator<Medico> id = this.getListaDeMedico().iterator();

		while (id.hasNext()) {
			Medico novoMedico = id.next();

			if (novoMedico.getEspecialidade().equals(especialidade)) {
				listaDeMedicoPorEspecialidade.add(novoMedico);
			}
		}
		if (!listaDeMedicoPorEspecialidade.isEmpty()) {
			medicoReferencia = listaDeMedicoPorEspecialidade.get(0);
			Iterator<Medico> it = listaDeMedicoPorEspecialidade.iterator();
			while (it.hasNext()) {
				Medico novoMedico = it.next();
				if (novoMedico.primeiroDiaLivre().compareTo(
						medicoReferencia.primeiroDiaLivre()) <= 0) {
					melhorMedico = novoMedico;
				}
			}
		}
		return melhorMedico;
	}

	/**
	 * Retorna a lista de medicos
	 * 
	 * @return Lista de Medicos
	 */
	public List<String> getListaDeMedicos() {
		List<String> medicos = new ArrayList<String>();
		Iterator<Medico> it = this.listaDeMedico.iterator();
	
		while (it.hasNext()) {
			Medico novoMedico = it.next();
			medicos.add(novoMedico.getNomeDoMedico());
		}
		return medicos;
	}

	private List<HorarioDeAtendimento> mostraHorariosDoDia(Medico medico,
			Calendar calendario) {
		List<HorarioDeAtendimento> listaDePacientesDoDia = new ArrayList<HorarioDeAtendimento>();

		Iterator<HorarioDeAtendimento> it = medico.getListaDePacientes()
				.iterator();

		while (it.hasNext()) {
			HorarioDeAtendimento novoHorario = it.next();

			if (novoHorario.getMes() == calendario.get(Calendar.MONTH)
					&& novoHorario.getDiaDoMes() == calendario
							.get(Calendar.DAY_OF_MONTH)) {
				listaDePacientesDoDia.add(novoHorario);
			}
		}
		return listaDePacientesDoDia;
	}

	private boolean mesmaHoraCirurgia(Medico medico,
			HorarioDeAtendimento horario) {
		List<HorarioDeAtendimento> diasDeCirurgia = medico
				.getListaDePacientesCirurgia();

		Iterator<HorarioDeAtendimento> id = diasDeCirurgia.iterator();

		while (id.hasNext()) {
			HorarioDeAtendimento novoHorario = id.next();
			if (novoHorario.getDiaDoMes() == horario.getDiaDoMes()
					&& novoHorario.getMes() == horario.getMes()) {
				return true;
			}
		}
		return false;
	}

}
