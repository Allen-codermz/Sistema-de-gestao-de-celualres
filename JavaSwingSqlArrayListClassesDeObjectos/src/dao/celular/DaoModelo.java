package dao.celular;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.celular.Conexao;
import model.celular.Marca;
import model.celular.Modelo;

public class DaoModelo {
//	creat
	public void adicionarModelo(String modelo, int codigoMarca) throws SQLException {
		Connection con = Conexao.conectar();
		PreparedStatement stmt = null;
		stmt = con.prepareStatement("insert into modelo (modelo, codigoMarca) values(?,?)");
		stmt.setString(1, modelo);
		stmt.setInt(2, codigoMarca);
		stmt.executeUpdate();
		con.close();

	}

// read
	public ArrayList<Modelo> listaDeModelos() throws SQLException, ClassNotFoundException {
		ArrayList<Modelo> modelos = new ArrayList<Modelo>();
		PreparedStatement stmt = null;
		Connection con = Conexao.conectar();
		stmt = con.prepareStatement("SELECT mo.codigoModelo, mo.modelo, m.codigoMarca, m.marca " 
		+ "FROM modelo mo "
		+ "JOIN marca m ON mo.codigoMarca = m.codigoMarca "
		+"ORDER BY mo.codigoModelo ASC");
		
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			int codigoModelo = rs.getInt("codigoModelo");
			String modelo1 = rs.getString("modelo");
			Marca marca = new Marca(rs.getInt("codigoMarca"), rs.getString("marca"));

			Modelo modelo = new Modelo(codigoModelo,modelo1);
			modelo.setMarca(marca);
			
			modelos.add(modelo);
		}
		con.close();
		return modelos;
	}

//	update
	public void actualizarModelo(int codigoModelo, String modelo) throws SQLException {
		Connection con = Conexao.conectar();
		PreparedStatement stmt = null;
		stmt = con.prepareStatement("update modelo set modelo=? where codigoModelo=?");
		stmt.setString(1, modelo);
		stmt.setInt(2, codigoModelo);
		stmt.executeUpdate();
		con.close();

	}

//	delete
	public void removerModelo(int codigoModelo) throws SQLException {

		Connection con = Conexao.conectar();
		PreparedStatement stmt = null;
		stmt = con.prepareStatement("delete from modelo where codigoModelo=?");
		stmt.setInt(1, codigoModelo);
		stmt.executeUpdate();
		con.close();

	}

}
