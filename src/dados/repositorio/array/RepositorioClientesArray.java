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
    
    

    public int getTamCacheClientes() {
		return TAM_CACHE_CLIENTES;
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
    
    public int procurarIndice(String cpf){
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
