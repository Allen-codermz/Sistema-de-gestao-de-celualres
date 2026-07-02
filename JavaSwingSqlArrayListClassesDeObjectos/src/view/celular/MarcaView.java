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

import controller.celular.Controllermarca;
import model.celular.CadastroUser;
import model.celular.Marca;

public class MarcaView implements ActionListener, MouseListener {

	private JFrame frameMarca;
	private JTextField textMarca;
	private JTable table;
	
	private JLabel lblUser;

	private JButton btnAdicionar, btnListar, btnEditar, btnRemover;

	private CadastroUser usuarioLogado;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public MarcaView(CadastroUser usuario) {
		this.usuarioLogado = usuario;
		initialize();
		confirmarPermissoes();
		if(usuario != null) {
			lblUser.setText("Usuario: "+ usuarioLogado.getNome()+" | "+"Perfil: "+usuarioLogado.getPerfil());
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
		panel.setBounds(70, 234, 344, 90);
		frameMarca.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setForeground(new Color(0, 70, 67));
		lblMarca.setFont(new Font("Caladea", Font.BOLD, 16));
		lblMarca.setBounds(43, 37, 79, 29);
		panel.add(lblMarca);

		textMarca = new JTextField();
		textMarca.setForeground(new Color(0, 70, 67));
		textMarca.setFont(new Font("Caladea", Font.BOLD, 14));
		textMarca.setBackground(new Color(240, 237, 229));
		textMarca.setBounds(132, 37, 165, 29);
		panel.add(textMarca);
		textMarca.setColumns(10);

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
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "CodigoMarca", "Nome da Marca" }));
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
	}
//nivel de acesso
	public void confirmarPermissoes() {
		if (usuarioLogado == null)
			return;
		String perfil = usuarioLogado.getPerfil();

		if (perfil.equals("User")) {
			btnEditar.setEnabled(false);
			btnRemover.setEnabled(false);
		}
	}

	private void adicionarMarca() {
		String marca = textMarca.getText();

		if (marca.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Por favor preencha o campo");
			return;
		}

		Controllermarca controller = new Controllermarca();
		try {
			controller.adicionarMarca(usuarioLogado.getNome(), usuarioLogado.getPerfil(), marca);
			JOptionPane.showMessageDialog(null, "Marca adicionado com sucesso!");
			limparCaixas();
			limparTabela();
			// listar();
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

				listarNaTabela.addRow(new Object[] { codigo, nomeMarca });
			}
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private void editarMarca() {
		int linhaSeleccionada = table.getSelectedRow();
		if (linhaSeleccionada == -1) {
			JOptionPane.showMessageDialog(null, "Por favor, selecione um marca na tabela!");
			return;
		}
		String marca = textMarca.getText();
		try {
			int codigoMarca = (int) table.getValueAt(linhaSeleccionada, 0);
			Controllermarca controller = new Controllermarca();
			controller.actualizarMarca(usuarioLogado.getNome(), usuarioLogado.getPerfil(), codigoMarca, marca);
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
