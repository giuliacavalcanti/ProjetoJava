package dados.repositorio.hashmap;

import dados.repositorio.interfaces.IRepConta;
import modelo.conta.Conta;
import java.util.*;

public class RepositorioContasHashmap implements IRepConta{

    Map<String,Conta> contas = new HashMap<String,Conta>();

    public Map<String, Conta> getContas() {
        return contas;
    }

    public void setContas(Map<String, Conta> contas) {
        this.contas = contas;
    }

    @Override
    public void inserir(Conta conta) {
        contas.put(conta.getId(),conta);
    }

    @Override
    public void remover(Conta conta) {
        contas.remove(conta.getId());
    }

    @Override
    public void atualizar(Conta conta) {
        remover(consultar(conta.getId()));
        inserir(conta);
    }

    @Override
    public Conta consultar(String num_conta) {
        return (Conta) contas.get(num_conta);
    }

}
