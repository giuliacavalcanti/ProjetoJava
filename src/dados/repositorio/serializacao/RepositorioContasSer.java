package dados.repositorio.serializacao;

import dados.repositorio.interfaces.IRepConta;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.conta.Conta;

public class RepositorioContasSer implements IRepConta{

    @Override
    public void inserir(Conta g) {
        try {
            gravarCliente(g);
        } catch (IOException ex) {
            Logger.getLogger(RepositorioClientesSer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void remover(Conta g) {
        if (consultar(g.getNumero()) == null)
            ;//throw exception cliente nao existente
        else {
            inserir(null);
        }
    }

    @Override
    public Conta consultar(String numero) {
        try {
            return lerCliente(numero);
        } catch (IOException ex) {
            Logger.getLogger(RepositorioClientesSer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RepositorioClientesSer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void atualizar(Conta g) {
        if (consultar(g.getNumero()) == null)
            ;//throw exception cliente nao existente
        else {
            inserir(g);
        }
    }

    public static void gravarCliente(Conta g) throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream(g.getNumero());
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(g);
    }

    public static Conta lerCliente(String arquivo) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(arquivo);
        ObjectInputStream ois = new ObjectInputStream(fis);
        return (Conta) ois.readObject();
    }
}
