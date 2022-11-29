package visao;

import java.awt.EventQueue; 
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.xml.crypto.Data;

import controle.CClienteControl;
import modelo.MCliente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class JCadastroCliente extends JFrame {

	private JPanel contentPane;
	private JTextField edNome;
	private JTextField edCnh;
	private JTextField edCpf;
	private JTextField edTelefone;
	private JTextField edGmail;
	private JTextField edData;

	
	JMenu menu = new JMenu();

	public JCadastroCliente() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 537, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbTitulo = new JLabel("Cadastro Cliente");
		lbTitulo.setBounds(174, 0, 158, 14);
		lbTitulo.setVerticalAlignment(SwingConstants.TOP);
		contentPane.add(lbTitulo);

		JLabel lbCpf = new JLabel("CPF :  ");
		lbCpf.setHorizontalAlignment(SwingConstants.RIGHT);
		lbCpf.setBounds(55, 130, 46, 14);
		contentPane.add(lbCpf);

		JLabel lbNome = new JLabel("Nome : ");
		lbNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lbNome.setBounds(46, 52, 55, 14);
		contentPane.add(lbNome);

		JLabel lbCnh = new JLabel("CNH :  ");
		lbCnh.setHorizontalAlignment(SwingConstants.RIGHT);
		lbCnh.setBounds(55, 165, 46, 14);
		contentPane.add(lbCnh);

		JLabel lbTelefone = new JLabel("Telefone :  ");
		lbTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
		lbTelefone.setBounds(12, 201, 89, 14);
		contentPane.add(lbTelefone);

		JLabel lbGmail = new JLabel("Gmail :  ");
		lbGmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lbGmail.setBounds(22, 236, 79, 14);
		contentPane.add(lbGmail);

		JLabel lbData = new JLabel("Data :  ");
		lbData.setHorizontalAlignment(SwingConstants.RIGHT);
		lbData.setBounds(12, 89, 89, 14);
		contentPane.add(lbData);

		JLabel lbImg = new JLabel("New label");
		lbImg.setIcon(new ImageIcon(JCadastroCliente.class.getResource("/visao/149071_resized.png")));
		lbImg.setBounds(393, 24, 102, 105);
		contentPane.add(lbImg);

		JLabel lbSexo = new JLabel("Sexo :   ");
		lbSexo.setBounds(50, 277, 62, 18);
		contentPane.add(lbSexo);

		edNome = new JTextField();
		edNome.setBounds(126, 49, 222, 20);
		contentPane.add(edNome);
		edNome.setColumns(10);

		edCnh = new JTextField();
		edCnh.setColumns(10);
		try {
			edCnh = new JFormattedTextField(new MaskFormatter("###########"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		edCnh.setBounds(126, 162, 220, 20);
		contentPane.add(edCnh);

		edCpf = new JTextField();
		edCpf.setColumns(10);
		try {
			edCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		edCpf.setBounds(126, 127, 222, 20);
		contentPane.add(edCpf);

		edTelefone = new JTextField();
		edTelefone.setColumns(10);
		try {
			edTelefone = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		edTelefone.setBounds(126, 198, 148, 20);
		contentPane.add(edTelefone);

		edGmail = new JTextField();
		edGmail.setColumns(10);
		edGmail.setBounds(126, 233, 222, 20);
		contentPane.add(edGmail);

		edData = new JTextField();
		edData.setColumns(10);
		try {
			edData = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		edData.setBounds(126, 86, 148, 20);
		contentPane.add(edData);

		JComboBox<String> cbSexo = new JComboBox();
		cbSexo.setBounds(126, 277, 148, 22);
		cbSexo.addItem("");
		cbSexo.addItem("Masculino");
		cbSexo.addItem("Feminino");
		contentPane.add(cbSexo);

		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
		btnFechar.setBounds(393, 227, 102, 23);
		contentPane.add(btnFechar);

		JButton btGravar = new JButton("Gravar");
		btGravar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String wNome 	 = edNome.getText();
				String wCpf 	 = edCpf.getText();
				String wCnh 	 = edCnh.getText();
				String wSexo 	 = cbSexo.getSelectedItem().toString();
				String wEmail 	 = edGmail.getText();
				String wTelefone = edTelefone.getText();
				String wDataTest = edData.getText();
				LocalDate wData  = LocalDate.parse(edData.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				
				Integer contValidacao = 0;
				
				MCliente Mc = new MCliente();
				
				

				if (wNome == null || wNome.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nome Invalido");
					dispose();
					
					setVisible(true);
				
				} else {
					contValidacao ++;
					Mc.setWNome(wNome);
				}

				if (wCpf == null || wCpf.isEmpty()) {
					JOptionPane.showMessageDialog(null, "CPF Invalido");
				} else {
					contValidacao ++;
					Mc.setwCpf(wCpf);
				}

				if (wCnh == null || wCnh.isEmpty()) {
					JOptionPane.showMessageDialog(null, "CNH Invalido");
				} else {
					contValidacao ++;
					Mc.setwCarteiraMotorista(wCnh);
				}
				
				if (wEmail == null || wEmail.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Email Invalido");
				} else {
					contValidacao ++;
					Mc.setwGmail(wEmail);
				}
				
				if (wTelefone == null || wTelefone.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Telefone Invalido");
				} else {
					contValidacao ++;
					Mc.setwNumeroTelefone(wTelefone);
				}
				
				if (wSexo == null || wSexo.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Sexo Invalido");
				} else {
					contValidacao ++;
					Mc.setwSexo(wSexo);
				}
				
				
				if (wDataTest == null || wDataTest.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Data Invalida");
				} else {
					contValidacao ++;
					Mc.setwDataNascimento(wData);
				}
				

				CClienteControl TableCliente = CClienteControl.getInstancia();
				Boolean insert = TableCliente.inserir(Mc);

				if (contValidacao == 7) {
					
					JOptionPane.showMessageDialog(null, "Dados confirmados");
					dispose();
				}

			}
		});
		btGravar.setBounds(393, 159, 102, 23);
		contentPane.add(btGravar);

		JButton btLimpar = new JButton("Limpar");
		btLimpar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				cbSexo.	   setSelectedItem("");
				edCpf. 	   setText("");
				edNome.	   setText("");
				edCnh. 	   setText("");
				edData.	   setText("");
				edGmail.   setText("");
				edTelefone.setText("");

			}
		});
		btLimpar.setBounds(393, 194, 102, 23);
		contentPane.add(btLimpar);

	}
}
