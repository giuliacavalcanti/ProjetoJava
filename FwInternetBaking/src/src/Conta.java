package src;

public class Conta extends ContaAbstrata  {
	public Conta(double saldo, String numero) {
		super(saldo, numero);
	}
	
	@Override
	public void debitar(double valor) {
		this.setSaldo(this.getSaldo() - valor);
		//System.out.println("Valor " + valor + " foi debitado \n");
	}
	
}