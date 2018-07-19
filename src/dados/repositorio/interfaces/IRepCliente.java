package dados.repositorio.interfaces;

import modelo.cliente.Cliente;

public interface IRepCliente extends IRepGen<Cliente>{
    public static final int TAM_CACHE_CLIENTES = 100;
}
