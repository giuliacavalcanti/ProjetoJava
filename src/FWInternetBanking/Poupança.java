package FWInternetBanking;

public class Poupan�a extends Conta{

	public Poupan�a(double saldo, String numero) {
		super(saldo, numero);
	
	}
	
	public void renderJuros(double taxa) {
		
		double saldoAtual = getSaldo();
		creditar(saldoAtual * taxa);
		
	}
}
