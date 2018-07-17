package src;

public interface IRepConta {
	public Conta procurar_Conta(String numero_conta);
	public boolean existe(String numero_conta);
	public void remover(Conta conta);
	public void atualizar(Conta conta);
	public void inserir_conta(Conta conta);
}
