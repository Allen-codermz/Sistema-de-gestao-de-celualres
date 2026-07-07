package view.celular;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import controller.celular.ControllerFabricante;
import dao.celular.DaoContinente;
import dao.celular.DaoPais;
import model.celular.CadastroUser;
import model.celular.Continente;
import model.celular.Fabricante;
import model.celular.Modelo;
import model.celular.Pais;

public class FabricanteView implements ActionListener, MouseListener {

	private JFrame frame;
	private JComboBox comboBoxContinente, comboBoxPais;
	private JTextField textFabricante;
	private JTable table;

	private JButton btnAdicionar, btnListar, btnEditar, btnRemover;
	private JButton btnNewButton;
	private TableRowSorter<DefaultTableModel> sorter;
	private JTextField textPesquisa;
	private CadastroUser usuarioLogado;
	private JLabel lblUser;
	private JLabel lblNewLabel_1;
	private ArrayList<Pais> listaDePais = new ArrayList<>();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public FabricanteView(CadastroUser usuario) {
		this.usuarioLogado = usuario;
		initialize();
		carregarContinentes();
		confirmarPermissoes();
		if (usuario != null) {
			lblUser.setText("Usuario: " + usuarioLogado.getNome() + " | " + "Perfil: " + usuarioLogado.getPerfil());
		}
	}

	public void setVisible(boolean visible) {
		frame.setVisible(visible);
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

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(321, 47, 616, 36);
		panel_3.setBackground(new Color(240, 237, 229));
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel = new JLabel("Cadastro de Fabricante");
		lblNewLabel.setBounds(247, 0, 369, 36);
		panel_3.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(0, 70, 67));
		lblNewLabel.setFont(new Font("Caladea", Font.BOLD, 30));

		JPanel panel = new JPanel();
		panel.setBounds(45, 257, 384, 250);
		panel.setBackground(new Color(240, 237, 229));
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblEndereco = new JLabel("Fabricante:");
		lblEndereco.setBounds(36, 48, 157, 35);
		lblEndereco.setForeground(new Color(0, 70, 67));
		lblEndereco.setFont(new Font("Caladea", Font.BOLD, 20));
		panel.add(lblEndereco);

		textFabricante = new JTextField();
		textFabricante.setFont(new Font("Caladea", Font.BOLD, 14));
		textFabricante.setForeground(new Color(0, 70, 67));
		textFabricante.setBackground(new Color(240, 237, 229));
		textFabricante.setBounds(198, 48, 161, 35);
		panel.add(textFabricante);
		textFabricante.setColumns(10);

		JLabel lblFabricante = new JLabel("Continente:");
		lblFabricante.setBounds(36, 118, 157, 40);
		lblFabricante.setForeground(new Color(0, 70, 67));
		lblFabricante.setFont(new Font("Caladea", Font.BOLD, 20));
		panel.add(lblFabricante);

		comboBoxContinente = new JComboBox();
		comboBoxContinente.setForeground(new Color(0, 70, 67));
		comboBoxContinente.setFont(new Font("Caladea", Font.BOLD, 14));
		comboBoxContinente.setBackground(new Color(240, 237, 229));
		comboBoxContinente.setBounds(198, 118, 161, 40);
		panel.add(comboBoxContinente);
		comboBoxContinente.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED);
				filtrarPaises();
			}
		});

		comboBoxPais = new JComboBox();
		comboBoxPais.setForeground(new Color(0, 70, 67));
		comboBoxPais.setFont(new Font("Caladea", Font.BOLD, 14));
		comboBoxPais.setBackground(new Color(240, 237, 229));
		comboBoxPais.setBounds(198, 187, 161, 40);
		panel.add(comboBoxPais);

		JLabel lblFabricante_1 = new JLabel("País de origem:");
		lblFabricante_1.setForeground(new Color(0, 70, 67));
		lblFabricante_1.setFont(new Font("Caladea", Font.BOLD, 20));
		lblFabricante_1.setBounds(36, 187, 157, 40);
		panel.add(lblFabricante_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(610, 190, 277, 250);
		panel_1.setBackground(new Color(240, 237, 229));
		frame.getContentPane().add(panel_1);

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(76, 12, 127, 46);
		btnAdicionar.setBackground(new Color(0, 70, 67));
		btnAdicionar.setForeground(new Color(240, 237, 229));
		btnAdicionar.setFont(new Font("Caladea", Font.BOLD, 14));
		btnAdicionar.addActionListener(this);
		panel_1.setLayout(null);
		panel_1.add(btnAdicionar);

		btnListar = new JButton("Listar");
		btnListar.setBounds(76, 70, 127, 46);
		btnListar.setBackground(new Color(0, 70, 67));
		btnListar.setForeground(new Color(240, 237, 229));
		btnListar.setFont(new Font("Caladea", Font.BOLD, 14));
		btnListar.addActionListener(this);
		panel_1.add(btnListar);

		btnEditar = new JButton("Editar");
		btnEditar.setBounds(76, 121, 127, 46);
		btnEditar.setBackground(new Color(0, 70, 67));
		btnEditar.setForeground(new Color(240, 237, 229));
		btnEditar.setFont(new Font("Caladea", Font.BOLD, 14));
		btnEditar.addActionListener(this);
		panel_1.add(btnEditar);

		btnRemover = new JButton("Remover");
		btnRemover.setBounds(76, 175, 127, 46);
		btnRemover.setBackground(new Color(0, 70, 67));
		btnRemover.setForeground(new Color(240, 237, 229));
		btnRemover.setFont(new Font("Caladea", Font.BOLD, 14));
		btnRemover.addActionListener(this);
		panel_1.add(btnRemover);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(398, 512, 682, 171);
		panel_2.setBackground(new Color(240, 237, 229));
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 12, 626, 154);
		panel_2.add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Caladea", Font.BOLD, 14));
		table.setForeground(new Color(0, 70, 67));
		scrollPane.setViewportView(table);
		table.addMouseListener(this);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "CodigoFabricante", "Fabricante", "Pais de origem"}));
		table.setBackground(new Color(240, 237, 229));

		btnNewButton = new JButton("Tela Principal");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipalView tela = new TelaPrincipalView(usuarioLogado);
				tela.setVisible(true);
			}
		});
		btnNewButton.setForeground(new Color(240, 237, 229));
		btnNewButton.setFont(new Font("Caladea", Font.BOLD, 14));
		btnNewButton.setBackground(new Color(0, 70, 67));
		btnNewButton.setBounds(1193, 27, 136, 38);
		frame.getContentPane().add(btnNewButton);

		lblUser = new JLabel("");
		lblUser.setForeground(new Color(0, 70, 67));
		lblUser.setFont(new Font("Caladea", Font.BOLD, 14));
		lblUser.setBounds(610, 24, 444, 17);
		frame.getContentPane().add(lblUser);

		textPesquisa = new JTextField();
		textPesquisa.setBounds(872, 474, 194, 38);
		frame.getContentPane().add(textPesquisa);
		textPesquisa.setFont(new Font("Caladea", Font.PLAIN, 14));
		textPesquisa.setBackground(new Color(240, 237, 229));
		textPesquisa.setForeground(new Color(0, 70, 67));
		textPesquisa.setColumns(10);

		lblNewLabel_1 = new JLabel("Pesquisar:");
		lblNewLabel_1.setForeground(new Color(0, 70, 67));
		lblNewLabel_1.setFont(new Font("Caladea", Font.BOLD, 18));
		lblNewLabel_1.setBounds(873, 455, 97, 17);
		frame.getContentPane().add(lblNewLabel_1);
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
			sorter.setRowFilter(RowFilter.regexFilter("(?i)" + Pattern.quote(texto), 1, 2, 3, 4, 5, 6, 7, 8));
		}
	}

	private void carregarContinentes() {
		try {
			ArrayList<Continente> continentes = DaoContinente.listaDecontinentes();
			DefaultComboBoxModel<Continente> modeloContinente = new DefaultComboBoxModel<Continente>();
			for (Continente c : continentes) {
				modeloContinente.addElement(c);
			}
			comboBoxContinente.setModel(modeloContinente);

			listaDePais = DaoPais.listaDePais();

			if (modeloContinente.getSize() > 0) {
				comboBoxContinente.setSelectedIndex(0);
				filtrarPaises();
			}
		} catch (SQLException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Erro ao carregar continentes/países: " + e.getMessage());
		}
	}

	private void filtrarPaises() {
		Continente continenteSelecionado = (Continente) comboBoxContinente.getSelectedItem();
		DefaultComboBoxModel<Pais> modeloPais = new DefaultComboBoxModel<Pais>();
		if (continenteSelecionado != null) {
			for (Pais p : listaDePais) {
				if (p.getContinente() != null
						&& p.getContinente().getCodigoContinente() == continenteSelecionado.getCodigoContinente()) {
					modeloPais.addElement(p);
				}
			}
		}
		comboBoxPais.setModel(modeloPais);
	}

//	private Continente buscarContinentePorCodigo(int codigo) {
//		ComboBoxModel<Continente> modelo = comboBoxContinente.getModel();
//		for (int i = 0; i < modelo.getSize(); i++) {
//			Continente c = modelo.getElementAt(i);
//			if (c.getCodigoContinente() == codigo) {
//				return c;
//			}
//		}
//		return null;
//	}

//	private void selecionarPaisNoCombo(String nomePais) {
//		for (Pais p : listaDePais) {
//			if (p.getPais().equalsIgnoreCase(nomePais)) {
//				Continente continente = buscarContinentePorCodigo(p.getContinente().getCodigoContinente());
//				comboBoxContinente.setSelectedItem(continente);
//				filtrarPaises();
//				comboBoxPais.setSelectedItem(p);
//				return;
//			}
//		}
//	}

	public void confirmarPermissoes() {
		if (usuarioLogado == null)
			return;
		String perfil = usuarioLogado.getPerfil();

		if (perfil.equals("Operador")) {
			btnEditar.setEnabled(false);
			btnRemover.setEnabled(false);
		}
	}

	private void adicionarFabricante() {
		Pais paisSelecionado = (Pais) comboBoxPais.getSelectedItem();
		String fabricante = textFabricante.getText();

		if (fabricante.isEmpty() || fabricante.isBlank() || paisSelecionado == null) {
			JOptionPane.showMessageDialog(null, "Por favor preencha os campos");
			return;
		}
		String paisDeOrigem = paisSelecionado.getPais();
		try {
			ControllerFabricante controller = new ControllerFabricante();
			controller.adicionarFabricante(usuarioLogado.getNome(), usuarioLogado.getPerfil(), fabricante,
					paisDeOrigem);
			JOptionPane.showMessageDialog(null, "Fabricante adicionado com sucesso!");
			limparCaixas();
			limparTabela();
			listar();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao adicionar: " + ex.getMessage());
		}
	}

	public void listar() {
		DefaultTableModel listarNaTabela = (DefaultTableModel) table.getModel();
		ControllerFabricante controller = new ControllerFabricante();

		try {
			ArrayList<Fabricante> listaDeFabricantes = controller.listaDeFabricantes();
			for (Fabricante fabricante : listaDeFabricantes) {
				int codigo = fabricante.getCodigoFabricante();
				String nomeFabricante = fabricante.getFabricante();
				String paisDeOrigem = fabricante.getPaisDeOrigem();

				listarNaTabela.addRow(new Object[] { codigo, nomeFabricante, paisDeOrigem });
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

	private void editarFabricante() {
		int linhaSeleccionada = table.getSelectedRow();
		if (linhaSeleccionada == -1) {
			JOptionPane.showMessageDialog(null, "Por favor, selecione um fabricante na tabela!");
			return;
		}
		Pais paisSelecionado = (Pais) comboBoxPais.getSelectedItem();
		String fabricante = textFabricante.getText();
		if (fabricante.isEmpty() || fabricante.isBlank() || paisSelecionado == null) {
			JOptionPane.showMessageDialog(null, "Por favor preencha os campos!");
			return;
		}
		String paisDeOrigem = paisSelecionado.getPais();
		ControllerFabricante controller = new ControllerFabricante();
		try {
			int codigoFabricante = (int) table.getValueAt(linhaSeleccionada, 0);
			controller.actualizarFabricante(usuarioLogado.getNome(), usuarioLogado.getPerfil(), codigoFabricante,
					fabricante, paisDeOrigem);
			JOptionPane.showMessageDialog(null, "Fabricante atualizado com sucesso!");
			limparCaixas();
			limparTabela();
			listar();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex.getMessage());
		}
	}

	private void removerFabricante() {
		int linhaSeleccionada = table.getSelectedRow();
		if (linhaSeleccionada == -1) {
			JOptionPane.showMessageDialog(null, "Por favor, selecione um fabricante tabela!");
			return;
		}

		try {
			int codigo = (int) table.getValueAt(linhaSeleccionada, 0);
			ControllerFabricante controller = new ControllerFabricante();
			controller.removerFabricante(usuarioLogado.getNome(), usuarioLogado.getPerfil(), codigo);
			JOptionPane.showMessageDialog(null, "fabricante removido com sucesso!");
			limparCaixas();
			limparTabela();
			listar();

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao remover: " + ex.getMessage());
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdicionar) {
			adicionarFabricante();
		}
		if (e.getSource() == btnListar) {
			limparTabela();
			listar();
		}
		if (e.getSource() == btnEditar) {
			editarFabricante();
		}
		if (e.getSource() == btnRemover) {
			removerFabricante();
		}
	}

	public void limparTabela() {
		while (table.getRowCount() > 0) {
			DefaultTableModel listar = (DefaultTableModel) table.getModel();
			listar.removeRow(0);
		}
	}

	public void limparCaixas() {
		textFabricante.setText("");
	}

	public void mouseClicked(MouseEvent e) {
		if (table.getSelectedRow() != -1) {
			int indice = table.getSelectedRow();
			DefaultTableModel linhaSelecionada = (DefaultTableModel) table.getModel();
			textFabricante.setText(linhaSelecionada.getValueAt(indice, 1).toString());			
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
