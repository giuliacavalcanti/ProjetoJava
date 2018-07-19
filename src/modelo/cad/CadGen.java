package modelo.cad;

import dados.repositorio.interfaces.*;

public abstract class CadGen<E>{
    private IRepGen repositorio;
    
    public void inseir(E e){
        repositorio.inserir(e);
    }
    
    public void remover(E e){
        repositorio.remover(e);
    }
    
    public void atualizar(E e){
        repositorio.atualizar(e);
    }
    
    public E procurar(String id){
        return (E) repositorio.procurar(id);
    }
}
