package modelo.conta;

import br.com.framework.EntidadeGenerica;
import exception.conta.SaldoInsuficienteException;
import modelo.cliente.Cliente;

public abstract class Conta extends EntidadeGenerica {

    private double saldo;
    private Cliente cliente;
    
    public Conta(double saldo, String numero,Cliente cliente) {
    		super(numero);
            this.saldo = saldo;
            this.cliente = cliente;
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
