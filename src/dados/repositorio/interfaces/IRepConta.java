package dados.repositorio.interfaces;

import modelo.conta.Conta;

public interface IRepConta extends IRepGen<Conta>{
    public static final int TAM_CACHE_CONTAS = 100;
}
