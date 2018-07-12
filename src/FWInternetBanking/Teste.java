package FWInternetBanking;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Conta c1 = new Conta(201.0,"1090");
		Conta c2 = new Conta(120.0,"1415");
		Conta c3 = new Conta(1403.21,"9020");
		Conta[] contas = new Conta[100];

		contas[0] = c1;
		contas[1] = c2;
		
		RepositorioContasArray repContas = new RepositorioContasArray(contas, 1);
		
		Cliente cl1 = new Cliente("Cliente 1","22222");
		
	
		//Teste  Transeferir();
		//c1.transferir(c2,900);
		//c1.creditar(900);
		//c1.transferir(c2, 300);
		
		//Teste Repositorio
		System.out.println(repContas.existe("1090"));
		repContas.inserir(c3);
		System.out.println(repContas.existe("9020"));
		repContas.remover(c2);
		System.out.println(repContas.existe("1415"));
		System.out.println(repContas.procurar("9020").getSaldo());
		c3.creditar(20.0);
		repContas.atualizar(c3);
		System.out.println(repContas.procurar("9020").getSaldo());
	}

	
}
