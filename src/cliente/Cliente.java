package cliente;

public class Cliente {
	
	private String nome;
	private String cpf;
        private Endereco endereco;
	private EnumCliente tipo;
	
	public Cliente(String nome, String cpf,String rua,String cep,int numero,EnumCliente tipo) {
		super();
		this.nome = nome;
		this.cpf = cpf;
                endereco = new Endereco(rua,cep,numero);
                this.tipo = tipo;
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public EnumCliente getTipo() {
        return tipo;
    }

    public void setTipo(EnumCliente tipo) {
        this.tipo = tipo;
    }

}

