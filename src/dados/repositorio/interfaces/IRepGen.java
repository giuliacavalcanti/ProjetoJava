package dados.repositorio.interfaces;

public interface IRepGen<E> {
    public void inserir(E e);
    public void remover(E e);
    public void atualizar(E e);
    public E procurar(String id);
}
