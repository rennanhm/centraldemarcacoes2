package interfaceUsuario;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import persistencia.GravaLerPlanoDeSaude;
import Medico.Especialidade;
import PlanoDeSaude.PlanoDeSaude;

/**
 * 
 * @author Grupo 7
 *
 */
public class MainPlanoDeSaude {
	private static final int NUMERO_DE_OPCOES = 4;
	private static Scanner input;
	private	static List<PlanoDeSaude> listaDePlanosDeSaude;
	private static int opcao;
	private static Double valor;
	private static String nome;
	private static String telefone;
	
	
	public static void main(String[] args) throws Exception {
		
		try{
			listaDePlanosDeSaude = GravaLerPlanoDeSaude.lerPlanoDeSaude(listaDePlanosDeSaude);
		}catch (Exception e){
			listaDePlanosDeSaude = new ArrayList<PlanoDeSaude>();
			listaDePlanosDeSaude.add(new PlanoDeSaude());
		}
		
	
		
		do {
			printMenu();
			System.out.print("> ");
			opcao = lerValor();

			switch (opcao) {
			case 1:
				mudaPreco();
				break;
			case 2:
				adicionaPlano();
				break;
			case 3:
				imprimePlanosCadastrados();
				break;
			case 4:
				break;
			default:
				System.out.println("Opcao invalida digite novamente!");
				break;
			}
			GravaLerPlanoDeSaude.gravaPlanoDeSaude(listaDePlanosDeSaude);
		} while (opcao != NUMERO_DE_OPCOES);
	}
	
	
	public static List<PlanoDeSaude> listaDePlanosCadastrados(){
            try{
			listaDePlanosDeSaude = GravaLerPlanoDeSaude.lerPlanoDeSaude(listaDePlanosDeSaude);
		}catch (Exception e){
			listaDePlanosDeSaude = new ArrayList<PlanoDeSaude>();
			listaDePlanosDeSaude.add(new PlanoDeSaude());
		}
            return listaDePlanosDeSaude;
	}


	private static void printMenu(){
		StringBuilder sb = new StringBuilder();
		sb.append("\nEscolha uma das opcoes\n");
		sb.append("\n1 - Alterar preco de uma consulta particular.");
		sb.append("\n2 - Cadastrar novo plano de saude.");
		sb.append("\n3 - Lista de planos cadastrados.");
		sb.append("\n4 - Voltar.");
		System.out.println(sb.toString());
	}
	
	private static void mudaPreco() throws Exception {
		Especialidade especialidade;
		int opcao;

		System.out.println("\nEscolha o numero da especialidade que deseja alterar o preco:\n");
		

		for (int i = 0; i < Especialidade.values().length; i++) {
			System.out.println(i + 1 + " - " + Especialidade.values()[i]);
		}
		
		System.out.print("> ");
		opcao = lerValor();
		

		if (opcao <= Especialidade.values().length) {
			especialidade = Especialidade.values()[opcao - 1];
			System.out.println("Novo valor: ");
			System.out.print("> ");
			Double novoPreco = (double) lerValor();
			while (novoPreco <= 0){
				System.out.println("Valor invalido digite novamente");
				System.out.print("> ");
				novoPreco = (double) lerValor();
			}
			especialidade.setValorDaConsulta(novoPreco);
		} else {
			throw new Exception("Especialidade nao existe");
		}
		
	}
	
	private static void adicionaPlano() throws Exception {
		System.out.println("Qual o nome do plano?");
		System.out.print("> ");
		nome = input.nextLine();
		
		System.out.println("Qual o preco do plano que deseja adicionar?");
		System.out.print("> ");
		valor = (double) lerValor();
		
		
		System.out.println("Qual e o telefone(Da forma (xx)xxxx-xxxx )?:");
		System.out.print("> ");
		telefone = input.next();
		try{
		listaDePlanosDeSaude.add(new PlanoDeSaude(nome, valor, telefone));
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		System.out.println("Plano adicionado com sucesso");
	}
	
	
	private static void imprimePlanosCadastrados(){
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < listaDePlanosDeSaude.size(); i++){
			sb.append(i + 1 + " - " + listaDePlanosDeSaude.get(i).getNomeDoPlano() + "\n");
		}
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
}