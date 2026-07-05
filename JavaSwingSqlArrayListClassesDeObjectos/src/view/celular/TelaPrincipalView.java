package view.celular;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.celular.CadastroUser;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipalView {

	private JFrame frame;

	private JLabel lblUser;

	private CadastroUser usuarioLogado;

	private JButton btnGerirUsers, btnAcessarLogs, btnGestaoDeFabricante;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public TelaPrincipalView(CadastroUser usuario) {
		this.usuarioLogado = usuario;
		initialize();
		confirmarPermissoes();

		if (usuario != null) {
			lblUser.setText("Usuario: " + usuarioLogado.getNome() + " | " + "Perfil: " + usuarioLogado.getPerfil());
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

		JPanel panel = new JPanel();
		panel.setBounds(12, 22, 1431, 666);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 70, 67));
		panel_2.setBounds(0, 0, 741, 654);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("''SISTEMA");
		lblNewLabel_1.setFont(new Font("Caladea", Font.BOLD, 60));
		lblNewLabel_1.setForeground(new Color(240, 237, 229));
		lblNewLabel_1.setBounds(217, 87, 280, 127);
		panel_2.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("DE");
		lblNewLabel_2.setFont(new Font("Caladea", Font.BOLD, 60));
		lblNewLabel_2.setForeground(new Color(240, 237, 229));
		lblNewLabel_2.setBounds(320, 194, 100, 78);
		panel_2.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("GESTÃO");
		lblNewLabel_3.setFont(new Font("Caladea", Font.BOLD, 60));
		lblNewLabel_3.setForeground(new Color(240, 237, 229));
		lblNewLabel_3.setBounds(253, 284, 244, 102);
		panel_2.add(lblNewLabel_3);

		JLabel lblNewLabel_5 = new JLabel("CELULARES''");
		lblNewLabel_5.setFont(new Font("Caladea", Font.BOLD, 60));
		lblNewLabel_5.setForeground(new Color(240, 237, 229));
		lblNewLabel_5.setBounds(207, 496, 376, 64);
		panel_2.add(lblNewLabel_5);

		JLabel lblNewLabel_2_1 = new JLabel("DE");
		lblNewLabel_2_1.setForeground(new Color(240, 237, 229));
		lblNewLabel_2_1.setFont(new Font("Caladea", Font.BOLD, 60));
		lblNewLabel_2_1.setBounds(320, 387, 100, 78);
		panel_2.add(lblNewLabel_2_1);

		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginView login = new LoginView(usuarioLogado);
				login.setVisible(true);
			}
		});
		btnLogOut.setForeground(new Color(0, 70, 67));
		btnLogOut.setFont(new Font("Caladea", Font.BOLD, 14));
		btnLogOut.setBackground(new Color(240, 237, 229));
		btnLogOut.setBounds(12, 12, 100, 33);
		panel_2.add(btnLogOut);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(894, 262, 289, 370);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JButton btnGestaoDeCelular = new JButton("Gestão de celulares");
		btnGestaoDeCelular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CelularView celular = new CelularView(usuarioLogado);
				celular.setVisible(true);
			}
		});
		btnGestaoDeCelular.setFont(new Font("Caladea", Font.BOLD, 14));
		btnGestaoDeCelular.setBackground(new Color(0, 70, 67));
		btnGestaoDeCelular.setForeground(new Color(240, 237, 229));
		btnGestaoDeCelular.setBounds(65, 45, 191, 48);
		panel_1.add(btnGestaoDeCelular);

		JButton btnGestaoDeMarca = new JButton("Gestão de marcas");
		btnGestaoDeMarca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MarcaView celular = new MarcaView(usuarioLogado);
				celular.setVisible(true);
			}
		});
		btnGestaoDeMarca.setFont(new Font("Caladea", Font.BOLD, 14));
		btnGestaoDeMarca.setBackground(new Color(0, 70, 67));
		btnGestaoDeMarca.setForeground(new Color(240, 237, 229));
		btnGestaoDeMarca.setBounds(65, 114, 191, 48);
		panel_1.add(btnGestaoDeMarca);

		JButton btnGestaoDeModelo = new JButton("Gestão de modelos");
		btnGestaoDeModelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModeloView celular = new ModeloView(usuarioLogado);
				celular.setVisible(true);
			}
		});
		btnGestaoDeModelo.setFont(new Font("Caladea", Font.BOLD, 14));
		btnGestaoDeModelo.setBackground(new Color(0, 70, 67));
		btnGestaoDeModelo.setForeground(new Color(240, 237, 229));
		btnGestaoDeModelo.setBounds(65, 174, 191, 48);
		panel_1.add(btnGestaoDeModelo);

		JButton btnGestaoDeCor = new JButton("Gestão de cores\n");
		btnGestaoDeCor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Corview celular = new Corview(usuarioLogado);
				celular.setVisible(true);
			}
		});
		btnGestaoDeCor.setFont(new Font("Caladea", Font.BOLD, 14));
		btnGestaoDeCor.setBackground(new Color(0, 70, 67));
		btnGestaoDeCor.setForeground(new Color(240, 237, 229));
		btnGestaoDeCor.setBounds(65, 231, 191, 48);
		panel_1.add(btnGestaoDeCor);

		btnGestaoDeFabricante = new JButton("Gestão de fabricantes");
		btnGestaoDeFabricante.setFont(new Font("Caladea", Font.BOLD, 14));
		btnGestaoDeFabricante.setBackground(new Color(0, 70, 67));
		btnGestaoDeFabricante.setForeground(new Color(240, 237, 229));
		btnGestaoDeFabricante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FabricanteView celular = new FabricanteView(usuarioLogado);
				celular.setVisible(true);
			}
		});
		btnGestaoDeFabricante.setBounds(65, 297, 191, 48);
		panel_1.add(btnGestaoDeFabricante);

		JLabel lblNewLabel = new JLabel("WELCOME");
		lblNewLabel.setFont(new Font("Caladea", Font.BOLD, 70));
		lblNewLabel.setForeground(new Color(0, 70, 67));
		lblNewLabel.setBounds(857, 72, 374, 147);
		panel.add(lblNewLabel);

		btnGerirUsers = new JButton("Gerir Users");
		btnGerirUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroUserView user = new CadastroUserView(usuarioLogado);
				user.setVisible(true);
			}
		});
		btnGerirUsers.setForeground(new Color(240, 237, 229));
		btnGerirUsers.setFont(new Font("Caladea", Font.BOLD, 14));
		btnGerirUsers.setBackground(new Color(0, 70, 67));
		btnGerirUsers.setBounds(1227, 0, 124, 48);
		panel.add(btnGerirUsers);

		btnAcessarLogs = new JButton("Acessar Logs");
		btnAcessarLogs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogsView log = new LogsView(usuarioLogado);
				log.setVisible(true);
			}
		});
		btnAcessarLogs.setForeground(new Color(240, 237, 229));
		btnAcessarLogs.setFont(new Font("Caladea", Font.BOLD, 14));
		btnAcessarLogs.setBackground(new Color(0, 70, 67));
		btnAcessarLogs.setBounds(1227, 53, 124, 48);
		panel.add(btnAcessarLogs);

		lblUser = new JLabel("");
		lblUser.setFont(new Font("Caladea", Font.BOLD, 14));
		lblUser.setForeground(new Color(0, 70, 67));
		lblUser.setBounds(746, 16, 368, 17);
		panel.add(lblUser);
	}

	public void confirmarPermissoes() {
		if (usuarioLogado == null)
			return;

		String perfil = usuarioLogado.getPerfil();
		switch (perfil) {
		case "Operador":
			btnGerirUsers.setEnabled(false);
			btnAcessarLogs.setEnabled(false);
			break;
		case "SuperOperador":
			btnGerirUsers.setEnabled(false);
			btnAcessarLogs.setEnabled(false);
			break;
		case "Administrador":
			btnAcessarLogs.setEnabled(false);
			break;
		case "Auditor":
			btnGerirUsers.setEnabled(false);
			break;
		}
	}

	public void setVisible(boolean visible) {
		frame.setVisible(visible);

	}
}
