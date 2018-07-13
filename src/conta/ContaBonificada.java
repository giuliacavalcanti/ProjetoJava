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
public class ContaBonificada extends Conta{
    private double bonus;
    
    public ContaBonificada(double saldo, String numero) {
        super(saldo, numero);
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
        
    }
}
