package projetojavafw;

import exception.fachada.ClienteNuloException;
import modelo.cliente.Cliente;
import modelo.cliente.TipoCliente;
import modelo.conta.Conta;
import modelo.conta.ContaSemImposto;
import view.fachada.FachadaCad;

public class ProjetoJavaFW {

    public static void main(String[] args) throws ClienteNuloException {
        
    	FachadaCad fachada = new FachadaCad();
    	
    	//Cliente clienteT = new Cliente(nome, cpf, cep, numero, tipo, id);    	
    	Cliente clienteT = new Cliente("Lucas","10920","1021024",1209,TipoCliente.CLASS,"10");
    	fachada.cadastrar(clienteT);
    	
    	Conta contaT = new ContaSemImposto(1902.90,"101",clienteT,"11");
    	fachada.cadastrar(contaT);
    	
    	fachada.debitar("101", 124.0);
    	
    	Conta teste = fachada.procurarConta("101");
    	System.out.println(teste.getSaldo());
    	
    	fachada.removerConta("101");
    	teste = fachada.procurarConta("101");
    }
}
