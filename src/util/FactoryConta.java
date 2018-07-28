package util;

import dados.repositorio.array.RepositorioContasArray;
import dados.repositorio.hashmap.RepositorioContasHashmap;
import dados.repositorio.interfaces.IRepConta;
import dados.repositorio.jdbc.Conta.RepositorioContasJDBC;
import dados.repositorio.serializacao.RepositorioContasSer;

public class FactoryConta {
	
	public IRepConta verificarRepositorio(int tipoRepo) {
		
		IRepConta repo;
		
		switch (tipoRepo) {
		case 1:
			repo = instanciarRepContasArray();
			break;
		case 2:
			repo = instanciarRepContasHashmap();
			break;
		case 3:
			repo = instanciarRepContasJDBC();
			break;
		case 4:
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
