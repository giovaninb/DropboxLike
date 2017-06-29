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
import java.nio.file.Path;
import java.nio.file.Paths;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.JTextPane;
import javax.swing.JTextField;

public class JanelaPrincipal extends JFrame {

	private JPanel painelCentral;
	private JButton btnSelecionarArquivos;	
	private JScrollPane scroll;
	private DefaultListModel model;
	private DefaultListModel model2;
	private JList listSelecionadas;
	private JTextField textFieldSelected;
	
	private JProgressBar progressBar;
	private JButton btnEnviarArquivos;
	private JLabel lblCronometro;
	private JButton btnAdicionarArquivos;
	private JButton btnRemoverArquivos;
	
	private JTextField txEndereco;
	private JButton btnConectar;

	/**
	 * Create the frame.
	 */
	public JanelaPrincipal() {
		
		String nomeAplicacao = "Client App";
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 650);
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
		
		JPanel panelConecta = new JPanel();
		painelTopo.add(panelConecta);
		
		JLabel lblIp = new JLabel("IP :");
		panelConecta.add(lblIp);
		
		txEndereco = new JTextField();
		panelConecta.add(txEndereco);
		txEndereco.setColumns(10);
		
		btnConectar = new JButton("Conectar");
		panelConecta.add(btnConectar);
		
		JPanel panelInterno = new JPanel();
		painelTopo.add(panelInterno);
		
		JLabel lblSelecioneSuasImagens = new JLabel("Selecione suas Imagens: ");
		panelInterno.add(lblSelecioneSuasImagens);
		
		btnSelecionarArquivos = new JButton("Selecionar Arquivos");
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
		
		model2 = new DefaultListModel();
		
		JPanel painelBaixo = new JPanel();
		painelCentral.add(painelBaixo, BorderLayout.SOUTH);
		painelBaixo.setLayout(new GridLayout(0, 1, 10, 10));
		
		JPanel panelBarraCronometro = new JPanel();
		painelBaixo.add(panelBarraCronometro);
		panelBarraCronometro.setLayout(new BoxLayout(panelBarraCronometro, BoxLayout.X_AXIS));
		
		JLabel labelEspaco = new JLabel("");
		labelEspaco.setHorizontalAlignment(SwingConstants.CENTER);
		labelEspaco.setBorder(new EmptyBorder(10, 10,10, 10));
		panelBarraCronometro.add(labelEspaco);
		
		progressBar = new JProgressBar();
		panelBarraCronometro.add(progressBar);
		progressBar.setBackground(new Color(153, 255, 153));
		progressBar.setStringPainted(true);
		progressBar.setForeground(new Color(51, 204, 0));
		
		lblCronometro = new JLabel("00:00");
		lblCronometro.setBorder(new EmptyBorder(10, 10,10, 10));
		panelBarraCronometro.add(lblCronometro);
		lblCronometro.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panelAddRemArq = new JPanel();
		painelBaixo.add(panelAddRemArq);
		
		btnEnviarArquivos = new JButton("Enviar Arquivos");
		btnEnviarArquivos.setEnabled(false);
		panelAddRemArq.add(btnEnviarArquivos);
//		btnEnviarArquivos.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				cronometro = new Cronometro(lblCronometro);
//				cronometro.start();
//				barraProgresso = new BarraProgresso(progressBar, btnEnviarArquivos, cronometro);
//				barraProgresso.start();
//				// consumir elementos da lista 1, e produzir elementos na lista 2
//				
//				// setar texto nos campos de contagem
//		        textFieldSelected.setText(String.valueOf(model.getSize())); 
//		        
//
//			
//			}
//		});
		
		// TODO Deixar desativado até Enviar para o Servidor
		// TODO setEnable(false) no SelecionarArquivos depois de enviado
		btnAdicionarArquivos = new JButton("Adicionar Arquivos");
		btnAdicionarArquivos.setEnabled(false);
		panelAddRemArq.add(btnAdicionarArquivos);
		
		btnRemoverArquivos = new JButton("Remover Arquivos");
		btnRemoverArquivos.setEnabled(false);
		panelAddRemArq.add(btnRemoverArquivos);
	}

	
	
	public JTextField getTxEndereco() {
		return txEndereco;
	}



	public void setTxEndereco(JTextField txEndereco) {
		this.txEndereco = txEndereco;
	}



	public JButton getBtnConectar() {
		return btnConectar;
	}



	public void setBtnConectar(JButton btnConectar) {
		this.btnConectar = btnConectar;
	}



	public JPanel getPainelCentral() {
		return painelCentral;
	}

	public void setPainelCentral(JPanel painelCentral) {
		this.painelCentral = painelCentral;
	}

	public JButton getBtnSelecionarArquivos() {
		return btnSelecionarArquivos;
	}

	public void setBtnSelecionarArquivos(JButton btnSelecionarArquivos) {
		this.btnSelecionarArquivos = btnSelecionarArquivos;
	}

	public JScrollPane getScroll() {
		return scroll;
	}

	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}

	public DefaultListModel getModel() {
		return model;
	}

	public void setModel(DefaultListModel model) {
		this.model = model;
	}

	public DefaultListModel getModel2() {
		return model2;
	}

	public void setModel2(DefaultListModel model2) {
		this.model2 = model2;
	}

	public JList getListSelecionadas() {
		return listSelecionadas;
	}

	public void setListSelecionadas(JList listSelecionadas) {
		this.listSelecionadas = listSelecionadas;
	}

	public JTextField getTextFieldSelected() {
		return textFieldSelected;
	}

	public void setTextFieldSelected(JTextField textFieldSelected) {
		this.textFieldSelected = textFieldSelected;
	}

	public JProgressBar getProgressBar() {
		return progressBar;
	}

	public void setProgressBar(JProgressBar progressBar) {
		this.progressBar = progressBar;
	}

	public JButton getBtnEnviarArquivos() {
		return btnEnviarArquivos;
	}

	public void setBtnEnviarArquivos(JButton btnEnviarArquivos) {
		this.btnEnviarArquivos = btnEnviarArquivos;
	}

	public JLabel getLblCronometro() {
		return lblCronometro;
	}

	public void setLblCronometro(JLabel lblCronometro) {
		this.lblCronometro = lblCronometro;
	}

	public JButton getBtnAdicionarArquivos() {
		return btnAdicionarArquivos;
	}

	public void setBtnAdicionarArquivos(JButton btnAdicionarArquivos) {
		this.btnAdicionarArquivos = btnAdicionarArquivos;
	}

	public JButton getBtnRemoverArquivos() {
		return btnRemoverArquivos;
	}

	public void setBtnRemoverArquivos(JButton btnRemoverArquivos) {
		this.btnRemoverArquivos = btnRemoverArquivos;
	}
	
	
	

}
