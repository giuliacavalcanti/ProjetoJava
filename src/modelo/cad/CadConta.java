package modelo.cad;

import br.com.framework.*;
import dados.repositorio.interfaces.IRepConta;
import modelo.conta.Conta;


public class CadConta extends CadGenerico<Conta>{
    private IRepConta irepconta;

    public CadConta(IRepConta irepconta) {
        this.irepconta = irepconta;
    }

    public void inserir(Conta conta) {
        irepconta.inserir(conta);
        System.out.println("A conta " + conta.getId() + " inserida com suceso");
    }

    public void remover(Conta conta) {
        irepconta.remover(conta);
        System.out.println("A conta " + conta.getId() + " removida com sucesso");
    }

    public void atualizar(Conta conta) {
        irepconta.atualizar(conta);
        System.out.println("A conta " + conta.getId() + " atualizada com sucesso");
    }

    public Conta consultar(String num) {
        return irepconta.consultar(num);
    }

    public void debitar(String num, double valor) {
        Conta conta=irepconta.consultar(num);
        conta.debitar(valor);
        atualizar(conta);
    }

    public void creditar(String num, double valor) {
        Conta conta=irepconta.consultar(num);
        conta.creditar(valor);
        atualizar(conta);
    }

    public void transferir(String o, String d, double valor) {
        irepconta.consultar(o).transferir(irepconta.consultar(d), valor);
        atualizar(irepconta.consultar(d));
    }
}