package modelo.cadconta;

import modelo.conta.Conta;
import dados.repositorio.interfaces.IRepConta;

public class CadConta{
    private IRepConta irepconta;

    public CadConta(IRepConta irepconta) {
        this.irepconta = irepconta;
    }

    public void inserir(Conta conta) {
            if(irepconta.getIndice() == irepconta.getTamCacheContas()){
                    System.out.println("Repositorio de Contas cheio");
            }
            else if(irepconta.existe(conta.getNumero()) == true) {
                    System.out.println("A conta " + conta.getNumero() + " ja existe");
            }
            else {
                    irepconta.inserir(conta);
                    System.out.println("A conta " + conta.getNumero() + " inserida com suceso");

            }
    }

    public void remover(Conta conta) {
            if(irepconta.existe(conta.getNumero()) == true) {
                    irepconta.remover(conta);
                    System.out.println("A conta " + conta.getNumero() + " removida com sucesso");

            }
            else {
                    System.out.println("A conta " + conta.getNumero() + " nao existe");
            }
    }

    public void atualizar(Conta conta) {
            if(irepconta.existe(conta.getNumero()) == true) {
                    irepconta.atualizar(conta);
                    System.out.println("A conta " + conta.getNumero() + " atualizada com sucesso");
            }
            else {
                    System.out.println("A conta " + conta.getNumero() + " nao existe");
            }
    }

    public Conta procurar(String num) {
            if(irepconta.existe(num) == true) {
                return irepconta.procurar(num);
            }
            else {
                 System.out.println("A conta " + num + " nao existe ");

            }
            return null;
    }

    public void debitar(String num, double valor) {
            if(irepconta.existe(num) == true) {
                    Conta conta=irepconta.procurar(num);
                    conta.debitar(valor);
                    atualizar(conta);
            }
             else {
                     System.out.println("A conta " + num + " nao existe ");
             }
    }

    public void creditar(String num, double valor) {
            if(irepconta.existe(num) == true) {
                Conta conta=irepconta.procurar(num);
                    conta.creditar(valor);
                    atualizar(conta);
            }
            else {
                    System.out.println("A conta " + num + " nao existe ");
            }
    }

    public void transferir(String o, String d, double valor) {
            if(irepconta.existe(o)) {
                if(irepconta.existe(d)){
                    irepconta.procurar(o).transferir(irepconta.procurar(d), valor);
                            atualizar(irepconta.procurar(d));
                }
                else {
                    System.out.println("A conta destino " + d + " nao existe ");
                }
            }
            else {
                System.out.println("A conta destino " + o + " nao existe ");
            }
    }
}