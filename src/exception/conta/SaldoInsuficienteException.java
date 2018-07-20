package exception.conta;

import exception.generic.ExceptionGenerica;

public class SaldoInsuficienteException extends ExceptionGenerica {

	private double saldo;
	private double valor;
	
	public SaldoInsuficienteException(double saldo, double valor) {
		this.saldo = saldo;
		this.valor = valor;
		errMsg = "Saldo Insuficiente! - Saldo:" + this.saldo + "Valor:" + this.valor;
	}

	public String getErrMsg() {
		return errMsg;
	}

	
}
