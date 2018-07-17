package modelo.conta;

import modelo.cliente.Cliente;

public abstract class Conta {

    private double saldo;
    private String numero;
    private Cliente cliente;

    public Conta(double saldo, String numero,Cliente cliente) {
            super();
            this.saldo = saldo;
            this.numero = numero;
            this.cliente = cliente;
    }

    public double getSaldo() {
            return saldo;
    }

    public void setSaldo(double saldo) {
            this.saldo = saldo;
    }

    public String getNumero() {
            return numero;
    }

    public void setNumero(String numero) {
            this.numero = numero;
    }

    public void creditar(double valor) {

            this.saldo += valor;
    }

    public abstract void debitar(double valor);

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public void transferir(Conta conta_destino, double valor) {
        if (this.saldo >= valor) {
            this.debitar(valor);
            conta_destino.creditar(valor);
        } else {
            System.out.println("A conta " + this.numero + " nao possui saldo suficiente");
        }
    }
        
}
