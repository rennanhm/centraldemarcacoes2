package Paciente;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe de Telefones. Cria um objeto a partir do telefone passado como parametro.
 * 
 * @author Grupo 7
 * 
 */
public class TelefoneDeContato {
	
	private String telefone;

	/**
	 * 
	 * @param telefone Telefone do contato.
	 * @throws Exception Se o telefone apresentar formato invalido.
	 */
	public TelefoneDeContato(String telefone) throws Exception {
		
		if (testaTelefone(telefone) == false){
			throw new Exception ("Telefone residencial invalido");
		}
		
		this.telefone = telefone;
		
	}
	
	private boolean testaTelefone(String telefone) {
		Pattern padrao = Pattern.compile("\\([0-9]{2}\\)[0-9]{4}\\-?[0-9]{4}");
		Matcher pesquisa = padrao.matcher(telefone);
		if (pesquisa.matches() || telefone.length() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Retorna o telefone.
	 * @return telefone.
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * Muda o telefone para o passado como parametro.
	 * @param telefone Novo telefone.
	 */
	public void setTelefone(String telefone) {
		if (testaTelefone(telefone)){
			this.telefone = telefone;
		}
	}
	
	/**
	 * Retorna uma string que representa o telefone.
	 */
	public String toString() {
		return "Telefone: " + telefone;
	}

}
