package controller.celular;

import dao.celular.DaoCadastroUser;
import model.celular.CadastroUser;

public class ControllerLogin {

	private DaoCadastroUser dao = new DaoCadastroUser();

	public CadastroUser autenticaUser(String username, String senha) {
		return dao.autenticarUser(username, senha);
	}
}
