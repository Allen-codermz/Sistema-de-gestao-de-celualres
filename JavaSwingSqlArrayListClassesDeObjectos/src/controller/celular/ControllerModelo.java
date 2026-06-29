package controller.celular;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.celular.DaoModelo;
import model.celular.Modelo;

public class ControllerModelo {
	private DaoModelo dao = new DaoModelo();
	private ControllerLog log = new ControllerLog();
	public void adicionarModelo(String usuario,String perfil,String modelo) throws SQLException {
		dao.adicionarModelo(modelo);
		log.registarLog(usuario, perfil,"Adicionou um modelo");
	}

	public ArrayList<Modelo> listaDeModelo() throws ClassNotFoundException, SQLException {
		return dao.listaDeModelos();
	}

	public void actualizarModelo(String usuario,String perfil,int codigoModelo, String modelo) throws SQLException {
		dao.actualizarModelo(codigoModelo, modelo);
		log.registarLog(usuario, perfil, "Actualizou um modelo com o codigo "+codigoModelo);
	}

	public void removerModelo(String usuario,String perfil,int codigoModelo) throws SQLException {
		dao.removerModelo(codigoModelo);
		log.registarLog(usuario, perfil, "Removeu um modelo com o codigo "+ codigoModelo);
	}
}
