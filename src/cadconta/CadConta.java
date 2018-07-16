package cadconta;

import conta.Conta;
import repositorio.interfaces.IRepConta;

public class CadConta{

	public void inserir(Conta conta, IRepConta irepconta) {
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
	
	public void remover(Conta conta, IRepConta irepconta) {
		if(irepconta.existe(conta.getNumero()) == true) {
			irepconta.remover(conta);
			System.out.println("A conta " + conta.getNumero() + " removida com sucesso");

		}
		else {
			System.out.println("A conta " + conta.getNumero() + " nao existe");
		}
	}
	
	public void atualizar(Conta conta, IRepConta irepconta) {
		if(irepconta.existe(conta.getNumero()) == true) {
			irepconta.atualizar(conta);
			System.out.println("A conta " + conta.getNumero() + " atualizada com sucesso");
		}
		else {
			System.out.println("A conta " + conta.getNumero() + " nao existe");
		}
	}
}
