package dados.repositorio.hashmap;

import dados.repositorio.interfaces.IRepConta;
import modelo.conta.Conta;
import java.util.*;

public class RepositorioContasHashmap implements IRepConta{

    Map contas = new HashMap();

    public Map getContas() {
        return contas;
    }

    public void setContas(Map contas) {
        this.contas = contas;
    }

    @Override
    public void inserir(Conta conta) {
        contas.put(conta.getNumero(),conta);
    }

    @Override
    public void remover(Conta conta) {
        contas.remove(conta);
    }

    @Override
    public void atualizar(Conta conta) {
        remover(procurar(conta.getNumero()));
        inserir(conta);
    }

    @Override
    public Conta procurar(String num_conta) {
        return (Conta) contas.get(num_conta);
    }

}
