
package dados.repositorio.jdbc.Conta;

import dados.repositorio.interfaces.IRepConta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.conta.Conta;
import util.UtilProperties;

import static util.JDBCConnectionUtil.*;
public class RepositorioContasJDBC implements IRepConta{
    
    
    @Override
	public void inserir(Conta conta) {
		try {
                    Connection connection = getConnection();
                    PreparedStatement stmt = connection.prepareStatement(UtilProperties.getSql("inserirConta"));
                    stmt.setString(1, conta.getNumero());
                    stmt.setDouble(2, conta.getSaldo());
                    stmt.executeUpdate(UtilProperties.getSql("inserirConta"));
                    commitTransaction();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				rollbackTransaction();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
	}

    @Override
	public void remover(Conta conta) {
		try {
                    Connection connection = getConnection();
                    PreparedStatement stmt = connection.prepareStatement(UtilProperties.getSql("removerConta"));
                    stmt.setString(1,conta.getId());
                    stmt.executeUpdate(UtilProperties.getSql("removerConta"));
                    commitTransaction();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
    

    @Override
	public Conta consultar(String c) {
		try {
                    Connection connection = getConnection();
                    PreparedStatement stmt = connection.prepareStatement(UtilProperties.getSql("selectConta"));
                    stmt.setString(1, c);
                    ResultSet rs = stmt.executeQuery(UtilProperties.getSql("selectConta"));
                    while(rs.next()) {
                            String num = rs.getString("Numero");
                            double saldo = rs.getDouble("Saldo");
                    }
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				rollbackTransaction();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return null;
	}

    @Override
	public void atualizar(Conta conta) {
		try {
			
			Connection connection = getConnection();
                    PreparedStatement stmt = connection.prepareStatement(UtilProperties.getSql("updateConta"));
                    stmt.setDouble(1, conta.getSaldo());
                    stmt.setObject(2, conta.getId());
                    stmt.executeUpdate(UtilProperties.getSql("updateConta"));
                    commitTransaction();
		
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				rollbackTransaction();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
    
}
