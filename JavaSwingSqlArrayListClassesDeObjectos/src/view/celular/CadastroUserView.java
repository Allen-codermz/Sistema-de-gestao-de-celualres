package view.celular;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.celular.ControllerCadastroUser;
import controller.celular.ControllerModelo;
import model.celular.CadastroUser;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JPasswordField;

public class CadastroUserView implements ActionListener {

	private JFrame frame;
	private JTextField textNome;
	private JTextField textApelido;
	private JPasswordField textSenha;

	private JButton btnCadastrar, btnGerarSenha, btnListar, btnEditar, btnRemover;
	private JTable table;

	private JComboBox comboBoxPerfil;

	private CadastroUser usuarioLogado;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public CadastroUserView(CadastroUser usuario) {
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

		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 237, 229));
		panel.setBounds(49, 110, 353, 408);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome\n");
		lblNewLabel.setFont(new Font("Caladea", Font.BOLD, 14));
		lblNewLabel.setForeground(new Color(0, 70, 67));
		lblNewLabel.setBounds(49, 12, 59, 17);
		panel.add(lblNewLabel);

		textNome = new JTextField();
		textNome.setForeground(new Color(0, 70, 67));
		textNome.setFont(new Font("Caladea", Font.BOLD, 16));
		textNome.setBackground(new Color(240, 237, 229));
		textNome.setBounds(49, 29, 239, 43);
		panel.add(textNome);
		textNome.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Apelido");
		lblNewLabel_1.setFont(new Font("Caladea", Font.BOLD, 14));
		lblNewLabel_1.setForeground(new Color(0, 70, 67));
		lblNewLabel_1.setBounds(49, 81, 59, 17);
		panel.add(lblNewLabel_1);

		textApelido = new JTextField();
		textApelido.setForeground(new Color(0, 70, 67));
		textApelido.setFont(new Font("Caladea", Font.BOLD, 16));
		textApelido.setBackground(new Color(240, 237, 229));
		textApelido.setBounds(49, 101, 239, 43);
		panel.add(textApelido);
		textApelido.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Perfil");
		lblNewLabel_2.setFont(new Font("Caladea", Font.BOLD, 14));
		lblNewLabel_2.setForeground(new Color(0, 70, 67));
		lblNewLabel_2.setBounds(49, 150, 59, 17);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Senha");
		lblNewLabel_3.setFont(new Font("Caladea", Font.BOLD, 14));
		lblNewLabel_3.setForeground(new Color(0, 70, 67));
		lblNewLabel_3.setBounds(49, 232, 59, 17);
		panel.add(lblNewLabel_3);

		textSenha = new JPasswordField();
		textSenha.setForeground(new Color(0, 70, 67));
		textSenha.setEditable(false);
		textSenha.setBackground(new Color(240, 237, 229));
		textSenha.setBounds(49, 248, 114, 43);
		panel.add(textSenha);
		textSenha.setColumns(10);

		btnCadastrar = new JButton("Cadastar");
		btnCadastrar.setFont(new Font("Caladea", Font.BOLD, 14));
		btnCadastrar.setForeground(new Color(240, 237, 229));
		btnCadastrar.setBackground(new Color(0, 70, 67));
		btnCadastrar.setBounds(83, 353, 169, 43);
		btnCadastrar.addActionListener(this);
		panel.add(btnCadastrar);

		btnGerarSenha = new JButton("Gerar senha");
		btnGerarSenha.setFont(new Font("Caladea", Font.BOLD, 14));
		btnGerarSenha.setForeground(new Color(240, 237, 229));
		btnGerarSenha.setBackground(new Color(0, 70, 67));
		btnGerarSenha.setBounds(166, 248, 122, 43);
		btnGerarSenha.addActionListener(this);
		panel.add(btnGerarSenha);

		comboBoxPerfil = new JComboBox();
		comboBoxPerfil.setFont(new Font("Caladea", Font.BOLD, 16));
		comboBoxPerfil.setModel(new DefaultComboBoxModel(new String[] { "User", "superUser", "administrador", "auditor" }));
		comboBoxPerfil.setForeground(new Color(0, 70, 67));
		comboBoxPerfil.setBackground(new Color(240, 237, 229));
		comboBoxPerfil.setBounds(49, 170, 239, 44);
		panel.add(comboBoxPerfil);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 237, 229));
		panel_1.setBounds(404, 27, 589, 53);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("Gestão de usuário");
		lblNewLabel_4.setFont(new Font("Caladea", Font.BOLD, 40));
		lblNewLabel_4.setForeground(new Color(0, 70, 67));
		lblNewLabel_4.setBounds(82, 12, 457, 41);
		panel_1.add(lblNewLabel_4);

		JButton btnNewButton = new JButton("Tela Principal");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipalView tela = new TelaPrincipalView(usuarioLogado);
				tela.setVisible(true);
			}
		});
		btnNewButton.setForeground(new Color(240, 237, 229));
		btnNewButton.setBackground(new Color(0, 70, 67));
		btnNewButton.setFont(new Font("Caladea", Font.BOLD, 14));
		btnNewButton.setBounds(1216, 27, 127, 38);
		frame.getContentPane().add(btnNewButton);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(240, 237, 229));
		panel_1_1.setBounds(409, 198, 190, 194);
		frame.getContentPane().add(panel_1_1);

		btnListar = new JButton("Listar");
		btnListar.setForeground(new Color(240, 237, 229));
		btnListar.setFont(new Font("Caladea", Font.BOLD, 14));
		btnListar.setBackground(new Color(0, 70, 67));
		btnListar.setBounds(50, 37, 127, 40);
		btnListar.addActionListener(this);
		panel_1_1.add(btnListar);

		btnEditar = new JButton("Editar");
		btnEditar.setForeground(new Color(240, 237, 229));
		btnEditar.setFont(new Font("Caladea", Font.BOLD, 14));
		btnEditar.setBackground(new Color(0, 70, 67));
		btnEditar.setBounds(50, 89, 127, 40);
		btnEditar.addActionListener(this);
		panel_1_1.add(btnEditar);

		btnRemover = new JButton("Remover");
		btnRemover.setForeground(new Color(240, 237, 229));
		btnRemover.setFont(new Font("Caladea", Font.BOLD, 14));
		btnRemover.setBackground(new Color(0, 70, 67));
		btnRemover.setBounds(50, 141, 127, 40);
		btnRemover.addActionListener(this);
		panel_1_1.add(btnRemover);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(240, 237, 229));
		panel_2.setBounds(670, 212, 672, 194);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 12, 622, 171);
		panel_2.add(scrollPane);

		table = new JTable();
		table.setForeground(new Color(0, 70, 67));
		table.setFont(new Font("Caladea", Font.BOLD, 14));
		table.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "CodigoUser", "Nome", "Apelido", "Perfil" }));
		scrollPane.setViewportView(table);

	}

	// confirmacao do cadastro do usuario
	private void cadastrar() {
		String nome = textNome.getText();
		String apelido = textApelido.getText();
		String perfil = (String) comboBoxPerfil.getSelectedItem();
		String senha = textSenha.getText();
		if (nome.isEmpty() || apelido.isEmpty() || senha.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos!!");
			return;

		}

		try {
			ControllerCadastroUser controller = new ControllerCadastroUser();
			controller.adicionarUser(usuarioLogado.getNome(), usuarioLogado.getPerfil(), nome, apelido, perfil, senha);
			JOptionPane.showMessageDialog(null, perfil + " adicionado com sucesso!");

			LoginView tela = new LoginView();
			tela.setVisible(true);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao adicionar: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// gerador de senha
	private void gerarSenha() {
		String nome = textNome.getText();
		String apelido = textApelido.getText();

		char pLetra = Character.toUpperCase(nome.charAt(0));
		Random random = new Random();
		int n1 = random.nextInt(10);
		int n2 = random.nextInt(10);
		int n3 = random.nextInt(10);

		String senhaGerada = "" + pLetra + apelido + n1 + n2 + n3;
		textSenha.setText(senhaGerada);
	}

	// txt contendo as credencias
	private void criarCredenciais() {
		String nome = textNome.getText();
		String apelido = textApelido.getText();
		String perfil = (String) comboBoxPerfil.getSelectedItem();
		String senha = textSenha.getText();

		try {
			FileWriter writer = new FileWriter(nome + ".txt");

			writer.write("Nome:" + nome + " " + apelido + "\n");
			writer.write("Perfil:" + perfil + "\n");
			writer.write("Senha:" + senha + "\n");

			writer.close();

			JOptionPane.showMessageDialog(null, "Senha gerada com sucesso!!");

		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao gerar senha");
		}
	}

	// read (lista dos users)
	public void listar() {
		DefaultTableModel listarNaTabela = (DefaultTableModel) table.getModel();
		ControllerCadastroUser user = new ControllerCadastroUser();
		try {
			ArrayList<CadastroUser> listaDeUsers = user.listaDeUsers();
			for (CadastroUser users : listaDeUsers) {
				int codigoUser = users.getCodigoUsuario();
				String nome = users.getNome();
				String apelido = users.getApelido();
				String perfil = users.getPerfil();

				listarNaTabela.addRow(new Object[] { codigoUser, nome, apelido, perfil });
			}
		} catch (ClassNotFoundException | SQLException e1) {
			JOptionPane.showMessageDialog(null, "Erro ao listar" + e1.getMessage());
			e1.printStackTrace();
		}
	}

	// update (alterar perfil do user)
	public void editarUser() {
		int linhaSeleccionada = table.getSelectedRow();
		if (linhaSeleccionada == -1) {
			JOptionPane.showMessageDialog(null, "Por favor, selecione um marca na tabela!");
			return;
		}
		int codigoUser = (int) table.getValueAt(linhaSeleccionada, 0);
		String nome = (String) table.getValueAt(linhaSeleccionada, 1);
		String apelido = (String) table.getValueAt(linhaSeleccionada, 2);
		String novoPerfil = (String) comboBoxPerfil.getSelectedItem();

		if (usuarioLogado != null && codigoUser == usuarioLogado.getCodigoUsuario()) {
			JOptionPane.showMessageDialog(null, "Não pode alterar o seu proprio perfil!!");
			return;
		}

		try {

			ControllerCadastroUser controller = new ControllerCadastroUser();

			controller.actualizarUser(codigoUser, nome, apelido, usuarioLogado.getNome(), usuarioLogado.getPerfil(),
					novoPerfil);

			JOptionPane.showMessageDialog(null, "User actualizado com sucesso!");
			limparCaixas();
			limparTabela();
			listar();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex.getMessage());
		}

	}

	public void removerUser() {
		int linhaSeleccionada = table.getSelectedRow();
		if (linhaSeleccionada == -1) {
			JOptionPane.showMessageDialog(null, "Por favor, selecione uma Marca na tabela!");
			return;
		}
		int codigoUser = (int) table.getValueAt(linhaSeleccionada, 0);

		if (usuarioLogado != null && codigoUser == usuarioLogado.getCodigoUsuario()) {
			JOptionPane.showMessageDialog(null, "Não pode remover a seu propria conta!!");
			return;
		}

		try {

			ControllerCadastroUser controller = new ControllerCadastroUser();
			controller.removerUser(usuarioLogado.getNome(), usuarioLogado.getPerfil(), codigoUser);
			JOptionPane.showMessageDialog(null, "Usuario removido com sucesso!");
			limparCaixas();
			limparTabela();
			listar();

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao remover: " + ex.getMessage());
		}
	}

	public void limparTabela() {
		while (table.getRowCount() > 0) {
			DefaultTableModel listar = (DefaultTableModel) table.getModel();
			listar.removeRow(0);
		}
	}

	public void limparCaixas() {
		// textModelo.setText("");
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCadastrar) {
			cadastrar();
		}
		if (e.getSource() == btnGerarSenha) {
			gerarSenha();
			criarCredenciais();
		}
		if (e.getSource() == btnListar) {
			limparTabela();
			listar();
		}
		if (e.getSource() == btnEditar) {
			editarUser();
		}
		if (e.getSource() == btnRemover) {
			removerUser();
		}

	}

	public void setVisible(boolean visible) {
		frame.setVisible(visible);

	}
}
