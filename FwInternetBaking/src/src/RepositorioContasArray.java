package src;

public class RepositorioContasArray {
	public static final int TAM_CACHE_CONTAS = 100;
	private int indice;
	private Conta[] contas = new Conta[TAM_CACHE_CONTAS];
	
	public RepositorioContasArray(Conta[] contas, int indice) {
		super();
		this.indice = indice;
		this.contas = contas;
	}


	public void inserir_conta(Conta conta) {
		int conta_existe;
		conta_existe = procuraIndice(conta.getNumero());
		if(conta_existe == -1) {
			contas[indice] = conta;
			indice++;
		}
		else {
			return;
		}
	}
	
	
	public void atualizar(Conta conta) {
		int conta_existe;
		conta_existe = procuraIndice(conta.getNumero());
		if(conta_existe == -1) {
			return;
		}
		else {
			contas[indice] = conta;
		}
	}
	
	public void remover(Conta conta) {
		int conta_existe;
		conta_existe = procuraIndice(conta.getNumero());
		if(conta_existe == -1) {
			return;
		}
		else {
			contas[conta_existe] = contas[indice];
			contas[indice] = null;
			indice--;
		}
	}
	
	
	
	private int procuraIndice(String numeroConta) {
		for(int busca_indice = 0; busca_indice < TAM_CACHE_CONTAS; busca_indice++) {
			if(contas[busca_indice] == null) {
				return -1;
			}
			else if(contas[busca_indice].getNumero().equals(numeroConta) == true) {
				return busca_indice;
			}
		}
		return -1;
	}
	
	
	public boolean existe(String numero_conta) {
		int conta_existe;
		conta_existe = procuraIndice(numero_conta);
		if(conta_existe == -1) {
			return false;
		}
		else {
			return true;
		}
	}
	
	
	public Conta procurar_Conta(String numero_conta) {
		int conta_existe;
		conta_existe = procuraIndice(numero_conta);
		if(conta_existe == -1) {
			return null;
		}
		else {
			return contas[conta_existe];
		}
		
	}
	
	
	
}
	
