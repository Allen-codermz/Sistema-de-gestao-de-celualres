package controller.celular;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.celular.DaoCor;
import model.celular.Cor;

public class ControllerCor {
	
	private static DaoCor dao = new DaoCor();
	private ControllerLog log = new ControllerLog();

	public void adicionarCor(String usuario,String perfil,String cor) throws SQLException {
		String descricao = CorApiService.buscarDescricao(cor);
		dao.adicionarCor(cor, descricao);
		log.registarLog(usuario, perfil, "Adicionou uma nova cor");
	}

	public static ArrayList<Cor> listaDeCores() throws ClassNotFoundException, SQLException {
		return dao.listaDeCores();
	}

	public void actualizarCor(String usuario,String perfil,int codigoCor, String cor) throws SQLException {
		String descricao = CorApiService.buscarDescricao(cor);
		dao.actualizarCor(codigoCor, cor, descricao);
		log.registarLog(usuario, perfil, "Actualizou uma cor com o codigo"+codigoCor);
	}

	public void removerCor(String usuario,String perfil,int codigoCor) throws SQLException {
		dao.removerCor(codigoCor);
		log.registarLog(usuario, perfil, "Removeu uma cor com o codigo "+codigoCor);
	}

}
