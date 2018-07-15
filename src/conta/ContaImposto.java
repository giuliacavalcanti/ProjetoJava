package conta;

public class ContaImposto extends Conta{

	private static final double taxa = 0.001;
	
	public ContaImposto(double saldo, String numero) {
		super(saldo, numero);
		// TODO Auto-generated constructor stub
	}

	public void debitar(double valor) {
		double imposto = valor * taxa;
		double saldo = this.getSaldo();
		if(saldo >= valor + imposto) {
			this.setSaldo(saldo - (valor + imposto));
		} else {
			System.out.println("Saldo insuficiente");
		}
				
		
	}
}
