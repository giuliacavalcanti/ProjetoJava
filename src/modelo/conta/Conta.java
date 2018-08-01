package modelo.conta;

import javax.persistence.*;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.framework.EntidadeGenerica;
import exception.conta.SaldoInsuficienteException;
import java.io.Serializable;
import modelo.cliente.Cliente;

@Entity
@Table(name="tb_conta")


public abstract class Conta extends EntidadeGenerica implements Serializable {
    //private double saldo;
    //private Cliente cliente;
    
    @Id
    @Column(
    		name = "numero") 
    private String numero;
    
    
    @Column(
    		name = "saldo")
    private double saldo;
   
    @ManyToOne(
		fetch = FetchType.EAGER
		)
		@JoinColumn(
		name= "tb_cliente_cpf"
		)
	private Cliente cliente;
    
   public Conta() {
	  super("");
   }
    
    public Conta(double saldo, String numero,Cliente cliente,String id) {
            super(id);
            this.saldo = saldo;
            this.cliente = cliente;
            this.numero=numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    

    public double getSaldo() {
            return saldo;
    }

    public void setSaldo(double saldo) {
            this.saldo = saldo;
    }

    public void creditar(double valor) {

            this.saldo += valor;
    }

    public abstract void debitar(double valor) throws SaldoInsuficienteException;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public void transferir(Conta conta_destino, double valor) throws SaldoInsuficienteException {
    	
            this.debitar(valor);
            conta_destino.creditar(valor);
       
    }
        
}
