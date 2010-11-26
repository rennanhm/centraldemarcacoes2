package Paciente;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pessoa {
	
	private String nome;
	private String cpf;
	private EnderecoDoPaciente endereco;
	private TelefoneDeContato telefone;
	private String Idade;
	
	public Pessoa(String nome, String cpf, String Idade,
			      EnderecoDoPaciente endereco,
			      TelefoneDeContato telefone) throws Exception{
		try{
			if (nome.length() > 0 && nome != null){
				this.nome = nome;
			}
		}catch (Exception e){
			throw new Exception("Nome invalido");
		}
		
		try{
			Pattern padrao = Pattern
			.compile("[0-9]{3}\\.?[0-9]{3}\\.?[0-9]{3}\\-?[0-9]{2}");
			Matcher pesquisa = padrao.matcher(cpf);
			if (pesquisa.matches()){
				this.cpf = cpf;
			}
		}catch (Exception e){
			throw new Exception("Nome invalido");
		}
		
		this.Idade = Idade;
		this.endereco = endereco;
		this.telefone = telefone;
	}
	
	public String getNome(){
		return nome;
	}
	
	public String getCpf(){
		return cpf;
	}
	
	public String Idade(){
		return Idade;
	}

	public EnderecoDoPaciente getEndereco() {
		return endereco;
	}

	public TelefoneDeContato getTelefone() {
		return telefone;
	}

	public String getIdade() {
		return Idade;
	}
	
	

}
