package interfaceUsuario;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;

import persistencia.GravaLerMedico;
import persistencia.GravaLerPaciente;


import Medico.Medico;
import Paciente.HorarioDeAtendimento;
import Paciente.Paciente;
import Secretaria.Secretaria;

public class MainSecretaria {
	private static Scanner input;
	private static List<Medico> listaDeMedico;
	public static List<Paciente> listaDePaciente;
	private static Secretaria secretaria;
	private static final int NUMERO_DE_OPCOES = 6;

	public static void main(String[] args) throws Exception {
		int opcoes;
		input = new Scanner(System.in);	
		
		try{
			listaDePaciente = GravaLerPaciente.lerPaciente(listaDePaciente);
		} catch (Exception e){
			listaDePaciente = new ArrayList<Paciente>();
		} 
		try{
			listaDeMedico = GravaLerMedico.lerMedico(listaDeMedico);
		} catch (Exception e){
			listaDePaciente = new ArrayList<Paciente>();
		} 
		
		secretaria = new Secretaria(listaDeMedico, listaDePaciente);
		
		
		if (!(listaDeMedico.isEmpty() && listaDePaciente.isEmpty())){

			do {
				printMenu1();
				System.out.print("> ");
				opcoes = lerValor();

				switch (opcoes) {
				case 1:
					marcaConsulta();
					break;
				case 2:
					cancelarConsultaERemarca();
					break;
				case 3:
					criaListaDeEspera();
					break;
				case 4:
					cancelarConsulta();
					break;
				case 5:
					mostraMedicosCadastrados();
					break;
				default:
					break;
				}
				
				GravaLerMedico.gravaMedico(listaDeMedico);
				GravaLerPaciente.gravaPaciente(listaDePaciente);

			} while (opcoes != NUMERO_DE_OPCOES);
		}
		else {
			System.out.println("Nao existe medico cadastrado\n");
		}
	}

	private static void printMenu1() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nEscolha uma das opcoes\n");
		sb.append("\n1 - Marcar consulta/retorno/cirurgia.");
		sb.append("\n2 - Cancelar todas as consultas de um determinado dia e remarcar caso necessario.");
		sb.append("\n3 - Criar lista de espera.");
		sb.append("\n4 - Cancelar uma consulta/cirurgia especifica");
		sb.append("\n5 - Medicos cadastrados na clinica");
		sb.append("\n6 - Voltar.");
		System.out.println(sb.toString());

	}

	// Ler o valor digitado pelo usuario e verifica se ele eh um numero, caso
	// seja uma letra o programa eh fechado
	private static int lerValor() {
		input = new Scanner(System.in);
		while (true) {
			try {
				Integer number = 0;
				number = Integer.valueOf(input.nextLine());
				return number;
			} catch (java.lang.NumberFormatException nfe) {
				System.out.println("Erro ao digitar numero");
				System.out.println("Digite novamente");
				System.out.print("> ");
			}
		}
	}

	private static void mostraMedicosCadastrados() {
		if (listaDeMedico.size() == 0) {
			System.out.println("Nao existe medicos cadastrados na clinica");
		} else {

			Iterator<Medico> it = listaDeMedico.iterator();

			while (it.hasNext()) {
				Medico novoMedico = it.next();
				System.out.println(novoMedico + "\n");
			}
		}
	}

	private static void imprimeNomeMedicosCadastrados() {
		int cont = 0;
		Iterator<Medico> it = listaDeMedico.iterator();

		while (it.hasNext()) {
			cont++;
			Medico proximoMedico = it.next();
			if (proximoMedico == null) {
				continue;
			} else {
				System.out.println(cont + " - "
						+ proximoMedico.getNomeDoMedico());
			}
		}

	}

	private static void marcaConsulta() {
		int opcoes, opcoes2;
		boolean opcoes3 = false;
		boolean opcoes4 = true;
		Medico medico = null;

		if (!listaDeMedico.isEmpty()) {
			do {
				System.out
				.println("Escolha qual medico deseja marcar consulta/cirurgia");

				imprimeNomeMedicosCadastrados();

				System.out.print("> ");
				opcoes = lerValor();

				try {
					medico = listaDeMedico.get(opcoes - 1);
				} catch (java.lang.IndexOutOfBoundsException e) {
					System.out.println("Opcao invalida!");
					marcaConsulta();
				}

				System.out.println("1 - Marcar consulta");
				System.out.println("2 - Marcar cirurgia");
				System.out.println("3 - Voltar");

				System.out.print("> ");
				opcoes = lerValor();
				switch (opcoes) {
				case 1:
					System.out
					.println("\nNumero de itendificacao do paciente\n");
					System.out.print("> ");
					opcoes = lerValor();
					System.out.print("\nSe for primeira consulta digite 1 se for consulta retorno digite 2: ");
					opcoes2 = lerValor();
					if (opcoes2 == 1) {
						opcoes3 = true;
						opcoes4 = false;
					}

					if (medico.getDiasDeExpediente().isEmpty()) {
						System.out.println("Medico nao faz consulta");
						opcoes = 2;
						break;
					} else {
						try {
							Paciente novoPaciente = null;
							for (Paciente paciente : listaDePaciente){
								if (paciente.getNumeroDeIdentificacao() == opcoes){
									novoPaciente = paciente;
									paciente.setHorarioDeAtendimento(new HorarioDeAtendimento(opcoes, opcoes3, opcoes4));
									secretaria.marcarConsulta(medico, paciente);
									confirmacaoDaConsulta(medico, paciente);
									System.out.println("Adicionado com sucesso\n");
									System.out.println(medico.agendaMedico());
									opcoes = 2;
									break;
								}
							}
							
							if (novoPaciente == null){
								System.out.println("Paciente nao encontrado");
							}
							opcoes = 2;
							break;
						} catch (Exception e) {
							System.out.println("Hora invalida. Tente novamente.\n");
							opcoes = 2;
							break;
						}
						

					}

				case 2:
					System.out
					.println("\nNumero de itendificacao do paciente\n");
					System.out.print("> ");
					opcoes = lerValor();
					System.out
					.println("\nSe for primeira consulta digite 1 se for consulta retorno digite 2");
					opcoes2 = lerValor();
					if (opcoes2 == 1) {
						opcoes3 = true;
						opcoes4 = false;
					}
					if (medico.getDiasDeCirurgia().isEmpty()) {
						System.out.println("Medico nao faz cirurgia");
						opcoes = 2;
						break;
						
					} else {
						try {
							Paciente novoPaciente = null;
							for (Paciente paciente : listaDePaciente){
								if (paciente.getNumeroDeIdentificacao() == opcoes){
									novoPaciente = paciente;
									paciente.setHorarioDeAtendimento(new HorarioDeAtendimento(opcoes, opcoes3, opcoes4));
									secretaria.marcarCirurgia(medico, paciente);
//									confirmacaoDaConsulta(medico, paciente);
									System.out.println("Adicionado com sucesso\n");
									System.out.println(medico.agendaMedico());
									opcoes = 2;
									break;
								}
							}
							
							if (novoPaciente == null){
								System.out.println("Paciente nao encontrado");
							}
							opcoes = 2;
							break;
						} catch (Exception e) {
							System.out
							.println("Hora invalida. Tente novamente.\n");
							break;
						}
					}
				default:
					System.out.println("Opcao invalida digite novamente!");
					break;
				}
			} while (opcoes != 2);
		} else {
			System.out.println("Nenhum medico cadastrado na clinica");
		}
	}

	private static void cancelarConsultaERemarca() {
		int opcoes;
		Medico medico = null;

		if (!listaDeMedico.isEmpty()) {
			do {
				System.out
				.println("Escolha qual medico deseja cancelar consulta");

				imprimeNomeMedicosCadastrados();
				System.out.print("> ");
				opcoes = lerValor();

				try {
					medico = listaDeMedico.get(opcoes - 1);
				} catch (java.lang.IndexOutOfBoundsException e) {
					System.out.println("Opcao invalida!");
					marcaConsulta();
				}

				System.out
				.println("ATENCAO - DESEJA REALMENTE CANCELAR CONSULTAS ?");
				System.out.println("1 - Sim");
				System.out.println("2 - Nao");

				System.out.print("> ");
				opcoes = lerValor();

				switch (opcoes) {

				case 1:
					System.out
					.println("\nDigite o dia, mes e ano que deseja cancelar a consulta\n");
					System.out.print("> ");
					Calendar calendario = new GregorianCalendar(lerAno(),
							lerMes() - 1, lerDia() - 1);
					secretaria.remacarConsulta(medico, calendario);
					System.out
					.println("Consultas canceladas e remacadar com sucesso");
					System.out.println(medico.agendaMedico());
					opcoes = 1;
					break;
				}
			} while (opcoes != 1);
		} else {
			System.out.println("Nenhum medico cadastrado na clinica");
		}
	}

	private static void criaListaDeEspera() {

		int opcoes;
		int opcoes2;
		boolean opcoes3 = false;
		boolean opcoes4 = true;
		Medico medico = null;

		if (!listaDeMedico.isEmpty()) {
			System.out
			.println("\nDigite o dia, mes e ano limite para a lista de espera");
			System.out.print("> ");
			Calendar calendario = new GregorianCalendar(lerAno(), lerMes() - 1,
					lerDia() - 1);

			System.out
			.println("Escolha para que medico deseja criar a lista de espera");
			imprimeNomeMedicosCadastrados();
			System.out.print("> ");
			opcoes = lerValor();


			try {
				medico = listaDeMedico.get(opcoes - 1);
				if (!medico.getDiasDeExpediente().isEmpty()){
					System.out
					.println("\nDigite o numero de itendificacao do paciente");
					System.out.print("> ");
					opcoes2 = lerValor();

					System.out
					.println("\nSe for primeira consulta digite 1 se for consulta retorno digite 2");
					opcoes2 = lerValor();
					if (opcoes2 == 1) {
						opcoes3 = true;
						opcoes4 = false;
					}

					Paciente novoPaciente = null;
					for (Paciente paciente : listaDePaciente){
						if (paciente.getNumeroDeIdentificacao() == opcoes){
							novoPaciente = paciente;
							paciente.setHorarioDeAtendimento(new HorarioDeAtendimento(opcoes, opcoes3, opcoes4));
							if (secretaria.marcarConsultaComDataLimite(medico, paciente, calendario)) {
								System.out.println("Lista de espera criada.");
							} else {
								System.out.println("Nao foi possivel criar a lista de espera");
							}
						} else {
							System.out.println("Ainda nao existe medicos cadastrados.");
						}

						opcoes = 2;
						break;
					}


					if (novoPaciente == null){
						System.out.println("Paciente nao encontrado");
					}


				}
			}  catch (java.lang.IndexOutOfBoundsException e) {
				System.out.println("Opcao invalida!");
			}
		}
		System.out.println("Medico nao faz consulta");

	}

	private static int lerDia() {
		return lerOpcoes("Insira o dia [1-31]: ", 1, 31);
	}

	private static int lerAno() {
		return lerOpcoes(String.format("Insira o ano [%d-%d]: ", 1970, 2100),
				1970, 2100);
	}

	private static int lerMes() {
		return lerOpcoes(
				"Insira o mes [1 = janeiro; 2 = fevereiro; ...; 12 = dezembro]: ",
				1, 12);
	}

	private static int lerOpcoes(String mensagem, int minimo, int maximo) {
		while (true) {
			try {
				System.out.print(mensagem);
				Integer numero = 0;
				do {
					numero = Integer.valueOf(input.nextLine());
				} while (numero < minimo || numero > maximo);
				return numero;
			} catch (NumberFormatException nfe) {
				System.out.println("Erro ao digitar. Tente novamente");
			}
		}
	}

	private static void cancelarConsulta() {
		int opcoes, opcoes2;
		boolean opcoes3 = false;
		boolean opcoes4 = true;
		Medico medico = new Medico();

		if (!listaDeMedico.isEmpty()) {
			do {
				System.out
				.println("Escolha qual medico deseja cancelar consulta");

				imprimeNomeMedicosCadastrados();

				System.out.print("> ");
				opcoes = lerValor();

				try {
					medico = listaDeMedico.get(opcoes - 1);
				} catch (java.lang.IndexOutOfBoundsException e) {
					System.out.println("Opcao invalida!");
					marcaConsulta();
				}

				System.out
				.println("ATENCAO - DESEJA REALMENTE CANCELAR CONSULTAS ?");
				System.out.println("1 - Sim");
				System.out.println("2 - Nao");

				System.out.print("> ");
				opcoes = lerValor();
				switch (opcoes) {
				case 1:
					System.out
					.println("\nNumero de itendificacao do paciente\n");
					System.out.print("> ");
					opcoes = lerValor();
					System.out
					.println("\nSe fosse a primeira consulta digite 1 se fosse consulta retorno digite 2");
					opcoes2 = lerValor();
					if (opcoes2 == 1) {
						opcoes3 = true;
						opcoes4 = false;
					}

					if (medico.getDiasDeExpediente().isEmpty()) {
						System.out.println("Medico nao faz consulta");
						opcoes = 1;
						break;
					} else {
						try {
							HorarioDeAtendimento horario = secretaria
							.excluirConsulta(medico,
									new HorarioDeAtendimento(opcoes,
											opcoes3, opcoes4));
							if (horario == null) {
								System.out
								.println("Nao foi possivel remover. Paciente esse nao existe");
							} else {
								System.out.println("Removido com sucesso\n");

							}
							opcoes = 1;
							break;
						} catch (Exception e) {
							System.out
							.println("Hora invalida. Tente novamente.\n");
							break;
						}
					}
				default:
					System.out.println("Opcao invalida digite novamente!");
					break;
				}
			} while (opcoes != 1);
		} else {
			System.out.println("Nenhum medico cadastrado na clinica");
		}
	}
	
	private static void confirmacaoDaConsulta(Medico medico, Paciente paciente){
		int opcao1; 
		
		
		
		HorarioDeAtendimento horario = medico.getListaDePacientes().get(medico.getListaDePacientes().size()-1);
		System.out.println("\nO paciente pode ser marcado nessa data: " + horario.getDiaDoMes() + "/" + (horario.getMes()+1) + "/"  + horario.getAno() + "\n");
		System.out.println("1 - Confirmar consulta para essa data");
		System.out.println("2 - Marcar consulta em outra data");
		
		System.out.print("> ");
		opcao1 = lerValor();
	
		if (opcao1 == 2){
			
			secretaria.excluirConsulta(medico, horario);
			Calendar calendario = horario.getCalendario();
			if ((calendario.get(Calendar.DAY_OF_MONTH) == calendario.getActualMaximum(Calendar.DAY_OF_MONTH))){
				calendario.roll(Calendar.DAY_OF_MONTH, true);
				calendario.roll(Calendar.MONTH, true);
				horario.setCalendario(calendario);
				paciente.setHorarioDeAtendimento(horario);
				secretaria.marcarConsulta(medico, paciente);
				confirmacaoDaConsulta(medico, paciente);
			}
			else {
				calendario.roll(Calendar.DAY_OF_MONTH, true);
				horario.setCalendario(calendario);
				paciente.setHorarioDeAtendimento(horario);
				secretaria.marcarConsulta(medico, paciente);
				confirmacaoDaConsulta(medico, paciente);
			}
		}
				
	}
	
	
	public static String confirmacaoConsulta(Medico medico, Paciente paciente){
		HorarioDeAtendimento horario = medico.getListaDePacientes().get(medico.getListaDePacientes().size()-1);
		return "\nO paciente pode ser marcado nessa data: " + horario.getDiaDoMes() + "/" + (horario.getMes()+1) + "/"  + horario.getAno() + "\n";
	}
	
	
	
		
		

}
