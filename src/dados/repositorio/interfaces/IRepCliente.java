package dados.repositorio.interfaces;

import br.com.framework.IRepGenerico;
import modelo.cliente.Cliente;

public interface IRepCliente extends IRepGenerico<Cliente>{
    public static final int TAM_CACHE_CLIENTES = 100;
}
