
package controller.celular;

import java.sql.SQLException;
import java.util.ArrayList;
import dao.celular.DaoCelular;
import model.celular.Celular;

public class ControllerCelular {
	private DaoCelular dao = new DaoCelular();
	private ControllerLog log = new ControllerLog();

	public void adicionarCelular(String usuario,String perfil, double preco, int anoDeFabrico) throws SQLException {
		dao.adicionarCelular( preco, anoDeFabrico);
		log.registarLog(usuario, perfil, "Adicionou um celular");
	}

	public ArrayList<Celular> listaDeCelulares() throws ClassNotFoundException, SQLException {
		return dao.listaDeCelulares();
	}

	public void actualizarCelular(String usuario,String perfil,int codigo, double preco, int anoDeFabrico) throws SQLException {
		dao.actualizarCelular(codigo,preco, anoDeFabrico);
		log.registarLog(usuario, perfil, "Actualizou um celular com o codigo"+codigo);
	}

	public void removerCelular(String usuario,String perfil,int codigo) throws SQLException {
		dao.removerCelular(codigo);
		log.registarLog(usuario, perfil, "Removeu um  celular com o codigo"+codigo);
	}
}
