package dados.repositorio.array;

import modelo.cliente.Cliente;
import dados.repositorio.interfaces.IRepCliente;
/*
 *
 * @author 1545-6 IRON V4
 */
public class RepositorioClientesArray implements IRepCliente{
//    public static final int TAM_CACHE_CONTAS = 100;//vai para a Interface
    private Cliente clientes[];
    private int indice;

    public RepositorioClientesArray() {
        indice = 0;
        clientes = new Cliente[TAM_CACHE_CLIENTES];
    }
    
    public void inserir(Cliente cliente){
    	if(indice < TAM_CACHE_CLIENTES) {
    		clientes[indice++]=cliente;	
    	}
    	
    }
    
    public void atualizar(Cliente cliente){
        if(!(existe(cliente.getId())))
            System.out.println("Cliente nao existente");
        else
        	clientes[this.procurarIndice(cliente.getId())]=cliente;
    }
    
    public void remover(Cliente cliente){
        if(!(existe(cliente.getId())))
            System.out.println("Cliente nao existente");
        else{
        	clientes[this.procurarIndice(cliente.getId())] = clientes[indice];
        	clientes[indice--] = null;
        }
    }
    
    public int procurarIndice(String cpf){
        int i=0;
        while(!(clientes[i].getId().equals(cpf)))
            i++;
        return i;
    }
    
    public boolean existe(String cpf){
        for(int i=0;i<TAM_CACHE_CLIENTES;i++){
            if(clientes[i].getId().equals(cpf))
                return true;
        }
        return false;
    }
    
    public Cliente consultar(String cpf){
    		
    		if(existe(cpf)) {
    			 return clientes[this.procurarIndice(cpf)];	
    		}
    		
           return null;
    }


}
