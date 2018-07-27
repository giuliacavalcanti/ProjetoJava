package exception.conta;

import util.UtilProperties;

public class SaldoInsuficienteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6338797796805054775L;

	public SaldoInsuficienteException(double saldo, double valor) {
		super(UtilProperties.getException("SaldoInsuficenteException"));
	
	}

	
}
