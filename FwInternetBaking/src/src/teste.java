package src;

public class teste {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Conta c1 = new Conta(300.5, "91212189");
		Conta c2 = new Conta(40.5, "123");
		Conta c3 = new Conta(100.90,"8291");
		Conta[] contas = new Conta[100];
		
		contas[0] = c1;
		contas[1] = c2;
		
		RepositorioContasArray repositorioContas = new RepositorioContasArray(contas, 1);
		
		Cliente cli = new Cliente("Giulia", "81991" );
		
		
		//transferencia
		//c1.transferir(c2, 500);
		//c2.transferir(c1, 50);
		
		//Repositorio
		System.out.println(repositorioContas.existe("123"));
		repositorioContas.inserir_conta(c3);
		System.out.println(repositorioContas.existe("8291"));
		repositorioContas.remover(c2);
		System.out.println(repositorioContas.existe("123"));
		System.out.println(repositorioContas.procurar_Conta("91212189").getSaldo());
		c3.creditar(20.0);
		repositorioContas.atualizar(c3);
		repositorioContas.remover(c1);
		System.out.println(repositorioContas.procurar_Conta("8291").getSaldo());
		repositorioContas.inserir_conta(c2);
		System.out.println(repositorioContas.procurar_Conta("123").getSaldo());
		repositorioContas.inserir_conta(c1);
		System.out.println(repositorioContas.procurar_Conta("8291").getSaldo());
	}
	

}
