package src;

public class teste {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Conta c1 = new Conta(300.5, "91212189");
		Conta c2 = new Conta(40.5, "123");
		Conta c3 = new Conta(100.90,"8291");
		Conta[] contas = new Conta[100];
		
		
		Poupanca p1 = new Poupanca(2321.3, "3242");
		Poupanca p2 = new Poupanca(1231.2, "34");
		Poupanca p3 = new Poupanca(131312.2, "21");
		
		/*contas[0] = c1;
		contas[1] = c2;
		contas[2] = p1;
		contas[3] = p2;*/
		
	
		
		
		RepositorioContasArray repositorioContas = new RepositorioContasArray(contas, 1);
		repositorioContas.inserir_conta(c1);
		repositorioContas.inserir_conta(c2);
		repositorioContas.inserir_conta(c3);
		repositorioContas.inserir_conta(p1);
		repositorioContas.inserir_conta(p2);
		repositorioContas.inserir_conta(p3);
		
		Cliente cli = new Cliente("Giulia", "81991" );
		is_poupanca(repositorioContas);
		
		//transferencia
		//c1.transferir(c2, 500);
		//c2.transferir(c1, 50);
		
		/*//Repositorio
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
		System.out.println(repositorioContas.procurar_Conta("8291").getSaldo());*/
		
	}
	
	public static void is_poupanca(RepositorioContasArray respositorioContas) {
		int count;
		Poupanca p;
		Conta [] contas = respositorioContas.getContas();
		for(count = 0; count < RepositorioContasArray.getTamCacheContas(); count++ ) {
			if(contas[count] instanceof Poupanca) {
				p = new Poupanca(contas[count].getSaldo(), contas[count].getNumero());
				System.out.println("O salto antigo da conta " + p.getNumero() + " é " + p.getSaldo());
				p.renderJuros(3);
				System.out.println("O salto atual da conta " + p.getNumero() + " é " + p.getSaldo());
				
			}
		}
	}
}
