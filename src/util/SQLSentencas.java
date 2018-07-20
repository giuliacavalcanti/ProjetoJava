package until;



public class SQLSentencas {
	static final String inserir = "INSERT INTO TB_CLIENTES VALUES (?, ?, ?)";
	static final String remover = "DELETE FROM TB_CLIENTE WHERE ID = ? ";
	static final String update = "UPDATE USUARIO SET NOME = ? WHERE ID = ?";
	static final String consultar = "SELECT FROM TB_CLIENTE WHERE = ?";

	
	public static String getInserir() {
		return inserir;
	}
	public static String getRemover() {
		return remover;
	}
	public static String getUpdate() {
		return update;
	}
	public static String getConsultar() {
		return consultar;
	}
	
	
	
	
}
