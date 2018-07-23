package modelo.cliente;

import java.util.ArrayList;

import javax.persistence.*;

import br.com.framework.EntidadeGenerica;
import modelo.conta.Conta;

@Entity
@Table (name= "tb_cliente")
public class Cliente extends EntidadeGenerica implements Comparable<Cliente> {
	
    @Column ( name="nome")
    private String nome;
    
    @OneToOne(
        cascade = CascadeType.ALL
    )
    @PrimaryKeyJoinColumn
    private Endereco endereco;
    
    
    private TipoCliente tipo;
    
    @Id
    @Column ( name="cpf")
    private String cpf;

    public Cliente(String nome, String cpf,String cep,int numero,TipoCliente tipo,String id) {
            super(id);
            this.cpf=cpf;
            this.nome = nome;
            endereco = new Endereco(cep,numero);
            this.tipo = tipo;
    }
    
   @OneToMany(
		   mappedBy="cliente",
		   fetch = FetchType.LAZY
		   )
   private ArrayList<Conta> contas;

    public Cliente() {
        super("");
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

