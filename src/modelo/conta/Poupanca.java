/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.conta;

import modelo.cliente.Cliente;

/**
 *
 * @author 1545-6 IRON V4
 */
public class Poupanca extends ContaSemImposto{
    
    public Poupanca(double saldo, String numero,Cliente cliente,String id) {
        super(saldo, numero,cliente,id);
    }
    
    public void renderJuros(double taxa){
        double saldoAtual = getSaldo();
        creditar(saldoAtual*taxa);
    }
    
}
