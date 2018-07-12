package FWInternetBanking;

import java.time.temporal.TemporalAmount;
import java.util.ArrayList;

public class RepositorioContasArray {

	public static final int TAM_CACHE_CONTAS = 100;
	private Conta[] contas;
	private int indice;
	//ArrayList listaContas = new ArrayList();
	
	public RepositorioContasArray(Conta[] contas, int indice) {
		super();
		this.contas = contas;
		this.indice = indice;
	}
	
	public void inserir(Conta conta) {
		
		int n;
		
		for(n=0;n<TAM_CACHE_CONTAS;n++) {
			
			if(contas[n] == null) {
				contas[n] = conta;
				this.indice += 1;
				System.out.println("Conta:" + conta.getNumero() + " inserida com sucesso");
				return;
				
			}
			
		} 
			
		System.out.println("Conta:" + conta.getNumero() + " não foi possivel fazer a inserção");			
		
	}
	
	public void atualizar(Conta conta) {
		
		int n;
		for(n=0;n<TAM_CACHE_CONTAS;n++) {
			if (contas[n].getNumero().equals(conta.getNumero())) {
				contas[n] = conta;
				System.out.println("Conta:" + conta.getNumero() + " atualizada");
				return;
			} 
		}
		System.out.println("Conta:" + conta.getNumero() + " não encontrada");
			
	}
	
	public void remover(Conta conta) {
		int n;
		
		for(n=0;n<TAM_CACHE_CONTAS;n++) {
			if(contas[n] != null) {
				if (contas[n].getNumero().equals(conta.getNumero()))  {
					contas[n] = null;
					
					System.out.println("Conta:" + conta.getNumero() + " removida com sucesso!");
					
					while(contas[n+1] != null) {
						contas[n] = contas[n+1];
						n++;
					}
					
					if(contas[n] == null) 
						return;
					
				}
				
			}	
		}
			
	}
	
	private int procurarIndice(String num_conta) {
		
		int n;
		
		if(existe(num_conta)) {
		for(n=0;n<TAM_CACHE_CONTAS;n++) {
			if (contas[n].getNumero().equals(num_conta)) {
				//update
				System.out.println("Conta:" + num_conta + " Indice:" + n);
				return n;
				} 
			}
		}
		return -1;
	}
	
	public boolean existe(String num_conta) {
		int n = 0;
		for(n=0;n<TAM_CACHE_CONTAS;n++) {

			if(contas[n] != null) {
				if (contas[n].getNumero().equals(num_conta)) 
					return true;			
			}
			
		}
		
		return false;
		
	}
	
	public Conta procurar(String num_conta) {
		int n = procurarIndice(num_conta);
		
		return contas[n];
	}
	
}
