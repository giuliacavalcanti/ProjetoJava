package modelo.conta;

import exception.conta.SaldoInsuficienteException;
import modelo.cliente.Cliente;

public class ContaImposto extends Conta{

	private static final double taxa = 0.001;
	
	public ContaImposto(double saldo, String numero,Cliente cliente) {
		super(saldo, numero,cliente);
		// TODO Auto-generated constructor stub
	}

	public void debitar(double valor) throws SaldoInsuficienteException {
		double imposto = valor * taxa;
		double saldo = this.getSaldo();
		if(saldo >= valor + imposto) {
			this.setSaldo(saldo - (valor + imposto));
		} else {
			SaldoInsuficienteException sie = new SaldoInsuficienteException(saldo, valor);
			throw sie;
		}
				
		
	}
}
