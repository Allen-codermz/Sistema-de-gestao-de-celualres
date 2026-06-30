package dao.celular;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.celular.Conexao;
import model.celular.Cor;

public class DaoCor {
	public void adicionarCor(String cor, String descricao) throws SQLException {
		Connection con = Conexao.conectar();
		PreparedStatement stmt = null;
		stmt = con.prepareStatement("insert into cor(cor, descricao) values(?,?)");
		stmt.setString(1, cor);
		stmt.setString(2, descricao);
		stmt.executeUpdate();
		con.close();

	}

// read
	public ArrayList<Cor> listaDeCores() throws SQLException, ClassNotFoundException {
		ArrayList<Cor> cores = new ArrayList<Cor>();
		PreparedStatement stmt = null;
		Connection con = Conexao.conectar();
		stmt = con.prepareStatement("SELECT * FROM cor");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			int codigoCor = rs.getInt(1);
			String cor = rs.getString(2);
			String descricao = rs.getString(3);

			cores.add(new Cor(codigoCor, cor, descricao));
		}
		con.close();
		return cores;
	}

//	update
	public void actualizarCor(int codigoCor, String cor,String descricao) throws SQLException {
		Connection con = Conexao.conectar();
		PreparedStatement stmt = null;
		stmt = con.prepareStatement("update cor set cor=? , descricao=? where codigoCor=?");
		stmt.setString(1, cor);
		stmt.setString(2, descricao);
		stmt.setInt(3, codigoCor);
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
