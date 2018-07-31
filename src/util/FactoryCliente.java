package util;

import dados.repositorio.array.RepositorioClientesArray;
import dados.repositorio.interfaces.IRepCliente;
import dados.repositorio.jdbc.clientedao.DaoCliente;
import dados.repositorio.serializacao.RepositorioClientesSer;
import dados.repositorio.treeset.RepositorioClientesTreeset;

public class FactoryCliente {
	
	public IRepCliente verificarRepositorio(int valor) {
		
		IRepCliente repo;
		
		switch (TipoRepo.forInt(valor)) {
		case ARRAY:
			repo = instanciarRepClientesArray();
			break;
		case TREESET:
			repo = instanciarRepClientesTreeset();
			break;
		case JDBC:
			repo = instanciarRepClientesJDBC();
			break;
		case SERIAL:
			repo = instanciarRepClientesSer();
			break;
		
		default:
			repo = null;
		}
		
		return repo;
		
	}
	
	public RepositorioClientesArray instanciarRepClientesArray() {
		
		return new RepositorioClientesArray();
	}
	
	public DaoCliente instanciarRepClientesJDBC() {
		
		return new DaoCliente();
	}

	public RepositorioClientesTreeset instanciarRepClientesTreeset() {
	
		return new RepositorioClientesTreeset();
	}
	
	public RepositorioClientesSer instanciarRepClientesSer() {
		
		return new RepositorioClientesSer();
	}
	
	
}
