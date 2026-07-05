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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.celular.ControllerFabricante;
import model.celular.CadastroUser;
import model.celular.Fabricante;

public class FabricanteView implements ActionListener, MouseListener {

	private JFrame frame;
	private JTextField textFabricante;
	private JTextField textPaisDeOrigem;
	private JTable table;

	private JButton btnAdicionar, btnListar, btnEditar, btnRemover;
	private JButton btnNewButton;
	
	private CadastroUser usuarioLogado;
	private JLabel lblUser;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public FabricanteView(CadastroUser usuario) {
		this.usuarioLogado=usuario;
		initialize();
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
		panel.setBounds(45, 257, 384, 183);
		panel.setBackground(new Color(240, 237, 229));
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblEndereco = new JLabel("Fabricante:");
		lblEndereco.setBounds(36, 48, 157, 35);
		lblEndereco.setForeground(new Color(0, 70, 67));
		lblEndereco.setFont(new Font("Caladea", Font.BOLD, 20));
		panel.add(lblEndereco);

		textPaisDeOrigem = new JTextField();
		textPaisDeOrigem.setFont(new Font("Caladea", Font.BOLD, 14));
		textPaisDeOrigem.setForeground(new Color(0, 70, 67));
		textPaisDeOrigem.setBackground(new Color(240, 237, 229));
		textPaisDeOrigem.setBounds(198, 48, 161, 35);
		panel.add(textPaisDeOrigem);
		textPaisDeOrigem.setColumns(10);

		JLabel lblFabricante = new JLabel("País de origem:");
		lblFabricante.setBounds(36, 118, 157, 40);
		lblFabricante.setForeground(new Color(0, 70, 67));
		lblFabricante.setFont(new Font("Caladea", Font.BOLD, 20));
		panel.add(lblFabricante);

		textFabricante = new JTextField();
		textFabricante.setForeground(new Color(0, 70, 67));
		textFabricante.setFont(new Font("Caladea", Font.BOLD, 14));
		textFabricante.setBackground(new Color(240, 237, 229));
		textFabricante.setBounds(198, 118, 161, 40);
		panel.add(textFabricante);
		textFabricante.setColumns(10);

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
		panel_2.setBounds(388, 457, 682, 223);
		panel_2.setBackground(new Color(240, 237, 229));
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 32, 626, 154);
		panel_2.add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Caladea", Font.BOLD, 14));
		table.setForeground(new Color(0, 70, 67));
		scrollPane.setViewportView(table);
		table.addMouseListener(this);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "CodigoFabricante", "Pais de origem", "Fabricante" }));
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
	}
	
	public void confirmarPermissoes() {
		if(usuarioLogado == null)return;
		String perfil = usuarioLogado.getPerfil();
		
		if(perfil.equals("Operador")) {
			btnEditar.setEnabled(false);
			btnRemover.setEnabled(false);
		}
	}

	private void adicionarFabricante() {
		String fabricante = textFabricante.getText();
		String paisDeOrigem = textPaisDeOrigem.getText();
		
		if(fabricante.isEmpty() || paisDeOrigem.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Por favor preencha os campos" );
			return;
		}
		try {
			ControllerFabricante controller = new ControllerFabricante();
			controller.adicionarFabricante(usuarioLogado.getNome(),usuarioLogado.getPerfil(), fabricante, paisDeOrigem);
			JOptionPane.showMessageDialog(null, "Fabricante adicionado com sucesso!");
			limparCaixas();
			limparTabela();
			// listar();
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
	}

	private void editarFabricante() {
		int linhaSeleccionada = table.getSelectedRow();
		if (linhaSeleccionada == -1) {
			JOptionPane.showMessageDialog(null, "Por favor, selecione um fabricante na tabela!");
			return;
		}
		String marca = textFabricante.getText();
		String paisDeOrigem = textPaisDeOrigem.getText();
		if(marca.isEmpty() || paisDeOrigem.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Por favor preencha os campos!");
			return;
		}

		ControllerFabricante controller = new ControllerFabricante();
		try {
			int codigoFabricante = (int) table.getValueAt(linhaSeleccionada, 0);
			controller.actualizarFabricante(usuarioLogado.getNome(),usuarioLogado.getPerfil(),codigoFabricante, marca, paisDeOrigem);
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
			controller.removerFabricante(usuarioLogado.getNome(),usuarioLogado.getPerfil(),codigo);
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
		textPaisDeOrigem.setText("");
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
