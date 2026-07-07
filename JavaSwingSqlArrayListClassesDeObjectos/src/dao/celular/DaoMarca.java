package dao.celular;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import controller.celular.Conexao;
import model.celular.Fabricante;
import model.celular.Marca;

public class DaoMarca {
//	creat
	public void adicionarMarca(String marca,int codigoFabricante) throws SQLException {
		Connection con = Conexao.conectar();
		PreparedStatement stmt = null;
		stmt = con.prepareStatement("insert into marca (marca,codigoFabricante) values(?,?)");
		stmt.setString(1, marca);
		stmt.setInt(2, codigoFabricante);
		stmt.executeUpdate();
		con.close();

	}

// read
	public ArrayList<Marca> listaDeMarcas() throws SQLException, ClassNotFoundException {
		ArrayList<Marca> marcas = new ArrayList<Marca>();
		PreparedStatement stmt = null;
		Connection con = Conexao.conectar();
		stmt = con.prepareStatement("SELECT m.codigoMarca,m.marca, f.codigoFabricante, f.fabricante, f.paisDeOrigem " + "FROM marca m "
				+ "JOIN fabricante f ON m.codigoFabricante = f.codigoFabricante " + "ORDER BY m.codigoMarca ASC");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			int codigoMarca = rs.getInt(1);
			String marca1 = rs.getString(2);

			Fabricante fabricante = new Fabricante(rs.getInt("codigoFabricante"), rs.getString("fabricante"),
					rs.getString("paisDeOrigem"));
			
			Marca marca = new Marca(codigoMarca,marca1);
			marca.setFabricante(fabricante);
			
			marcas.add(marca);
		}
		con.close();
		return marcas;
	}

//	update
	public void actualizarMarca(int codigoMarca, String marca,int codigoFabricante) throws SQLException {
		Connection con = Conexao.conectar();
		PreparedStatement stmt = null;
		stmt = con.prepareStatement("update marca set marca=?,codigoFabricante=? where codigoMarca=?");
		stmt.setString(1, marca);
		stmt.setInt(2,codigoFabricante);
		stmt.setInt(3, codigoMarca);
		stmt.executeUpdate();
		con.close();
	}

//	delete
	public void removerMarca(int codigoMarca) throws SQLException {

		Connection con = Conexao.conectar();
		PreparedStatement stmt = null;
		stmt = con.prepareStatement("delete from marca where codigoMarca=?");
		stmt.setInt(1, codigoMarca);
		stmt.executeUpdate();
		con.close();

	}

}
