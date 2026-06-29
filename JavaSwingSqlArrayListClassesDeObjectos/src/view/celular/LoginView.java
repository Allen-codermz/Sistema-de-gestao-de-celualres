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
	private JTextField textNome;
	private JPasswordField passwordSenha;

	private JButton btnIniciarSessao;
	private JTextField textApelido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView window = new LoginView();
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
	public LoginView() {
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
		panel_1.setBounds(532, 75, 309, 41);
		panel_1.setBackground(new Color(240, 237, 229));
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Iniciar Sessão");
		lblNewLabel.setForeground(new Color(0, 70, 67));
		lblNewLabel.setFont(new Font("Caladea", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel.setBounds(26, 0, 271, 34);
		panel_1.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBounds(532, 215, 309, 474);
		panel.setBackground(new Color(240, 237, 229));
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		textNome = new JTextField();
		textNome.setFont(new Font("Caladea", Font.PLAIN, 14));
		textNome.setForeground(new Color(0, 70, 67));
		textNome.setBackground(new Color(240, 237, 229));
		textNome.setBounds(71, 77, 174, 46);
		panel.add(textNome);
		textNome.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Nome usuario");
		lblNewLabel_1.setFont(new Font("Caladea", Font.BOLD, 14));
		lblNewLabel_1.setForeground(new Color(0, 70, 67));
		lblNewLabel_1.setBackground(new Color(0, 70, 67));
		lblNewLabel_1.setBounds(75, 58, 103, 17);
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
		btnIniciarSessao.setBounds(9, 391, 138, 45);
		btnIniciarSessao.addActionListener(this);
		panel.add(btnIniciarSessao);

		JButton btnResetarSenha = new JButton("Resetar Senha");
		btnResetarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetSenhaView reset = new resetSenhaView();
				reset.setVisible(true);
			}
		});
		btnResetarSenha.setForeground(new Color(240, 237, 229));
		btnResetarSenha.setFont(new Font("Caladea", Font.BOLD, 14));
		btnResetarSenha.setBackground(new Color(0, 70, 67));
		btnResetarSenha.setBounds(159, 391, 138, 45);
		panel.add(btnResetarSenha);

		textApelido = new JTextField();
		textApelido.setFont(new Font("Caladea", Font.PLAIN, 14));
		textApelido.setForeground(new Color(0, 70, 67));
		textApelido.setColumns(10);
		textApelido.setBackground(new Color(240, 237, 229));
		textApelido.setBounds(71, 173, 174, 46);
		panel.add(textApelido);

		JLabel lblNewLabel_1_1 = new JLabel("Apelido usuario");
		lblNewLabel_1_1.setForeground(new Color(0, 70, 67));
		lblNewLabel_1_1.setFont(new Font("Caladea", Font.BOLD, 14));
		lblNewLabel_1_1.setBackground(new Color(0, 70, 67));
		lblNewLabel_1_1.setBounds(75, 154, 138, 17);
		panel.add(lblNewLabel_1_1);
	}

	public void iniciarSessao() {
		String nome = textNome.getText();
		String apelido = textApelido.getText();
		String senha = String.valueOf(passwordSenha.getPassword());
	
		if(nome.isEmpty()||apelido.isEmpty()||senha.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Por favor preecha os campos");
			return;
		}
		ControllerLogin controller = new ControllerLogin();
		CadastroUser usuario = controller.autenticaUser(nome, apelido, senha);
		if (usuario != null) {

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
