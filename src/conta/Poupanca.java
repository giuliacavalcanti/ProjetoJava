/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conta;

/**
 *
 * @author 1545-6 IRON V4
 */
public class Poupanca extends Conta{
    
    public Poupanca(double saldo, String numero) {
        super(saldo, numero);
    }
    
    public void renderJuros(double taxa){
        double saldoAtual = getSaldo();
        creditar(saldoAtual*taxa);
    }
    
}
