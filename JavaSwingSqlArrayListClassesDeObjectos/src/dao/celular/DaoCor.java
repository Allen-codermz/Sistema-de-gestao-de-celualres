package dao.celular;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.celular.Conexao;
import model.celular.Cor;

public class DaoCor {
	public void adicionarCor(String cor) throws SQLException {
		Connection con = Conexao.conectar();
		PreparedStatement stmt = null;
		stmt = con.prepareStatement("insert into cor(nomeHexa) values(?)");
		stmt.setString(1, cor);
		stmt.executeUpdate();
		con.close();

	}

// read
	public ArrayList<Cor> listaDeCores() throws SQLException, ClassNotFoundException {
		ArrayList<Cor> modelos = new ArrayList<Cor>();
		PreparedStatement stmt = null;
		Connection con = Conexao.conectar();
		stmt = con.prepareStatement("SELECT * FROM cor");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			int codigoModelo = rs.getInt(1);
			String modelo = rs.getString(2);

			modelos.add(new Cor(codigoModelo, modelo));
		}
		con.close();
		return modelos;
	}

//	update
	public void actualizarCor(int codigoCor, String cor) throws SQLException {
		Connection con = Conexao.conectar();
		PreparedStatement stmt = null;
		stmt = con.prepareStatement("update cor set nomeHexa=? where codigoCor=?");
		stmt.setString(1, cor);
		stmt.setInt(2, codigoCor);
		stmt.executeUpdate();
		con.close();

	}

//	delete
	public void removerCor(int codigoCor) throws SQLException {

		Connection con = Conexao.conectar();
		PreparedStatement stmt = null;
		stmt = con.prepareStatement("delete from cor where codigoCor=?");
		stmt.setInt(1, codigoCor);
		stmt.executeUpdate();
		con.close();

	}

}
