package dados.repositorio.jdbc.gerentedao;


import static util.JDBCConnectionUtil.commitTransaction;
import static util.JDBCConnectionUtil.getConnection;
import static util.JDBCConnectionUtil.rollbackTransaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import dados.repositorio.interfaces.IRepGerente;
import modelo.gerente.Gerente;
import util.UtilProperties;

public class GerenteDAO implements IRepGerente {
	
	@Override
	public void atualizar(Gerente gerente) {
		try {
            
			Connection connection = getConnection();
                    String sql = "UPDATE CONTA SET NOME = ? TELEFONE = ? CELULAR = ? EMAIL = ? WHERE ID = ?";
                    PreparedStatement stmt = connection.prepareStatement(sql);
                    stmt.setString(1, gerente.getNome());
                    stmt.setString(2, gerente.getTelefone());
                    stmt.setString(3, gerente.getCelular());
                    stmt.setString(4, gerente.getEmail());
                    stmt.setObject(5, gerente.getId());
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
	public Gerente consultar(String id) {

    	try {
    		Connection connection = getConnection();
    		String sql = "SELECT FROM TB_GERENTE WHERE id = ?";
    		PreparedStatement stmt = connection.prepareStatement(sql);
    		stmt.setString(1, id);
    		ResultSet rs = stmt.executeQuery(sql);
    		while(rs.next()) {
                String reId = rs.getString("Id");
                String nome = rs.getString("Nome");
                String telefone = rs.getString("Telefone");
                String celular = rs.getString("Celular");
                String email = rs.getString("Email");
                
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	} try {
			rollbackTransaction();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
    	return null;
    	
    	
	}

	@Override
	public void inserir(Gerente gerente) {
		try {
            Connection connection = getConnection();
            String sql = "INSERT INTO TB_GERENTE VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, gerente.getId());
            stmt.setString(2, gerente.getNome());
            stmt.setString(3, gerente.getTelefone());
            stmt.setString(4, gerente.getCelular());
            stmt.setString(5, gerente.getEmail());
            
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
	public void remover(Gerente gerente) {
		try {
            Connection connection = getConnection();
            String sql = "DELETE FROM TB_GERENTE WHERE ID = ? ";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,gerente.getId());
            stmt.executeUpdate(sql);
            commitTransaction();

} catch (SQLException e) {
	e.printStackTrace();
}

		
	}

}
