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
    public static final int TAM_CACHE_CONTAS = 100;
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
    
    public void inserir(Conta conta){
        if(existe(conta.getNumero())){
            System.out.println("Conta ja existente");
            return;
        }
        if(indice==99)
            System.out.println("Repositorio cheio");
        else{
            contas[++indice]=conta;
        }
    }
    
    public void atualizar(Conta conta){
        if(!(existe(conta.getNumero())))
            System.out.println("Conta nao existente");
        else
            contas[this.procurarIndice(conta.getNumero())]=conta;
    }
    
    public void remover(Conta conta){
        if(!(existe(conta.getNumero())))
            System.out.println("Conta nao existente");
        else{
            contas[this.procurarIndice(conta.getNumero())] = contas[indice];
            contas[indice--] = null;
        }
    }
    
    private int procurarIndice(String numeroConta){
        int i=0;
        while(!(contas[i++].getNumero().equals(numeroConta)));
        return i;
    }
    
    public boolean existe(String numeroConta){
        for(int i=0;i<TAM_CACHE_CONTAS;i++){
            if(contas[i].equals(numeroConta))
                return true;
        }
        return false;
    }
    
    public Conta procurar(String numeroConta){
        if(!(existe(numeroConta)))
            return null;
        else
            return contas[this.procurarIndice(numeroConta)];
    }
}
