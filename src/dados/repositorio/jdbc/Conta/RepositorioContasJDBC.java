
package dados.repositorio.jdbc.Conta;

import dados.repositorio.interfaces.IRepConta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.conta.Conta;
import static util.JDBCConnectionUtil.*;
public class RepositorioContasJDBC implements IRepConta{
    
    
    @Override
	public void inserir(Conta conta) {
		try {
                    Connection connection = getConnection();
                    String sql = "INSERT INTO TB_CONTA VALUES (?, ?)";
                    PreparedStatement stmt = connection.prepareStatement(sql);
                    stmt.setString(1, conta.getNumero());
                    stmt.setDouble(2, conta.getSaldo());
                    stmt.executeUpdate(sql);
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
                    String sql = "DELETE FROM TB_CONTA WHERE ID = ? ";
                    PreparedStatement stmt = connection.prepareStatement(sql);
                    stmt.setString(1,conta.getId());
                    stmt.executeUpdate(sql);
                    commitTransaction();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

    @Override
	public Conta consultar(String c) {
		try {
                    Connection connection = getConnection();
                    String sql = "SELECT FROM TB_CONTA WHERE = ?";
                    PreparedStatement stmt = connection.prepareStatement(sql);
                    stmt.setString(1, c);
                    ResultSet rs = stmt.executeQuery(sql);
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
                    String sql = "UPDATE CONTA SET SALDO = ? WHERE ID = ?";
                    PreparedStatement stmt = connection.prepareStatement(sql);
                    stmt.setDouble(1, conta.getSaldo());
                    stmt.setObject(2, conta.getId());
                    stmt.executeUpdate(sql);
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
