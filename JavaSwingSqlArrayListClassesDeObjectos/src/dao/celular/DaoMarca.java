package dao.celular;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import controller.celular.Conexao;
import model.celular.Marca;

public class DaoMarca {
//	creat
	public void adicionarMarca(String marca) throws SQLException {
		Connection con = Conexao.conectar();
		PreparedStatement stmt = null;
		stmt = con.prepareStatement("insert into marca (marca) values(?)");
		stmt.setString(1, marca);
		stmt.executeUpdate();
		con.close();

	}

// read
	public ArrayList<Marca> listaDeMarcas() throws SQLException, ClassNotFoundException {
		ArrayList<Marca> celulares = new ArrayList<Marca>();
		PreparedStatement stmt = null;
		Connection con = Conexao.conectar();
		stmt = con.prepareStatement("SELECT * FROM marca");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			int codigoMarca = rs.getInt(1);
			String marca = rs.getString(2);

			celulares.add(new Marca(codigoMarca, marca));
		}
		con.close();
		return celulares;
	}

//	update
	public void actualizarMarca(int codigoMarca, String marca) throws SQLException {
		Connection con = Conexao.conectar();
		PreparedStatement stmt = null;
		stmt = con.prepareStatement("update marca set marca=? where codigoMarca=?");
		stmt.setString(1, marca);
		stmt.setInt(2, codigoMarca);
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
