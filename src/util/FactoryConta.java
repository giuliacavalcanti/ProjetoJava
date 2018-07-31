package util;

import dados.repositorio.array.RepositorioContasArray;
import dados.repositorio.hashmap.RepositorioContasHashmap;
import dados.repositorio.interfaces.IRepConta;
import dados.repositorio.jdbc.Conta.RepositorioContasJDBC;
import dados.repositorio.serializacao.RepositorioContasSer;

public class FactoryConta {
	
	public IRepConta verificarRepositorio(int valor) {
		
		IRepConta repo;
		
		switch (TipoRepo.forInt(valor)) {
		case ARRAY:
			repo = instanciarRepContasArray();
			break;
		case HASHMAP:
			repo = instanciarRepContasHashmap();
			break;
		case JDBC:
			repo = instanciarRepContasJDBC();
			break;
		case SERIAL:
			repo = instanciarRepContasSerial();
			break;
			
		default:
			repo = null;
		}
		
		return repo;
		
	}
	
	public RepositorioContasArray instanciarRepContasArray() {
		
		return new RepositorioContasArray();
	}
	
	public RepositorioContasJDBC instanciarRepContasJDBC() {
		
		return new RepositorioContasJDBC();
	}

	public RepositorioContasHashmap instanciarRepContasHashmap() {
	
		return new RepositorioContasHashmap();
	}
	
	public RepositorioContasSer instanciarRepContasSerial() {
		
		return new RepositorioContasSer();
	}
	
}
