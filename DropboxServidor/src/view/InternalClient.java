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
import net.miginfocom.swing.MigLayout;

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
		getContentPane().setLayout(new MigLayout("", "[38px][13px][153px][10px][31px][33px][86px]", "[24px][20px][334px]"));
		
		JLabel lblCliente = new JLabel("CLIENTE");
		lblCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblCliente.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		getContentPane().add(lblCliente, "cell 2 0 4 1,growx,aligny top");
		
		txtIP = new JTextField();
		txtIP.setEditable(false);
		getContentPane().add(txtIP, "cell 1 1 2 1,growx,aligny top");
		txtIP.setColumns(10);
		
		JLabel lblIp = new JLabel("IP:");
		getContentPane().add(lblIp, "cell 0 1,growx,aligny center");
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		getContentPane().add(lblQuantidade, "cell 4 1 2 1,alignx left,aligny center");
		
		txtQuantidade = new JTextField();
		txtQuantidade.setEditable(false);
		getContentPane().add(txtQuantidade, "cell 6 1,alignx left,aligny top");
		txtQuantidade.setColumns(10);
		
		modelo = new DefaultListModel();
		listaCliente = new JList();
		scroll = new JScrollPane(listaCliente, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		getContentPane().add(scroll, "cell 0 2 7 1,grow");

	}
}
