package interfaceUsuario;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import Medico.DiaDeTrabalho;
import Medico.Especialidade;
import Medico.Medico;
import Medico.Semana;

import persistencia.GravaLerMedico;

public class MainMedico {
	private static final int NUMERO_DE_OPCOES = 4;
	private static Scanner input;
	public static List<Medico> listaDeMedico;

	public static void main(String[] args) throws Exception {
		
		int opcoes;
		input = new Scanner(System.in);
		
		
		try{
			listaDeMedico = GravaLerMedico.lerMedico((ArrayList<Medico>) listaDeMedico);
		} catch (Exception e){
			listaDeMedico = new ArrayList<Medico>();
		}
	
		
		
		
		do {
			printMenu1();
			System.out.print("> ");
			opcoes = lerValor();

			switch (opcoes) {
			case 1:
				Medico medico = new Medico(lerNomeMedico(),
						lerEspecialidade(), lerTempoPrimeiraConsulta(),
						lerTempoConsultaRetorno());
				listaDeMedico.add(medico);
				System.out.println("Medico adicionado com sucesso");
				break;
			case 2:
				adicionaHorario();
				break;
			case 3:
				imprimeHorarioEMedicosClinica();
				break;
			default:
				break;
			}
			GravaLerMedico.gravaMedico((ArrayList<Medico>) listaDeMedico);
		} while (opcoes != NUMERO_DE_OPCOES);
	} 

	
	public static List<Medico> getListaDeMedicos(){
		return listaDeMedico;
	}

	private static void printMenu1() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nEscolha uma das opcoes\n");
		sb.append("\n1 - Cadastrar novo medico.");
		sb.append("\n2 - Adicionar horario de medicos ja cadastrados.");
		sb.append("\n3 - Imprimir agenda de todos os medicos cadastrados.");
		sb.append("\n4 - Voltar."); 
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

	// Ler Nome do Medico. Retorna o nome do medico digitado.
	// Nao sera aceito nome vazios. Caso isso aconteca sera lancado uma execao.
	public static String lerNomeMedico() throws Exception {
		System.out.print("Nome do Medico: ");
		String nomeMedico = input.nextLine();
		if (nomeMedico == null || nomeMedico.trim().length() == 0) {
			throw new Exception("Login nao pode ser vazio");
		}
		return nomeMedico;
	}

	// Ler a especialidade do medico. Retorna o objeto que contenha a
	// especialidade do medico.
	private static Especialidade lerEspecialidade() throws Exception {
		int opcao;

		System.out.println("\nEscolha o numero que correponde a especialidade do medico:\n");

		for (int i = 0; i < Especialidade.values().length; i++) {
			System.out.println(i + 1 + " - " + Especialidade.values()[i]);
		}
		
		System.out.print("> ");
		opcao = lerValor();
		

		if (!(opcao > Especialidade.values().length)) {
			return Especialidade.values()[opcao - 1];

		} else {
			throw new Exception("Especialidade nao existe");
		}
	}

	//Ler os horarios de um dia da semana. Retorna o objeto Dia.
	private static DiaDeTrabalho lerDia(Semana diaDaSemana) throws Exception {
		String entrada, saida;

		System.out.print("Horario de Entrada " + diaDaSemana + " (no formato hh:mm): ");
		entrada = input.nextLine();
		System.out.print("Horario de Saida " + diaDaSemana + " (no formato hh:mm): ");
		saida = input.nextLine();

		return new DiaDeTrabalho(diaDaSemana , entrada, saida);

	}


	//Ler o tempo que o medico gasta na primeira consulta.
	private static int lerTempoPrimeiraConsulta() {
		System.out
				.print("\nDigite o tempo medio de uma primeira consulta(em minutos): ");
		return lerValor();
	}

	//Ler o tempo que o medico gasta na consulta de retorno.
	private static int lerTempoConsultaRetorno() {
		System.out
				.print("\nDigite o tempo medio de uma consulta de acompanhamento(em minutos): ");
		return lerValor();
	}

	//Imprime todas as fichas dos medicos da clinica.
	private static void imprimeHorarioEMedicosClinica() {
		Iterator<Medico> it = listaDeMedico.iterator();
		
		if (listaDeMedico.isEmpty()) {
			System.out.println("A clinica nao possui nenhum medico cadastrado");
		} 
		while (it.hasNext()){
			Medico novoMedico = it.next();
			System.out.println("\n" + novoMedico.toString() + "\n" + novoMedico.agendaMedico() + "\n");
		}
		
	}

	//Imprime o nome de todos os medicos cadastrados.
	private static void imprimeNomeMedicosCadastrados() {
		int cont = 0;
		Iterator<Medico> it = listaDeMedico.iterator();

		while (it.hasNext()) {
			cont++;
			Medico proximoMedico = it.next();
			if (proximoMedico == null) {
				continue;
			} else {
				System.out.println(cont + " - " + proximoMedico.getNomeDoMedico());
			}
		}

	}
	
	private static void imprimeDiaDaSemana(){
		for (int i = 0; i < Semana.values().length; i++){
			System.out.println(i + 1 + " - " + Semana.values()[i].getNomeDia());
		}
	}
	
	private static void adicionaHorario() {
		int opcoes;
		Medico medico = new Medico();

		if (!listaDeMedico.isEmpty()) {
			do {
				System.out
						.println("Escolha qual medico deseja adicionar horario");

				imprimeNomeMedicosCadastrados();

				System.out.print("> ");
				opcoes = lerValor();

				try {
					medico = listaDeMedico.get(opcoes - 1);
				} catch (java.lang.IndexOutOfBoundsException e) {
					System.out.println("Opcao invalida!");
					adicionaHorario();
				}

				System.out.println("1 - Cadastrar horario de atendimento"); 
				System.out.println("2 - Cadastrar horario de cirurgias");
				System.out.println("3 - Voltar");

				System.out.print("> ");
				opcoes = lerValor();

				switch (opcoes) {
				case 1:
					System.out
							.println("\nEscolha qual dia da semana deseja adicionar horario\n");
					imprimeDiaDaSemana();
					System.out.print("> ");
					opcoes = lerValor();
					Semana semana1 = Semana.values()[opcoes - 1];
					try {
						medico.addDiasDeExpediente(lerDia(semana1));
						System.out.println("Adicionado com sucesso\n");
						opcoes = 3;
						break;
					} catch (Exception e) {
						System.out.println("Hora invalida. Tente novamente.\n");
						break;
					}

				case 2:
					System.out
							.println("\nEscolha qual dia da semana deseja adicionar horario\n");
					imprimeDiaDaSemana();
					System.out.print("> ");
					opcoes = lerValor();
					Semana semana2 = Semana.values()[opcoes - 1];
					try {
						medico.addDiasDeCirurgia(lerDia(semana2));
						verificaHoraIgual(medico);
						System.out.println("Adicionado com sucesso\n");
						opcoes = 3;
						break;
					} catch (Exception e) {
						System.out.println("Hora invalida. Tente novamente.\n");

						break;
					}
				case 3:
					imprimeHorarioEMedicosClinica();
					break;
				default:
					System.out.println("Opcao invalida digite novamente!");
					break;
				}
			} while (opcoes != 3);
		} else {
			System.out.println("Nenhum medico cadastrado na clinica");
		}
	}

	
	private static void testaHorarios(Medico medico1, Medico medico2) {
		if (listaDeMedico.size() >= 2) {
			if (medico1.getEspecialidade().equals(medico2.getEspecialidade())) {
				for (DiaDeTrabalho diaMedico1 : medico1.getDiasDeCirurgia()) {
					for (DiaDeTrabalho diaMedico2 : medico2.getDiasDeCirurgia()) {
						if (diaMedico1.getDiaSemana().equals(diaMedico2.getDiaSemana())) {
							int hora1Entrou = tempoNaClinica(diaMedico1.getEntrou());
							int hora2Entrou = tempoNaClinica(diaMedico2.getEntrou());
							int hora1Saiu = tempoNaClinica(diaMedico1.getSaiu());
							int hora2Saiu = tempoNaClinica(diaMedico2.getSaiu());

							if (hora1Entrou > hora2Entrou && hora1Entrou < hora2Saiu) {
								System.out.println("ATENCAO\nO medico: " + medico1.getNomeDoMedico() +  " e o medico: " + medico2.getNomeDoMedico() + "\nSao da mesma especialidade e estao disponivei para cirurgia no mesmo horario\n" );
							} else if (hora2Entrou > hora1Entrou && hora2Entrou < hora1Saiu) {
								System.out.println("ATENCAO\nO medico: " + medico1.getNomeDoMedico() +  " e o medico: " + medico2.getNomeDoMedico() + "\nSao da mesma especialidade e estao disponivei para cirurgia no mesmo horario\n" );
							} 
						}
					}
				}
			}
		} 

	}
	
		
	
	
	private static void verificaHoraIgual(Medico medico){	
		if (listaDeMedico.size() >= 2){
			for (int i = 0; i < listaDeMedico.toArray().length ; i++){
				Medico medico1 = (Medico) listaDeMedico.toArray()[i];
				if (!medico.equals(medico1)){
				testaHorarios(medico, medico1);
				}
			}
		}
		
	}
	
	private static int tempoNaClinica(String hora){
		String[] horaMedico = hora.split(":");
		return Integer.parseInt(horaMedico[0])* 60 + Integer.parseInt(horaMedico[1]);
	}
}
