/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio.array;

import cliente.Cliente;

/**
 *
 * @author 1545-6 IRON V4
 */
public class RepositorioClientesArray {
    public static final int TAM_CACHE_CONTAS = 100;//vai para a Interface
    private Cliente clientes[];
    private int indice;

    public RepositorioClientesArray() {
        indice = 0;
        clientes = new Cliente[TAM_CACHE_CONTAS];
    }

    public Cliente[] getClientes() {
        return clientes;
    }

    public void setClientes(Cliente[] clientes) {
        this.clientes = clientes;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }
    
    public void inserir(Cliente cliente){//tem que checar se existe e se esta cheio antes de inserir
            clientes[indice++]=cliente;
    }
    
    public void atualizar(Cliente cliente){//no controlador tem q testar se existe antes de atualizar
            clientes[this.procurarIndice(cliente.getCpf())]=cliente;
    }
    
    public void remover(Cliente cliente){//tem que checar se existe antes de remover
            clientes[this.procurarIndice(cliente.getCpf())] = clientes[indice];
            clientes[indice--] = null;
    }
    
    private int procurarIndice(String cpf){//se nao encontrar retorna -1, senao o indice
        int i=0;
        for(Cliente c : clientes){
            if(c.getCpf().equals(cpf))
                return i;
            i++;
        }
        return -1;
    }
    
    public boolean existe(String cpf){
        if(this.procurarIndice(cpf)==-1)
            return false;
        return true;
    }
    
    public Cliente procurar(String cpf){//tem que checar se existe no controlador antes de procurar
            return clientes[this.procurarIndice(cpf)];
    }
}