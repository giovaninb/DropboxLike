package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.SpringLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JInternalFrame;

public class JanelaPrincipal extends JFrame {

	private JPanel painelCentral;

	/**
	 * Create the frame.
	 */
	public JanelaPrincipal() {
		String nomeAplicacao = "Server App";
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(900, 100, 945, 600);
		setTitle(nomeAplicacao);
		painelCentral = new JPanel();
		painelCentral.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelCentral);
		painelCentral.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JInternalFrame internalFrame = new JInternalFrame("Client #");
		painelCentral.add(internalFrame);
		internalFrame.setVisible(true);
	}

}
