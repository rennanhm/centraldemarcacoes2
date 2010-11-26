package PlanoDeSaude;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Classe PlanoDeSaude onde se localisa o preco do plano, o nome do plano e telefone do plano.
 * @author Grupo 7
 *
 */
public class PlanoDeSaude {
	
	private final String STRING_VAZIA = "";

	private Double precoDoPlano;
	private String nomeDoPlano;
	private String telefoneDoPlano;
	
	/**
	 * Constroi um plano de saude
	 */
	public PlanoDeSaude() {
		this.nomeDoPlano = "Particular";
	}
	
	/**
	 * Atribui o nome e o preco do plano
	 * @param nomeDoPlano Nome do plano
	 * @param precoDoPlano Preco do plano
	 * @param telefoneDoPlano Telefone do plano
	 * @throws Exception Caso nome seja vazio ou preco seja menor ou igual a zero e se o telefone nao tiver no padrao (nn)nnnn-nnnn
	 */
	public PlanoDeSaude(String nomeDoPlano, Double precoDoPlano, String telefoneDoPlano) throws Exception {
		if (nomeDoPlano.equals(STRING_VAZIA) || nomeDoPlano == null) {
			throw new Exception(
					"O nome do plano nao pode ser nulo ou vazio.");
		}
		else if (precoDoPlano < 0){
			throw new Exception("Preco nao pode ser menor ou igual a zero.");
		}
		
		else if (!testaTelefone(telefoneDoPlano)){
			throw new Exception("Formato de telefone residencial invalido.");
		}
		
		this.nomeDoPlano = nomeDoPlano;
		this.precoDoPlano = precoDoPlano;
		this.telefoneDoPlano = telefoneDoPlano;
		
	}

	
	
	/**
	 * Recupera o preco do plano.
	 * @return Retorna o preco do plano.
	 */
	public Double getPrecoDoPlano() {
		return precoDoPlano;
	}

	/**
	 * Recupera o nome do plano.
	 * @return O nome do plano.
	 */
	public String getNomeDoPlano() {
		return nomeDoPlano;
	}
	

	/**
	 * Recupera o telefone do plano.
	 * @return Telefone do plano.
	 */
	public String getTelefoneDoPlano() {
		return telefoneDoPlano;
	}

	/**
	 * Muda o telefone do plano.
	 * @param telefoneDoPlano Novo telefone do plano.
	 * @throws Exception Caso o telefone esteja no formato errado.
	 */
	public void setTelefoneDoPlano(String telefoneDoPlano) throws Exception {
		if (!testaTelefone(telefoneDoPlano)){
			throw new Exception("Formato de telefone residencial invalido.");
		}
		this.telefoneDoPlano = telefoneDoPlano;
	}

	/**
	 * Muda o preco do plano
	 * @param precoDoPlano Novo preco do plano
	 */
	public void setPrecoDoPlano(Double precoDoPlano) {
		this.precoDoPlano = precoDoPlano;
	}

	/**
	 * Representacao do objeto em forma de string
	 */
	public String toString(){
		return "Nome: " + nomeDoPlano + " - preco: " + precoDoPlano + " - telefone: " + telefoneDoPlano ;
	}
	
	private boolean testaTelefone(String telefone){
		Pattern padrao = Pattern.compile("\\([0-9]{2}\\)[0-9]{4}\\-?[0-9]{4}");
		Matcher pesquisa = padrao.matcher(telefone);
		if (pesquisa.matches()){
			return true;
		}
		return false;
	}
	
}
