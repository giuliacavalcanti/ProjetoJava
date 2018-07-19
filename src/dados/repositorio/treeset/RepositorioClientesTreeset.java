package dados.repositorio.treeset;

import dados.repositorio.interfaces.IRepCliente;
import java.util.*;
import modelo.cliente.Cliente;

public class RepositorioClientesTreeset implements IRepCliente {
    
    Set<Cliente> clientes = new TreeSet<Cliente>();


    public Set<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Set<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    @Override
    public void inserir(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public void remover(Cliente cliente) {
        clientes.remove(cliente);
    }

    @Override
    public void atualizar(Cliente cliente) {
        remover(consultar(cliente.getId()));
        inserir(cliente);
    }

    @Override
    public Cliente consultar(String cpf) {
        Iterator<Cliente> it = clientes.iterator();
        Cliente c;
        while(true) {
            c = (Cliente) it.next();
            if(c.getId().equals(cpf))
                return c;
        }
    }
}
