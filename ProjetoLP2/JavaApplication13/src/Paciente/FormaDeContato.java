package Paciente;
/**
 * Enum dos valores Possiveis de tipos de Contatos. Usado para criar os tipos de contatos
 * dos pacientes cadastrados.
 * @author Grupo 7
 */
public enum FormaDeContato{
	
	TELEFONE_RESIDENCIAL("Telefone residencial"),
	TELEFONE_COMERCIAL("Telefone comercial"), 
	TELEFONE_CELULAR("Telefone celular"), 
	EMAIL("Email");
	
	private String nome;
	
	private FormaDeContato(String nome){
		this.nome = nome;
	}
	
	/**
	 * Acessa o nome do tipo de contado
	 * @return Qual o tipo de contato.
	 */
	
	public String getNome(){
		return this.nome;
	}
	
}
