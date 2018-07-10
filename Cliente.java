package FWInternetBanking;

public class Cliente {
	
	private String nome;
	private String cpf;
	private enum tipoCliente { 
		TIPO1,TIPO2,TIPO3
	}
	
	public Cliente(String nome, String cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
}

