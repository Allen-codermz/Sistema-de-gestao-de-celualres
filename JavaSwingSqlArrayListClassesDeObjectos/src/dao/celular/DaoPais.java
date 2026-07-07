package dao.celular;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.celular.Conexao;
import model.celular.Continente;
import model.celular.Pais;

public class DaoPais {
	public static ArrayList<Pais> listaDePais() throws SQLException, ClassNotFoundException {
		ArrayList<Pais> paises = new ArrayList<Pais>();
		PreparedStatement stmt = null;
		Connection con = Conexao.conectar();
		stmt = con.prepareStatement("SELECT p.codigoPais, p.pais, c.codigoContinente, c.Continente "
		+ "FROM Pais p "
		+ "JOIN Continente c ON p.codigoContinente = c.codigoContinente " + "ORDER BY p.codigoPais ASC");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			int codigoPais = rs.getInt(1);
			String pais1 = rs.getString(2);
			Continente continente = new Continente(rs.getInt("codigoContinente"), rs.getString("continente"));

			Pais pais = new Pais(codigoPais, pais1);
			pais.setContinente(continente);

			paises.add(pais);
		}
		con.close();
		return paises;
	}
}
