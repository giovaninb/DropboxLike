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
import model.TransfereImagens;
import view.JanelaPrincipal;

public class ControleJanelaPrincipal implements ActionListener, KeyListener {
	
	private JanelaPrincipal jan;
	private BarraProgresso barraProgresso;
	private Cronometro cronometro;
	private TransfereImagens transfere;

	public ControleJanelaPrincipal(JanelaPrincipal jan) {
		this.jan = jan;
		registraListeners();
		
	}

	private void registraListeners() {
		this.jan.getBtnSelecionarArquivos().addActionListener(this);
		this.jan.getBtnEnviarArquivos().addActionListener(this);
		this.jan.getBtnAdicionarArquivos().addActionListener(this);
		this.jan.getBtnRemoverArquivos().addActionListener(this);
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
		if (e.getActionCommand().equalsIgnoreCase("Selecionar Arquivos")) {
			String imagens[];
			Path caminho = Paths.get(System.getProperty("user.dir"),"src"+File.separator+"images");
	        String path = caminho.toString();
			JFileChooser chooser = new JFileChooser(path);  //Cria uma instância do JFileChooser
			// TODO Referência: http://javafree.uol.com.br/artigo/877686/Visualizador-de-Imagens-com-JavaSwing+exemplo-JFileChooser.html
			chooser.setMultiSelectionEnabled(true); //Seleciona múltiplos arquivos: true
		    FileNameExtensionFilter filter = new FileNameExtensionFilter(
		    		"PNG & JPEG Images", "png", "jpeg");  //Cria um filtro
		    chooser.setFileFilter(filter);  //Altera o filtro do JFileChooser
		    int returnVal = chooser.showOpenDialog(jan.getParent()); //Abre o diálogo JFileChooser
		    if(returnVal == JFileChooser.APPROVE_OPTION) {  //Verifica se o usuário clicou no botão OK
		    	File selFile[] = chooser.getSelectedFiles();
		    	imagens = new String[selFile.length];  
		    	
		        for (int i = 0; i < selFile.length; i++) {  
		           imagens[i] = selFile[i].getName();
		           // Método para setar texto no JTextArea
		           //listSelecionadas.append((i+1)+") "+imagens[i]+"\n");
		           // TODO Referência: http://www.java2s.com/Code/Java/Swing-JFC/AnexampleofJListwithaDefaultListModel.htm
		           jan.getModel().addElement((i+1)+") "+imagens[i]+"\n");
		           // Para pegar o caminho absoluto
		           // absoluto[i] = selFile[i].getAbsolutePath();
		           System.out.println("Você selecionou este arquivo: " +imagens[i]); // Apresenta uma mensagem informando o nome dos arquivos selecionados
		        }  
		        jan.getTextFieldSelected().setText(String.valueOf(selFile.length)); 
			}
		} 
		if (e.getActionCommand().equalsIgnoreCase("Enviar Arquivos")) {
			cronometro = new Cronometro(jan.getLblCronometro());
			cronometro.start();
			barraProgresso = new BarraProgresso(jan.getProgressBar(), jan.getBtnEnviarArquivos(), cronometro);
			barraProgresso.start();
			// consumir elementos da lista 1, e produzir elementos na lista 2
			
			// setar texto nos campos de contagem
	        jan.getTextFieldSelected().setText(String.valueOf(jan.getModel().getSize())); 
			
		}
		if (e.getActionCommand().equalsIgnoreCase("Adicionar Arquivos")) {
			String imagens[];
			Path caminho = Paths.get(System.getProperty("user.dir"),"src"+File.separator+"images");
	        String path = caminho.toString();
			JFileChooser chooser = new JFileChooser(path);  //Cria uma instância do JFileChooser
			// TODO Referência: http://javafree.uol.com.br/artigo/877686/Visualizador-de-Imagens-com-JavaSwing+exemplo-JFileChooser.html
			chooser.setMultiSelectionEnabled(true); //Seleciona múltiplos arquivos: true
		    FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        "PNG & JPEG Images", "png", "jpeg");  //Cria um filtro
		    chooser.setFileFilter(filter);  //Altera o filtro do JFileChooser
		    int returnVal = chooser.showOpenDialog(jan.getParent()); //Abre o diálogo JFileChooser
		    if(returnVal == JFileChooser.APPROVE_OPTION) {  //Verifica se o usuário clicou no botão OK
		    	File selFile[] = chooser.getSelectedFiles();
		    	imagens = new String[selFile.length];  
		    	  
		        for (int i = 0; i < selFile.length; i++) {  
		           imagens[i] = selFile[i].getName();
		           // Método para setar texto no JTextArea
		           //listSelecionadas.append((i+1)+") "+imagens[i]+"\n");
		           // TODO Referência: http://www.java2s.com/Code/Java/Swing-JFC/AnexampleofJListwithaDefaultListModel.htm
		           jan.getModel2().insertElementAt((i+1)+") "+imagens[i]+"\n", jan.getModel2().getSize());
		           // Para pegar o caminho absoluto
		           // absoluto[i] = selFile[i].getAbsolutePath();
		           System.out.println("Você selecionou este arquivo: " +imagens[i]); // Apresenta uma mensagem informando o nome dos arquivos selecionados
		        }
		        jan.getTextFieldSended().setText(String.valueOf(selFile.length));
		    }
		}
		if (e.getActionCommand().equalsIgnoreCase("Remover Arquivos")) {
			try {
				if (jan.getModel2().getSize() > 0)
			          jan.getModel2().removeElementAt(0);
				 	  jan.getTextFieldSended().setText(String.valueOf(jan.getModel2().getSize()));
					  System.out.println("Você removeu esta imagem: "+jan.getModel2().get(0));	
			} catch (ArrayIndexOutOfBoundsException arg) {
				if (jan.getModel2().isEmpty()) {
					System.out.println("Lista Vazia! Não há o que remover.");
				}
			}
		}
	
		}

	}

