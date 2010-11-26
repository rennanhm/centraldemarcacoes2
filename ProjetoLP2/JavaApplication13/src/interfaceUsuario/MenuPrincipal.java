package interfaceUsuario;

import java.util.Scanner;

public class MenuPrincipal {
	private static Scanner input;
	private static final int NUMERO_DE_OPCOES = 5;
	private static int opcao;
	
	public static void main(String[] args) {
		input = new Scanner(System.in);
		
		do {
			printMenu();
			System.out.print("> ");
			opcao = lerValor();
			
			switch (opcao) {
			case 1:
				try{
				MainMedico.main(null);
				}catch(Exception e){
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				try{
					MainPaciente.main(null);
					}catch(Exception e){
						System.out.println(e.getMessage());
					}
				break;
			case 3:
				try{
					MainPlanoDeSaude.main(null);
					}catch(Exception e){
						System.out.println(e.getMessage());
					}
				break;
			case 4:
				try{
					MainSecretaria.main(null);
				}catch(Exception e){
					System.out.println(e.getMessage());
				}
				break;
			default:
				break;
			}
		}while(opcao != NUMERO_DE_OPCOES);

		System.out.println("Obrigado.");
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
	
	public static void printMenu(){
		StringBuilder sb = new StringBuilder();
		sb.append("\nEscolha uma das opcoes\n");
		sb.append("\n1 - Acesso aos Medicos.");
		sb.append("\n2 - Acesso aos Pacientes.");
		sb.append("\n3 - Acesso aos Planos de Saude.");
		sb.append("\n4 - Acesso a Secretaria.");
		sb.append("\n5 - SAIR.");
		System.out.println(sb.toString());
	}
}