package view.celular;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import controller.celular.ControllerCadastroUser;
import controller.celular.ControllerLogin;
import model.celular.CadastroUser;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AlterarsenhaView implements ActionListener {

	private JFrame frame;
	private JTextField textUsername;
	private JPasswordField passwordSenhaNova;
	private JPasswordField passwordSenhaAntiga;
	
	private JButton btnAlterarSenha;
	
	private CadastroUser usuarioLogado;

	/**
	 * Launch the application.
	 */

	

	/**
	 * Create the application.
	 */
	public AlterarsenhaView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(240, 237, 229));
		frame.setBounds(100, 100, 1403, 832);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(240, 237, 229));
		panel_1.setBounds(861, 53, 309, 41);
		frame.getContentPane().add(panel_1);
		
		JLabel lblAlterarSenha = new JLabel("Alterar Senha");
		lblAlterarSenha.setForeground(new Color(0, 70, 67));
		lblAlterarSenha.setFont(new Font("Caladea", Font.BOLD | Font.ITALIC, 40));
		lblAlterarSenha.setBounds(26, 0, 271, 34);
		panel_1.add(lblAlterarSenha);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(240, 237, 229));
		panel.setBounds(861, 135, 309, 475);
		frame.getContentPane().add(panel);
		
		textUsername = new JTextField();
		textUsername.setForeground(new Color(0, 70, 67));
		textUsername.setFont(new Font("Caladea", Font.PLAIN, 14));
		textUsername.setColumns(10);
		textUsername.setBackground(new Color(240, 237, 229));
		textUsername.setBounds(71, 81, 174, 46);
		panel.add(textUsername);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setForeground(new Color(0, 70, 67));
		lblNewLabel_1.setFont(new Font("Caladea", Font.BOLD, 14));
		lblNewLabel_1.setBackground(new Color(0, 70, 67));
		lblNewLabel_1.setBounds(71, 52, 103, 17);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Senha nova");
		lblNewLabel_2.setForeground(new Color(0, 70, 67));
		lblNewLabel_2.setFont(new Font("Caladea", Font.BOLD, 14));
		lblNewLabel_2.setBounds(74, 245, 100, 17);
		panel.add(lblNewLabel_2);
		
		passwordSenhaNova = new JPasswordField();
		passwordSenhaNova.setForeground(new Color(0, 70, 67));
		passwordSenhaNova.setFont(new Font("Dialog", Font.BOLD, 14));
		passwordSenhaNova.setBackground(new Color(240, 237, 229));
		passwordSenhaNova.setBounds(71, 268, 174, 46);
		panel.add(passwordSenhaNova);
		
		btnAlterarSenha = new JButton("Alterar senha");
		btnAlterarSenha.addActionListener(this);
		btnAlterarSenha.setForeground(new Color(240, 237, 229));
		btnAlterarSenha.setFont(new Font("Caladea", Font.BOLD, 14));
		btnAlterarSenha.setBackground(new Color(0, 70, 67));
		btnAlterarSenha.setBounds(85, 372, 138, 45);
		panel.add(btnAlterarSenha);
		
		JLabel lblNewLabel_1_1 = new JLabel("Senha Antiga");
		lblNewLabel_1_1.setForeground(new Color(0, 70, 67));
		lblNewLabel_1_1.setFont(new Font("Caladea", Font.BOLD, 14));
		lblNewLabel_1_1.setBackground(new Color(0, 70, 67));
		lblNewLabel_1_1.setBounds(71, 148, 103, 17);
		panel.add(lblNewLabel_1_1);
		
		passwordSenhaAntiga = new JPasswordField();
		passwordSenhaAntiga.setForeground(new Color(0, 70, 67));
		passwordSenhaAntiga.setFont(new Font("Caladea", Font.PLAIN, 14));
		passwordSenhaAntiga.setColumns(10);
		passwordSenhaAntiga.setBackground(new Color(240, 237, 229));
		passwordSenhaAntiga.setBounds(71, 177, 174, 46);
		panel.add(passwordSenhaAntiga);
		
		JButton btnTelaPrincipal = new JButton("Voltar");
		btnTelaPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginView login = new LoginView(usuarioLogado);
				login.setVisible(true);
			}
		});
		btnTelaPrincipal.setForeground(new Color(240, 237, 229));
		btnTelaPrincipal.setFont(new Font("Caladea", Font.BOLD, 14));
		btnTelaPrincipal.setBackground(new Color(0, 70, 67));
		btnTelaPrincipal.setBounds(1272, 30, 91, 45);
		frame.getContentPane().add(btnTelaPrincipal);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(0, 70, 67));
		panel_2.setBounds(12, 34, 741, 654);
		frame.getContentPane().add(panel_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("''ORGANIZAR, CONTROLAR");
		lblNewLabel_1_1_1.setForeground(new Color(240, 237, 229));
		lblNewLabel_1_1_1.setFont(new Font("Caladea", Font.BOLD, 55));
		lblNewLabel_1_1_1.setBounds(12, 69, 717, 127);
		panel_2.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("E GERIR CELULARES");
		lblNewLabel_2_1.setForeground(new Color(240, 237, 229));
		lblNewLabel_2_1.setFont(new Font("Caladea", Font.BOLD, 55));
		lblNewLabel_2_1.setBounds(98, 208, 511, 78);
		panel_2.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("NUNCA FOI");
		lblNewLabel_3.setForeground(new Color(240, 237, 229));
		lblNewLabel_3.setFont(new Font("Caladea", Font.BOLD, 55));
		lblNewLabel_3.setBounds(198, 298, 297, 102);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("SIMPLES''");
		lblNewLabel_2_1_1.setForeground(new Color(240, 237, 229));
		lblNewLabel_2_1_1.setFont(new Font("Caladea", Font.BOLD, 55));
		lblNewLabel_2_1_1.setBounds(245, 511, 380, 78);
		panel_2.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("TÃO");
		lblNewLabel_3_1.setForeground(new Color(240, 237, 229));
		lblNewLabel_3_1.setFont(new Font("Caladea", Font.BOLD, 55));
		lblNewLabel_3_1.setBounds(289, 412, 134, 102);
		panel_2.add(lblNewLabel_3_1);
	}
	
	public void alterarSenha() {
		String username = textUsername.getText();
		String senhaAntiga = String.valueOf(passwordSenhaAntiga.getPassword());
		String senhaNova = String.valueOf(passwordSenhaNova.getPassword());
		
		if(username.isEmpty() || senhaAntiga.isEmpty()|| senhaNova.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos!!");
			return;
		}
		
		if(senhaNova.equals(senhaAntiga)) {
			JOptionPane.showMessageDialog(null, "A nova senha deve ser diferente da senha antiga");
			return;
		}
		
		ControllerLogin controller = new ControllerLogin();
		CadastroUser usuario = controller.autenticaUser(username, senhaAntiga);
		
		if(usuario == null) {
			JOptionPane.showMessageDialog(null,"Verifique a senha ou o username e tente novamente!!");
			return;
		}
		try {
			ControllerCadastroUser user = new ControllerCadastroUser();
			user.alterarSenha(username, usuario.getPerfil(), senhaNova);
			JOptionPane.showMessageDialog(null, "Senha alterada com sucesso");
			frame.dispose();
		}catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao alterar Senha: "+ex.getMessage());
		}
		
	}

	public void setVisibe(boolean visible) {
		frame.setVisible(visible);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnAlterarSenha) {
			alterarSenha();
		}
	}
}
