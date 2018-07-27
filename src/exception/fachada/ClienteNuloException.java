package exception.fachada;

import util.UtilProperties;

public class ClienteNuloException extends Exception{
    /**
	 * 
	 */
	private static final long serialVersionUID = 6616909888957909968L;

	public ClienteNuloException() {
		super(UtilProperties.getException("ClienteNuloException"));
	
	}
}
