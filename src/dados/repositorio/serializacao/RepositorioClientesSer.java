package dados.repositorio.serializacao;

import dados.repositorio.interfaces.IRepCliente;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.cliente.Cliente;


public class RepositorioClientesSer implements IRepCliente{

    @Override
    public void inserir(Cliente g) {
        try {
            gravarCliente(g);
        } catch (IOException ex) {
            Logger.getLogger(RepositorioClientesSer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void remover(Cliente g) {
        if (consultar(g.getCpf()) == null)
            ;//throw exception cliente nao existente
        else
            inserir(null);
    }

    @Override
    public Cliente consultar(String cpf) {
        try {
            return lerCliente(cpf);
        } catch (IOException ex) {
            Logger.getLogger(RepositorioClientesSer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RepositorioClientesSer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void atualizar(Cliente g) {
        if(consultar(g.getCpf())==null)
            ;//throw exception cliente nao existente
        else
            inserir(g);
    }
    
    public static void gravarCliente(Cliente g) throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream(g.getCpf());
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(g);
    }
    
    public static Cliente lerCliente(String arquivo) throws FileNotFoundException,IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(arquivo);
        ObjectInputStream ois = new ObjectInputStream(fis);
        return (Cliente) ois.readObject();
    }
    
}
