
package controller.celular;

import java.sql.SQLException;
import java.util.ArrayList;
import dao.celular.DaoFabricante;
import model.celular.Fabricante;

public class ControllerFabricante {
	private DaoFabricante dao = new DaoFabricante();
	private ControllerLog log = new ControllerLog();

	public void adicionarFabricante(String usuario,String perfil,String fabricante, String paisDeOrigem) throws SQLException {
		dao.adicionarFabricante(fabricante, paisDeOrigem);
		log.registarLog(usuario, perfil, "Adicionou um fabricante");
	}

	public ArrayList<Fabricante> listaDeFabricantes() throws ClassNotFoundException, SQLException {
		return dao.listaDeFabricantes();
	}

	public void actualizarFabricante(String usuario,String perfil,int codigoFabricante, String fabricante, String paisDeOrigem) throws SQLException {
		dao.actualizarFabricante(codigoFabricante, fabricante, paisDeOrigem);
		log.registarLog(usuario, perfil,"Actualizou um fabricante com o codigo "+codigoFabricante);
	}

	public void removerFabricante(String usuario,String perfil,int codigoFabricante) throws SQLException {
		dao.removerFabricante(codigoFabricante);
		log.registarLog(usuario, perfil, "Removeu um fabricante com o codigo "+codigoFabricante);
	}
}
