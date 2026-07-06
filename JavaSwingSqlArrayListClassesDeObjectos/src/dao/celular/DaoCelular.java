package dao.celular;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import controller.celular.Conexao;
import model.celular.Celular;
import model.celular.Cor;
import model.celular.Fabricante;
import model.celular.Marca;
import model.celular.Modelo;

public class DaoCelular {
//	creat
	public void adicionarCelular(int codigoMarca, int codigoModelo, int codigoCor, int codigoFabricante, double preco,
			int anoDeFabrico) throws SQLException {
		Connection con = Conexao.conectar();
		PreparedStatement stmt = null;
		stmt = con.prepareStatement(
				"insert into celulares (codigoMarca, codigoModelo, CodigoCor , codigoFabricante, preco, anoDeFabrico) values(?,?,?,?,?,?)");
		stmt.setInt(1, codigoMarca);
		stmt.setInt(2, codigoModelo);
		stmt.setInt(3, codigoCor);
		stmt.setInt(4, codigoFabricante);
		stmt.setDouble(5, preco);
		stmt.setInt(6, anoDeFabrico);
		stmt.executeUpdate();
		con.close();

	}

// read
	public ArrayList<Celular> listaDeCelulares() throws SQLException, ClassNotFoundException {
		ArrayList<Celular> celulares = new ArrayList<Celular>();
		PreparedStatement stmt = null;
		Connection con = Conexao.conectar();
		stmt = con.prepareStatement("SELECT c.numeroDeSerie, c.preco, c.anoDeFabrico, " + "m.codigoMarca, m.marca, "
				+ "mo.codigoModelo, mo.modelo, " + "co.codigoCor, co.Cor, co.descricao, "
				+ "f.codigoFabricante, f.fabricante, f.paisDeOrigem " + "FROM celulares c "
				+ "JOIN marca m ON c.codigoMarca = m.codigoMarca "
				+ "JOIN modelo mo ON c.codigoModelo = mo.codigoModelo " + "JOIN cor co ON c.codigoCor = co.codigoCor "
				+ "JOIN fabricante f ON c.codigoFabricante = f.codigoFabricante " 
				+ "ORDER BY c.numeroDeSerie ASC");

		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			int codigo = rs.getInt("numeroDeSerie");
			double preco = rs.getDouble("preco");
			int anoDeFabrico = rs.getInt("anoDeFabrico");

			Marca marca = new Marca(rs.getInt("codigoMarca"), rs.getString("marca"));
			Modelo modelo = new Modelo(rs.getInt("codigoModelo"), rs.getString("modelo"));
			Cor cor = new Cor(rs.getInt("codigoCor"), rs.getString("cor"), rs.getString("descricao"));
			Fabricante fabricante = new Fabricante(rs.getInt("codigoFabricante"), rs.getString("fabricante"),
					rs.getString("paisDeOrigem"));

			Celular celular = new Celular(codigo, preco, anoDeFabrico);
			celular.setMarca(marca);
			celular.setModelo(modelo);
			celular.setCor(cor);
			celular.setFabricante(fabricante);

			celulares.add(celular);
		}
		con.close();
		return celulares;
	}

//	update
	public void actualizarCelular(int codigo, double preco, int anoDeFabrico) throws SQLException {
		Connection con = Conexao.conectar();
		PreparedStatement stmt = null;
		stmt = con.prepareStatement("update celulares set  preco=?, anoDeFabrico=? where numeroDeSerie=?");
		stmt.setDouble(1, preco);
		stmt.setInt(2, anoDeFabrico);
		stmt.setInt(3, codigo);
		stmt.executeUpdate();
		con.close();
	}

//	delete
	public void removerCelular(int codigo) throws SQLException {

		Connection con = Conexao.conectar();
		PreparedStatement stmt = null;
		stmt = con.prepareStatement("delete from celulares where numeroDeSerie=?");
		stmt.setInt(1, codigo);
		stmt.executeUpdate();
		con.close();
	}

}
