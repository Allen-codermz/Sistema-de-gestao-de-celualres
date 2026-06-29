package controller.celular;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.celular.DaoCor;
import model.celular.Cor;

public class ControllerCor {
	
	private DaoCor dao = new DaoCor();
	private ControllerLog log = new ControllerLog();

	public void adicionarCor(String usuario,String perfil,String cor) throws SQLException {
		dao.adicionarCor(cor);
		log.registarLog(usuario, perfil, "Adicionou uma nova cor");
	}

	public ArrayList<Cor> listaDeCores() throws ClassNotFoundException, SQLException {
		return dao.listaDeCores();
	}

	public void actualizarCor(String usuario,String perfil,int codigoCor, String cor) throws SQLException {
		dao.actualizarCor(codigoCor, cor);
		log.registarLog(usuario, perfil, "Actualizou uma cor com o codigo"+codigoCor);
	}

	public void removerCor(String usuario,String perfil,int codigoCor) throws SQLException {
		dao.removerCor(codigoCor);
		log.registarLog(usuario, perfil, "Removeu uma cor com o codigo "+codigoCor);
	}

}
