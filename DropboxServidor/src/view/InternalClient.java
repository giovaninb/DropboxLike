package view;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

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
		getContentPane().setLayout(null);
		
		JLabel lblCliente = new JLabel("CLIENTE");
		lblCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblCliente.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		lblCliente.setBounds(155, 11, 100, 24);
		getContentPane().add(lblCliente);
		
		txtIP = new JTextField();
		txtIP.setEditable(false);
		txtIP.setBounds(61, 42, 153, 20);
		getContentPane().add(txtIP);
		txtIP.setColumns(10);
		
		JLabel lblIp = new JLabel("IP:");
		lblIp.setBounds(20, 45, 28, 14);
		getContentPane().add(lblIp);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setBounds(224, 45, 66, 14);
		getContentPane().add(lblQuantidade);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setEditable(false);
		txtQuantidade.setBounds(288, 42, 56, 20);
		getContentPane().add(txtQuantidade);
		txtQuantidade.setColumns(10);
		
		modelo = new DefaultListModel();
		listaCliente = new JList();
		scroll = new JScrollPane(listaCliente, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setSize(364, 334);
		scroll.setLocation(10, 75);
		getContentPane().add(scroll);

	}
}
