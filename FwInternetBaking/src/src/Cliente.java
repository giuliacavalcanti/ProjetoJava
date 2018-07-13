package src;

public class Cliente implements CadastraCliente {
	private String nome;
	//private Endereco endereco;
	private String Cpf;
	
	public String getNome() {
		return nome;
	}

	/*public Endereco getEndereco() {
		return endereco;
	}*/

	public String getCpf() {
		return Cpf;
	}

	public Cliente(String nome,String cpf) {
		super();
		this.nome = nome;
		//this.endereco = endereco;
		Cpf = cpf;
	}
	
}
