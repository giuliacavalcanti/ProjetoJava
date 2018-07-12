package FWInternetBanking;

public class Poupança extends Conta{

	public Poupança(double saldo, String numero) {
		super(saldo, numero);
	
	}
	
	public void renderJuros(double taxa) {
		
		double saldoAtual = getSaldo();
		creditar(saldoAtual * taxa);
		
	}
}
