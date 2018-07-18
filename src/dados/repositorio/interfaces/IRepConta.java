package dados.repositorio.interfaces;

import modelo.conta.Conta;

public interface IRepConta {
    
    public static final int TAM_CACHE_CONTAS = 100;
//    public Conta[] getContas();
//    public void setContas(Conta[] contas);
    public int getIndice();
    public void setIndice(int indice); 
//    public boolean isFull();
    public void inserir(Conta conta);
    public void remover(Conta conta);
    public void atualizar(Conta conta);
    public Conta procurar(String num_conta);
    public int procurarIndice(String num_conta);
    public boolean existe(String num_conta);
    public int getTamCacheContas();
}
