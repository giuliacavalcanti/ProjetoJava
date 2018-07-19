package modelo.cad;

import modelo.cliente.Cliente;
import dados.repositorio.interfaces.IRepCliente;


public class CadCliente extends CadGen<Cliente>{
    private IRepCliente irepcliente;

    public CadCliente(IRepCliente irepcliente) {
        this.irepcliente = irepcliente;
    }

    public void inserir(Cliente cliente) {
            irepcliente.inserir(cliente);
    }

    public void remover(Cliente cliente) {
        irepcliente.remover(cliente);
        System.out.println("A cliente " + cliente.getCpf() + " removida com sucesso");
    }

    public void atualizar(Cliente cliente) {
        irepcliente.atualizar(cliente);
        System.out.println("A cliente " + cliente.getCpf() + " atualizada com sucesso");
    }

    public Cliente procurar(String cpf) {
        return irepcliente.procurar(cpf);
    }

}