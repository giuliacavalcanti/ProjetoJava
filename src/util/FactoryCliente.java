package util;

import dados.repositorio.array.RepositorioClientesArray;
import dados.repositorio.interfaces.IRepCliente;
import dados.repositorio.jdbc.clientedao.DaoCliente;
import dados.repositorio.treeset.RepositorioClientesTreeset;

public class FactoryCliente {
	
	public IRepCliente verificarRepositorio(int tipoRepo) {
		
		IRepCliente repo;
		
		switch (tipoRepo) {
		case 1:
			repo = instanciarRepClientesArray();
			break;
		case 2:
			repo = instanciarRepClientesTreeset();
			break;
		case 3:
			repo = instanciarRepClientesJDBC();
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
	
	
}
