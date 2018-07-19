package modelo.cad;

import modelo.cliente.Cliente;
import br.com.framework.CadGenerico;
import dados.repositorio.interfaces.IRepCliente;


public class CadCliente extends CadGenerico<Cliente>{
    private IRepCliente irepcliente;

    public CadCliente(IRepCliente irepcliente) {
        this.irepcliente = irepcliente;
    }

    public void inserir(Cliente cliente) {
            irepcliente.inserir(cliente);
    }

    public void remover(Cliente cliente) {
        irepcliente.remover(cliente);
        System.out.println("A cliente " + cliente.getId() + " removida com sucesso");
    }

    public void atualizar(Cliente cliente) {
        irepcliente.atualizar(cliente);
        System.out.println("A cliente " + cliente.getId() + " atualizada com sucesso");
    }

    public Cliente consultar(String cpf) {
        return irepcliente.consultar(cpf);
    }

}