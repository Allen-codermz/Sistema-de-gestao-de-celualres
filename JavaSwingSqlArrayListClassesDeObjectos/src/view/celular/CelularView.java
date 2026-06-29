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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.celular.ControllerCelular;
import model.celular.CadastroUser;
import model.celular.Celular;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class CelularView implements ActionListener, MouseListener {

	private JFrame frameCelular;
	private JTextField textPreco;
	private JComboBox comboBoxAnoDeFabrico;
	private JTable tableCelular;

	private JButton btnAdicionar, btnListar, btnEditar, btnRemover;
	private CadastroUser usuarioLogado;

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
		panel.setBackground(new Color(255, 252, 239));
		panel.setBounds(31, 123, 365, 310);
		frameCelular.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblPreco = new JLabel("Preco:");
		lblPreco.setForeground(new Color(0, 70, 67));
		lblPreco.setBounds(34, 21, 79, 14);
		panel.add(lblPreco);
		lblPreco.setFont(new Font("Caladea", Font.BOLD, 16));

		JLabel lblAnoDeFabrico = new JLabel("Ano de fabrico:");
		lblAnoDeFabrico.setForeground(new Color(0, 70, 67));
		lblAnoDeFabrico.setBounds(34, 77, 115, 14);
		panel.add(lblAnoDeFabrico);
		lblAnoDeFabrico.setFont(new Font("Caladea", Font.BOLD, 16));

		textPreco = new JTextField();
		textPreco.setBackground(new Color(240, 237, 229));
		textPreco.setBounds(159, 12, 144, 35);
		panel.add(textPreco);
		textPreco.setColumns(10);

		comboBoxAnoDeFabrico = new JComboBox();
		comboBoxAnoDeFabrico.setModel(new DefaultComboBoxModel(new String[] { "2000", "2001", "2002", "2003", "2004",
				"2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017",
				"2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026" }));
		comboBoxAnoDeFabrico.setBackground(new Color(240, 237, 229));
		comboBoxAnoDeFabrico.setBounds(159, 59, 144, 35);
		panel.add(comboBoxAnoDeFabrico);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setForeground(new Color(0, 70, 67));
		lblMarca.setFont(new Font("Caladea", Font.BOLD, 16));
		lblMarca.setBounds(34, 129, 115, 14);
		panel.add(lblMarca);
		
		JLabel lblCor = new JLabel("Cor:");
		lblCor.setForeground(new Color(0, 70, 67));
		lblCor.setFont(new Font("Caladea", Font.BOLD, 16));
		lblCor.setBounds(34, 191, 115, 14);
		panel.add(lblCor);
		
		JLabel lblFabricante = new JLabel("Fabricante:");
		lblFabricante.setForeground(new Color(0, 70, 67));
		lblFabricante.setFont(new Font("Caladea", Font.BOLD, 16));
		lblFabricante.setBounds(34, 255, 115, 14);
		panel.add(lblFabricante);
		
		JComboBox comboBoxMarca = new JComboBox();
		comboBoxMarca.setBackground(new Color(240, 237, 229));
		comboBoxMarca.setBounds(159, 120, 144, 35);
		panel.add(comboBoxMarca);
		
		JComboBox comboBoxCor = new JComboBox();
		comboBoxCor.setBackground(new Color(240, 237, 229));
		comboBoxCor.setBounds(159, 182, 144, 35);
		panel.add(comboBoxCor);
		
		JComboBox comboBoxFabricante = new JComboBox();
		comboBoxFabricante.setBackground(new Color(240, 237, 229));
		comboBoxFabricante.setBounds(159, 246, 144, 35);
		panel.add(comboBoxFabricante);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 237, 229));
		panel_1.setBounds(416, 572, 808, 120);
		frameCelular.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		btnListar = new JButton("Listar");
		btnListar.setBackground(new Color(0, 70, 67));
		btnListar.setForeground(new Color(240, 237, 229));
		btnListar.setFont(new Font("Caladea", Font.BOLD, 14));
		btnListar.setBounds(243, 22, 127, 48);
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
		btnEditar.setBounds(433, 22, 127, 48);
		btnEditar.addActionListener(this);
		panel_1.add(btnEditar);

		btnRemover = new JButton("Remover");
		btnRemover.setBackground(new Color(0, 70, 67));
		btnRemover.setForeground(new Color(240, 237, 229));
		btnRemover.setFont(new Font("Caladea", Font.BOLD, 14));
		btnRemover.setBounds(627, 22, 127, 48);
		btnRemover.addActionListener(this);
		panel_1.add(btnRemover);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(240, 237, 229));
		panel_2.setBounds(416, 123, 933, 203);
		frameCelular.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 911, 181);
		panel_2.add(scrollPane);

		tableCelular = new JTable();
		tableCelular.setFont(new Font("Caladea", Font.BOLD, 14));
		tableCelular.setForeground(new Color(0, 70, 67));
		tableCelular.addMouseListener(this);
		scrollPane.setViewportView(tableCelular);
		tableCelular.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Numero de Serie","Marca","Modelo","Cor","Preco", "Ano de Fabrico", "Tempo de Existencia" }));
		tableCelular.setBackground(new Color(240, 237, 229));

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(240, 237, 229));
		panel_3.setBounds(288, 40, 755, 37);
		frameCelular.getContentPane().add(panel_3);

		JLabel lblTitulo = new JLabel("  Cadastro do Celular");
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

			ControllerCelular controller = new ControllerCelular();
			controller.adicionarCelular(usuarioLogado.getNome(), usuarioLogado.getPerfil(), preco, anoDeFabrico);

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
				double preco = celular.getPreco();
				int anoDeFabrico = celular.getAnoDeFabrico();
				int tempoDeExistencia = celular.calcularTempo();
				listarNaTabela.addRow(new Object[] { codigo, preco, anoDeFabrico, tempoDeExistencia });
			}
		} catch (ClassNotFoundException | SQLException e1) {

			e1.printStackTrace();
		}
	}

	public void confirmarPermissoes() {
		if (usuarioLogado == null)
			return;
		String perfil = usuarioLogado.getPerfil();

		if (perfil.equals("user")) {
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
