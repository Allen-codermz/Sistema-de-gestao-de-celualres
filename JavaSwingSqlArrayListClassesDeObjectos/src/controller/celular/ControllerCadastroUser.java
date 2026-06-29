package controller.celular;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.celular.DaoCadastroUser;
import model.celular.CadastroUser;



public class ControllerCadastroUser {
	private DaoCadastroUser dao = new DaoCadastroUser();
	private ControllerLog log = new ControllerLog();

	public void adicionarUser(String nomeAd ,String perfilAd,String nome, String apelido, String perfil,String senha) throws SQLException {
		
		dao.adicionarUser(nome, apelido, perfil, senha);
		log.registarLog(nomeAd, perfilAd, "Adicionou um usuario com o perfil de "+perfil);
	}

	public ArrayList<CadastroUser> listaDeUsers() throws ClassNotFoundException, SQLException {
		return dao.listaDeUsers();
	}

	public  void actualizarUser(int codigoUser, String nome, String apelido,String nomeAd ,String perfilAd,String novoPerfil) throws SQLException {
		dao.actualizarUser(codigoUser, novoPerfil);
		log.registarLog(nomeAd ,perfilAd, "Actualizou o perfil do usuario "+nome+" "+apelido+" para "+novoPerfil);
	}

	public void removerUser(String nomeAd ,String perfilAd,int codigoUser) throws SQLException {
		dao.removerUser(codigoUser);
		log.registarLog(nomeAd, perfilAd, "Removeu um user com o codigo "+codigoUser);
	}
}
