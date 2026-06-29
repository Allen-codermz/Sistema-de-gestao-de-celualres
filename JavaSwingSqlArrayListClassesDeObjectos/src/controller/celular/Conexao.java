package controller.celular;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class Conexao {

	public static Connection conectar() {
		Connection conexao = null;
		try {
			if (conexao == null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/celular", "root", "Ilovejava@123");
				//JOptionPane.showMessageDialog(null, "CONECTADO COM SUCESSO");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return conexao;
	}

	public static void main(String[] args) {
		conectar();
	}
}
