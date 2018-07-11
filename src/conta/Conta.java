package conta;


public class Conta {
    private double saldo;
    private String numero;

    public Conta(double saldo, String numero) {
        this.saldo = saldo;
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }
    
    private void creditar(double credito){
        this.saldo+=credito;
    }
    
    private boolean debitar(double debito){
        if(saldo>=debito){
            this.saldo-=debito;
            return true;
        }
        return false;
    }
    
    public String getNumero() {
        return numero;
    }
    
    public void transferencia(Conta recebendo,double valor){
        if(debitar(valor))
            recebendo.creditar(valor);
    }
    
}
