package modelo.cadcliente;

import modelo.cliente.Cliente;
import dados.repositorio.interfaces.IRepCliente;


public class CadCliente{
    private IRepCliente irepcliente;

    public CadCliente(IRepCliente irepcliente) {
        this.irepcliente = irepcliente;
    }

    public void inserir(Cliente cliente) {
            if(irepcliente.existe(cliente.getCpf()) == true) {
                    System.out.println("A cliente " + cliente.getCpf() + " ja existe");
            }
            else {
                    irepcliente.inserir(cliente);
                    System.out.println("A cliente " + cliente.getCpf() + " inserida com suceso");

            }
    }

    public void remover(Cliente cliente) {
            if(irepcliente.existe(cliente.getCpf()) == true) {
                    irepcliente.remover(cliente);
                    System.out.println("A cliente " + cliente.getCpf() + " removida com sucesso");

            }
            else {
                    System.out.println("A cliente " + cliente.getCpf() + " nao existe");
            }
    }

    public void atualizar(Cliente cliente) {
            if(irepcliente.existe(cliente.getCpf()) == true) {
                    irepcliente.atualizar(cliente);
                    System.out.println("A cliente " + cliente.getCpf() + " atualizada com sucesso");
            }
            else {
                    System.out.println("A cliente " + cliente.getCpf() + " nao existe");
            }

    }

    public Cliente procurar(String cpf) {
            if(irepcliente.existe(cpf)) {
                    System.out.println("A cliente " + cpf + " nao existe");
            }
            else {
                    return irepcliente.procurar(cpf);
            }
            return null;
    }

}