/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.fachada;

import modelo.cadcliente.CadCliente;
import modelo.cadconta.CadConta;
import dados.repositorio.array.RepositorioClientesArray;
import modelo.cliente.Cliente;
import dados.repositorio.array.RepositorioContasArray;
import dados.repositorio.interfaces.IRepCliente;
import dados.repositorio.interfaces.IRepConta;
import modelo.conta.Conta;

/**
 *
 * @author 1545-6 IRON V4
 */
public class FachadaCad {
    private static FachadaCad instancia;
    private CadConta contas;
    private CadCliente clientes;

    public FachadaCad() {
        initCad();
    }
    
    public static FachadaCad getInstance(){
        if (instancia == null) {
            instancia = new FachadaCad();
        }
        return instancia;
    }

    private void initCad() {
        IRepConta repConta = new RepositorioContasArray();
        contas = new CadConta(repConta);
        IRepCliente repCliente = new RepositorioClientesArray();
        clientes = new CadCliente(repCliente);
    }
    
    public void atualizar(Cliente c) {
        clientes.atualizar(c);
    }

    public Cliente procurarCliente(String cpf) {
        return clientes.procurar(cpf);
    }

    public void cadastrar(Cliente c) {
        clientes.inserir(c);
    }

    public void descadastrarCliente(String cpf) {
        clientes.remover(clientes.procurar(cpf));
    }
    
    public void atualizar(Conta c) {
        contas.atualizar(c);
    }

    public Conta procurarConta(String n) {
        return contas.procurar(n);
    }

    public void cadastrar(Conta c) {
        Cliente cli = c.getCliente();
        if (cli != null) {
            clientes.procurar(cli.getCpf());
            contas.inserir(c);
        } else {
            System.out.println("cliente nulo");
        }
    }
    
    public void removerConta(String n) {
        contas.remover(contas.procurar(n));
    }

    public void creditar(String num, double valor) {
        contas.creditar(num,valor);
    }

    public void debitar(String num, double valor) {
        contas.debitar(num,valor);
    }

    public void transferir(String origem,String destino, double val) {
        contas.transferir(origem, destino, val);
    }
}
