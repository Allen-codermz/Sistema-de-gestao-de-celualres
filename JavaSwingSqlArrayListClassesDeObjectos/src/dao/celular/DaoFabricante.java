package dao.celular;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import controller.celular.Conexao;
import model.celular.Fabricante;

public class DaoFabricante {
//	creat
	public void adicionarFabricante(String fabricante, String paisDeOrigem) throws SQLException {
		Connection con = Conexao.conectar();
		PreparedStatement stmt = null;
		stmt = con.prepareStatement("insert into fabricante (fabricante, paisDeOrigem) values(?,?)");
		stmt.setString(1, fabricante);
		stmt.setString(2, paisDeOrigem);
		stmt.executeUpdate();
		con.close();

	}

// read
	public ArrayList<Fabricante> listaDeFabricantes() throws SQLException, ClassNotFoundException {
		ArrayList<Fabricante> fabricantes = new ArrayList<Fabricante>();
		PreparedStatement stmt = null;
		Connection con = Conexao.conectar();
		stmt = con.prepareStatement("SELECT * FROM fabricante");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			int codigoFabricante = rs.getInt(1);
			String fabricante = rs.getString(2);
			String paisDeOrigem = rs.getString(3);

			fabricantes.add(new Fabricante(codigoFabricante, fabricante,paisDeOrigem));
		}
		con.close();
		return fabricantes;
	}

//	update
	public void actualizarFabricante(int codigoFabricante, String fabricante,String paisDeOrigem) throws SQLException {
		Connection con = Conexao.conectar();
		PreparedStatement stmt = null;
		stmt = con.prepareStatement("update fabricante set fabricante=?, paisDeOrigem=? where codigoFabricante=?");
		stmt.setString(1, fabricante);
		stmt.setString(2, paisDeOrigem);
		stmt.setInt(3, codigoFabricante);
		stmt.executeUpdate();

		con.close();
	}

//	delete
	public void removerFabricante(int codigo) throws SQLException {

		Connection con = Conexao.conectar();
		PreparedStatement stmt = null;
		stmt = con.prepareStatement("delete from fabricante where codigoFabricante=?");
		stmt.setInt(1, codigo);
		stmt.executeUpdate();

		con.close();
	}
}
