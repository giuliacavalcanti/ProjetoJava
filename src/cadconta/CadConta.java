package cadconta;

import conta.Conta;
import repositorio.interfaces.IRepConta;

public class CadConta{
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
		if(irepconta.existe(conta.getNumero()) == true) {
			irepconta.remover(conta);
			System.out.println("A conta " + conta.getNumero() + " removida com sucesso");

		}
		else {
			System.out.println("A conta " + conta.getNumero() + " nao existe");
		}
	}
	
	public void atualizar(Conta conta) {
		if(irepconta.existe(conta.getNumero()) == true) {
			irepconta.atualizar(conta);
			System.out.println("A conta " + conta.getNumero() + " atualizada com sucesso");
		}
		else {
			System.out.println("A conta " + conta.getNumero() + " nao existe");
		}
	}
	
	public Conta procurar(Conta conta) {
		 if(irepconta.existe(conta.getNumero()) == true) {
				return conta;
			}
			else {
				System.out.println("A conta " + conta.getNumero() + " nao existe ");

			}
		 return conta;
	}
	
	public void debitar(Conta conta, double valor) {
		 if(irepconta.existe(conta.getNumero()) == true) {
				conta.debitar(valor);
				atualizar(conta);
			}
		 else {
			 System.out.println("A conta " + conta.getNumero() + " nao existe ");
		 }
	}
	
	public void creditar(Conta conta, double valor) {
		if(irepconta.existe(conta.getNumero()) == true) {
			conta.creditar(valor);
			atualizar(conta);
		}
		else {
			System.out.println("A conta " + conta.getNumero() + " nao existe ");
		}
	}
	
	public void transferir(Conta conta_destino, double valor) {
		 if(irepconta.existe(conta_destino.getNumero()) == true) {
			 conta_destino.transferir(conta_destino, valor);
				atualizar(conta_destino);
		}
		 else {
				System.out.println("A conta destino " + conta_destino.getNumero() + " nao existe ");
		 }
	}
}