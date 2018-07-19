package dados.repositorio.treeset;

import dados.repositorio.interfaces.IRepCliente;
import java.util.*;
import modelo.cliente.Cliente;

public class RepositorioClientesTreeset implements IRepCliente {
    
    Set clientes = new TreeSet();
    int indice;

    public RepositorioClientesTreeset() {
        this.indice = 0;
    }

    public Set getClientes() {
        return clientes;
    }

    public void setClientes(Set clientes) {
        this.clientes = clientes;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    @Override
    public void inserir(Cliente cliente) {
        clientes.add(cliente);
        indice++;
    }

    @Override
    public void remover(Cliente cliente) {
        clientes.remove(cliente);
        indice--;
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

    @Override
    @SuppressWarnings("empty-statement")
    public int procurarIndice(String cpf) {
        Iterator it = clientes.iterator();
        Cliente c;
        for(int i = 0;;i++) {
            c = (Cliente) it.next();
            if(c.getCpf().equals(cpf))
                return i;
        }
    }

    @Override
    public boolean existe(String cpf) {
        return clientes.contains(procurar(cpf));
    }

}
