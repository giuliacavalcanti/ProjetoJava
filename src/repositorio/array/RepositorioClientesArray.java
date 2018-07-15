<<<<<<< HEAD
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
>>>>>>> 05edb0622892d77d676a4413a43379b59918b0fa
package repositorio.array;

import cliente.Cliente;

<<<<<<< HEAD
public class RepositorioClientesArray {
    public static final int TAM_CACHE_CLIENTES = 100;
=======
/**
 *
 * @author 1545-6 IRON V4
 */
public class RepositorioClientesArray {
    public static final int TAM_CACHE_CONTAS = 100;//vai para a Interface
>>>>>>> 05edb0622892d77d676a4413a43379b59918b0fa
    private Cliente clientes[];
    private int indice;

    public RepositorioClientesArray() {
        indice = 0;
<<<<<<< HEAD
        clientes = new Cliente[TAM_CACHE_CLIENTES];
=======
        clientes = new Cliente[TAM_CACHE_CONTAS];
>>>>>>> 05edb0622892d77d676a4413a43379b59918b0fa
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
    
<<<<<<< HEAD
    public void inserir(Cliente cliente){
    	
    	clientes[indice++]=cliente;
    }
    
    public void atualizar(Cliente cliente){
        if(!(existe(cliente.getCpf())))
            System.out.println("Cliente nao existente");
        else
        	clientes[this.procurarIndice(cliente.getCpf())]=cliente;
    }
    
    public void remover(Cliente cliente){
        if(!(existe(cliente.getCpf())))
            System.out.println("Cliente nao existente");
        else{
        	clientes[this.procurarIndice(cliente.getCpf())] = clientes[indice];
        	clientes[indice--] = null;
        }
    }
    
    private int procurarIndice(String cpf){
        int i=0;
        while(!(clientes[i].getCpf().equals(cpf)))
            i++;
        return i;
    }
    
    public boolean existe(String cpf){
        for(int i=0;i<TAM_CACHE_CLIENTES;i++){
            if(clientes[i].equals(cpf))
                return true;
        }
        return false;
    }
    
    public Cliente procurar(String cpf){
    		
    		if(existe(cpf)) {
    			 return clientes[this.procurarIndice(cpf)];	
    		}
    		
           return null;
    }
}

=======
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
>>>>>>> 05edb0622892d77d676a4413a43379b59918b0fa
