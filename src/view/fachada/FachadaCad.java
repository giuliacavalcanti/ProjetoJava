/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.fachada;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import exception.fachada.ClienteNuloException;
import modelo.cad.CadCliente;
import modelo.cad.CadConta;
import modelo.cliente.Cliente;
import modelo.conta.Conta;
import util.FactoryCliente;
import util.FactoryConta;
import util.UtilProperties;

/**
 *
 * @author 1545-6 IRON V4
 */
public class FachadaCad {
    private static FachadaCad instancia;
    private CadConta contas;
    private CadCliente clientes;
    
    private Properties pConfig = new Properties();
	private Properties pSql = new Properties();
	private Properties pExceptions = new Properties();
	
	

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
    	
    	carregarProperties();
    	
    	FactoryCliente fclt = new FactoryCliente();
    	FactoryConta fcnt = new FactoryConta();
    	 
        //IRepConta repConta = new RepositorioContasArray();
        contas = new CadConta(fcnt.verificarRepositorio(Integer.parseInt(UtilProperties.getConfig("RepositorioConta"))));;
        //IRepCliente repCliente = new RepositorioClientesArray();
        clientes = new CadCliente(fclt.verificarRepositorio(Integer.parseInt(UtilProperties.getConfig("RepositorioCliente"))));
    }
    
    public void atualizar(Cliente c) {
        clientes.atualizar(c);
    }

    public Cliente procurarCliente(String cpf) {
        return clientes.consultar(cpf);
    }

    public void cadastrar(Cliente c) {
        clientes.inserir(c);
    }

    public void descadastrarCliente(String cpf) {
        clientes.remover(clientes.consultar(cpf));
    }
    
    public void atualizar(Conta c) {
        contas.atualizar(c);
    }

    public Conta procurarConta(String n) {
        return contas.consultar(n);
    }

    public void cadastrar(Conta c) throws ClienteNuloException {
        Cliente cli = c.getCliente();
        if (cli != null) {
            clientes.consultar(cli.getId());
            contas.inserir(c);
        } else {
            throw new ClienteNuloException();
        }
    }
    
    public void removerConta(String n) {
        contas.remover(contas.consultar(n));
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
    
    public void carregarProperties() {
    	
    	FileInputStream fis = null;
    	
    	try {
    		
			fis = new FileInputStream("config.properties");
			pConfig.load(fis);
			UtilProperties.setConfig(pConfig);
			fis.close();
			
			fis = new FileInputStream("SQLSentences.properties");
			pSql.load(fis);
			UtilProperties.setConfig(pSql);
			fis.close();
			
			fis = new FileInputStream("exceptions.properties");
			pExceptions.load(fis);
			UtilProperties.setConfig(pExceptions);
			fis.close();
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    }
}
