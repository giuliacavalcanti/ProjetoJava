package modelo.cadconta;

import modelo.conta.Conta;
import dados.repositorio.interfaces.IRepConta;

public class CadConta{
    private IRepConta irepconta;

    public CadConta(IRepConta irepconta) {
        this.irepconta = irepconta;
    }
	private IRepConta irepconta;
	
	public void inserir(Conta conta) {
		if(irepconta.getIndice() == irepconta.getTamCacheContas()){
			System.out.println("Repositorio de Contas cheio");
		}
		else if(irepconta.existe(conta.getNumero()) == true) {
			System.out.println("A conta " + conta.getNumero() + " ja existe");
		}
		else {
			irepconta.inserir(conta);
			System.out.println("A conta " + conta.getNumero() + " inserida com suceso");

		}
	}
	
	public void remover(Conta conta) {
		try {
			
			irepconta.remover(conta);

		}
		 catch (NullPointerException e) {
				System.err.println("Operação não pode ser realizada");
			}
	}
	
	public void atualizar(Conta conta) {
		try {
			
			irepconta.atualizar(conta);
			
		} catch (NullPointerException e) {
				System.err.println("Operação não pode ser realizada");
			}
	}
	
	public Conta procurar(String num_conta) {
		 
		Conta conta = null;
		
		 try {
				conta = irepconta.procurar(num_conta);
			}
		 catch (NullPointerException e) {
				System.err.println("A conta não existe");
			}
		
		return conta;
	}
	
	public void debitar(Conta conta, double valor) {
		
		try {
			
			conta.debitar(valor);
			atualizar(conta);
			
		} catch (NullPointerException e) {
			
			System.err.println("Operação não pode ser realizada");
		
		}
	}
	
	public void creditar(Conta conta, double valor) {
		try {
			
			conta.creditar(valor);
			atualizar(conta);
		}
		catch (NullPointerException e) {
			
			System.err.println("Operação não pode ser realizada");
		
		}
	}
	
	public void transferir(Conta conta_destino, double valor) {
		 try {
			 
			conta_destino.transferir(conta_destino, valor);
			atualizar(conta_destino);
			
		} catch (NullPointerException e) {
			
			System.err.println("Operação não pode ser realizada");
		
		}
	}
}