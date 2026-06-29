package view.celular;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.celular.DaoCadastroUser;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class resetSenhaView implements ActionListener {

	private JFrame frame;
	private JTextField textNome;
	private JPasswordField passwordNovaSenha;
	private JTextField textApelido;
	private JPasswordField passwordConfirmar;

	private JButton btnResetarSenha;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public resetSenhaView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setLocation(-560, -198);
		frame.getContentPane().setBackground(new Color(240, 237, 229));
		frame.setBounds(100, 100, 1403, 832);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(240, 237, 229));
		panel.setBounds(554, 107, 309, 539);
		frame.getContentPane().add(panel);

		textNome = new JTextField();
		textNome.setFont(new Font("Caladea", Font.BOLD, 14));
		textNome.setForeground(new Color(0, 70, 67));
		textNome.setColumns(10);
		textNome.setBackground(new Color(240, 237, 229));
		textNome.setBounds(71, 77, 174, 46);
		panel.add(textNome);

		JLabel lblNewLabel_1 = new JLabel("Nome usuario");
		lblNewLabel_1.setForeground(new Color(0, 70, 67));
		lblNewLabel_1.setFont(new Font("Caladea", Font.BOLD, 14));
		lblNewLabel_1.setBackground(new Color(0, 70, 67));
		lblNewLabel_1.setBounds(75, 58, 103, 17);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Nova Senha");
		lblNewLabel_2.setForeground(new Color(0, 70, 67));
		lblNewLabel_2.setFont(new Font("Caladea", Font.BOLD, 14));
		lblNewLabel_2.setBounds(74, 245, 104, 17);
		panel.add(lblNewLabel_2);

		passwordNovaSenha = new JPasswordField();
		passwordNovaSenha.setFont(new Font("Caladea", Font.BOLD, 14));
		passwordNovaSenha.setForeground(new Color(0, 70, 67));
		passwordNovaSenha.setBackground(new Color(240, 237, 229));
		passwordNovaSenha.setBounds(71, 268, 174, 46);
		panel.add(passwordNovaSenha);

		btnResetarSenha = new JButton("Resetar senha");
		btnResetarSenha.setForeground(new Color(240, 237, 229));
		btnResetarSenha.setFont(new Font("Caladea", Font.BOLD, 14));
		btnResetarSenha.setBackground(new Color(0, 70, 67));
		btnResetarSenha.setBounds(88, 450, 138, 45);
		btnResetarSenha.addActionListener(this);
		panel.add(btnResetarSenha);

		textApelido = new JTextField();
		textApelido.setFont(new Font("Caladea", Font.BOLD, 14));
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

		JLabel lblNewLabel_2_1 = new JLabel("Confirmar nova senha ");
		lblNewLabel_2_1.setForeground(new Color(0, 70, 67));
		lblNewLabel_2_1.setFont(new Font("Caladea", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(74, 342, 152, 17);
		panel.add(lblNewLabel_2_1);

		passwordConfirmar = new JPasswordField();
		passwordConfirmar.setForeground(new Color(0, 70, 67));
		passwordConfirmar.setBackground(new Color(240, 237, 229));
		passwordConfirmar.setBounds(71, 365, 174, 46);
		panel.add(passwordConfirmar);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(240, 237, 229));
		panel_3.setBounds(547, 23, 341, 36);
		frame.getContentPane().add(panel_3);

		JLabel lblResetDeSenha = new JLabel("Reset de Senha");
		lblResetDeSenha.setForeground(new Color(0, 70, 67));
		lblResetDeSenha.setFont(new Font("Caladea", Font.BOLD, 40));
		lblResetDeSenha.setBounds(12, 0, 369, 36);
		panel_3.add(lblResetDeSenha);

		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginView tela = new LoginView();
				tela.setVisible(true);
			}
		});
		btnNewButton_1.setForeground(new Color(240, 237, 229));
		btnNewButton_1.setFont(new Font("Caladea", Font.BOLD, 14));
		btnNewButton_1.setBackground(new Color(0, 70, 67));
		btnNewButton_1.setBounds(1266, 23, 88, 38);
		frame.getContentPane().add(btnNewButton_1);

	}

	private void resetarSenha() {
		String nome = textNome.getText();
		String apelido = textApelido.getText();
		String novaSenha = String.valueOf(passwordNovaSenha.getPassword());
		String confirmar = String.valueOf(passwordConfirmar.getPassword());

		if (nome.isEmpty() || apelido.isEmpty() || novaSenha.isEmpty() || confirmar.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos!!");
			return;
			
		}
		if (!novaSenha.equals(confirmar)) {
			JOptionPane.showMessageDialog(null, "Senhas diferentes!");
			return;
		}
		try {
			DaoCadastroUser dao = new DaoCadastroUser();
			dao.resetarSenha(nome, apelido, novaSenha);
			JOptionPane.showMessageDialog(null, "Senha alterada com Sucesso!!");

			LoginView login = new LoginView();
			login.setVisible(true);
			frame.dispose();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro:" + e.getMessage());
		}
	}

	public void setVisible(boolean visible) {
		frame.setVisible(visible);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnResetarSenha) {
			resetarSenha();
		}

	}

}
