package controller.celular;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.celular.DaoLog;
import model.celular.Log;

public class ControllerLog {
	private DaoLog dao = new DaoLog();
	
	public void registarLog(String usuario,String perfil, String accao) throws SQLException {
		dao.registarLog(usuario, perfil, accao);
	}

	public ArrayList<Log> listaDeLogs() throws ClassNotFoundException, SQLException {
		return dao.listaDeLogs();
	}
}
