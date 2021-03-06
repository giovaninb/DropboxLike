package control;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.BarraProgresso;
import model.Cronometro;
import model.Imagem;
import view.JanelaPrincipal;

public class ControleJanelaPrincipal implements ActionListener, KeyListener {
	
	private JanelaPrincipal jan;
	private BarraProgresso barraProgresso;
	private Cronometro cronometro;
	private Imagem imagem;
	private ClientSocket cliente;

	public ControleJanelaPrincipal(JanelaPrincipal jan, ClientSocket client) {
		this.jan = jan;
		this.cliente = client;
		registraListeners();
	}

	private void registraListeners() {
		this.jan.getBtnSelecionarArquivos().addActionListener(this);
		this.jan.getBtnEnviarArquivos().addActionListener(this);
		this.jan.getBtnAdicionarArquivos().addActionListener(this);
		this.jan.getBtnRemoverArquivos().addActionListener(this);
		this.jan.getBtnConectar().addActionListener(this);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("Conectar")) {
			cliente.estabeleConexao();
		}
		if (e.getActionCommand().equalsIgnoreCase("Selecionar Arquivos")) {
			String imagens[];
			Path caminho = Paths.get(System.getProperty("user.dir"),"src"+File.separator+"images");
	        String path = caminho.toString();
			JFileChooser chooser = new JFileChooser(path);  //Cria uma inst�ncia do JFileChooser
			
			chooser.setMultiSelectionEnabled(true); //Seleciona m�ltiplos arquivos: true
		    FileNameExtensionFilter filter = new FileNameExtensionFilter(
		    		"BMP & JPG Images", "bmp", "jpg");  //Cria um filtro
		    chooser.setFileFilter(filter);  //Altera o filtro do JFileChooser
		    int returnVal = chooser.showOpenDialog(jan); //Abre o di�logo JFileChooser
		    if(returnVal == JFileChooser.APPROVE_OPTION) {  //Verifica se o usu�rio clicou no bot�o OK
		    	File selFile[] = chooser.getSelectedFiles();
		    	imagens = new String[selFile.length];  
		    	
		        for (int i = 0; i < selFile.length; i++) {  
		           imagens[i] = selFile[i].getName();
		           imagem = new Imagem();
		           imagem.setNome(imagens[i]);
		           System.out.println("Imagem: "+imagem.getNome().toString());
		           // M�todo para setar texto no JTextArea
		           //listSelecionadas.append((i+1)+") "+imagens[i]+"\n");
		          
		           jan.getModel().addElement((i+1)+") "+imagens[i]+"\n");
		           // Para pegar o caminho absoluto
		           // absoluto[i] = selFile[i].getAbsolutePath();
		           //System.out.println("Voc� selecionou este arquivo: " +imagens[i]); // Apresenta uma mensagem informando o nome dos arquivos selecionados
		        }  
		        jan.getTextFieldSelected().setText(String.valueOf(selFile.length)); 
			}
		} 
		if (e.getActionCommand().equalsIgnoreCase("Enviar Arquivos")) {
			cronometro = new Cronometro(jan.getLblCronometro());
			cronometro.start();
			barraProgresso = new BarraProgresso(jan.getProgressBar(), jan.getBtnEnviarArquivos(), cronometro);
			barraProgresso.start();
			cliente.serializarArquivo();
			// setar texto nos campos de contagem
	        jan.getTextFieldSelected().setText(String.valueOf(jan.getModel().getSize())); 
			
		}
		if (e.getActionCommand().equalsIgnoreCase("Adicionar Arquivos")) {
			String imagens[];
			Path caminho = Paths.get(System.getProperty("user.dir"),"src"+File.separator+"images");
	        String path = caminho.toString();
			JFileChooser chooser = new JFileChooser(path);  //Cria uma inst�ncia do JFileChooser
			chooser.setMultiSelectionEnabled(true); //Seleciona m�ltiplos arquivos: true
		    FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        "PNG & JPEG Images", "png", "jpeg");  //Cria um filtro
		    chooser.setFileFilter(filter);  //Altera o filtro do JFileChooser
		    int returnVal = chooser.showOpenDialog(jan); //Abre o di�logo JFileChooser
		    if(returnVal == JFileChooser.APPROVE_OPTION) {  //Verifica se o usu�rio clicou no bot�o OK
		    	File selFile[] = chooser.getSelectedFiles();
		    	imagens = new String[selFile.length];  
		    	  
		        for (int i = 0; i < selFile.length; i++) {  
		           imagens[i] = selFile[i].getName();
		           // M�todo para setar texto no JTextArea
		           //listSelecionadas.append((i+1)+") "+imagens[i]+"\n");
		           jan.getModel2().insertElementAt((jan.getModel2().getSize()+1)+") "+imagens[i]+"\n", jan.getModel2().getSize());
		           // Para pegar o caminho absoluto
		           // absoluto[i] = selFile[i].getAbsolutePath();
		           System.out.println("Voc� selecionou este arquivo: " +imagens[i]); // Apresenta uma mensagem informando o nome dos arquivos selecionados
		        }
		        jan.getTextFieldSelected().setText(String.valueOf(jan.getModel2().getSize()));
		        jan.getBtnAdicionarArquivos().setEnabled(true);
		        jan.getBtnRemoverArquivos().setEnabled(true);
		    }
		}
		if (e.getActionCommand().equalsIgnoreCase("Remover Arquivos")) {
			try {
				if (jan.getModel2().getSize() > 0)
			          jan.getModel2().removeElementAt(0);
				 	  jan.getTextFieldSelected().setText(String.valueOf(jan.getModel2().getSize()));
					  System.out.println("Voc� removeu esta imagem: "+jan.getModel2().get(0));	
			} catch (ArrayIndexOutOfBoundsException arg) {
				if (jan.getModel2().isEmpty()) {
					System.out.println("Lista Vazia! N�o h� o que remover.");
				}
			}
		}
	
		}

	}

