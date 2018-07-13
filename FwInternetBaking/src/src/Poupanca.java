package src;

public class Poupanca extends Conta {
	
	public Poupanca(double saldo, String numero) {
		super(saldo, numero);
	}
	
	public void renderJuros(double taxa) {
		double saldoAtual = getSaldo();
		creditar(saldoAtual*taxa);
	}

}
