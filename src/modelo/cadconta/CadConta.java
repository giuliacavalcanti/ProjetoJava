package modelo.cadconta;

import modelo.conta.Conta;
import dados.repositorio.interfaces.IRepConta;

public class CadConta{
    private IRepConta irepconta;

    public CadConta(IRepConta irepconta) {
        this.irepconta = irepconta;
    }

    public void inserir(Conta conta) {
        irepconta.inserir(conta);
        System.out.println("A conta " + conta.getNumero() + " inserida com suceso");
    }

    public void remover(Conta conta) {
        irepconta.remover(conta);
        System.out.println("A conta " + conta.getNumero() + " removida com sucesso");
    }

    public void atualizar(Conta conta) {
        irepconta.atualizar(conta);
        System.out.println("A conta " + conta.getNumero() + " atualizada com sucesso");
    }

    public Conta procurar(String num) {
        return irepconta.procurar(num);
    }

    public void debitar(String num, double valor) {
        Conta conta=irepconta.procurar(num);
        conta.debitar(valor);
        atualizar(conta);
    }

    public void creditar(String num, double valor) {
        Conta conta=irepconta.procurar(num);
        conta.creditar(valor);
        atualizar(conta);
    }

    public void transferir(String o, String d, double valor) {
        irepconta.procurar(o).transferir(irepconta.procurar(d), valor);
        atualizar(irepconta.procurar(d));
    }
}