package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.BarraProgresso;
import model.Cronometro;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Component;
import javax.swing.Box;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JProgressBar;
import java.awt.FlowLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class JanelaPrincipal extends JFrame {

	private JPanel painelCentral;
	
	private BarraProgresso barraProgresso;
	private JProgressBar progressBar;
	private JButton btnEnviarArquivos;
	private Cronometro cronometro;
	private JLabel lblCronometro;

	/**
	 * Create the frame.
	 */
	public JanelaPrincipal() {
		
		String nomeAplicacao = "Client App";
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setTitle(nomeAplicacao);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnMenu.add(mntmSair);
		painelCentral = new JPanel();
		painelCentral.setBorder(new EmptyBorder(5, 5, 5, 5));
		painelCentral.setLayout(new BorderLayout(0, 0));
		setContentPane(painelCentral);
		
		JPanel painelTopo = new JPanel();
		painelTopo.setBorder(new EmptyBorder(10, 10, 10, 10));
		painelCentral.add(painelTopo, BorderLayout.NORTH);
		painelTopo.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel title = new JLabel("Bem vindo ao Dropbox Like");
		title.setFont(new Font("Tahoma", Font.BOLD, 16));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		painelTopo.add(title);
		
		JPanel panelInterno = new JPanel();
		painelTopo.add(panelInterno);
		
		JLabel lblSelecioneSuasImagens = new JLabel("Selecione suas Imagens: ");
		panelInterno.add(lblSelecioneSuasImagens);
		
		JButton btnSelecionarArquivos = new JButton("Selecionar Arquivos");
		btnSelecionarArquivos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String imagens[];
				JFileChooser chooser = new JFileChooser();  //Cria uma instância do JFileChooser
				// TODO Referência: http://javafree.uol.com.br/artigo/877686/Visualizador-de-Imagens-com-JavaSwing+exemplo-JFileChooser.html
				chooser.setMultiSelectionEnabled(true); //Seleciona múltiplos arquivos: true
			    FileNameExtensionFilter filter = new FileNameExtensionFilter(
			        "JPG & GIF Images", "jpg", "gif");  //Cria um filtro
			    chooser.setFileFilter(filter);  //Altera o filtro do JFileChooser
			    int returnVal = chooser.showOpenDialog(getParent()); //Abre o diálogo JFileChooser
			    if(returnVal == JFileChooser.APPROVE_OPTION) {  //Verifica se o usuário clicou no botão OK
			    	File selFile[] = chooser.getSelectedFiles();
			    	imagens = new String[selFile.length];  
			    	  
			        for (int i = 0; i < selFile.length; i++) {  
			           imagens[i] = selFile[i].getName();
			           // Para pegar o caminho absoluto
			           // absoluto[i] = selFile[i].getAbsolutePath();
			           System.out.println("Você selecionou este arquivo: " +imagens[i]); // Apresenta uma mensagem informando o nome dos arquivos selecionados
			        }  
			         
//			    	System.out.println("Você selecionou este arquivo: " +
//			            chooser.getSelectedFile().getName());  //Apresenta uma mensagem informando o nome do arquivo/diretório selecionado
			        
			    }
			}
		});
		panelInterno.add(btnSelecionarArquivos);
		
		JPanel painelCentro = new JPanel();
		painelCentro.setBorder(new EmptyBorder(10, 10, 10, 10));
		painelCentral.add(painelCentro, BorderLayout.CENTER);
		painelCentro.setLayout(new GridLayout(1, 2, 5, 5));
		
		JPanel panelSelectedImages = new JPanel();
		painelCentro.add(panelSelectedImages);
		panelSelectedImages.setLayout(new BorderLayout(5, 5));
		
		JLabel lblTitleSelectedImages = new JLabel("Imagens Selecionadas");
		lblTitleSelectedImages.setHorizontalAlignment(SwingConstants.CENTER);
		panelSelectedImages.add(lblTitleSelectedImages, BorderLayout.NORTH);
		
		JTextArea textArea = new JTextArea();
		textArea.setTabSize(10);
		textArea.setEditable(false);
		panelSelectedImages.add(textArea, BorderLayout.CENTER);
		
		JPanel panelSendImages = new JPanel();
		painelCentro.add(panelSendImages);
		panelSendImages.setLayout(new BorderLayout(5, 5));
		
		JLabel lblTitleSendImages = new JLabel("Imagens Enviadas");
		lblTitleSendImages.setHorizontalAlignment(SwingConstants.CENTER);
		panelSendImages.add(lblTitleSendImages, BorderLayout.NORTH);
		
		JTextArea textArea2 = new JTextArea();
		panelSendImages.add(textArea2, BorderLayout.CENTER);
		textArea2.setTabSize(10);
		textArea2.setEditable(false);
		
		JPanel panelBaixo = new JPanel();
		painelCentral.add(panelBaixo, BorderLayout.SOUTH);
		panelBaixo.setLayout(new GridLayout(3, 2, 10, 10));
		
		progressBar = new JProgressBar();
		progressBar.setBackground(new Color(153, 255, 153));
		progressBar.setStringPainted(true);
		progressBar.setForeground(new Color(51, 204, 0));
		panelBaixo.add(progressBar);
		
		btnEnviarArquivos = new JButton("Enviar Arquivos");
		btnEnviarArquivos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cronometro = new Cronometro(lblCronometro);
				cronometro.start();
				barraProgresso = new BarraProgresso(progressBar, btnEnviarArquivos, cronometro);
				barraProgresso.start();
			
			}
		});
		panelBaixo.add(btnEnviarArquivos);
		
		lblCronometro = new JLabel("00:00:00");
		lblCronometro.setHorizontalAlignment(SwingConstants.CENTER);
		panelBaixo.add(lblCronometro);
		
		JButton btnRemoverArquivos = new JButton("Remover Arquivos");
		panelBaixo.add(btnRemoverArquivos);
	}
	


}
