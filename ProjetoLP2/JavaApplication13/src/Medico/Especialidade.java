package Medico;

import java.io.Serializable;

/**
 * Valores possiveis para Especialidade, usado no construtor de medico para indicar sua respectiva Especialidade. 
 * 
 * @author Grupo 7
 *
 */
public enum Especialidade implements Serializable {

	
	
	JOELHO(10), QUADRIL(20), TORNOZELO(25), OMBRO(30), PUNHO(40);
	
	private static final transient  long serialVersionUID = 1L;
	private double valorDaConsulta;

	
	
	private Especialidade(double valorDaConsulta){
		this.valorDaConsulta = valorDaConsulta;
	}
	/**
	 * Acessa o valor da consulta.
	 * @return valorDaConsulta valor da consulta.
	 */
	public double getValorDaConsulta() {
		return valorDaConsulta;
	}

	/**
	 * Modifica o valor da consulta.
	 * @param valorDaConsulta Valor da consulta. 
	 */
	public void setValorDaConsulta(double valorDaConsulta) {
		this.valorDaConsulta = valorDaConsulta;
	}

}

