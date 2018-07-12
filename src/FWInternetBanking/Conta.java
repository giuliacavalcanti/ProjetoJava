package FWInternetBanking;

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

	public void creditar(double valor) {
		
		this.saldo += valor;
	}
	
	public void debitar(double valor) {
		
		this.saldo -= valor;
	}
	
	public void transferir(Conta destino,double valor) {
	
		if(this.saldo > valor) {
			this.debitar(valor);
			destino.creditar(valor);
			System.out.println("Transferência feita com sucesso!");
		} else {
			System.out.println("Conta:" + this.numero + " " + "com saldo insuficiente!");
		}
		
	}
	
}
