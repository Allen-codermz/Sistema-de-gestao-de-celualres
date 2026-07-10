package view.celular;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.celular.ControllerCadastroUser;
import controller.celular.ControllerLog;
import controller.celular.Controllermarca;
import dao.celular.DaoCadastroUser;
import model.celular.CadastroUser;
import model.celular.Cor;
import model.celular.Marca;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class resetSenhaView implements ActionListener {

	private JFrame frame;
	private JComboBox comboBoxUsers;
	private JComboBox comboBoxPerfil;

	private ArrayList<CadastroUser> listaDeUsers = new ArrayList<>();
	private CadastroUser usuarioLogado;
	private JButton btnResetarSenha;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public resetSenhaView() {
		initialize();
		carregarUsers();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setLocation(-560, -198);
		frame.getContentPane().setBackground(new Color(240, 237, 229));
		frame.setBounds(100, 100, 517, 392);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(240, 237, 229));
		panel.setBounds(93, 85, 309, 236);
		frame.getContentPane().add(panel);

		comboBoxUsers = new JComboBox();
		comboBoxUsers.setFont(new Font("Caladea", Font.BOLD, 14));
		comboBoxUsers.setForeground(new Color(0, 70, 67));
		comboBoxUsers.setBackground(new Color(240, 237, 229));
		comboBoxUsers.setBounds(71, 105, 174, 46);
		panel.add(comboBoxUsers);

		JLabel lblNewLabel_1 = new JLabel("Nome usuario");
		lblNewLabel_1.setForeground(new Color(0, 70, 67));
		lblNewLabel_1.setFont(new Font("Caladea", Font.BOLD, 14));
		lblNewLabel_1.setBackground(new Color(0, 70, 67));
		lblNewLabel_1.setBounds(75, 85, 103, 17);
		panel.add(lblNewLabel_1);

		btnResetarSenha = new JButton("Resetar senha");
		btnResetarSenha.setForeground(new Color(240, 237, 229));
		btnResetarSenha.setFont(new Font("Caladea", Font.BOLD, 14));
		btnResetarSenha.setBackground(new Color(0, 70, 67));
		btnResetarSenha.setBounds(94, 165, 138, 45);
		btnResetarSenha.addActionListener(this);
		panel.add(btnResetarSenha);

		comboBoxPerfil = new JComboBox();
		comboBoxPerfil.setModel(new DefaultComboBoxModel(new String[] { "Operador", "SuperOperador", "Administrador", "Auditor" }));
		comboBoxPerfil.setFont(new Font("Caladea", Font.BOLD, 14));
		comboBoxPerfil.setForeground(new Color(0, 70, 67));
		comboBoxPerfil.setBackground(new Color(240, 237, 229));
		comboBoxPerfil.setBounds(70, 25, 174, 46);
		comboBoxPerfil.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			filtrarUsers();
		}
		});
		panel.add(comboBoxPerfil);

		JLabel lblNewLabel_1_1 = new JLabel("Perfil usuario");
		lblNewLabel_1_1.setForeground(new Color(0, 70, 67));
		lblNewLabel_1_1.setFont(new Font("Caladea", Font.BOLD, 14));
		lblNewLabel_1_1.setBackground(new Color(0, 70, 67));
		lblNewLabel_1_1.setBounds(71, 10, 103, 17);
		panel.add(lblNewLabel_1_1);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(240, 237, 229));
		panel_3.setBounds(90, 37, 309, 36);
		frame.getContentPane().add(panel_3);

		JLabel lblResetDeSenha = new JLabel("Reset de Senha");
		lblResetDeSenha.setForeground(new Color(0, 70, 67));
		lblResetDeSenha.setFont(new Font("Caladea", Font.BOLD, 30));
		lblResetDeSenha.setBounds(63, 0, 234, 36);
		panel_3.add(lblResetDeSenha);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnFechar.setForeground(new Color(240, 237, 229));
		btnFechar.setFont(new Font("Caladea", Font.BOLD, 14));
		btnFechar.setBackground(new Color(0, 70, 67));
		btnFechar.setBounds(423, 25, 82, 45);
		frame.getContentPane().add(btnFechar);

	}

	private void carregarUsers() {	
		listaDeUsers.clear();
		try {
			ControllerCadastroUser controller = new ControllerCadastroUser();
			listaDeUsers = controller.listaDeUsers();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		filtrarUsers();
	}
	
	private void filtrarUsers() {
		String perfil = (String) comboBoxPerfil.getSelectedItem();
		comboBoxUsers.removeAllItems();
		for(CadastroUser users : listaDeUsers) {
			if(perfil != null && perfil.equals(users.getPerfil())) {
				comboBoxUsers.addItem(users.getUsername());
			}
		}
	}

	private void resetarSenha() {
		String username = (String) comboBoxUsers.getSelectedItem();
		if(username == null) {
			JOptionPane.showMessageDialog(null,"Por favor selecione um username");
			return;
		}
		try {
			DaoCadastroUser user = new DaoCadastroUser();
			String senhaInicial = user.encontrarSenhaInicial(username);
			if(senhaInicial == null || senhaInicial.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Não foi encontrada uma senha inicial para este usuario!");
				return;
			}
			user.resetarSenha(username);
			if(usuarioLogado != null) {
				ControllerLog log = new ControllerLog();
				log.registarLog(usuarioLogado.getNome(), usuarioLogado.getPerfil(), "Resetou a senha do usuario "+ username +" para a senha padrão");
			}
			JOptionPane.showMessageDialog(null, "Senha resetada comm sucesso!!");
			frame.dispose();
		}catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao resetar senha "+ ex.getMessage());
		}
	}
	
	private void criarCredenciais() {
		String perfil = (String) comboBoxPerfil.getSelectedItem();
		String username = (String) comboBoxUsers.getSelectedItem();
		
		try {
			DaoCadastroUser user = new DaoCadastroUser();
			String senhaInicial = user.encontrarSenhaInicial(username);
	

			File file = new File("Credenciais Resetadas");
			if(!file.exists()) {
				file.mkdirs();
			}
			FileWriter writer = new FileWriter(new File(file,username + ".txt"));

			writer.write("Nome:" + username + "\n");
			writer.write("Perfil:" + perfil + "\n");
			writer.write("Senha:" + senhaInicial + "\n");
			

			writer.close();

		} catch (IOException  | SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao criar credenciais");
		}
	}


	public void setVisible(boolean visible) {
		frame.setVisible(visible);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnResetarSenha) {
			resetarSenha();criarCredenciais();
		}

	}
}
