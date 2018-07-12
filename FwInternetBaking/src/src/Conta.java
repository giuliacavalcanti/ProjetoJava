package src;

public class Conta {
	private double saldo;
	private String numero;
	
	public Conta(double saldo, String numero) {
		super();
		this.saldo = saldo;
		this.numero = numero;
	}
	

	public double getSaldo() {
		return saldo;
	}

	public String getNumero() {
		return numero;
	}

	public void debitar(double valor) {
		this.saldo = this.saldo - valor;
		System.out.println("Valor " + valor + " foi debitado \n");
	}
	
	public void creditar(double valor) {
		this.saldo = this.saldo + valor;
		System.out.println("Valor " + valor + " foi creditado \n");
	}

	public void transferir(Conta conta_destino, double valor) {
		if (this.saldo >= valor ) {
			this.debitar(valor);
			conta_destino.creditar(valor);
		}
		else {
			System.out.println("A conta " + this.numero + " nao possui saldo suficiente");
		}
	}
	
}
