package dao.celular;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import controller.celular.Conexao;
import model.celular.Celular;

public class DaoCelular {
//	creat
	public void adicionarCelular( int codigoMarca,int codigoModelo,int codigoCor,int  codigoFabricante,double preco, int anoDeFabrico) throws SQLException {
		Connection con = Conexao.conectar();
		PreparedStatement stmt = null;
		stmt = con.prepareStatement("insert into celulares (codigoMarca, codigoModelo, CodigoCor , codigoFabricante, preco, anoDeFabrico) values(?,?,?,?,?,?)");
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
		stmt = con.prepareStatement("SELECT * FROM celulares");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			int codigo = rs.getInt(1);
			double preco = rs.getDouble(2);
			int anoDeFabrico = rs.getInt(3);
			celulares.add(new Celular(codigo, preco, anoDeFabrico));
		}
		con.close();
		return celulares;
	}
	
//	update
	public void actualizarCelular(int codigo, double preco, int anoDeFabrico) throws SQLException {
		Connection con = Conexao.conectar();
		PreparedStatement stmt = null;
		stmt = con.prepareStatement(
				"update celulares set  preco=?, anoDeFabrico=? where numeroDeSerie=?");
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
