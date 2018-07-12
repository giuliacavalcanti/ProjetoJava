package FWInternetBanking;

public class RepositorioClienteArray {
	

	public static final int TAM_CACHE_CLIENTES = 100;
	private Cliente[] clientes;
	private int indice;
	
	public RepositorioClienteArray(Cliente[] clientes, int indice) {
		super();
		this.clientes = clientes;
		this.indice = indice;
	}
	
public void inserir(Cliente cliente) {
		
		int n;
		
		for(n=0;n<TAM_CACHE_CLIENTES;n++) {
			
			if(clientes[n] == null) {
				clientes[n] = cliente;
				this.indice += 1;
				System.out.println("Cliente:" + cliente.getNome() + " inserido com sucesso");
				return;
				
			}
			
		} 
		
		System.out.println("Cliente:" + cliente.getNome() + " não foi possivel fazer a inserção");			
		
	}
	
	public void atualizar(Cliente cliente) {
		
		int n;
		for(n=0;n<TAM_CACHE_CLIENTES;n++) {
			if (clientes[n].getCpf().equals(cliente.getCpf())) {
				clientes[n] = cliente;
				System.out.println("Cliente:" + cliente.getCpf() + " atualizado");
				return;
			} 
		}
		System.out.println("Cliente:" + cliente.getCpf() + " não encontrado");
			
	}
	
}
