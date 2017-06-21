package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.BarraProgresso;
import model.Cronometro;
import model.Imagem;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Component;
import javax.swing.Box;
import javax.swing.DefaultListModel;

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
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.JTextPane;
import javax.swing.JTextField;

public class JanelaPrincipal extends JFrame {

	private JPanel painelCentral;
	
	
	private JScrollPane scroll;
	private JScrollPane scroll2;
	private DefaultListModel model;
	private DefaultListModel model2;
	private JList listSelecionadas;
	private JList listEnviados;
	private JTextField textFieldSelected;
	private JTextField textFieldSended;
	
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
			    		"PNG & JPEG Images", "png", "jpeg");  //Cria um filtro
			    chooser.setFileFilter(filter);  //Altera o filtro do JFileChooser
			    int returnVal = chooser.showOpenDialog(getParent()); //Abre o diálogo JFileChooser
			    if(returnVal == JFileChooser.APPROVE_OPTION) {  //Verifica se o usuário clicou no botão OK
			    	File selFile[] = chooser.getSelectedFiles();
			    	imagens = new String[selFile.length];  
			    	
			        for (int i = 0; i < selFile.length; i++) {  
			           imagens[i] = selFile[i].getName();
			           // Método para setar texto no JTextArea
			           //listSelecionadas.append((i+1)+") "+imagens[i]+"\n");
			           // TODO Referência: http://www.java2s.com/Code/Java/Swing-JFC/AnexampleofJListwithaDefaultListModel.htm
			           model.addElement((i+1)+") "+imagens[i]+"\n");
			           // Para pegar o caminho absoluto
			           // absoluto[i] = selFile[i].getAbsolutePath();
			           System.out.println("Você selecionou este arquivo: " +imagens[i]); // Apresenta uma mensagem informando o nome dos arquivos selecionados
			        }  
			        textFieldSelected.setText(String.valueOf(selFile.length)); 
			         
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
		
		JPanel panelContSelected = new JPanel();
		panelSelectedImages.add(panelContSelected, BorderLayout.NORTH);
		panelContSelected.setLayout(new GridLayout(1, 2, 5, 5));
		
		JLabel lblTitleSelectedImages = new JLabel("Imagens Selecionadas:");
		panelContSelected.add(lblTitleSelectedImages);
		lblTitleSelectedImages.setHorizontalAlignment(SwingConstants.CENTER);
		
		textFieldSelected = new JTextField();
		textFieldSelected.setEditable(false);
		textFieldSelected.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldSelected.setColumns(5);
		panelContSelected.add(textFieldSelected);
		
		model = new DefaultListModel();
		listSelecionadas = new JList(model);
		scroll = new JScrollPane (listSelecionadas, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBorder(new EmptyBorder(10, 10, 10, 10));
		panelSelectedImages.add(scroll, BorderLayout.CENTER);
		
		JPanel panelSendImages = new JPanel();
		painelCentro.add(panelSendImages);
		panelSendImages.setLayout(new BorderLayout(5, 5));
		
		JPanel panelContSend = new JPanel();
		panelSendImages.add(panelContSend, BorderLayout.NORTH);
		panelContSend.setLayout(new GridLayout(1, 2, 5, 5));
		
		JLabel lblTitleSendImages = new JLabel("Imagens Enviadas");
		panelContSend.add(lblTitleSendImages);
		lblTitleSendImages.setHorizontalAlignment(SwingConstants.CENTER);
		
		textFieldSended = new JTextField();
		textFieldSended.setEditable(false);
		textFieldSended.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldSended.setColumns(5);		
		panelContSend.add(textFieldSended);
		
		model2 = new DefaultListModel();
		listEnviados = new JList(model2);
		scroll2 = new JScrollPane (listEnviados, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll2.setBorder(new EmptyBorder(10, 10, 10, 10));
		panelSendImages.add(scroll2, BorderLayout.CENTER);
		
		JPanel panelBaixo = new JPanel();
		painelCentral.add(panelBaixo, BorderLayout.SOUTH);
		panelBaixo.setLayout(new GridLayout(0, 1, 10, 10));
		
		JPanel panelBarraCronometro = new JPanel();
		panelBaixo.add(panelBarraCronometro);
		panelBarraCronometro.setLayout(new BoxLayout(panelBarraCronometro, BoxLayout.X_AXIS));
		
		progressBar = new JProgressBar();
		panelBarraCronometro.add(progressBar);
		progressBar.setBackground(new Color(153, 255, 153));
		progressBar.setStringPainted(true);
		progressBar.setForeground(new Color(51, 204, 0));
		
		lblCronometro = new JLabel("00:00:00");
		lblCronometro.setBorder(new EmptyBorder(10, 10,10, 10));
		panelBarraCronometro.add(lblCronometro);
		lblCronometro.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panelAddRemArq = new JPanel();
		panelBaixo.add(panelAddRemArq);
		
		btnEnviarArquivos = new JButton("Enviar Arquivos");
		panelAddRemArq.add(btnEnviarArquivos);
		btnEnviarArquivos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cronometro = new Cronometro(lblCronometro);
				cronometro.start();
				barraProgresso = new BarraProgresso(progressBar, btnEnviarArquivos, cronometro);
				barraProgresso.start();
				// consumir elementos da lista 1, e produzir elementos na lista 2
				
				// setar texto nos campos de contagem
		        textFieldSelected.setText(String.valueOf(model.getSize())); 
		        

			
			}
		});
		
		// TODO Deixar desativado até Enviar para o Servidor
		// TODO setEnable(false) no SelecionarArquivos depois de enviado
		JButton btnAdicionarArquivos = new JButton("Adicionar Arquivos");
		btnAdicionarArquivos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String imagens[];
				JFileChooser chooser = new JFileChooser();  //Cria uma instância do JFileChooser
				// TODO Referência: http://javafree.uol.com.br/artigo/877686/Visualizador-de-Imagens-com-JavaSwing+exemplo-JFileChooser.html
				chooser.setMultiSelectionEnabled(true); //Seleciona múltiplos arquivos: true
			    FileNameExtensionFilter filter = new FileNameExtensionFilter(
			        "PNG & JPEG Images", "png", "jpeg");  //Cria um filtro
			    chooser.setFileFilter(filter);  //Altera o filtro do JFileChooser
			    int returnVal = chooser.showOpenDialog(getParent()); //Abre o diálogo JFileChooser
			    if(returnVal == JFileChooser.APPROVE_OPTION) {  //Verifica se o usuário clicou no botão OK
			    	File selFile[] = chooser.getSelectedFiles();
			    	imagens = new String[selFile.length];  
			    	  
			        for (int i = 0; i < selFile.length; i++) {  
			           imagens[i] = selFile[i].getName();
			           // Método para setar texto no JTextArea
			           //listSelecionadas.append((i+1)+") "+imagens[i]+"\n");
			           // TODO Referência: http://www.java2s.com/Code/Java/Swing-JFC/AnexampleofJListwithaDefaultListModel.htm
			           model2.insertElementAt((i+1)+") "+imagens[i]+"\n", model2.getSize());
			           // Para pegar o caminho absoluto
			           // absoluto[i] = selFile[i].getAbsolutePath();
			           System.out.println("Você selecionou este arquivo: " +imagens[i]); // Apresenta uma mensagem informando o nome dos arquivos selecionados
			        }
			        textFieldSended.setText(String.valueOf(selFile.length));
			         
//			    	System.out.println("Você selecionou este arquivo: " +
//			            chooser.getSelectedFile().getName());  //Apresenta uma mensagem informando o nome do arquivo/diretório selecionado
			        
			    }
			}
		});
		panelAddRemArq.add(btnAdicionarArquivos);
		
		JButton btnRemoverArquivos = new JButton("Remover Arquivos");
		btnRemoverArquivos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (model2.getSize() > 0)
				          model2.removeElementAt(0);
					 	  textFieldSended.setText(String.valueOf(model2.getSize()));
						  System.out.println("Você removeu esta imagem: "+model2.get(0));	
				} catch (ArrayIndexOutOfBoundsException e) {
					if (model2.isEmpty()) {
						System.out.println("Lista Vazia! Não há o que remover.");
					}
				}
			}
		});
		panelAddRemArq.add(btnRemoverArquivos);
	}
	
	


}
