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
public class ContaBonificada extends ContaSemImposto{
    private double bonus;
    
    public ContaBonificada(double saldo, String numero,Cliente cliente) {
        super(saldo, numero,cliente);
        bonus=0.0;
    }
    
    @Override
    public void creditar(double valor){
        bonus+=valor*(0.1);
        super.creditar(valor);
    }
    
    public double getBonus() {
        return bonus;
    }
    
    public void realizarBonus(){
        super.creditar(bonus);
        bonus=0.0;
    }
}
