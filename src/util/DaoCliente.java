package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import util.JDBCConnectionUtil;
import dados.repositorio.interfaces.IRepCliente;
import modelo.cliente.Cliente;
import modelo.cliente.Endereco;

public class DaoCliente implements IRepCliente {
	private Connection connection;
	private JDBCConnectionUtil bd;
	
	
	@Override
	public void atualizar(Cliente cliente) {
		try {
			connection = JDBCConnectionUtil.getConnection();
			String sql = SQLSentencas.update;
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			if(cliente.getEndereco() != null) {
				inserir_endereco(cliente.getEndereco());
			}
			stmt.setObject(2, cliente.getEndereco());
			stmt.setObject(3, cliente.getEndereco());
			stmt.executeUpdate(sql);
			bd.commitTransaction();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				bd.rollbackTransaction();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}



	@Override
	public Cliente consultar(String c) {
		try {
			connection = JDBCConnectionUtil.getConnection();
			String sql = SQLSentencas.getConsultar();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, c);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String cpf = rs.getString("Cpf");
				String nome = rs.getString("NOME");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				bd.rollbackTransaction();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return null;
	}



	@Override
	public void inserir(Cliente cliente) {
		try {
			connection = JDBCConnectionUtil.getConnection();
			String sql = SQLSentencas.getInserir();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			if(cliente.getEndereco() != null) {
				inserir_endereco(cliente.getEndereco());
			}
			stmt.executeUpdate(sql);
			bd.commitTransaction();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				bd.rollbackTransaction();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}



	@Override
	public void remover(Cliente cliente) {
		try {
			connection = JDBCConnectionUtil.getConnection();
			String sql = SQLSentencas.getRemover();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1,cliente.getId());
			stmt.executeUpdate(sql);
			bd.commitTransaction();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void inserir_endereco(Endereco endereco) {
		try {
			connection = JDBCConnectionUtil.getConnection();
			Statement stmt = connection.createStatement();
			String sql = "INSERT INTO TB_ENDERECO VALUES("+endereco.getCep()+","+endereco.getNumero()+")";
			stmt.executeUpdate(sql);
			bd.commitTransaction();
			return;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
