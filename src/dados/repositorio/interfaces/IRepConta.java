package dados.repositorio.interfaces;

import modelo.conta.Conta;

public interface IRepConta {
    
    public static final int TAM_CACHE_CONTAS = 100;
    public void inserir(Conta conta);
    public void remover(Conta conta);
    public void atualizar(Conta conta);
    public Conta procurar(String num_conta);
}
