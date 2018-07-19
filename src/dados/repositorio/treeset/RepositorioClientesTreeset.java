package dados.repositorio.treeset;

import dados.repositorio.interfaces.IRepCliente;
import java.util.*;
import modelo.cliente.Cliente;

public class RepositorioClientesTreeset implements IRepCliente {
    
    Set clientes = new TreeSet();


    public Set getClientes() {
        return clientes;
    }

    public void setClientes(Set clientes) {
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
        remover(procurar(cliente.getCpf()));
        inserir(cliente);
    }

    @Override
    public Cliente procurar(String cpf) {
        Iterator it = clientes.iterator();
        Cliente c;
        while(true) {
            c = (Cliente) it.next();
            if(c.getCpf().equals(cpf))
                return c;
        }
    }
}
