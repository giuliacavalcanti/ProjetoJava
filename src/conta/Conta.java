package conta;

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

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void creditar(int valor) {
		
		this.saldo += valor;
	}
	
	public void debitar(int valor) {
		
		this.saldo -= valor;
	}
	
}
