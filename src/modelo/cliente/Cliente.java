package modelo.cliente;

import br.com.framework.EntidadeGenerica;

public class Cliente extends EntidadeGenerica implements Comparable<Cliente> {
	
	private String nome;
    private Endereco endereco;
	private TipoCliente tipo;
	
	public Cliente(String nome, String cpf,String rua,String cep,int numero,TipoCliente tipo) {
		super(cpf);
		this.nome = nome;
		endereco = new Endereco(rua,cep,numero);
		this.tipo = tipo;
	}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public TipoCliente getTipo() {
        return tipo;
    }

    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo;
    }

    @Override
    public int compareTo(Cliente c) {
       return this.getNome().compareTo(c.getNome());
    }
}

