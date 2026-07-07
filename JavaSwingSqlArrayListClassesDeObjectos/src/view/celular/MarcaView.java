package view.celular;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import controller.celular.ControllerFabricante;
import controller.celular.Controllermarca;
import model.celular.CadastroUser;
import model.celular.Fabricante;
import model.celular.Marca;
import javax.swing.JComboBox;

public class MarcaView implements ActionListener, MouseListener {

	private JFrame frameMarca;
	private JTextField textMarca;
	private JTable table;

	private JLabel lblUser;
	private TableRowSorter<DefaultTableModel> sorter;
	private JTextField textPesquisa;
	private JComboBox comboBoxFabricante;
	private ArrayList<Fabricante> listaDeFabricantes = new ArrayList<>();
	private JButton btnAdicionar, btnListar, btnEditar, btnRemover;

	private CadastroUser usuarioLogado;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public MarcaView(CadastroUser usuario) {
		this.usuarioLogado = usuario;
		initialize();
		carregarFabricante();
		confirmarPermissoes();
		if (usuario != null) {
			lblUser.setText("Usuario: " + usuarioLogado.getNome() + " | " + "Perfil: " + usuarioLogado.getPerfil());
		}

	}

	public void setVisible(boolean visible) {
		frameMarca.setVisible(visible);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameMarca = new JFrame();
		frameMarca.getContentPane().setBackground(new Color(240, 237, 229));
		frameMarca.setBounds(100, 100, 1403, 832);
		frameMarca.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMarca.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 237, 229));
		panel.setBounds(70, 181, 387, 143);
		frameMarca.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setForeground(new Color(0, 70, 67));
		lblMarca.setFont(new Font("Caladea", Font.BOLD, 16));
		lblMarca.setBounds(24, 96, 79, 29);
		panel.add(lblMarca);

		textMarca = new JTextField();
		textMarca.setForeground(new Color(0, 70, 67));
		textMarca.setFont(new Font("Caladea", Font.BOLD, 14));
		textMarca.setBackground(new Color(240, 237, 229));
		textMarca.setBounds(121, 88, 254, 38);
		panel.add(textMarca);
		textMarca.setColumns(10);

		comboBoxFabricante = new JComboBox();
		comboBoxFabricante.setForeground(new Color(0, 70, 67));
		comboBoxFabricante.setFont(new Font("Caladea", Font.BOLD, 14));
		comboBoxFabricante.setBackground(new Color(240, 237, 229));
		comboBoxFabricante.setBounds(120, 20, 255, 38);
		panel.add(comboBoxFabricante);

		JLabel lblFabricante = new JLabel("Fabricante:");
		lblFabricante.setForeground(new Color(0, 70, 67));
		lblFabricante.setFont(new Font("Caladea", Font.BOLD, 16));
		lblFabricante.setBounds(24, 41, 95, 17);
		panel.add(lblFabricante);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 237, 229));
		panel_1.setBounds(599, 123, 286, 216);
		frameMarca.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBackground(new Color(0, 70, 67));
		btnAdicionar.setForeground(new Color(240, 237, 229));
		btnAdicionar.setFont(new Font("Caladea", Font.BOLD, 14));
		btnAdicionar.setBounds(89, 22, 127, 36);
		btnAdicionar.addActionListener(this);
		panel_1.add(btnAdicionar);

		btnListar = new JButton("Listar");
		btnListar.setBackground(new Color(0, 70, 67));
		btnListar.setForeground(new Color(240, 237, 229));
		btnListar.setFont(new Font("Caladea", Font.BOLD, 14));
		btnListar.setBounds(89, 70, 127, 38);
		btnListar.addActionListener(this);
		panel_1.add(btnListar);

		btnEditar = new JButton("Editar");
		btnEditar.setBackground(new Color(0, 70, 67));
		btnEditar.setForeground(new Color(240, 237, 229));
		btnEditar.setFont(new Font("Caladea", Font.BOLD, 14));
		btnEditar.setBounds(89, 120, 127, 36);
		btnEditar.addActionListener(this);
		panel_1.add(btnEditar);

		btnRemover = new JButton("Remover");
		btnRemover.setBackground(new Color(0, 70, 67));
		btnRemover.setForeground(new Color(240, 237, 229));
		btnRemover.setFont(new Font("Caladea", Font.BOLD, 14));
		btnRemover.setBounds(89, 168, 127, 36);
		btnRemover.addActionListener(this);
		panel_1.add(btnRemover);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(240, 237, 229));
		panel_2.setBounds(399, 474, 656, 188);
		frameMarca.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 11, 585, 166);
		panel_2.add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Caladea", Font.BOLD, 14));
		table.setForeground(new Color(0, 70, 67));
		table.addMouseListener(this);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "CodigoMarca", "Nome da Marca", "Fabricante" }));
		table.setBackground(new Color(240, 237, 229));

		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(788, 11, 17, 166);
		panel_2.add(scrollBar);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(240, 237, 229));
		panel_3.setBounds(526, 28, 473, 35);
		frameMarca.getContentPane().add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Cadastro de Marca");
		lblNewLabel_1.setForeground(new Color(0, 70, 67));
		lblNewLabel_1.setFont(new Font("Caladea", Font.BOLD, 30));
		lblNewLabel_1.setBounds(78, 12, 297, 24);
		panel_3.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("Tela Principal");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipalView tela = new TelaPrincipalView(usuarioLogado);
				tela.setVisible(true);
			}
		});
		btnNewButton.setForeground(new Color(240, 237, 229));
		btnNewButton.setFont(new Font("Caladea", Font.BOLD, 14));
		btnNewButton.setBackground(new Color(0, 70, 67));
		btnNewButton.setBounds(1223, 28, 136, 38);
		frameMarca.getContentPane().add(btnNewButton);

		lblUser = new JLabel("");
		lblUser.setForeground(new Color(0, 70, 67));
		lblUser.setFont(new Font("Caladea", Font.BOLD, 14));
		lblUser.setBounds(624, 14, 368, 17);
		frameMarca.getContentPane().add(lblUser);

		textPesquisa = new JTextField();
		textPesquisa.setFont(new Font("Caladea", Font.PLAIN, 14));
		textPesquisa.setBackground(new Color(240, 237, 229));
		textPesquisa.setForeground(new Color(0, 70, 67));
		textPesquisa.setBounds(834, 434, 194, 38);
		frameMarca.getContentPane().add(textPesquisa);
		textPesquisa.setColumns(10);

		lblNewLabel = new JLabel("Pesquisar:");
		lblNewLabel.setForeground(new Color(0, 70, 67));
		lblNewLabel.setFont(new Font("Caladea", Font.BOLD, 18));
		lblNewLabel.setBounds(834, 416, 97, 17);
		frameMarca.getContentPane().add(lblNewLabel);
		textPesquisa.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				filtar();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				filtar();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				filtar();
			}

		});
	}

	public void filtar() {
		String texto = textPesquisa.getText();
		if (texto.isEmpty()) {
			sorter.setRowFilter(null);
		} else {
			sorter.setRowFilter(RowFilter.regexFilter("(?i)" + Pattern.quote(texto), 1, 2, 3));
		}
	}

	// nivel de acesso
	public void confirmarPermissoes() {
		if (usuarioLogado == null)
			return;
		String perfil = usuarioLogado.getPerfil();

		if (perfil.equals("Operador")) {
			btnEditar.setEnabled(false);
			btnRemover.setEnabled(false);
		}
	}

	private void carregarFabricante() {

		comboBoxFabricante.removeAllItems();
		listaDeFabricantes.clear();
		try {
			ControllerFabricante controller = new ControllerFabricante();
			listaDeFabricantes = controller.listaDeFabricantes();
			for (Fabricante fabricante : listaDeFabricantes) {
				comboBoxFabricante.addItem(fabricante.getPaisDeOrigem() + " - " + fabricante.getFabricante());
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void adicionarMarca() {
		String marca = textMarca.getText();
		int codigoFabricante = listaDeFabricantes.get(comboBoxFabricante.getSelectedIndex()).getCodigoFabricante();

		if (marca.isEmpty() || marca.isBlank()) {
			JOptionPane.showMessageDialog(null, "Por favor preencha o campo");
			return;
		}
		if (comboBoxFabricante.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(null, "Por favor cadastre um fabricante primeiro!!");
			return;
		}

		Controllermarca controller = new Controllermarca();
		try {
			controller.adicionarMarca(usuarioLogado.getNome(), usuarioLogado.getPerfil(), marca, codigoFabricante);
			JOptionPane.showMessageDialog(null, "Marca adicionado com sucesso!");
			limparCaixas();
			limparTabela();
			listar();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao adicionar: " + ex.getMessage());
		}
	}

	public void listar() {
		DefaultTableModel listarNaTabela = (DefaultTableModel) table.getModel();
		Controllermarca controller = new Controllermarca();
		try {
			ArrayList<Marca> listaDeMarcas = controller.listaDeMarcas();
			for (Marca marca : listaDeMarcas) {
				int codigo = marca.getCodigoMarca();
				String nomeMarca = marca.getMarca();
				Fabricante fabricante = marca.getFabricante();

				listarNaTabela.addRow(new Object[] { codigo, nomeMarca, fabricante });
			}
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		sorter = new TableRowSorter<DefaultTableModel>(listarNaTabela);
		table.setRowSorter(sorter);

		for (int i = 0; i < table.getColumnCount(); i++) {
			sorter.setSortable(i, false);
		}
	}

	private void editarMarca() {
		int linhaSeleccionada = table.getSelectedRow();
		if (linhaSeleccionada == -1) {
			JOptionPane.showMessageDialog(null, "Por favor, selecione um marca na tabela!");
			return;
		}
		String marca = textMarca.getText();
		if (marca.isEmpty() || marca.isBlank()) {
			JOptionPane.showMessageDialog(null, "Por favor preencha o campo!!");
			return;
		}
		int codigoFabricante = listaDeFabricantes.get(comboBoxFabricante.getSelectedIndex()).getCodigoFabricante();
		try {
			int codigoMarca = (int) table.getValueAt(linhaSeleccionada, 0);

			Controllermarca controller = new Controllermarca();
			controller.actualizarMarca(usuarioLogado.getNome(), usuarioLogado.getPerfil(), codigoMarca,
					codigoFabricante, marca);
			JOptionPane.showMessageDialog(null, "Marca editada com sucesso!");
			limparCaixas();
			limparTabela();
			listar();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex.getMessage());
		}
	}

	private void removerMarca() {
		int linhaSeleccionada = table.getSelectedRow();
		if (linhaSeleccionada == -1) {
			JOptionPane.showMessageDialog(null, "Por favor, selecione uma Marca na tabela!");
			return;
		}

		try {
			int codigo = (int) table.getValueAt(linhaSeleccionada, 0);
			Controllermarca controller = new Controllermarca();
			controller.removerMarca(usuarioLogado.getNome(), usuarioLogado.getPerfil(), codigo);
			JOptionPane.showMessageDialog(null, "Marca removida com sucesso!");
			limparCaixas();
			limparTabela();
			listar();

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao remover: " + ex.getMessage());
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdicionar) {
			adicionarMarca();
		}
		if (e.getSource() == btnListar) {
			limparTabela();
			listar();
		}
		if (e.getSource() == btnEditar) {
			editarMarca();
		}
		if (e.getSource() == btnRemover) {
			removerMarca();
		}
	}

	public void limparTabela() {
		while (table.getRowCount() > 0) {
			DefaultTableModel listar = (DefaultTableModel) table.getModel();
			listar.removeRow(0);
		}
	}

	public void limparCaixas() {
		textMarca.setText("");
	}

	public void mouseClicked(MouseEvent e) {
		if (table.getSelectedRow() != -1) {
			int indice = table.getSelectedRow();
			DefaultTableModel linhaSelecionada = (DefaultTableModel) table.getModel();

			textMarca.setText(linhaSelecionada.getValueAt(indice, 1).toString());

			Fabricante fabricanteDaLinha = (Fabricante) linhaSelecionada.getValueAt(indice, 2);
			for (int i = 0; i < listaDeFabricantes.size(); i++) {
				if (listaDeFabricantes.get(i).getCodigoFabricante() == fabricanteDaLinha.getCodigoFabricante()) {
					comboBoxFabricante.setSelectedIndex(i);
					break;
				}

			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
