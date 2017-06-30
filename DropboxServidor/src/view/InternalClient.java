package view;

import java.awt.EventQueue;


import javax.swing.DefaultListModel;
import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class InternalClient extends JInternalFrame {
	private JTextField txtIP;
	private JTextField txtQuantidade;
	private DefaultListModel modelo;
	private JList listaCliente;
	private JScrollPane scroll;

	/**
	 * Create the frame.
	 */
	public InternalClient() {
		setResizable(true);
		setClosable(true);
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		JPanel painelCentral = new JPanel();
		painelCentral.setBorder(new EmptyBorder(5, 5, 5, 5));
		painelCentral.setLayout(new BorderLayout(0, 0));
		getContentPane().add(painelCentral);
		
		JPanel painelTopo = new JPanel();
		painelTopo.setBorder(new EmptyBorder(10, 10, 10, 10));
		painelCentral.add(painelTopo, BorderLayout.NORTH);
		painelTopo.setLayout(new GridLayout(1, 1, 5, 5));

		
		JLabel lblCliente = new JLabel("CLIENTE");
		painelTopo.add(lblCliente);
		lblCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblCliente.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		
		JLabel lblIp = new JLabel("IP:");
		lblIp.setHorizontalAlignment(SwingConstants.CENTER);
		painelTopo.add(lblIp);
		
		txtIP = new JTextField();
		painelTopo.add(txtIP);
		txtIP.setEditable(false);
		txtIP.setColumns(10);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setHorizontalAlignment(SwingConstants.CENTER);
		painelTopo.add(lblQuantidade);
		
		txtQuantidade = new JTextField();
		painelTopo.add(txtQuantidade);
		txtQuantidade.setEditable(false);
		txtQuantidade.setColumns(10);
		
		JPanel painelCentro = new JPanel();
		painelCentro.setBorder(new EmptyBorder(10, 10, 10, 10));
		painelCentral.add(painelCentro, BorderLayout.CENTER);
		painelCentro.setLayout(new GridLayout(1, 2, 5, 5));
		
		modelo = new DefaultListModel();
		listaCliente = new JList();
		scroll = new JScrollPane(listaCliente, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		painelCentro.add(scroll);

	}

	public JTextField getTxtIP() {
		return txtIP;
	}

	public void setTxtIP(JTextField txtIP) {
		this.txtIP = txtIP;
	}

	public JTextField getTxtQuantidade() {
		return txtQuantidade;
	}

	public void setTxtQuantidade(JTextField txtQuantidade) {
		this.txtQuantidade = txtQuantidade;
	}
	
	
}
