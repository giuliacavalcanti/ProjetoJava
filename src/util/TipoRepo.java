package util;

public enum TipoRepo {
	
		ARRAY(0),SERIAL(1),JDBC(2),TREESET(3),HASHMAP(4);
			
	private final int tipo;

	private TipoRepo(int tipo) {
		this.tipo = tipo;
	}
	
	public static TipoRepo forInt(int valor) {
		for(TipoRepo tipoRepo : values()) {
			if (tipoRepo.tipo == valor)
				return tipoRepo;
		}
		
		return null;
	}
}
