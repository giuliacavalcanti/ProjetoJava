package exception.conta;

public class SaldoInsuficienteException extends Exception {

	public SaldoInsuficienteException(double saldo, double valor) {
		super("Saldo Insuficiente! Saldo:" + saldo + "Valor:" + valor);
	
	}

	
}
