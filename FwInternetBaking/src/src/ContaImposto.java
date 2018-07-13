package src;

public class ContaImposto extends ContaAbstrata {

	private ContaImposto(double saldo, String numero) {
		super(saldo, numero);
	}

	@Override
	public void debitar(double valor) {
		this.setSaldo((this.getSaldo() - valor) * 2.4);
		
	}

}
