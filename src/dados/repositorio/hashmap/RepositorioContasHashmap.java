package dados.repositorio.hashmap;

import dados.repositorio.interfaces.IRepConta;
import modelo.conta.Conta;
import java.util.*;

public class RepositorioContasHashmap implements IRepConta{

    Set contas = new HashSet();
    int indice;

    public RepositorioContasHashmap() {
        this.indice =0;
    }
    

    public Set getContas() {
        return contas;
    }

    public void setContas(Set contas) {
        this.contas = contas;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    @Override
    public void inserir(Conta conta) {
        contas.add(conta);
        indice++;
    }

    @Override
    public void remover(Conta conta) {
        contas.remove(conta);
        indice--;
    }

    @Override
    public void atualizar(Conta conta) {
        remover(procurar(conta.getNumero()));
        inserir(conta);
    }

    @Override
    public Conta procurar(String num_conta) {
        Iterator it = contas.iterator();
        Conta c;
        while(true) {
            c = (Conta) it.next();
            if(c.getNumero().equals(num_conta))
                return c;
        }
    }

    @Override
    public int procurarIndice(String num_conta) {
        Iterator it = contas.iterator();
        Conta c;
        for(int i = 0;;i++) {
            c = (Conta) it.next();
            if(c.getNumero().equals(num_conta))
                return i;
        }
    }

    @Override
    public boolean existe(String num_conta) {
        return contas.contains(procurar(num_conta));
    }

}
