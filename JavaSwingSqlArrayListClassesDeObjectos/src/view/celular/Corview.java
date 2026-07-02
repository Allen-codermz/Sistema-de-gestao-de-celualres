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
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import controller.celular.ControllerCor;
import controller.celular.CorApiService;
import model.celular.CadastroUser;
import model.celular.Cor;

public class Corview implements ActionListener, MouseListener {

	private JFrame frame;
	private JTextField textCorHex;
	private JTable table;

	private JButton btnListar, btnEditar, btnRemover, btnAdicionar;
	private JButton btnSelecionar;
	private JButton btnNewButton_1;
	private JPanel panel_1;
	private CadastroUser usuarioLogado;
	private JLabel lblUser;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public Corview(CadastroUser usuario) {
		this.usuarioLogado = usuario;
		initialize();
		confirmarPermissoes();
		if(usuario != null) {
			lblUser.setText("Usuario: "+ usuarioLogado.getNome()+" | "+"Perfil: "+usuarioLogado.getPerfil());
		}
	
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
		panel_3.setBounds(598, 29, 341, 36);
		panel_3.setBackground(new Color(240, 237, 229));
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel = new JLabel("Cadastro de Cores");
		lblNewLabel.setBounds(12, 0, 369, 36);
		panel_3.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(0, 70, 67));
		lblNewLabel.setFont(new Font("Caladea", Font.BOLD, 30));

		JPanel panel = new JPanel();
		panel.setBounds(660, 114, 227, 341);
		panel.setBackground(new Color(240, 237, 229));
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		btnListar = new JButton("Listar");
		btnListar.setBounds(49, 127, 130, 48);
		panel.add(btnListar);
		btnListar.setBackground(new Color(0, 70, 67));
		btnListar.setForeground(new Color(240, 237, 229));
		btnListar.setFont(new Font("Caladea", Font.BOLD, 14));
		btnListar.addActionListener(this);

		btnEditar = new JButton("Editar");
		btnEditar.setBounds(49, 187, 130, 48);
		panel.add(btnEditar);
		btnEditar.setBackground(new Color(0, 70, 67));
		btnEditar.setForeground(new Color(240, 237, 229));
		btnEditar.setFont(new Font("Caladea", Font.BOLD, 14));
		btnEditar.addActionListener(this);

		btnRemover = new JButton("Remover");
		btnRemover.setBounds(49, 246, 130, 48);
		panel.add(btnRemover);
		btnRemover.setBackground(new Color(0, 70, 67));
		btnRemover.setForeground(new Color(240, 237, 229));
		btnRemover.setFont(new Font("Caladea", Font.BOLD, 14));
		btnRemover.addActionListener(this);

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setForeground(new Color(240, 237, 229));
		btnAdicionar.setFont(new Font("Caladea", Font.BOLD, 14));
		btnAdicionar.setBackground(new Color(0, 70, 67));
		btnAdicionar.setBounds(49, 67, 130, 48);
		panel.add(btnAdicionar);
		btnAdicionar.addActionListener(this);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(367, 498, 682, 233);
		panel_2.setBackground(new Color(240, 237, 229));
		panel_2.setLayout(null);
		frame.getContentPane().add(panel_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 29, 626, 154);
		panel_2.add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Caladea", Font.BOLD, 14));
		table.setForeground(new Color(0, 70, 67));
		scrollPane.setViewportView(table);
		table.addMouseListener(this);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "CodigoCor", "Cor", "Descricao" }));
		table.setBackground(new Color(240, 237, 229));

		btnNewButton_1 = new JButton("Tela Principal");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipalView tela = new TelaPrincipalView(usuarioLogado);
				tela.setVisible(true);
			}
		});
		btnNewButton_1.setForeground(new Color(240, 237, 229));
		btnNewButton_1.setFont(new Font("Caladea", Font.BOLD, 14));
		btnNewButton_1.setBackground(new Color(0, 70, 67));
		btnNewButton_1.setBounds(1198, 27, 127, 38);
		frame.getContentPane().add(btnNewButton_1);
		
		lblUser = new JLabel("");
		lblUser.setForeground(new Color(0, 70, 67));
		lblUser.setFont(new Font("Caladea", Font.BOLD, 14));
		lblUser.setBounds(625, 12, 368, 17);
		frame.getContentPane().add(lblUser);
		
				btnSelecionar = new JButton("Selicionar Cor");
				btnSelecionar.setBounds(83, 232, 130, 48);
				frame.getContentPane().add(btnSelecionar);
				btnSelecionar.setFont(new Font("Caladea", Font.BOLD, 14));
				btnSelecionar.setForeground(new Color(240, 237, 229));
				btnSelecionar.setBackground(new Color(0, 70, 67));
				
						textCorHex = new JTextField();
						textCorHex.setBounds(225, 232, 127, 48);
						frame.getContentPane().add(textCorHex);
						textCorHex.setForeground(new Color(0, 70, 67));
						textCorHex.setFont(new Font("Caladea", Font.BOLD, 14));
						textCorHex.setEditable(false);
						textCorHex.setColumns(10);
						
								panel_1 = new JPanel();
								panel_1.setBounds(353, 232, 59, 48);
								frame.getContentPane().add(panel_1);
				btnSelecionar.addActionListener(this);
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

	public void escolherCor() {
		JColorChooser collorChoser = new JColorChooser();
		Color color = JColorChooser.showDialog(null, "Selecione uma cor", Color.white);
		if (color != null) {
			panel_1.setBackground(color);
			;

			String colorHex = String.format("#%02X%02X%02X", color.getRed(), color.getGreen(), color.getBlue());
			textCorHex.setText(colorHex);
		}
	}

	private void adicionarCor() {
		String cor = textCorHex.getText();

		if (cor.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Por favor preencha o campo");
			return;
		}

		try {
			ControllerCor controller = new ControllerCor();
			controller.adicionarCor(usuarioLogado.getNome(), usuarioLogado.getPerfil(), cor);
			JOptionPane.showMessageDialog(null, "Cor adicionado com sucesso!");
			limparCaixas();
			limparTabela();
			// listar();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao adicionar: " + ex.getMessage());
		}
	}

	public void listar() {
		DefaultTableModel listarNaTabela = (DefaultTableModel) table.getModel();
		ControllerCor controller = new ControllerCor();
		try {
			ArrayList<Cor> listaDeCores = controller.listaDeCores();
			for (Cor cor : listaDeCores) {
				int codigoCor = cor.getCodigoCor();
				String nomeMarca = cor.getCor();
				String descricao = cor.getDescricao();

				listarNaTabela.addRow(new Object[] { codigoCor, nomeMarca, descricao });
			}

		} catch (ClassNotFoundException | SQLException e1) {
			JOptionPane.showMessageDialog(null, "Erro ao listar: " + e1.getMessage());
			e1.printStackTrace();
		}
	}

	private void editarCor() {
		int linhaSeleccionada = table.getSelectedRow();
		if (linhaSeleccionada == -1) {
			JOptionPane.showMessageDialog(null, "Por favor, selecione uma cor na tabela!");
			return;
		}
		String cor = textCorHex.getText();
		if (cor.isEmpty()) {
			JOptionPane.showMessageDialog(null,"Por favor selecione uma nova cor primeiro!!");
			return;
		}
		try {
			int codigoCor = (int) table.getValueAt(linhaSeleccionada, 0);
			ControllerCor controller = new ControllerCor();
			controller.actualizarCor(usuarioLogado.getNome(), usuarioLogado.getPerfil(), codigoCor, cor);
			JOptionPane.showMessageDialog(null, "Cor editada com sucesso!");
			limparCaixas();
			limparTabela();
			listar();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex.getMessage());
		}
	}

	private void removerCor() {
		int linhaSeleccionada = table.getSelectedRow();
		if (linhaSeleccionada == -1) {
			JOptionPane.showMessageDialog(null, "Por favor, selecione uma cor na tabela!");
			return;
		}

		try {
			int codigoCor = (int) table.getValueAt(linhaSeleccionada, 0);
			ControllerCor controller = new ControllerCor();
			controller.removerCor(usuarioLogado.getNome(), usuarioLogado.getPerfil(), codigoCor);
			JOptionPane.showMessageDialog(null, "Cor removida com sucesso!");
			// limparCaixas();
			limparTabela();
			// listar();

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao remover: " + ex.getMessage());
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSelecionar) {
			escolherCor();
		}
		if (e.getSource() == btnAdicionar) {
			adicionarCor();
		}
		if (e.getSource() == btnListar) {
			limparTabela();
			listar();
		}
		if (e.getSource() == btnEditar) {
			editarCor();
		}
		if (e.getSource() == btnRemover) {
			removerCor();
		}
	}

	public void limparTabela() {
		while (table.getRowCount() > 0) {
			DefaultTableModel listar = (DefaultTableModel) table.getModel();
			listar.removeRow(0);
		}
	}

	public void limparCaixas() {
		textCorHex.setText("");
	}

	public void mouseClicked(MouseEvent e) {
		if (table.getSelectedRow() != -1) {
			int indice = table.getSelectedRow();
			DefaultTableModel linhaSelecionada = (DefaultTableModel) table.getModel();

			textCorHex.setText(linhaSelecionada.getValueAt(indice, 1).toString());
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

	public void setVisible(boolean visible) {
		frame.setVisible(visible);

	}
}
