package cadcliente;

import cliente.Cliente;
import repositorio.interfaces.IRepCliente;


public class CadCliente{
	
	public void inserir(Cliente cliente, IRepCliente irepcliente) {
		if(irepcliente.getIndice() == irepcliente.getTamCacheContas()){
			System.out.println("Repositorio de Clientes cheio");
		}
		else if(irepcliente.existe(cliente.getCpf()) == true) {
			System.out.println("A cliente " + cliente.getCpf() + " ja existe");
		}
		else {
			irepcliente.inserir(cliente);
			System.out.println("A cliente " + cliente.getCpf() + " inserida com suceso");

		}
	}
	
	public void remover(Cliente cliente, IRepCliente irepcliente) {
		if(irepcliente.existe(cliente.getCpf()) == true) {
			irepcliente.remover(cliente);
			System.out.println("A cliente " + cliente.getCpf() + " removida com sucesso");

		}
		else {
			System.out.println("A cliente " + cliente.getCpf() + " nao existe");
		}
	}
	
	public void atualizar(Cliente cliente, IRepCliente irepcliente) {
		if(irepcliente.existe(cliente.getCpf()) == true) {
			irepcliente.atualizar(cliente);
			System.out.println("A cliente " + cliente.getCpf() + " atualizada com sucesso");
		}
		else {
			System.out.println("A cliente " + cliente.getCpf() + " nao existe");
		}
	}
}

