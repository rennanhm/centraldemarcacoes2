package Medico;
/**
 * Valores possiveis para dias. Usado para criar a semana de trabalho do medico.
 * 
 * @author Grupo 7
 * 
 */
public enum Semana {
	DOMINGO(0,"Domingo"), SEGUNDA(1,"Segunda"), TERCA(2,"Terca"), QUARTA(3,"Quarta"), QUINTA(4,"Quinta"), SEXTA(5,"Sexta"), SABADO(6,"Sabado");

	private int posicaoNaSemana;
	private String nomeDia;

	private Semana(int posicaoNaSemana, String nomeDia){
		this.posicaoNaSemana = posicaoNaSemana;
		this.nomeDia = nomeDia;
	}

	/**
	 * Acessa a posicao do dia da semana.
	 * @return O int equivalente ao dia da semana. 
	 */
	public int getPosicaoNaSemana(){
		return this.posicaoNaSemana;
	}
	/**
	 * Acessa o nome do dia.
	 * @return O nome por extenso.
	 */
	public String getNomeDia() {
		return this.nomeDia;
	}

}