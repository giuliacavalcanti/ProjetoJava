package modelo.gerente;

import br.com.framework.EntidadeGenerica;


public class GerenteCliente extends EntidadeGenerica{

	private int gerenteId;
	private String clienteCpf;
	
	
	public GerenteCliente(String id, int gerenteId, String clienteCpf) {
		super(id);
		this.gerenteId = gerenteId;
		this.clienteCpf = clienteCpf;
	}

	public int getGerenteId() {
		return gerenteId;
	}

	public void setGerenteId(int gerenteId) {
		this.gerenteId = gerenteId;
	}

	public String getClienteCpf() {
		return clienteCpf;
	}

	public void setClienteCpf(String clienteCpf) {
		this.clienteCpf = clienteCpf;
	}
	
}
