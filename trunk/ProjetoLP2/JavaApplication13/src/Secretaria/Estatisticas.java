package Secretaria;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import persistencia.GravaLerMedico;
import Medico.Especialidade;
import Medico.Medico;
import Paciente.HorarioDeAtendimento;

/**
 * 
 * @author Grupo 7 <3
 * 
 */
/*
 * * Quantas primeiras consultas e cirurgias foram realizadas em um determinado
 * mes, Sendo esse valor organizado por medico e por especialidade. Estas
 * estatisticas podem ser apresentadas na forma de uma tabela. Se nenhum mes e
 * nenhum ano forem passados como parametro, o mes corrente e o ano corrente
 * devem ser considerados.
 */

public class Estatisticas {
	public static List<Medico> listaDeMedico;
	public List<String> listaEstatisticas;

	public Estatisticas(List<Medico> listaDeMedico) {
		this.listaEstatisticas = new ArrayList();
		this.listaDeMedico = listaDeMedico;
	}

	/**
	 * Estatisticas de Primeira Conssulta por Especialidade na data atual;
	 * 
	 * @param especialidade
	 */
	public void estatiscasPrimeiraConsulta(Especialidade especialidade) {
		listaEstatisticas.clear();
		Calendar calendario = new GregorianCalendar();
		Iterator<Medico> iteraMedico = listaDeMedico.iterator();
		int cont = 0;
		while (iteraMedico.hasNext()) {
			Medico proximoMedico = iteraMedico.next();
			System.out.println(proximoMedico.getEspecialidade());
			if (proximoMedico.getEspecialidade().equals(especialidade)) {
				System.out.println("entrou");
				Iterator<HorarioDeAtendimento> iteraPaciente = proximoMedico
						.getAgenda().getListaPacientesConsulta().iterator();
				System.out.println(iteraPaciente.hasNext());
				while (iteraPaciente.hasNext()) {
					HorarioDeAtendimento proximoPaciente = iteraPaciente.next();
					if (proximoPaciente.isPrimeiraConsulta()) {
						if (proximoPaciente.getAno() == calendario
								.get(Calendar.YEAR)
								&& proximoPaciente.getMes() == calendario
										.get(Calendar.MONTH)) {
							cont += 1;
						}
					}
				}

			}

		}
		if (cont > 0) {
			listaEstatisticas.add("Especialidade: " + especialidade.toString()
					+ " " + cont + " " + " Consultas No mes atual");
		} else {
			listaEstatisticas.add("Especialidade: " + especialidade.toString()
					+ " " + "Nao teve nenhuma consulta esse mes");
		}

	}

	public static List<Medico> getListaDeMedico() {
		return listaDeMedico;
	}

	public List<String> getListaEstatisticas() {
		return listaEstatisticas;
	}

	/**
	 * Estatisticas de Primeira Conssulta por medico e data;
	 * 
	 * @param medico
	 *            objeto medico;
	 * @param mes
	 *            mes para a consulta;
	 * @param ano
	 *            ano da consulta da estatistica;
	 */
	public void estatiscasPrimeiraConsulta(Medico medico, int mes, int ano) {
		listaEstatisticas.clear();
		Iterator<Medico> iteraMedico = listaDeMedico.iterator();
		int cont = 0;
		while (iteraMedico.hasNext()) {
			Medico proximoMedico = iteraMedico.next();
			if (proximoMedico.equals(medico)) {
				Iterator<HorarioDeAtendimento> iteraPaciente = proximoMedico
						.getAgenda().getListaPacientesConsulta().iterator();
				while (iteraPaciente.hasNext()) {
					HorarioDeAtendimento proximoPaciente = iteraPaciente.next();
					if (proximoPaciente.isPrimeiraConsulta()) {
						if (proximoPaciente.getAno() == ano
								&& proximoPaciente.getMes() == mes - 1) {
							cont += 1;
						}
					}
				}
			}
		}
		if (cont > 0) {
			listaEstatisticas.add("Medico: " + medico.getNomeDoMedico() + " "
					+ cont + " " + "Consultas No mes/ano: " + mes + "/" + ano);
		} else {
			listaEstatisticas.add("Medico: " + medico.getNomeDoMedico()
					+ " Nao possui " + "Consultas No mes/ano: " + mes + "/"
					+ ano);
		}

	}

	/**
	 * Estatisticas de primeira conssulta por especialidade e data;
	 * 
	 * @param especialidade
	 * @param mes
	 * @param ano
	 */

	public void estatiscasPrimeiraConsulta(Especialidade especialidade,
			int mes, int ano) {
		listaEstatisticas.clear();
		Iterator<Medico> iteraMedico = listaDeMedico.iterator();
		int cont = 0;
		while (iteraMedico.hasNext()) {
			Medico proximoMedico = iteraMedico.next();
			if (proximoMedico.getEspecialidade().equals(especialidade)) {
				Iterator<HorarioDeAtendimento> iteraPaciente = proximoMedico
						.getAgenda().getListaPacientesConsulta().iterator();
				while (iteraPaciente.hasNext()) {
					HorarioDeAtendimento proximoPaciente = iteraPaciente.next();
					if (proximoPaciente.isPrimeiraConsulta()) {
						System.out.println(proximoPaciente.getAno() == ano);
						System.out.println(proximoPaciente.getMes() == mes - 1);
						if (proximoPaciente.getAno() == ano
								&& proximoPaciente.getMes() == mes - 1) {
							cont += 1;
						}
					}
				}
			}
		}
		if (cont > 0) {
			listaEstatisticas.add("Especialidade: " + especialidade.toString()
					+ " " + cont + " " + "Consultas No mes/ano: " + mes + "/"
					+ ano);
		} else {
			listaEstatisticas.add("Especialidade: " + especialidade.toString()
					+ " " + "Nao possui " + "Consultas No mes/ano: " + mes
					+ "/" + ano);
		}

	}

	/**
	 * Estatiscas de Cirurgia apartir de uma especialidade;
	 * 
	 * @param especialidade
	 */
	public void estatiscasCirurgia(Especialidade especialidade) {
		listaEstatisticas.clear();
		Calendar calendario = new GregorianCalendar();
		Iterator<Medico> iteraMedico = listaDeMedico.iterator();
		int cont = 0;
		while (iteraMedico.hasNext()) {
			Medico proximoMedico = iteraMedico.next();
			if (proximoMedico.getEspecialidade().equals(especialidade)) {
				Iterator<HorarioDeAtendimento> iteraPaciente = proximoMedico
						.getAgenda().getListaPacientesCirurgia().iterator();
				while (iteraPaciente.hasNext()) {
					HorarioDeAtendimento proximoPaciente = iteraPaciente.next();
					if (!proximoPaciente.isPrimeiraConsulta()
							&& !proximoPaciente.isRetorno()) {
						if (proximoPaciente.getAno() == calendario
								.get(Calendar.YEAR)
								&& proximoPaciente.getMes() == calendario
										.get(Calendar.MONTH)) {
							cont += 1;
						}
					}
				}

			}

		}
		if (cont > 0) {
			listaEstatisticas.add("Especialidade: " + especialidade.toString()
					+ " " + cont + " " + " Cirurgia No mes atual");
		} else {
			listaEstatisticas.add("Especialidade: " + especialidade.toString()
					+ " " + "Nao teve nenhuma cirurgia esse mes");
		}
	}

	/**
	 * Estatiscas de Cirurgia a partir de um medico e de uma data especifica;
	 * 
	 * @param medico
	 * @param mes
	 * @param ano
	 */
	public void estatiscasCirurgia(Medico medico, int mes, int ano) {
		listaEstatisticas.clear();
		Iterator<Medico> iteraMedico = listaDeMedico.iterator();
		int cont = 0;
		while (iteraMedico.hasNext()) {
			Medico proximoMedico = iteraMedico.next();
			if (proximoMedico.equals(medico)) {
				Iterator<HorarioDeAtendimento> iteraPaciente = proximoMedico
						.getAgenda().getListaPacientesCirurgia().iterator();
				while (iteraPaciente.hasNext()) {
					HorarioDeAtendimento proximoPaciente = iteraPaciente.next();
					if (!proximoPaciente.isPrimeiraConsulta()
							&& !proximoPaciente.isRetorno()) {
						if (proximoPaciente.getAno() == ano
								&& proximoPaciente.getMes() == mes - 1) {
							cont += 1;
						}
					}
				}
			}
		}
		if (cont > 0) {
			listaEstatisticas
					.add("Medico: " + medico.getNomeDoMedico() + " " + cont
							+ " " + "Cirurgia(s) No mes/ano: " + mes + "/"
							+ ano);
		} else {
			listaEstatisticas.add("Medico: " + medico.getNomeDoMedico() + " "
					+ "nao possui Cirurgia No mes/ano: " + mes + "/" + ano);
		}

	}

	/**
	 * Estatiscas de Cirurgia a partir de uma especialidade e de uma data
	 * especifica;
	 * 
	 * @param especialidade
	 * @param mes
	 * @param ano
	 */
	public void estatiscasCirurgia(Especialidade especialidade, int mes, int ano) {
		listaEstatisticas.clear();
		Iterator<Medico> iteraMedico = listaDeMedico.iterator();
		int cont = 0;
		while (iteraMedico.hasNext()) {
			Medico proximoMedico = iteraMedico.next();
			if (proximoMedico.getEspecialidade().equals(especialidade)) {
				Iterator<HorarioDeAtendimento> iteraPaciente = proximoMedico
						.getAgenda().getListaPacientesCirurgia().iterator();
				while (iteraPaciente.hasNext()) {
					HorarioDeAtendimento proximoPaciente = iteraPaciente.next();
					if (!proximoPaciente.isPrimeiraConsulta()
							&& proximoPaciente.isRetorno()) {
						if (proximoPaciente.getAno() == ano
								&& proximoPaciente.getMes() == mes - 1) {
							cont += 1;
						}
					}
				}
			}
		}
		if (cont > 0) {
			listaEstatisticas.add("Especialidade: " + especialidade.toString()
					+ " " + cont + " " + "Cirurgias No mes/ano: " + mes + "/"
					+ ano);
		} else {
			listaEstatisticas.add("Especialidade: " + especialidade.toString()
					+ " " + "Cirurgias No mes/ano: " + mes + "/" + ano);
		}

	}

}
