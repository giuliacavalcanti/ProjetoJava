package FWInternetBanking;

public class Cliente {
	
	private String nome;
	private String cpf;
	private TipoCliente tipoCliente;
	private Endereço endereço;
	
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

