package src;

public interface Cadastro_Conta {
	public void creditar(double valor);
	public abstract void debitar(double valor);
	public void transferir(Conta conta_destino, double valor);
}
