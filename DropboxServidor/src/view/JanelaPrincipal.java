package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.SpringLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.LayoutManager;

public class JanelaPrincipal extends JFrame {

	private JDesktopPane contentPane;
	private int cont = 0;
	
	/*public static void main(String[] args) {
		JanelaPrincipal jp = new JanelaPrincipal();
		jp.setVisible(true);
	}*/
	
	/**
	 * Create the frame.
	 */
	public JanelaPrincipal() {
		BorderLayout borderLayout = (BorderLayout) getContentPane().getLayout();
		borderLayout.setVgap(5);
		borderLayout.setHgap(5);
		
		contentPane = new JDesktopPane();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(contentPane);
		contentPane.setLayout(new GridLayout(1, 3, 5, 5));
		
		String nomeAplicacao = "Server App";
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(900, 100, 945, 600);
		setTitle(nomeAplicacao);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		
		JMenuItem mntmConecta = new JMenuItem("Conecta Cliente");
		mntmConecta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// COLOCAR A INTERNAL FRAME AQUI
				//VOU DEIXAR COMENTADO QUALQUER COISA
				
				/*JPanel painelPrincipal = new JPanel();
				InternalClient ic = new InternalClient();
				ic.setVisible(true);
				ic.setBounds(cont, cont, 400, 400);
				cont = cont+50;
				contentPane.add(ic);
				ic.getContentPane().add(painelPrincipal);
			
				painelPrincipal.setVisible(true);
				validate();*/
			}
		});
		mnMenu.add(mntmConecta);
		
		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mntmSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Abrir alguma coisa sobre o Sobre");
			}
		});
		mnMenu.add(mntmSobre);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnMenu.add(mntmSair);
		
	}

}
