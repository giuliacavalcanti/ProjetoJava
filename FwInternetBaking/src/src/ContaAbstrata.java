package src;

public abstract class ContaAbstrata implements Cadastro_Conta {
	private double saldo;
	private String numero;
	
	public ContaAbstrata(double saldo, String numero) {
		super();
		this.saldo = saldo;
		this.numero = numero;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	

	public double getSaldo() {
		return saldo;
	}

	public String getNumero() {
		return numero;
	}

	public abstract void debitar(double valor);
	
	public void creditar(double valor) {
		this.saldo = this.saldo + valor;
		//System.out.println("Valor " + valor + " foi creditado \n");
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
