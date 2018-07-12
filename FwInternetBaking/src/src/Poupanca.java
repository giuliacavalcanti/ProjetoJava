package src;

public class Poupanca extends Conta {
	public Poupanca(String numero, double saldo) {
		super(saldo, numero);
	}
	
	public void renderJuros(double taxa) {
		double saldoAtual = getSaldo();
		creditar(saldoAtual*taxa);
	}

}
