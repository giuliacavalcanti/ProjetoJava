package src;

public interface IRepCliente {
	public void inserir(Cliente cliente);
	public void remover(Cliente cliente);
	public void atualizar(Cliente cliente);
	public boolean existe(String Cpf);
	public Cliente procurar_cliente(String Cpf);
}
