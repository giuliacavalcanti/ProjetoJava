package conta;

public abstract class Conta {

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

	public void creditar(double valor) {
		
		this.saldo += valor;
	}
	
	public abstract void debitar(double valor);
	
}
