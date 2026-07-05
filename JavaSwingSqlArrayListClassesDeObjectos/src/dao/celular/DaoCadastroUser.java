package dao.celular;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import controller.celular.Conexao;
import model.celular.CadastroUser;

public class DaoCadastroUser {
//creat
	public void adicionarUser(String nome, String apelido,String username, String perfil, String senha) throws SQLException {
		Connection con = Conexao.conectar();
		PreparedStatement stmt = null;
		stmt = con.prepareStatement("insert into users (nome, apelido,username, perfil, senha, senhaInicial) values(?,?,?,?,?,?)");
		stmt.setString(1, nome);
		stmt.setString(2, apelido);
		stmt.setString(3, username);
		stmt.setString(4, perfil);
		stmt.setString(5, senha);
		stmt.setString(6, senha);
		stmt.executeUpdate();
		con.close();
	}

// read
	public ArrayList<CadastroUser> listaDeUsers() throws SQLException, ClassNotFoundException {
		ArrayList<CadastroUser> users = new ArrayList<CadastroUser>();
		PreparedStatement stmt = null;
		Connection con = Conexao.conectar();
		stmt = con.prepareStatement("SELECT * FROM users");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			int codigoUser = rs.getInt(1);
			String nome = rs.getString(2);
			String apelido = rs.getString(3);
			String username = rs.getString(4);
			String perfil = rs.getString(5);
			String senha = rs.getString(6);
			users.add(new CadastroUser(codigoUser, nome, apelido, username,perfil, senha));
		}
		con.close();
		return users;
	}

//	update
	public  void actualizarUser(int codigoUser, String novoPerfil)
			throws SQLException {
		Connection con = Conexao.conectar();
		PreparedStatement stmt = null;
		stmt = con.prepareStatement("update users set perfil =? where codigoUser=?");
		stmt.setString(1, novoPerfil);
		stmt.setInt(2, codigoUser);
		stmt.executeUpdate();
		con.close();
	}

//	delete
	public void removerUser(int codigoUser) throws SQLException {

		Connection con = Conexao.conectar();
		PreparedStatement stmt = null;
		stmt = con.prepareStatement("delete from users where codigoUser=?");
		stmt.setInt(1, codigoUser);
		stmt.executeUpdate();
		con.close();
	}


	// autenticar
	public CadastroUser autenticarUser(String username,String senha) {
		PreparedStatement stmt = null;
		Connection con = Conexao.conectar();
		try {
			stmt = con.prepareStatement("SELECT * FROM users where username=? AND senha=?");

			stmt.setString(1, username);
			stmt.setString(2, senha);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {

				CadastroUser user = new CadastroUser();
				user.setCodigoUsuario(rs.getInt("codigoUser"));
				user.setNome(rs.getString("nome"));
				user.setApelido(rs.getString("apelido"));
				user.setUsername(rs.getString("username"));
				user.setPerfil(rs.getString("perfil"));
				user.setSenha(rs.getString("senha"));

				return user;
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao autenticar" + e.getMessage());
		}
		return null;
	}
	//este metodo e responsavel por buscar/encontrar a senha Incial de cada user
	public String encontrarSenhaInicial(String username) throws SQLException {
		Connection con = Conexao.conectar();
		PreparedStatement stmt = null;
		stmt = con.prepareStatement("Select senhaInicial from users where username = ?");
		stmt.setString(1, username);
		ResultSet rs = stmt.executeQuery();
		String senhaInicial = null;
		if(rs.next()) {
			senhaInicial = rs.getString("senhaInicial");
		}
		con.close();
		return senhaInicial;
		
	}
	
	//reset da senha, depois de ser encontrado este metodo devolve a senha INCIAL (retornar a senha padrao do ususario)
	public void resetarSenha(String username) throws SQLException {
		Connection con = Conexao.conectar();
		PreparedStatement stmt = null;
		stmt = con.prepareStatement("update users set senha = senhaInicial where username = ?");
		stmt.setString(1, username);
		stmt.executeUpdate();
		con.close();
	}
	
	public void alterarSenha(String username,String novaSenha) throws SQLException {
		Connection con = Conexao.conectar();
		PreparedStatement stmt = null;
		stmt = con.prepareStatement("update users set senha=? where username=? ");
		stmt.setString(1, novaSenha);
		stmt.setString(2,username);
		stmt.executeUpdate();
		con.close();
		
	}

}
