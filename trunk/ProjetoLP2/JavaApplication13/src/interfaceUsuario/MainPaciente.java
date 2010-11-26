package interfaceUsuario;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


import persistencia.GravaLerPaciente;
import persistencia.GravaLerPlanoDeSaude;


import Paciente.FormaDeContato;
import Paciente.EnderecoDoPaciente;
import Paciente.Paciente;
import Paciente.TelefoneDeContato;


import PlanoDeSaude.PlanoDeSaude;

public class MainPaciente {

	private static final int NUMERO_DE_OPCOES = 4;
	public static List<Paciente> arrayDePacientes;
	private static List<Integer> arrayNumerosDeIdentificacao = new ArrayList<Integer>();
	private static Paciente paciente;
	static Scanner input;

	public static void main(String[] args) throws Exception {
		input = new Scanner(System.in);
		
		try{
			arrayDePacientes = GravaLerPaciente.lerPaciente(arrayDePacientes);
		} catch (Exception e){
			arrayDePacientes = new ArrayList<Paciente>();
		}
		
		int escolha;

		do {
			menuPrincipal();
			escolha = lerOpcaoDeNumeroInteiro("> ", 1, NUMERO_DE_OPCOES);

			switch (escolha) {
			case 1:
				try {
					paciente = new Paciente(
							pedeNomeDoPaciente(),
							pedeCpfDoPaciente(),
							new EnderecoDoPaciente(pedeRuaDoEndereco(),
									pedeComplementoDoEndereco(),
									pedeBairroDoEndereco(),
									pedeCidadeDoEndereco(),
									pedeEstadoDoEndereco(),
									pedeCepDoEndereco(), pedeNumeroDoEndereco()),
							new TelefoneDeContato(pedeTelefoneResidencial()),
							new TelefoneDeContato(pedeTelefoneComercial()),
							new TelefoneDeContato(pedeTelefoneCelular()),
							pedeDataDeNascimento(), pedePlanoDeSaude(),
							pedeEmailDoPaciente(),
							menuFormaDeContatoComPaciente(),
							pedeDataDaUltimaVisita());
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("\n" + e.getMessage());
					System.out.println("Cadastro nao foi possivel.");
					break;
				}
				paciente.setNumeroDeIdentificacao(atribuiNumeroDeIdentificacaoAoPaciente());
				arrayDePacientes.add(paciente);
				System.out.println("Paciente adicionado com sucesso\n Numero de indentificacao do paciente: " + paciente.getNome() + " eh: " + paciente.getNumeroDeIdentificacao());
				break;

			case 2:
				if (arrayDePacientes.isEmpty()) {
					System.out.println("\nNao existem pacientes cadastrados.");
				} else {
					excluiPaciente(pedeNomeDoPaciente());
				}
				break;
				
			case 3:
				imprimeListaDePacientesCadastrados();
				break;

			default:
				break;
			}
			GravaLerPaciente.gravaPaciente(arrayDePacientes);
		} while (escolha != NUMERO_DE_OPCOES);

	}
	
	
	public static List<Paciente> getListaDePacientes(){
		return arrayDePacientes;
	}
	
	private static void imprimeListaDePacientesCadastrados(){
		
		if (arrayDePacientes.isEmpty()){
			System.out.println("Nao existe nenhum paciente cadastrado.");
		}else{
			for (int i=0; i < arrayDePacientes.size(); i++){
				System.out.println("Nome: " + arrayDePacientes.get(i).getNome() + ", Cidade: " + arrayDePacientes.get(i).getEndereco().getCidade());
			}
		}
				
	}

	private static int lerOpcaoDeNumeroInteiro(String mensagem, int limiteMinimo,
			int limiteMaximo) {
		while (true) {
			try {
				System.out.print(mensagem);
				Integer numero = 0;
				do {
					numero = Integer.valueOf(input.nextLine());
				} while (numero < limiteMinimo || numero > limiteMaximo);
				return numero;
			} catch (NumberFormatException nfe) {
				System.out.println("Entrada invalida. Digite novamente.");
			}
		}
	}

	private static void menuPrincipal() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n--- Menu Principal ---\n\n");
		sb.append("1 - Cadastrar Paciente\n");
		sb.append("2 - Excluir Paciente\n");
		sb.append("3 - Lista de pacientes cadastrados\n");
		sb.append("4 - Sair\n");
		sb.append("\nEscolha sua opcao ");
		System.out.print(sb);
	}

	private static String menuFormaDeContatoComPaciente() {
		FormaDeContato[] arrayFormaDeContato = FormaDeContato.values();
		System.out.println("Escolha o tipo preferencial de contato com o paciente:");
		for (int i = 0; i < arrayFormaDeContato.length; i++) {
			System.out.println((i + 1) + " - "
					+ arrayFormaDeContato[i].getNome());
		}
		System.out.print("Digite sua opcao: ");
		int indiceDoContato = lerValor() - 1;
		return arrayFormaDeContato[indiceDoContato].getNome();
	}

	private static String pedeNomeDoPaciente() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nNome do paciente: ");
		return sc.nextLine();
	}

	private static String pedeCpfDoPaciente() {
		Scanner sc = new Scanner(System.in);
		System.out.print("CPF do paciente (Da forma xxx.xxx.xxx-xx ): ");
		return sc.next();
	}

	private static String pedeRuaDoEndereco() {
		Scanner sc = new Scanner(System.in);
		System.out.println("-- Endereco do paciente -- ");
		System.out.print("Rua/Avenida: ");
		return sc.nextLine();
	}
	
	private static String pedeComplementoDoEndereco() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Complemento (pode ser vazio): ");
		return sc.nextLine();
	}
	
	private static String pedeBairroDoEndereco() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Bairro: ");
		return sc.nextLine();
	}
	
	private static String pedeCidadeDoEndereco() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Cidade: ");
		return sc.nextLine();
	}
	
	private static String pedeEstadoDoEndereco() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Estado: ");
		return sc.nextLine();
	}
	
	private static String pedeCepDoEndereco() {
		Scanner sc = new Scanner(System.in);
		System.out.print("CEP (Da forma: xxxxx-xxx): ");
		return sc.nextLine();
	}
	
	private static int pedeNumeroDoEndereco() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Numero: ");
		return sc.nextInt();
	}

	private static String pedeTelefoneResidencial() {
		Scanner sc = new Scanner(System.in);
		System.out.println("--------------------------");
		System.out.print("Telefone residencial (Da forma (xx)xxxx-xxxx ): ");
		return sc.nextLine();
	}

	private static String pedeTelefoneComercial() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Telefone comercial (Da forma (xx)xxxx-xxxx ): ");
		return sc.nextLine();
	}

	private static String pedeTelefoneCelular() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Telefone celular (Da forma (xx)xxxx-xxxx ): ");
		return sc.nextLine();
	}

	private static String pedeDataDeNascimento() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Data de Nascimento (Da forma dd/mm/aaaa ): ");
		return sc.next();
	}

	private static PlanoDeSaude pedePlanoDeSaude() {
		List<PlanoDeSaude> listaDePlanosDeSaude = null ;
		System.out.println("Opcoes de planos:");
		imprimePlanosCadastrados();
		System.out.print("Digite a opcao de plano que deseja: \n");
		System.out.print("> ");
		int i = lerValor() - 1;
		
		try{
			listaDePlanosDeSaude = GravaLerPlanoDeSaude.lerPlanoDeSaude(listaDePlanosDeSaude);
		}catch (Exception e){
			listaDePlanosDeSaude = new ArrayList<PlanoDeSaude>();
			listaDePlanosDeSaude.add(new PlanoDeSaude());
		}
		
		return listaDePlanosDeSaude.get(i);
	}

	private static String pedeEmailDoPaciente() {
		Scanner sc = new Scanner(System.in);
		System.out
				.print("Email do paciente (Da forma paciente@email.com(.br) ): ");
		return sc.next();
	}

	private static String pedeDataDaUltimaVisita() {
		Scanner sc = new Scanner(System.in);
		System.out
				.print("Data da ultima visita do paciente a clinica (Da forma dd/mm/aaaa ): ");
		return sc.next();
	}

	private static int atribuiNumeroDeIdentificacaoAoPaciente() {
		Random numRandon = new Random();
		int numero = numRandon.nextInt(1000);

		while (arrayNumerosDeIdentificacao.contains(numero)) {
			numero = numRandon.nextInt(1000);
		}

		return numero;
	}

	private static void excluiPaciente(String nome) {
		boolean contemPaciente = false;
		for (int i = 0; i < arrayDePacientes.size(); i++) {
			if (arrayDePacientes.get(i).getNome().replace(" ", "").equalsIgnoreCase(nome.replace(" ", ""))) {
				arrayDePacientes.remove(i);
				contemPaciente = true;
				break;
			}
		}

		if (contemPaciente) {
			System.out.println("Paciente excluido.");
		} else {
			System.out.println("Nao foi possivel excluir o paciente.");
		}

	}

	private static void imprimePlanosCadastrados() {
		int i = 0;
		
		List<PlanoDeSaude> listaDePlanosDeSaude = null ;
		
		try{
			listaDePlanosDeSaude = GravaLerPlanoDeSaude.lerPlanoDeSaude(listaDePlanosDeSaude);
		}catch (Exception e){
			listaDePlanosDeSaude = new ArrayList<PlanoDeSaude>();
			listaDePlanosDeSaude.add(new PlanoDeSaude());
		}
		
//		if (MainPlanoDeSaude.listaDePlanosCadastrados() == null){
//			PlanoDeSaude plano = new PlanoDeSaude();
//			MainPlanoDeSaude.listaDePlanosCadastrados().add(plano);
//		}
//
//		if (MainPlanoDeSaude.listaDePlanosCadastrados().isEmpty()) {
//			PlanoDeSaude plano = new PlanoDeSaude();
//			MainPlanoDeSaude.listaDePlanosCadastrados().add(plano);
//		}
		
		
		for (PlanoDeSaude plano : listaDePlanosDeSaude) {
			i++;
			System.out.println(i + " - " + plano.getNomeDoPlano());
		}
	}
	
	// Ler o valor digitado pelo usuario e verifica se ele eh um numero, caso
	// seja uma letra o programa eh fechado
	private static int lerValor() {
		while (true) {
			try {
				Integer numero = 0;
				numero = Integer.valueOf(input.nextLine());
				return numero;
			} catch (java.lang.NumberFormatException nfe) {
				System.out.println("Erro ao digitar numero");
				System.out.println("Digite novamente");
				System.out.print("> ");
			}
		}
	}
}
