package dados.repositorio.array;

import modelo.cliente.Cliente;
import util.UtilProperties;
import dados.repositorio.interfaces.IRepCliente;
/*
 *
 * @author 1545-6 IRON V4
 */
public class RepositorioClientesArray implements IRepCliente{
	public static final int TAM_CACHE_CLIENTES = Integer.parseInt(UtilProperties.getConfig("TAM_CACHE"));
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
        int i;
        if(existe(cpf)) {
        	for(i=0;i<TAM_CACHE_CLIENTES;i++) {
            	if((clientes[i].getCpf().equals(cpf))) {
            		return i;
            	}
            }	
        }
       
        return -1;
    }
    
    public boolean existe(String cpf){
        for(int i=0;i<TAM_CACHE_CLIENTES;i++){
        if(clientes[i] != null) {
            if(clientes[i].getCpf().equals(cpf))
                return true;
        	}
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
