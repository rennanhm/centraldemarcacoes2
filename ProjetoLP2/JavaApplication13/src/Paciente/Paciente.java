package Paciente;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.*;

import Paciente.FormaDeContato;
import PlanoDeSaude.PlanoDeSaude;

/**
 * Classe Paciente. Cadastra um paciente a partir do nome, do cpf, do endereco,
 * do telefone residencial, comercial e o celular, da data de nascimento, do
 * plano de saude, do email do paciente e da melhor forma de contato com o
 * mesmo.
 * 
 * @author Grupo 7
 * 
 */
public class Paciente {

	private final int MES_DE_FEVEREIRO = 02;
	private String nome;
	private String cpf;
	private EnderecoDoPaciente endereco;
	private TelefoneDeContato foneResidencial;
	private TelefoneDeContato foneComercial;
	private TelefoneDeContato foneCelular;
	private String dataDeNascimento;
	private int idade;
	private String email;
	private String formaDeContato;
	private String dataDaUltimaVisita;
	private HorarioDeAtendimento horarioDeAtendimento;

	/**
	 * * 
	 * 
	 *Cadastra um paciente recebendo como parametros o nome, o cpf, o endereco,
	 * o telefone residencial, comercial e o celular, a data de nascimento, o
	 * plano de saude, o email do paciente e a melhor forma de contato com o
	 * mesmo.
	 * @param nome Nome do paciente
	 * @param cpf Cpf do paciente
	 * @param endereco Endereco do paciente 
	 * @param foneResidencial Telefone residencial do paciente
	 * @param foneComercial Telefone comercial do paciente
	 * @param foneCelular Telefone celular do paciente
	 * @param dataDeNascimento Data de nascimento do paciente
	 * @param planoDeSaude Plano de saude do paciente
	 * @param email Email do paciente
	 * @param formaDeContato Forma de contato do paciente
	 * @throws Exception
	 */
	public Paciente(String nome, String cpf, EnderecoDoPaciente endereco,
			TelefoneDeContato foneResidencial, TelefoneDeContato foneComercial,
			TelefoneDeContato foneCelular, String dataDeNascimento,
			PlanoDeSaude planoDeSaude, String email, String formaDeContato)
			throws Exception {

		if (nome.length() == 0 || nome == null) {
			throw new Exception(
					"O nome do paciente nao pode ser nulo ou vazio.");
		} else if (testaCpf(cpf) == false) {
			throw new Exception("CPF invalido.");
		} else if (testaDataDeNascimento(dataDeNascimento) == false) {
			throw new Exception("Data de nascimento invalida.");
		} else if (testaEmailValido(email) == false) {
			throw new Exception("Email invalido.");
		} else if (testaFormaDeContato(formaDeContato) == false) {
			throw new Exception("Forma de contato invalida.");
		}

		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.foneResidencial = foneResidencial;
		this.foneComercial = foneComercial;
		this.foneCelular = foneCelular;
		this.dataDeNascimento = dataDeNascimento;
		this.email = email;
		this.formaDeContato = formaDeContato;
		this.horarioDeAtendimento = new HorarioDeAtendimento(planoDeSaude);
		idade = calculaIdadeDoPaciente(dataDeNascimento);

	}

	/**
	 * * 
	 * 
	 *Cadastra um paciente recebendo como parametros o nome, o cpf, o endereco,
	 * o telefone residencial, comercial e o celular, a data de nascimento, o
	 * plano de saude, o email do paciente e a melhor forma de contato com o
	 * mesmo.
	 * @param nome Nome do paciente
	 * @param cpf Cpf do paciente
	 * @param endereco Endereco do paciente 
	 * @param foneResidencial Telefone residencial do paciente
	 * @param foneComercial Telefone comercial do paciente
	 * @param foneCelular Telefone celular do paciente
	 * @param dataDeNascimento Data de nascimento do paciente
	 * @param planoDeSaude Plano de saude do paciente
	 * @param email Email do paciente
	 * @param formaDeContato Forma de contato do paciente
	 * @param dataDaUltimaVisita Data da ultima visita do paciente
	 * @throws Exception
	 */
	public Paciente(String nome, String cpf, EnderecoDoPaciente endereco,
			TelefoneDeContato foneResidencial, TelefoneDeContato foneComercial,
			TelefoneDeContato foneCelular, String dataDeNascimento,
			PlanoDeSaude planoDeSaude, String email, String formaDeContato,
			String dataDaUltimaVisita) throws Exception {

		this(nome, cpf, endereco, foneResidencial, foneComercial, foneCelular,
				dataDeNascimento, planoDeSaude, email, formaDeContato);

		if (testaDataDeNascimento(dataDaUltimaVisita) == false) {
			throw new Exception("Data da ultima visita invalida.");
		}
		this.dataDaUltimaVisita = dataDaUltimaVisita;
	}

	private boolean testaCpf(String cpf) {
		Pattern padrao = Pattern
				.compile("[0-9]{3}\\.?[0-9]{3}\\.?[0-9]{3}\\-?[0-9]{2}");
		Matcher pesquisa = padrao.matcher(cpf);
		if (pesquisa.matches()) {
			return true;
		}
		return false;
	}

	private boolean testaDataDeNascimento(String data) {
		Pattern padrao = Pattern
				.compile("(0[1-9]|[1-9]|[12][0-9]|3[01])[\\-/](0[1-9]|1[012]|[1-9])[\\-/](19|20)?\\d{2}");
		Matcher pesquisa = padrao.matcher(data);
		boolean dataCorreta = true;

		String[] arrayData = data.split("/");
		String[] meses = { "02", "04", "06", "09", "11" };

		if (pesquisa.matches()) {
			if (dataEmAnoBissextoValida(data) == false) {
				dataCorreta = false;
			} else {
				for (int i = 0; i < meses.length; i++) {
					if (arrayData[0].equals("31")
							&& arrayData[1].equals(meses[i])) {
						dataCorreta = false;
						break;
					}
				}
			}
		} else {
			dataCorreta = false;
		}

		if (dataCorreta) {
			return true;
		} else {
			return false;
		}

	}

	private boolean dataEmAnoBissextoValida(String data) {
		GregorianCalendar calendario = new GregorianCalendar();
		String[] arrayData = data.split("/");

		int dia = Integer.parseInt(arrayData[0]);
		int mes = Integer.parseInt(arrayData[1]);
		int ano = Integer.parseInt(arrayData[2]);

		if (mes == MES_DE_FEVEREIRO && dia == 30) {
			return false;
		} else if (!(calendario.isLeapYear(ano)) && mes == MES_DE_FEVEREIRO
				&& dia == 29) {
			return false;
		}
		return true;
	}

	private int calculaIdadeDoPaciente(String data) {
		GregorianCalendar calendario = new GregorianCalendar();
		int dia = calendario.get(Calendar.DAY_OF_MONTH);
		int mes = (calendario.get(Calendar.MONTH)) + 1;
		int ano = calendario.get(Calendar.YEAR);

		String[] arrayDataDeNascimento = data.split("/");

		int diaDoNascimento = Integer.parseInt(arrayDataDeNascimento[0]);
		int mesDoNascimento = Integer.parseInt(arrayDataDeNascimento[1]);
		int anoDoNascimento = Integer.parseInt(arrayDataDeNascimento[2]);

		if (mes > mesDoNascimento) {
			return ano - anoDoNascimento;
		} else if (mes == mesDoNascimento) {
			if (dia < diaDoNascimento) {
				return ano - anoDoNascimento - 1;
			} else {
				return ano - anoDoNascimento;
			}
		} else {
			return ano - anoDoNascimento - 1;
		}

	}

	private boolean testaEmailValido(String email) {
		Pattern padrao = Pattern.compile(".+@.+\\.[a-z]+");
		Matcher pesquisa = padrao.matcher(email);
		if (email.contains(",") || email.contains(";") || email.contains("?")
				|| email.contains("&") || email.contains("!")
				|| email.contains(":") || email.contains("*")
				|| email.contains("#")) {
			return false;
		} else if (pesquisa.matches()) {
			return true;
		} else {
			return false;
		}

	}

	private boolean testaFormaDeContato(String contato) {
		boolean contatoValido = false;
		FormaDeContato[] arrayDeContato = FormaDeContato.values();
		for (int i = 0; i < arrayDeContato.length; i++) {
			if (arrayDeContato[i].getNome().toLowerCase()
					.equals(contato.toLowerCase())) {
				contatoValido = true;
				break;
			}
		}
		if (contatoValido) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Retorna o horario de atendimento do paciente
	 * 
	 * @return Horario de atendimento
	 */
	public HorarioDeAtendimento getHorarioDeAtendimento() {
		return horarioDeAtendimento;
	}

	/**
	 * Muda o horario de atendimento para o passado como parametro
	 * 
	 * @param horarioDeAtendimento
	 *            Novo horario de atendimento
	 */
	public void setHorarioDeAtendimento(
			HorarioDeAtendimento horarioDeAtendimento) {
		this.horarioDeAtendimento = horarioDeAtendimento;
	}

	/**
	 * Retorna o nome do paciente
	 * 
	 * @return Nome do paciente
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Retorna o cpf do paciente
	 * 
	 * @return CPF
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * Retorna o endereco do paciente.
	 * 
	 * @return Endereco.
	 */
	public EnderecoDoPaciente getEndereco() {
		return endereco;
	}

	/**
	 * Retorna a data de nascimento do paciente
	 * 
	 * @return Data de nascimento.
	 */
	public String getDataDeNascimento() {
		return dataDeNascimento;
	}

	/**
	 * Retorna a idade do paciente.
	 * 
	 * @return Idade.
	 */
	public int getIdade() {
		return idade;
	}

	/**
	 * Retorna o plano de saude do paciente
	 * 
	 * @return Plano de Saude.
	 */
	public PlanoDeSaude getPlanoDeSaude() {
		return horarioDeAtendimento.getPlanoDeSaude();
	}

	/**
	 * Retorna o email do paciente.
	 * 
	 * @return Email.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Retorna os telefones para contato.
	 * 
	 * @return Telefones para contato.
	 */
	public TelefoneDeContato getTelefoneResidencial() {
		return foneResidencial;
	}

	/**
	 * Retorna o telefone comercial.
	 * 
	 * @return Telefone comercial.
	 */
	public TelefoneDeContato getTelefoneComercial() {
		return foneComercial;
	}

	/**
	 * Retorna o telefone celular.
	 * 
	 * @return Telefone celular.
	 */
	public TelefoneDeContato getTelefoneCelular() {
		return foneCelular;
	}

	/**
	 * Retorna a forma de contato com o paciente.
	 * 
	 * @return Forma de contato.
	 */
	public String getFormaDeContato() {
		return formaDeContato;
	}

	/**
	 * Retorna o numero de identificacao unico do paciente.
	 * 
	 * @return Numero de identificacao do paciente.
	 */
	public int getNumeroDeIdentificacao() {
		return horarioDeAtendimento.getNumeroDeIdentificao();
	}

	/**
	 * Retorna a data da ultima visita do paciente a clinica.
	 * 
	 * @return Data da ultima visita.
	 */
	public String getDataDaUltimaVisita() {
		return dataDaUltimaVisita;
	}

	/**
	 * Muda o endereco do paciente para o passado como parametro
	 * 
	 * @param endereco
	 *            Novo endereco do paciente.
	 */
	public void setEndereco(EnderecoDoPaciente endereco) {
		this.endereco = endereco;
	}

	/**
	 * Muda o plano de saude para o passado como parametro.
	 * 
	 * @param planoDeSaude
	 *            Novo plano de saude do paciente.
	 */
	public void setPlanoDeSaude(PlanoDeSaude planoDeSaude) {
		this.horarioDeAtendimento.setPlanoDeSaude(planoDeSaude);
	}

	/**
	 * Muda o email do pacinete para o passado como parametro.
	 * 
	 * @param email
	 *            Novo email do paciente.
	 */
	public void setEmail(String email) {
		if (testaEmailValido(email)) {
			this.email = email;
		}
	}

	/**
	 * Muda a forma do contato com o paciente para o passado como parametro.
	 * 
	 * @param formaDeContato
	 *            Nova forma de contato com o paciente.
	 */
	public void setFormaDeContato(String formaDeContato) {
		this.formaDeContato = formaDeContato;
	}

	/**
	 * Muda a data da ultima visita para a passada como parametro.
	 * 
	 * @param novaData
	 *            A data da visita mais recente do paciente a clinica.
	 */
	public void setDataDaUltimaVisita(String novaData) {
		if (testaDataDeNascimento(novaData)) {
			dataDaUltimaVisita = novaData;
		}
	}

	/**
	 * Muda o numero de indentificacao do paciente para o passado como parametro
	 * 
	 * @param numeroDeIdentificacao
	 *            Novo numero de identificacao
	 */
	public void setNumeroDeIdentificacao(int numeroDeIdentificacao) {
		horarioDeAtendimento.setNumeroDeIdentificao(numeroDeIdentificacao);
	}

	/**
	 * Muda o telefone para o passado como parametro.
	 * 
	 * @param telefones
	 *            Novo telefone para contato.
	 */
	public void setTelefoneResidencial(TelefoneDeContato foneResidencial) {
		this.foneResidencial = foneResidencial;
	}

	/**
	 * Muda o telefone comercial para o passado como parametro.
	 * 
	 * @param foneComercial
	 *            Novo telefone comercial.
	 */
	public void setTelefoneComercial(TelefoneDeContato foneComercial) {
		this.foneComercial = foneComercial;
	}

	/**
	 * Muda o telefone celular para o passado como parametro.
	 * 
	 * @param foneCelular
	 *            Novo telefone celular.
	 */
	public void setTelefoneCelular(TelefoneDeContato foneCelular) {
		this.foneCelular = foneCelular;
	}

	/**
	 * Retorna uma String que representa o paciente
	 */
	public String toString() {
		return "Nome: " + this.getNome();
	}

	/**
	 * String com dados do paciente
	 * 
	 * @return Uma string que apresenta o numero de indentificacao do paciente,
	 * o nome do mesmo e o plano de saude utilizado
	 */
	public String imprime() {
		return "Numero de identificacao: " + this.getNumeroDeIdentificacao()
				+ "Nome: " + this.getNome() + " Plano: "
				+ this.getPlanoDeSaude().getNomeDoPlano();
	}

}
