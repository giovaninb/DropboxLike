package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JProgressBar;
import java.awt.FlowLayout;

public class JanelaPrincipal extends JFrame {

	private JPanel painelCentral;

	/**
	 * Create the frame.
	 */
	public JanelaPrincipal() {
		
		String nomeAplicacao = "Client App";
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle(nomeAplicacao);
		painelCentral = new JPanel();
		painelCentral.setBorder(new EmptyBorder(5, 5, 5, 5));
		painelCentral.setLayout(new BorderLayout(0, 0));
		setContentPane(painelCentral);
		
		JPanel painelTopo = new JPanel();
		painelTopo.setBorder(new EmptyBorder(10, 10, 10, 10));
		painelCentral.add(painelTopo, BorderLayout.NORTH);
		painelTopo.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel title = new JLabel("Bem vindo ao Dropbox Like");
		title.setFont(new Font("Tahoma", Font.PLAIN, 16));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		painelTopo.add(title);
		
		JPanel panelInterno = new JPanel();
		painelTopo.add(panelInterno);
		
		JLabel lblSelecioneSuasImagens = new JLabel("Selecione suas Imagens: ");
		panelInterno.add(lblSelecioneSuasImagens);
		
		JButton btnSelecionarArquivos = new JButton("Selecionar Arquivos");
		panelInterno.add(btnSelecionarArquivos);
		
		JPanel painelCentro = new JPanel();
		painelCentro.setBorder(new EmptyBorder(10, 10, 10, 10));
		painelCentral.add(painelCentro, BorderLayout.CENTER);
		painelCentro.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panelSelectedImages = new JPanel();
		painelCentro.add(panelSelectedImages);
		panelSelectedImages.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitleSelectedImages = new JLabel("Imagens Selecionadas");
		panelSelectedImages.add(lblTitleSelectedImages, BorderLayout.NORTH);
		
		JTextArea textArea = new JTextArea();
		panelSelectedImages.add(textArea, BorderLayout.CENTER);
		
//		JPanel panelSendImages = new JPanel();
//		painelCentro.add(panelSendImages);
//		panelSendImages.setLayout(new BorderLayout(0, 0));
//		
//		JLabel lblTitleSendImages = new JLabel("Imagens Enviadas");
//		panelSendImages.add(lblTitleSendImages);
		
	}

}
