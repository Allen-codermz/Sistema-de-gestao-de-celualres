package view.celular;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import controller.celular.ControllerLog;
import model.celular.CadastroUser;
import model.celular.Log;

import javax.swing.JLabel;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class LogsView {

	private JFrame frame;
	private JTable table;
	private JPanel panel;
	private JLabel lblRegistosEAces;
	private JButton btnNewButton;

	private CadastroUser usuarioLogado;
	private JLabel lblUser;
	private JTextField textPesquisa;

	private TableRowSorter<DefaultTableModel> sorter;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public LogsView(CadastroUser usuario) {
		this.usuarioLogado = usuario;
		initialize();
		listar();
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

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(23, 280, 1294, 223);
		panel_2.setBackground(new Color(240, 237, 229));
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 32, 1230, 154);
		panel_2.add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Caladea", Font.PLAIN, 14));
		table.setEnabled(false);
		table.setForeground(new Color(0, 70, 67));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "CodigoLog", "Usuario", "Perfil", "Accao", "Data" }));
		table.setBackground(new Color(240, 237, 229));

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(240, 237, 229));
		panel.setBounds(498, 48, 422, 57);
		frame.getContentPane().add(panel);

		lblRegistosEAces = new JLabel("Registos e Acções");
		lblRegistosEAces.setForeground(new Color(0, 70, 67));
		lblRegistosEAces.setFont(new Font("Caladea", Font.BOLD, 40));
		lblRegistosEAces.setBounds(12, 0, 369, 57);
		panel.add(lblRegistosEAces);

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
		btnNewButton.setBounds(1215, 32, 136, 38);
		frame.getContentPane().add(btnNewButton);

		lblUser = new JLabel("");
		lblUser.setForeground(new Color(0, 70, 67));
		lblUser.setFont(new Font("Caladea", Font.BOLD, 14));
		lblUser.setBounds(562, 19, 298, 17);
		frame.getContentPane().add(lblUser);

		JLabel lblNewLabel = new JLabel("Pesquisar:");
		lblNewLabel.setFont(new Font("Caladea", Font.BOLD, 18));
		lblNewLabel.setForeground(new Color(0, 70, 67));
		lblNewLabel.setBounds(1094, 223, 97, 17);
		frame.getContentPane().add(lblNewLabel);
		textPesquisa = new JTextField();
		textPesquisa.setFont(new Font("Caladea", Font.PLAIN, 14));
		textPesquisa.setBackground(new Color(240, 237, 229));
		textPesquisa.setForeground(new Color(0, 70, 67));
		textPesquisa.setBounds(1089, 242, 194, 38);
		frame.getContentPane().add(textPesquisa);
		textPesquisa.setColumns(10);
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
			sorter.setRowFilter(RowFilter.regexFilter("(?i)" + Pattern.quote(texto), 1, 2, 3, 4));
		}
	}

	public void listar() {
		DefaultTableModel listarNaTabela = (DefaultTableModel) table.getModel();

		ControllerLog controller = new ControllerLog();

		ArrayList<Log> listaDeLogs = null;
		try {
			listaDeLogs = controller.listaDeLogs();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		for (Log log : listaDeLogs) {
			int codigoLog = log.getCodigoLog();
			String usuario = log.getUsuario();
			String perfil = log.getPerfil();
			String accao = log.getAccao();
			String dataAccao = log.getDataAccao();

			listarNaTabela.addRow(new Object[] { codigoLog, usuario, perfil, accao, dataAccao });
		}
		sorter = new TableRowSorter<DefaultTableModel>(listarNaTabela);
		table.setRowSorter(sorter);
		
		for(int i= 0;i<table.getColumnCount();i++) {
			sorter.setSortable(i, false);
		}
	}
}
