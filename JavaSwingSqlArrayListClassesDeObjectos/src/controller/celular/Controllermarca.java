package controller.celular;

import java.sql.SQLException;
import java.util.ArrayList;
import dao.celular.DaoMarca;
import model.celular.Marca;

public class Controllermarca {
	private DaoMarca dao = new DaoMarca();
	private ControllerLog log = new ControllerLog();
	
	public void adicionarMarca(String usuario,String perfil,String marca) throws SQLException {
		dao.adicionarMarca(marca);
		log.registarLog(usuario, perfil,"Adicionou uma marca");
	}

	public ArrayList<Marca> listaDeMarcas() throws ClassNotFoundException, SQLException {
		return dao.listaDeMarcas();
	}

	public void actualizarMarca(String usuario,String perfil,int codigoMarca, String marca) throws SQLException {
		dao.actualizarMarca(codigoMarca, marca);
		log.registarLog(usuario, perfil,"Actualizou uma marca com o codigo "+codigoMarca);
	}

	public void removerMarca(String usuario,String perfil,int codigoMarca) throws SQLException {
		dao.removerMarca(codigoMarca);
		log.registarLog(usuario, perfil, "Removeu uma marca com o codigo "+codigoMarca);
	}
}
