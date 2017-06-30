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
import javax.swing.BoxLayout;

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
		getContentPane().setLayout(new BorderLayout(5, 5));
				
		JPanel painelTopo = new JPanel();
		getContentPane().add(painelTopo, BorderLayout.NORTH);
		painelTopo.setBorder(new EmptyBorder(10, 10, 10, 10));
		painelTopo.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 25));
					
			JLabel lblCliente = new JLabel("CLIENTE");
			painelTopo.add(lblCliente);
			lblCliente.setHorizontalAlignment(SwingConstants.CENTER);
			lblCliente.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		
		JPanel painelCentro = new JPanel();
		getContentPane().add(painelCentro, BorderLayout.CENTER);
		painelCentro.setBorder(new EmptyBorder(10, 10, 10, 10));
		painelCentro.setLayout(new GridLayout(0, 1, 0, 0));
		modelo = new DefaultListModel();
		listaCliente = new JList(modelo);
		scroll = new JScrollPane(listaCliente, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		painelCentro.add(scroll, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		panel_1.add(lblQuantidade);
		lblQuantidade.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtQuantidade = new JTextField();
		panel_1.add(txtQuantidade);
		txtQuantidade.setEditable(false);
		txtQuantidade.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JLabel lblIp = new JLabel("IP:");
		panel_2.add(lblIp);
		lblIp.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtIP = new JTextField();
		panel_2.add(txtIP);
		txtIP.setEditable(false);
		txtIP.setColumns(10);		

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

	public DefaultListModel getModelo() {
		return modelo;
	}

	public void setModelo(DefaultListModel modelo) {
		this.modelo = modelo;
	}

	public JList getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(JList listaCliente) {
		this.listaCliente = listaCliente;
	}
	
	
	
	
}
