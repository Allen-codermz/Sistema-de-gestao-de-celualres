package controller.celular;

import dao.celular.DaoCadastroUser;
import model.celular.CadastroUser;

public class ControllerLogin {

	private DaoCadastroUser dao = new DaoCadastroUser();
	private ControllerLog log = new ControllerLog();

	public CadastroUser autenticaUser(String username, String senha) {
		CadastroUser usuario = dao.autenticarUser(username, senha);
		if (usuario != null) {
			try {
				log.registarLog(usuario.getUsername(), usuario.getPerfil(), "Iniciou Sessão");
			} catch (java.sql.SQLException e) {
				e.printStackTrace();
			}
		}
		return usuario;

	}

}
