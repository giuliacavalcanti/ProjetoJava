package exception.conta;

import util.UtilProperties;

public class ContaInexistenteException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7656902244148927750L;

	public ContaInexistenteException() {
		super(UtilProperties.getException("ContaInexistenteException"));
	}

}
