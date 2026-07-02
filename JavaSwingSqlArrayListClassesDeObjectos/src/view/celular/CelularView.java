package view.celular;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;

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
import javax.swing.table.DefaultTableModel;

import controller.celular.ControllerCelular;
import controller.celular.ControllerCor;
import controller.celular.ControllerFabricante;
import controller.celular.ControllerModelo;
import controller.celular.Controllermarca;
import model.celular.CadastroUser;
import model.celular.Celular;
import model.celular.Cor;
import model.celular.Fabricante;
import model.celular.Marca;
import model.celular.Modelo;

public class CelularView implements ActionListener, MouseListener {

	private JFrame frameCelular;
	private JTextField textPreco;
	private JComboBox comboBoxAnoDeFabrico, comboBoxMarca, comboBoxFabricante, comboBoxCor, comboBoxModelo;
	private JTable tableCelular;

	private JButton btnAdicionar, btnListar, btnEditar, btnRemover;
	private CadastroUser usuarioLogado;

	private JLabel lblUser;
	
	private ArrayList<Marca> listaDeMarcas = new ArrayList<>();
	private ArrayList<Cor> listaDeCores = new ArrayList<>();
	private ArrayList<Modelo> listaDeModelos = new ArrayList<>();
	private ArrayList<Fabricante> listaDeFabricantes = new ArrayList<>();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public CelularView(CadastroUser usuario) {
		this.usuarioLogado = usuario;
		initialize();
		confirmarPermissoes();
		carregarMarca();
		carregarModelo();
		carregarFabricante();
		carregarCor();
		if(usuario != null) {
			lblUser.setText("Usuario: "+ usuarioLogado.getNome()+" | "+"Perfil: "+usuarioLogado.getPerfil());
		}
	}

	public void setVisible(boolean visible) {
		frameCelular.setVisible(visible);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameCelular = new JFrame();
		frameCelular.getContentPane().setEnabled(false);
		frameCelular.getContentPane().setBackground(new Color(240, 237, 229));
		frameCelular.setBounds(100, 100, 1403, 832);
		frameCelular.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameCelular.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 237, 229));
		panel.setBounds(12, 44, 365, 394);
		frameCelular.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblPreco = new JLabel("Preco:");
		lblPreco.setForeground(new Color(0, 70, 67));
		lblPreco.setBounds(34, 365, 79, 14);
		panel.add(lblPreco);
		lblPreco.setFont(new Font("Caladea", Font.BOLD, 16));

		JLabel lblAnoDeFabrico = new JLabel("Ano de fabrico:");
		lblAnoDeFabrico.setForeground(new Color(0, 70, 67));
		lblAnoDeFabrico.setBounds(34, 300, 115, 14);
		panel.add(lblAnoDeFabrico);
		lblAnoDeFabrico.setFont(new Font("Caladea", Font.BOLD, 16));

		textPreco = new JTextField();
		textPreco.setBackground(new Color(240, 237, 229));
		textPreco.setBounds(159, 346, 179, 35);
		panel.add(textPreco);
		textPreco.setColumns(10);

		comboBoxAnoDeFabrico = new JComboBox();
		comboBoxAnoDeFabrico.setModel(new DefaultComboBoxModel(new String[] { "2000", "2001", "2002", "2003", "2004",
				"2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017",
				"2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026" }));
		comboBoxAnoDeFabrico.setBackground(new Color(240, 237, 229));
		comboBoxAnoDeFabrico.setBounds(159, 279, 179, 35);
		panel.add(comboBoxAnoDeFabrico);

		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setForeground(new Color(0, 70, 67));
		lblMarca.setFont(new Font("Caladea", Font.BOLD, 16));
		lblMarca.setBounds(34, 25, 115, 14);
		panel.add(lblMarca);

		JLabel lblCor = new JLabel("Cor:");
		lblCor.setForeground(new Color(0, 70, 67));
		lblCor.setFont(new Font("Caladea", Font.BOLD, 16));
		lblCor.setBounds(34, 162, 115, 14);
		panel.add(lblCor);

		JLabel lblFabricante = new JLabel("Fabricante:");
		lblFabricante.setForeground(new Color(0, 70, 67));
		lblFabricante.setFont(new Font("Caladea", Font.BOLD, 16));
		lblFabricante.setBounds(34, 225, 115, 14);
		panel.add(lblFabricante);

		comboBoxMarca = new JComboBox();
		comboBoxMarca.setBackground(new Color(240, 237, 229));
		comboBoxMarca.setBounds(159, 16, 179, 35);
		panel.add(comboBoxMarca);

		comboBoxCor = new JComboBox();
		comboBoxCor.setBackground(new Color(240, 237, 229));
		comboBoxCor.setBounds(159, 153, 179, 35);
		panel.add(comboBoxCor);

		comboBoxFabricante = new JComboBox();
		comboBoxFabricante.setBackground(new Color(240, 237, 229));
		comboBoxFabricante.setBounds(159, 216, 179, 35);
		panel.add(comboBoxFabricante);
		
		comboBoxModelo = new JComboBox();
		comboBoxModelo.setBackground(new Color(240, 237, 229));
		comboBoxModelo.setBounds(159, 81, 179, 35);
		panel.add(comboBoxModelo);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setForeground(new Color(0, 70, 67));
		lblModelo.setFont(new Font("Caladea", Font.BOLD, 16));
		lblModelo.setBounds(34, 90, 115, 14);
		panel.add(lblModelo);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 237, 229));
		panel_1.setBounds(642, 124, 247, 316);
		frameCelular.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		btnListar = new JButton("Listar");
		btnListar.setBackground(new Color(0, 70, 67));
		btnListar.setForeground(new Color(240, 237, 229));
		btnListar.setFont(new Font("Caladea", Font.BOLD, 14));
		btnListar.setBounds(59, 88, 127, 48);
		btnListar.addActionListener(this);
		panel_1.add(btnListar);

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setForeground(new Color(240, 237, 229));
		btnAdicionar.setBackground(new Color(0, 70, 67));
		btnAdicionar.setFont(new Font("Caladea", Font.BOLD, 14));
		btnAdicionar.setBounds(59, 22, 127, 48);
		btnAdicionar.addActionListener(this);
		panel_1.add(btnAdicionar);

		btnEditar = new JButton("Editar");
		btnEditar.setBackground(new Color(0, 70, 67));
		btnEditar.setForeground(new Color(240, 237, 229));
		btnEditar.setFont(new Font("Caladea", Font.BOLD, 14));
		btnEditar.setBounds(59, 158, 127, 48);
		btnEditar.addActionListener(this);
		panel_1.add(btnEditar);

		btnRemover = new JButton("Remover");
		btnRemover.setBackground(new Color(0, 70, 67));
		btnRemover.setForeground(new Color(240, 237, 229));
		btnRemover.setFont(new Font("Caladea", Font.BOLD, 14));
		btnRemover.setBounds(59, 227, 127, 48);
		btnRemover.addActionListener(this);
		panel_1.add(btnRemover);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(240, 237, 229));
		panel_2.setBounds(49, 476, 1342, 203);
		frameCelular.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 12, 1261, 181);
		panel_2.add(scrollPane);

		tableCelular = new JTable();
		tableCelular.setFont(new Font("Caladea", Font.BOLD, 14));
		tableCelular.setForeground(new Color(0, 70, 67));
		tableCelular.addMouseListener(this);
		scrollPane.setViewportView(tableCelular);
		tableCelular.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Numero de Serie", "Marca",
				"Modelo", "Cor","Fabricante", "Preco", "Ano de Fabrico", "Tempo de Existencia" }));
		tableCelular.setBackground(new Color(240, 237, 229));

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(240, 237, 229));
		panel_3.setBounds(591, 40, 317, 37);
		frameCelular.getContentPane().add(panel_3);
		panel_3.setLayout(null);

		JLabel lblTitulo = new JLabel("  Cadastro do Celular");
		lblTitulo.setBounds(12, 0, 287, 36);
		lblTitulo.setForeground(new Color(0, 70, 67));
		panel_3.add(lblTitulo);
		lblTitulo.setFont(new Font("Caladea", Font.BOLD, 30));

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
		btnNewButton.setBounds(1222, 39, 127, 38);
		frameCelular.getContentPane().add(btnNewButton);
		
		lblUser = new JLabel("");
		lblUser.setFont(new Font("Caladea", Font.BOLD, 14));
		lblUser.setForeground(new Color(0, 70, 67));
		lblUser.setBounds(643, 23, 298, 17);
		frameCelular.getContentPane().add(lblUser);
	}

	private void carregarMarca() {

		comboBoxMarca.removeAllItems();
		listaDeMarcas.clear();
		try {
			Controllermarca controller = new Controllermarca();
			listaDeMarcas = controller.listaDeMarcas();
			for (Marca marca : listaDeMarcas) {
				comboBoxMarca.addItem(marca.getMarca());
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void carregarCor() {

		comboBoxCor.removeAllItems();
		listaDeCores.clear();
		try {
			ControllerCor controller = new ControllerCor();
			listaDeCores = controller.listaDeCores();
			for (Cor cor: listaDeCores) {
				comboBoxCor.addItem(cor.getCor()+" - "+ cor.getDescricao());
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void carregarModelo() {

		comboBoxModelo.removeAllItems();
		listaDeModelos.clear();
		try {
			ControllerModelo controller = new ControllerModelo();
			listaDeModelos = controller.listaDeModelo();
			for (Modelo modelo : listaDeModelos) {
				comboBoxModelo.addItem(modelo.getModelo());
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void carregarFabricante() {

		comboBoxFabricante.removeAllItems();
		listaDeFabricantes.clear();
		try {
			ControllerFabricante controller = new ControllerFabricante();
			listaDeFabricantes = controller.listaDeFabricantes();
			for (Fabricante fabricante : listaDeFabricantes) {
				comboBoxFabricante.addItem(fabricante.getPaisDeOrigem()+" - "+fabricante.getFabricante());
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void adicionarCelular() {

		String preco1 = textPreco.getText();

		if (preco1.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Por favor Insira o preco!");
			return;
		}

		try {
			double preco = Double.parseDouble(preco1);
			if (preco <= 0) {
				JOptionPane.showMessageDialog(null, "O preco deve ser menor que zero!!");
			}
			int anoDeFabrico = Integer.parseInt((String) comboBoxAnoDeFabrico.getSelectedItem());
			int codigoMarca = listaDeMarcas.get(comboBoxMarca.getSelectedIndex()).getCodigoMarca();
			int codigoModelo = listaDeModelos.get(comboBoxModelo.getSelectedIndex()).getCodigoModelo();
			int codigoCor = listaDeCores.get(comboBoxCor.getSelectedIndex()).getCodigoCor();
			int codigoFabricante = listaDeFabricantes.get(comboBoxFabricante.getSelectedIndex()).getCodigoFabricante();
			

			ControllerCelular controller = new ControllerCelular();
			controller.adicionarCelular(usuarioLogado.getNome(), usuarioLogado.getPerfil(), codigoMarca,codigoModelo,codigoCor,codigoFabricante, preco, anoDeFabrico);

			JOptionPane.showMessageDialog(null, "Celular adicionado com sucesso!");
			limparCaixas();
			limparTabela();
			// listar();

		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Preco invalido, numeros apenas!!");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao adicionar: " + ex.getMessage());
		}
	}

	public void listar() {
		DefaultTableModel listarNaTabela = (DefaultTableModel) tableCelular.getModel();
		ControllerCelular controller = new ControllerCelular();
		try {
			ArrayList<Celular> listaDeCelulares = controller.listaDeCelulares();
			for (Celular celular : listaDeCelulares) {
				int codigo = celular.getCodigo();
				Marca marca = celular.getMarca();
				Modelo modelo = celular.getModelo();
				Cor cor = celular.getCor();
				Fabricante fabricante = celular.getFabricante();
				double preco = celular.getPreco();
				int anoDeFabrico = celular.getAnoDeFabrico();
				int tempoDeExistencia = celular.calcularTempo();
				listarNaTabela.addRow(new Object[] { codigo,marca,modelo,cor,fabricante, preco, anoDeFabrico, tempoDeExistencia });
			}
		} catch (ClassNotFoundException | SQLException e1) {

			e1.printStackTrace();
		}
	}

	public void confirmarPermissoes() {
		if (usuarioLogado == null)
			return;
		String perfil = usuarioLogado.getPerfil();

		if (perfil.equals("User")) {
			btnEditar.setEnabled(false);
			btnRemover.setEnabled(false);
		}
	}

	private void editarCelular() {
		int linhaSeleccionada = tableCelular.getSelectedRow();
		if (linhaSeleccionada == -1) {
			JOptionPane.showMessageDialog(null, "Por favor, selecione um celular na tabela!");
			return;
		}

		String precoStr = textPreco.getText();
		String anoStr = (String) comboBoxAnoDeFabrico.getSelectedItem();

		try {
			int codigo = (int) tableCelular.getValueAt(linhaSeleccionada, 0);
			double preco = Double.parseDouble(precoStr);
			int anoDeFabrico = Integer.parseInt(anoStr);

			ControllerCelular controller = new ControllerCelular();
			controller.actualizarCelular(usuarioLogado.getNome(), usuarioLogado.getPerfil(), codigo, preco,
					anoDeFabrico);

			JOptionPane.showMessageDialog(null, "Celular atualizado com sucesso!");
			limparCaixas();
			limparTabela();
			listar();

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex.getMessage());
		}
	}

	private void removerCelular() {
		int linhaSeleccionada = tableCelular.getSelectedRow();
		if (linhaSeleccionada == -1) {
			JOptionPane.showMessageDialog(null, "Por favor, selecione um celular na tabela!");
			return;
		}

		try {
			int codigo = (int) tableCelular.getValueAt(linhaSeleccionada, 0);

			ControllerCelular controller = new ControllerCelular();
			controller.removerCelular(usuarioLogado.getNome(), usuarioLogado.getPerfil(), codigo);
			JOptionPane.showMessageDialog(null, "Celular removido com sucesso!");
			limparCaixas();
			limparTabela();
			listar();

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao remover: " + ex.getMessage());
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdicionar) {
			adicionarCelular();
		}
		if (e.getSource() == btnListar) {
			limparTabela();
			listar();
		}
		if (e.getSource() == btnEditar) {
			editarCelular();
		}
		if (e.getSource() == btnRemover) {
			removerCelular();
		}
	}

	public void limparTabela() {
		while (tableCelular.getRowCount() > 0) {
			DefaultTableModel listar = (DefaultTableModel) tableCelular.getModel();
			listar.removeRow(0);
		}
	}

	public void limparCaixas() {
		textPreco.setText("");
		comboBoxAnoDeFabrico.setSelectedItem("");
	}

	public void mouseClicked(MouseEvent e) {
		if (tableCelular.getSelectedRow() != -1) {
			int indice = tableCelular.getSelectedRow();
			DefaultTableModel linhaSelecionada = (DefaultTableModel) tableCelular.getModel();

			textPreco.setText(linhaSelecionada.getValueAt(indice, 1).toString());
			comboBoxAnoDeFabrico.setSelectedItem(linhaSelecionada.getValueAt(indice, 2).toString());
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
