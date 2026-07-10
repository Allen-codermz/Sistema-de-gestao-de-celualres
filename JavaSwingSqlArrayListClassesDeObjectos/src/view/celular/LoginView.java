package view.celular;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.celular.ControllerLogin;
import model.celular.CadastroUser;

import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginView implements ActionListener {

	private JFrame frame;
	private JTextField textUsername;
	private JPasswordField passwordSenha;

	private JButton btnIniciarSessao;
	private CadastroUser usuarioLogado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView window = new LoginView(null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();  
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginView(CadastroUser usuario) {
		this.usuarioLogado = usuario;
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
		panel_1.setBounds(900, 60, 309, 41);
		panel_1.setBackground(new Color(240, 237, 229));
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Iniciar Sessão");
		lblNewLabel.setForeground(new Color(0, 70, 67));
		lblNewLabel.setFont(new Font("Caladea", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel.setBounds(26, 0, 271, 34);
		panel_1.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBounds(886, 138, 309, 475);
		panel.setBackground(new Color(240, 237, 229));
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		textUsername = new JTextField();
		textUsername.setFont(new Font("Caladea", Font.PLAIN, 14));
		textUsername.setForeground(new Color(0, 70, 67));
		textUsername.setBackground(new Color(240, 237, 229));
		textUsername.setBounds(71, 165, 174, 46);
		panel.add(textUsername);
		textUsername.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Caladea", Font.BOLD, 14));
		lblNewLabel_1.setForeground(new Color(0, 70, 67));
		lblNewLabel_1.setBackground(new Color(0, 70, 67));
		lblNewLabel_1.setBounds(71, 136, 103, 17);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Senha");
		lblNewLabel_2.setFont(new Font("Caladea", Font.BOLD, 14));
		lblNewLabel_2.setForeground(new Color(0, 70, 67));
		lblNewLabel_2.setBounds(74, 245, 59, 17);
		panel.add(lblNewLabel_2);

		passwordSenha = new JPasswordField();
		passwordSenha.setFont(new Font("Dialog", Font.BOLD, 14));
		passwordSenha.setForeground(new Color(0, 70, 67));
		passwordSenha.setBackground(new Color(240, 237, 229));
		passwordSenha.setBounds(71, 268, 174, 46);
		panel.add(passwordSenha);

		btnIniciarSessao = new JButton("Iniciar Sessão");
		btnIniciarSessao.setFont(new Font("Caladea", Font.BOLD, 14));
		btnIniciarSessao.setBackground(new Color(0, 70, 67));
		btnIniciarSessao.setForeground(new Color(240, 237, 229));
		btnIniciarSessao.setBounds(12, 382, 138, 45);
		btnIniciarSessao.addActionListener(this);
		panel.add(btnIniciarSessao);

		JButton btnAlterarSenha = new JButton("Alterar senha");
		btnAlterarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlterarsenhaView alterar = new AlterarsenhaView();
				alterar.setVisibe(true);
			}
		});
		btnAlterarSenha.setForeground(new Color(240, 237, 229));
		btnAlterarSenha.setFont(new Font("Caladea", Font.BOLD, 14));
		btnAlterarSenha.setBackground(new Color(0, 70, 67));
		btnAlterarSenha.setBounds(162, 382, 138, 45);
		panel.add(btnAlterarSenha);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(0, 70, 67));
		panel_2.setBounds(12, 27, 741, 654);
		frame.getContentPane().add(panel_2);

		JLabel lblNewLabel_1_1 = new JLabel("''EFICIÊNCIA  EM");
		lblNewLabel_1_1.setForeground(new Color(240, 237, 229));
		lblNewLabel_1_1.setFont(new Font("Caladea", Font.BOLD, 60));
		lblNewLabel_1_1.setBounds(12, 69, 521, 127);
		panel_2.add(lblNewLabel_1_1);

		JLabel lblNewLabel_2_1 = new JLabel("CADA CADASTRO,");
		lblNewLabel_2_1.setForeground(new Color(240, 237, 229));
		lblNewLabel_2_1.setFont(new Font("Caladea", Font.BOLD, 60));
		lblNewLabel_2_1.setBounds(72, 194, 511, 78);
		panel_2.add(lblNewLabel_2_1);

		JLabel lblNewLabel_3 = new JLabel("CONFIANÇA EM");
		lblNewLabel_3.setForeground(new Color(240, 237, 229));
		lblNewLabel_3.setFont(new Font("Caladea", Font.BOLD, 60));
		lblNewLabel_3.setBounds(185, 284, 456, 102);
		panel_2.add(lblNewLabel_3);

		JLabel lblNewLabel_2_1_1 = new JLabel("CADA CONSULTA''");
		lblNewLabel_2_1_1.setForeground(new Color(240, 237, 229));
		lblNewLabel_2_1_1.setFont(new Font("Caladea", Font.BOLD, 60));
		lblNewLabel_2_1_1.setBounds(230, 386, 511, 78);
		panel_2.add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_4 = new JLabel("Developed by Allen Dinis");
		lblNewLabel_4.setFont(new Font("Caladea", Font.ITALIC, 10));
		lblNewLabel_4.setForeground(new Color(240, 237, 229));
		lblNewLabel_4.setBounds(12, 625, 163, 17);
		panel_2.add(lblNewLabel_4);
	}

	public void iniciarSessao() {
		String username = textUsername.getText();
		String senha = String.valueOf(passwordSenha.getPassword());

		if (username.isEmpty() || senha.isEmpty() || username.isBlank() || senha.isBlank()) {
			JOptionPane.showMessageDialog(null, "Por favor preecha os campos");
			return;
		}
		ControllerLogin controller = new ControllerLogin();
		CadastroUser usuario = controller.autenticaUser(username, senha);
		if (usuario != null) {

			boolean senhaPadrao = usuario.getSenhaInicial() != null && usuario.getSenha() != null
					&& usuario.getSenha().equals(usuario.getSenhaInicial());
			if (senhaPadrao) {
				JOptionPane.showMessageDialog(null,
						"Ainda esta com a sua senha padrão, será redirecionado para um formulario para a sua alteração!");

				AlterarsenhaView reset = new AlterarsenhaView();
				reset.setVisible(true);
				frame.dispose();
				return;
			}
			TelaPrincipalView tela = new TelaPrincipalView(usuario);
			tela.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(null, "Credenciais invalida!!");
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnIniciarSessao) {
			iniciarSessao();
		}
	}

	public void setVisible(boolean visible) {
		frame.setVisible(true);
	}

}
