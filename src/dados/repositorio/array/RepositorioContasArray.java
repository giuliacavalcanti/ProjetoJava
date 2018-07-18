/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados.repositorio.array;

import modelo.conta.Conta;
import dados.repositorio.interfaces.IRepConta;

/**
 *
 * @author 1545-6 IRON V4
 */
public class RepositorioContasArray implements IRepConta{
//    public static final int TAM_CACHE_CONTAS = 100;
    private Conta contas[];
    private int indice;

    public RepositorioContasArray() {
        indice = 0;
        contas = new Conta[TAM_CACHE_CONTAS];
    }
   
    public void inserir(Conta conta){
    	
    	if(indice < TAM_CACHE_CONTAS) {
    		contas[indice++]=conta;
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
    
    public int procurarIndice(String numeroConta){
        int i=0;
        while(!(contas[i].getNumero().equals(numeroConta)))
            i++;
        return i;
    }
    
    public boolean existe(String numeroConta){
        for(int i=0;i<TAM_CACHE_CONTAS;i++){
            if(contas[i].getNumero().equals(numeroConta))
                return true;
        }
        return false;
    }
    
    public Conta procurar(String numeroConta){
                    return contas[this.procurarIndice(numeroConta)];
    }

//    @Override
//    public int getTamCacheContas() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

}
