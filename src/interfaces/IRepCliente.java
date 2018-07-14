package interfaces;

import cliente.Cliente;

public interface IRepCliente {
	
    public Cliente[] getClientes();
    public void setClientes(Cliente[] clientes);
    public int getIndice();
    public void setIndice(int indice); 
    public void inserir(Cliente cliente);
    public void remover(Cliente cliente);
    public void atualizar(Cliente cliente);
    public Cliente procurar(String cpf);
    public int procurarIndice(String cpf);
    public boolean existe(String cpf);
	
}
