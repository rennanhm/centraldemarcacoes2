package Paciente;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe de Endereco. Cria um objeto do tipo endereco com base na rua,
 * complemento, bairro, cidade, estado, cep e numero.
 * 
 * @author Grupo 7
 * 
 */
public class EnderecoDoPaciente {

	private String rua, complemento, bairro, cidade, estado, cep;
	private int numero;

	/**
	 * Cria um objeto do tipo Endereco a partir da rua, complemento, bairro,
	 * cidade, estado, cep e numero.
	 * 
	 * @param rua
	 *            Rua ou Avenida
	 * @param complemento
	 *            Complemento (pode ser vazio ou nao)
	 * @param bairro
	 *            Bairro
	 * @param cidade
	 *            Cidade
	 * @param estado
	 *            Estado
	 * @param cep
	 *            CEP
	 * @param numero
	 *            Numero da residencia
	 * @throws Exception
	 *             Se algum atributo for nulo, se o numero for menor ou igual a
	 *             zero ou se o formato do cep for invalido.
	 */
	public EnderecoDoPaciente(String rua, String complemento, String bairro,
			String cidade, String estado, String cep, int numero)
			throws Exception {
		

		if (rua.trim().length() == 0 || bairro.trim().length() == 0
				|| cidade.trim().length() == 0 || estado.trim().length() == 0
				|| numero < 0) {
			throw new Exception("Endereco invalido.");
		} else if (testaCep(cep) == false) {
			throw new Exception("CEP invalido.");
		}

		this.rua = rua;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		this.numero = numero;
	}
	
	private boolean testaCep(String cep){
		Pattern padrao = Pattern.compile("[0-9]{5}\\-?[0-9]{3}");
		Matcher pesquisa = padrao.matcher(cep);
		
		if (pesquisa.matches()){
			return true;
		}else{
			return false;
		}
		
	}

	/**
	 * Retorna a rua
	 * 
	 * @return Rua
	 */
	public String getRua() {
		return rua;
	}

	/**
	 * Muda a rua para a passada como parametro.
	 * 
	 * @param rua
	 *            Nova rua
	 */
	public void setRua(String rua) {
		if (!(rua.length() == 0)){
			this.rua = rua;
		}
	}

	/**
	 * Retorna o complemento
	 * 
	 * @return Complemento
	 */
	public String getComplemento() {
		return complemento;
	}

	/**
	 * Muda o complemento para o passado como parametro
	 * 
	 * @param complemento
	 *            Novo complemento do endereco
	 */
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	/**
	 * Retorna o Bairro
	 * 
	 * @return Bairro
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * Muda o bairro para o passado como parametro
	 * 
	 * @param bairro
	 *            Bairro
	 */
	public void setBairro(String bairro) {
		if (!(bairro.length() == 0)){
			this.bairro = bairro;
		}
	}

	/**
	 * Retorna a cidade
	 * 
	 * @return cidade
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * Muda a cidade para a passada como parametro
	 * 
	 * @param cidade
	 *            Nova cidade
	 */
	public void setCidade(String cidade) {
		if (!(cidade.length() == 0)){
			this.cidade = cidade;
		}
	}

	/**
	 * Retorna o estado
	 * 
	 * @return Estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * Muda o estado para o passado como parametro
	 * 
	 * @param estado
	 *            novo estado
	 */
	public void setEstado(String estado) {
		if (!(estado.length() == 0)){
			this.estado = estado;
		}
	}

	/**
	 * Retona o cep
	 * 
	 * @return CEP
	 */
	public String getCep() {
		return cep;
	}

	/**
	 * Muda o cep para o passado como parametro
	 * 
	 * @param cep
	 *            Novo Cep
	 */
	public void setCep(String cep) {
		if (testaCep(cep)){
			this.cep = cep;
		}
	}

	/**
	 * Retorna o numero da residencia
	 * 
	 * @return Numero da residencia
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * Muda o numero da residencia para o passado como parametro
	 * 
	 * @param numero
	 *            Novo numero
	 */
	public void setNumero(int numero) {
		if (numero > 0){
			this.numero = numero;
		}
	}

	/**
	 * Retona uma string com a rua, complemento, bairro, cidade, estado, cep e
	 * numero.
	 */
	public String toString() {
		return "Rua/avenida: " + rua + ", Complemento: " + complemento
				+ ", Bairro: " + bairro + ", Cidade: " + cidade + ", Estado: "
				+ estado + ", CEP: " + cep + ", Numero: " + numero;
	}

}
