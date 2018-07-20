package until;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Savepoint;

import dados.IRepClientes;
import negocio.Cliente;

import java.sql.Statement;
import java.sql.Connection;



public class JDBCConnectionUtil implements IRepClientes {
	
	private static String driver;

	private static String url;

	private static String user;

	private static String pass;

	

	private static Connection connection;

	

	static {

		try {	

			Class.forName(driver);

		} catch (ClassNotFoundException ex) {

			System.out.println("Erro ao carregar o driver JDBC do HSQLDB.");

			System.exit(-1);

		} 		

	}

	public static Connection getConnection() throws SQLException {

		if (connection == null || connection.isClosed()) {

			connection = DriverManager.getConnection(url,user,pass);

		}

		return connection;

	}

	

	public static void createTransaction() throws SQLException {

		getConnection();

		connection.setAutoCommit(false);

	}

	public static void createSavePoint() throws SQLException {

		getConnection();

		connection.setSavepoint();

	}

	public static void commitTransaction() throws SQLException {

		getConnection();

		connection.commit();

		connection.setAutoCommit(true);

	}

	public static void rollbackTransaction() throws SQLException {

		getConnection();

		connection.rollback();

		connection.setAutoCommit(true);

	}

	public static void rollbackTransaction(Savepoint savepoint) throws SQLException {

		getConnection();

		connection.rollback(savepoint);

		connection.setAutoCommit(true);

	}



	@Override
	public void atualizar(Cliente cliente) {
		try {
			connection = getConnection();
			Statement stmt = connection.createStatement();
			String sql = "UPDATE FROM TB_CLIENTE WHERE "+cliente.getId();
			stmt.executeUpdate(sql);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	@Override
	public Cliente consultar(String c) {
		try {
			Statement stmt = connection.createStatement();
			String sql = "SELECT FROM TB_CLIENTE WHERE "+ c;
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String cpf = rs.getString("Cpf");
				String nome = rs.getString("NOME");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}



	@Override
	public void inserir(Cliente cliente) {
		try {
			connection = getConnection();
			Statement stmt = connection.createStatement();			String sql = "INSERT INTO TB_CLIENTES VALUES ("+cliente.getId()+", "+cliente.getNome()+")";
			stmt.executeUpdate(sql);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



	@Override
	public void remover(Cliente cliente) {
		try {
			connection = getConnection();
			Statement stmt = connection.createStatement();			String sql = "DELETE FROM TB_CLIENTE WHERE "+cliente.getId();
			stmt.executeUpdate(sql);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}