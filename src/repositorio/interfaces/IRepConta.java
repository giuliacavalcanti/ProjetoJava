package repositorio.interfaces;

import conta.Conta;

public interface IRepConta {

    public Conta[] getContas();
    public void setContas(Conta[] contas);
    public int getIndice();
    public void setIndice(int indice); 
    public void inserir(Conta conta);
    public void remover(Conta conta);
    public void atualizar(Conta conta);
    public Conta procurar(String num_conta);
    public int procurarIndice(String num_conta);
    public boolean existe(String num_conta);
}
