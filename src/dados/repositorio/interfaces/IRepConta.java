package dados.repositorio.interfaces;

import br.com.framework.IRepGenerico;
import modelo.conta.Conta;

public interface IRepConta extends IRepGenerico<Conta>{
    public static final int TAM_CACHE_CONTAS = 100;
}
