package dados.repositorio.interfaces;

import modelo.cliente.Cliente;

public interface IRepCliente {
    
    public static final int TAM_CACHE_CLIENTES = 100;
    public void inserir(Cliente cliente);
    public void remover(Cliente cliente);
    public void atualizar(Cliente cliente);
    public Cliente procurar(String cpf);
    public int procurarIndice(String cpf);
    public boolean existe(String cpf);
	
}
