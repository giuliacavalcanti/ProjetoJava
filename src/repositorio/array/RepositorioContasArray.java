/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio.array;

import conta.Conta;

/**
 *
 * @author 1545-6 IRON V4
 */
public class RepositorioContasArray {
    public static final int TAM_CACHE_CONTAS = 100;//vai para a Interface
    private Conta contas[];
    private int indice;

    public RepositorioContasArray() {
        indice = 0;
        contas = new Conta[TAM_CACHE_CONTAS];
    }

    public Conta[] getContas() {
        return contas;
    }

    public void setContas(Conta[] contas) {
        this.contas = contas;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }
    
    public void inserir(Conta conta){//tem que checar se existe e se esta cheio antes de inserir
            contas[indice++]=conta;
    }
    
    public void atualizar(Conta conta){//no controlador tem q testar se existe antes de atualizar
            contas[this.procurarIndice(conta.getNumero())]=conta;
    }
    
    public void remover(Conta conta){//tem que checar se existe antes de remover
            contas[this.procurarIndice(conta.getNumero())] = contas[indice];
            contas[indice--] = null;
    }
    
    private int procurarIndice(String numeroConta){//se nao encontrar retorna -1, senao o indice
        int i=0;
        for(Conta c : contas){
            if(c.getNumero().equals(numeroConta))
                return i;
            i++;
        }
        return -1;
    }
    
    public boolean existe(String numeroConta){
        if(this.procurarIndice(numeroConta)==-1)
            return false;
        return true;
    }
    
    public Conta procurar(String numeroConta){//tem que checar se existe no controlador antes de procurar
            return contas[this.procurarIndice(numeroConta)];
    }
}
