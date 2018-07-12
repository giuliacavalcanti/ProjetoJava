package src;

public class RepositorioClienteArray {
	public static final int TAM_CACHE_CLIENTE = 100;
	private int indice;
	private Cliente[] clientes = new Cliente[TAM_CACHE_CLIENTE];
	
	
	
	
	public RepositorioClienteArray(int indice, Cliente[] clientes) {
		super();
		this.indice = indice;
		this.clientes = clientes;
	}

	public void inserir(Cliente cliente) {
		int posicao_array;
		posicao_array = procura_indice(cliente.getCpf());
		if(posicao_array == -1) {
			clientes[indice] = cliente;
			indice++;
		}
		else {
			return;
		}
	}
	
	public void remover(Cliente cliente) {
		int posicao_array;
		posicao_array = procura_indice(cliente.getCpf());
		if(posicao_array == -1) {
			return;
		}
		else {
			clientes[posicao_array] = clientes[indice];
			clientes[indice] = null;
			return;
		}
	}
	
	public void atualizar(Cliente cliente) {
		int posicao_array;
		posicao_array = procura_indice(cliente.getCpf());
		if(posicao_array == -1) {
			clientes[posicao_array] = cliente;
		}
		else {
			return;
		}
	}
	
	
	
	
	private int procura_indice(String Cpf){
		for(int busca_indice = 0; busca_indice < TAM_CACHE_CLIENTE; busca_indice++) {
			if(clientes[busca_indice] == null) {
				return -1;
			}
			else if(clientes[busca_indice].getCpf().equals(Cpf) == true) {
				return busca_indice;
			}
		}
		return -1;
	}
	
	public boolean existe(String Cpf) {
		int posicao_array;
		posicao_array = procura_indice(Cpf);
		if(posicao_array == -1) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public Cliente procurar_cliente(String Cpf) {
		int posicao_array;
		posicao_array = procura_indice(Cpf);
		if(posicao_array == -1) {
			return null;
		}
		else {
			return clientes[posicao_array];
		}
	}
}
		
