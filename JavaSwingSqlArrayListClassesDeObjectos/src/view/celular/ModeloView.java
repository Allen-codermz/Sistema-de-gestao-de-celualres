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

import controller.celular.ControllerModelo;
import controller.celular.Controllermarca;
import model.celular.CadastroUser;
import model.celular.Marca;
import model.celular.Modelo;
import javax.swing.JComboBox;

public class ModeloView implements ActionListener, MouseListener {

	private JFrame frame;
	private JTextField textModelo;

	private JButton btnAdicionar, btnListar, btnEditar, btnRemover;
	private JTable table;
	private CadastroUser usuarioLogado;
	
	private ArrayList<Marca> listaDeMarcas = new ArrayList<>();

	private JLabel lblUser;
	private JComboBox comboBoxMarca;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public ModeloView(CadastroUser usuario) {
		this.usuarioLogado = usuario;
		initialize();
		carregarMarca();
		confirmarPermissoes();
		if(usuario != null) {
			lblUser.setText("Usuario: "+ usuarioLogado.getNome()+" | "+"Perfil: "+usuarioLogado.getPerfil());
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

		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 237, 229));
		panel.setBounds(31, 234, 333, 129);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Modelo:");
		lblNewLabel.setForeground(new Color(0, 70, 67));
		lblNewLabel.setFont(new Font("Caladea", Font.BOLD, 16));
		lblNewLabel.setBounds(12, 108, 78, 17);
		panel.add(lblNewLabel);

		textModelo = new JTextField();
		textModelo.setForeground(new Color(0, 70, 67));
		textModelo.setFont(new Font("Caladea", Font.BOLD, 14));
		textModelo.setBackground(new Color(240, 237, 229));
		textModelo.setBounds(108, 87, 192, 38);
		panel.add(textModelo);
		textModelo.setColumns(10);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setForeground(new Color(0, 70, 67));
		lblMarca.setFont(new Font("Caladea", Font.BOLD, 16));
		lblMarca.setBounds(12, 38, 78, 17);
		panel.add(lblMarca);
		
		comboBoxMarca = new JComboBox();
		comboBoxMarca.setForeground(new Color(0, 70, 67));
		comboBoxMarca.setFont(new Font("Caladea", Font.BOLD, 14));
		comboBoxMarca.setBackground(new Color(240, 237, 229));
		comboBoxMarca.setBounds(108, 17, 190, 38);
		panel.add(comboBoxMarca);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 237, 229));
		panel_1.setBounds(507, 163, 293, 241);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBackground(new Color(0, 70, 67));
		btnAdicionar.setForeground(new Color(240, 237, 229));
		btnAdicionar.setFont(new Font("Caladea", Font.BOLD, 14));
		btnAdicionar.setBounds(80, 33, 127, 40);
		btnAdicionar.addActionListener(this);
		panel_1.add(btnAdicionar);

		btnListar = new JButton("Listar");
		btnListar.setBackground(new Color(0, 70, 67));
		btnListar.setForeground(new Color(240, 237, 229));
		btnListar.setFont(new Font("Caladea", Font.BOLD, 14));
		btnListar.setBounds(80, 85, 127, 40);
		btnListar.addActionListener(this);
		panel_1.add(btnListar);

		btnEditar = new JButton("Editar");
		btnEditar.setBackground(new Color(0, 70, 67));
		btnEditar.setForeground(new Color(240, 237, 229));
		btnEditar.setFont(new Font("Caladea", Font.BOLD, 14));
		btnEditar.setBounds(80, 137, 127, 40);
		btnEditar.addActionListener(this);
		panel_1.add(btnEditar);

		btnRemover = new JButton("Remover");
		btnRemover.setBackground(new Color(0, 70, 67));
		btnRemover.setForeground(new Color(240, 237, 229));
		btnRemover.setFont(new Font("Caladea", Font.BOLD, 14));
		btnRemover.setBounds(80, 189, 127, 40);
		btnRemover.addActionListener(this);
		panel_1.add(btnRemover);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(240, 237, 229));
		panel_2.setBounds(348, 471, 678, 194);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 12, 622, 171);
		panel_2.add(scrollPane);

		table = new JTable();
		table.setBackground(new Color(240, 237, 229));
		table.setFont(new Font("Caladea", Font.BOLD, 14));
		table.setForeground(new Color(0, 70, 67));
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "CodigoModelo", "Modelo", "Marca" }));
		scrollPane.setViewportView(table);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(240, 237, 229));
		panel_3.setBounds(306, 29, 832, 42);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Cadastro de Modelo");
		lblNewLabel_1.setForeground(new Color(0, 70, 67));
		lblNewLabel_1.setFont(new Font("Caladea", Font.BOLD, 30));
		lblNewLabel_1.setBounds(244, 12, 327, 25);
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
		btnNewButton.setBounds(1210, 29, 127, 38);
		frame.getContentPane().add(btnNewButton);
		
		lblUser = new JLabel("");
		lblUser.setForeground(new Color(0, 70, 67));
		lblUser.setFont(new Font("Caladea", Font.BOLD, 14));
		lblUser.setBounds(560, 6, 368, 17);
		frame.getContentPane().add(lblUser);
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
	

	private void adicionarModelo() {
		String modelo = textModelo.getText();
		int codigoMarca = listaDeMarcas.get(comboBoxMarca.getSelectedIndex()).getCodigoMarca();

		if (modelo.isEmpty() || modelo.isBlank()){
			JOptionPane.showMessageDialog(null, "Por favor preencha o campo");
			return;
		}
		if(comboBoxMarca.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(null, "Por favor cadastre uma marca primeiro!!");
			return;
		}
	
		ControllerModelo controller = new ControllerModelo();
		try {
			controller.adicionarModelo(usuarioLogado.getNome(), usuarioLogado.getPerfil(), modelo,codigoMarca);
			JOptionPane.showMessageDialog(null, "Modelo adicionado com sucesso!");
			limparCaixas();
			limparTabela();
			// listar();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao adicionar: " + ex.getMessage());
		}
	}

	public void listar() {
		DefaultTableModel listarNaTabela = (DefaultTableModel) table.getModel();
		ControllerModelo controller = new ControllerModelo();
		try {
			ArrayList<Modelo> listaDeModelos = controller.listaDeModelo();
			for (Modelo modelo : listaDeModelos) {
				int codigo = modelo.getCodigoModelo();
				String nomeModelo = modelo.getModelo();
				Marca marca = modelo.getMarca();

				listarNaTabela.addRow(new Object[] { codigo, nomeModelo, marca });
			}
		} catch (ClassNotFoundException | SQLException e1) {
			JOptionPane.showMessageDialog(null, "Erro ao listar" + e1.getMessage());
			e1.printStackTrace();
		}
	}

	public void confirmarPermissoes() {
		if (usuarioLogado == null)
			return;
		String perfil = usuarioLogado.getPerfil();

		if (perfil.equals("Operador")) {
			btnEditar.setEnabled(false);
			btnRemover.setEnabled(false);
		}
	}

	private void editarModelo() {
		int linhaSeleccionada = table.getSelectedRow();
		if (linhaSeleccionada == -1) {
			JOptionPane.showMessageDialog(null, "Por favor, selecione um marca na tabela!");
			return;
		}
		String modelo = textModelo.getText();
		if(modelo.isEmpty()|| modelo.isBlank()) {
			JOptionPane.showMessageDialog(null, "Por favor preencha o campo!");
			return;
		}
		try {
			int codigoModelo = (int) table.getValueAt(linhaSeleccionada, 0);
			ControllerModelo controller = new ControllerModelo();
			controller.actualizarModelo(usuarioLogado.getNome(), usuarioLogado.getPerfil(), codigoModelo, modelo);
			JOptionPane.showMessageDialog(null, "Marca editada com sucesso!");
			limparCaixas();
			limparTabela();
			listar();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex.getMessage());
		}
	}

	private void removerModelo() {
		int linhaSeleccionada = table.getSelectedRow();
		if (linhaSeleccionada == -1) {
			JOptionPane.showMessageDialog(null, "Por favor, selecione uma Marca na tabela!");
			return;
		}

		try {
			int codigo = (int) table.getValueAt(linhaSeleccionada, 0);
			ControllerModelo controller = new ControllerModelo();
			controller.removerModelo(usuarioLogado.getNome(), usuarioLogado.getPerfil(), codigo);
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
			adicionarModelo();
		}
		if (e.getSource() == btnListar) {
			limparTabela();
			listar();
		}
		if (e.getSource() == btnEditar) {
			editarModelo();
		}
		if (e.getSource() == btnRemover) {
			removerModelo();
		}
	}

	public void limparTabela() {
		while (table.getRowCount() > 0) {
			DefaultTableModel listar = (DefaultTableModel) table.getModel();
			listar.removeRow(0);
		}
	}

	public void limparCaixas() {
		textModelo.setText("");
	}

	public void mouseClicked(MouseEvent e) {
		if (table.getSelectedRow() != -1) {
			int indice = table.getSelectedRow();
			DefaultTableModel linhaSelecionada = (DefaultTableModel) table.getModel();

			textModelo.setText(linhaSelecionada.getValueAt(indice, 1).toString());
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
