package dao.celular;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.celular.Conexao;
import model.celular.Log;

public class DaoLog {
	
	public void registarLog(String usuario,String perfil, String accao) throws SQLException {
		Connection con = Conexao.conectar();
		PreparedStatement stmt = null;
		stmt = con.prepareStatement("insert into Celulareslogs (usuario,perfil,accao,dataAccao) values(?,?,?,NOW())");
		stmt.setString(1, usuario);
		stmt.setString(2, perfil);
		stmt.setString(3, accao);
		stmt.executeUpdate();
		con.close();
	}
	
	public ArrayList<Log> listaDeLogs() throws SQLException, ClassNotFoundException {
		ArrayList<Log> logs = new ArrayList<Log>();
		PreparedStatement stmt = null;
		Connection con = Conexao.conectar();
		stmt = con.prepareStatement("SELECT * FROM Celulareslogs ORDER BY dataAccao DESC");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			int codigoLog = rs.getInt(1);
			String usuario = rs.getString(2);
			String perfil = rs.getString(3);
			String accao = rs.getString(4);
			String dataAccao = rs.getString(5);

			logs.add(new Log(codigoLog, usuario,perfil, accao, dataAccao));
		}
		con.close();
		return logs;
	}
}
