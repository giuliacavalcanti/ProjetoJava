/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.conta;

import exception.conta.SaldoInsuficienteException;
import modelo.cliente.Cliente;

/**
 *
 * @author 1545-6 IRON V4
 */
public class ContaSemImposto extends Conta{

    public ContaSemImposto(double saldo, String numero,Cliente cliente) {
        super(saldo, numero,cliente);
    }
    
    @Override
    public void debitar(double valor) throws SaldoInsuficienteException{
    	if(this.getSaldo() >= valor) {
    		this.setSaldo(this.getSaldo() - valor);
    	} else {
    	throw new SaldoInsuficienteException(this.getSaldo(),valor);
    	}
        
    }
}
