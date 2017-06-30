package control;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

import model.Imagem;
import view.JanelaPrincipal;

public class ClientSocket {
	
	JanelaPrincipal jan;
	//Declaro o ServerSocket
    ServerSocket servSocket = null; 
    //Declaro o Socket de comunica√ß√£o
    Socket socket = null;
    //Declaro o leitor para a entrada de dados
    DataInputStream input;
    DataOutputStream output;
    
    ObjectInputStream objectInputStream;
    ObjectOutputStream objectOutputStream;
    
    Imagem imagem;
    
    
    
    public ClientSocket(JanelaPrincipal jan) {
		
		this.jan = jan;
	}


	public void estabeleConexao() {
    	JOptionPane conectou = new JOptionPane();
    	
    	// TODO pegar a referencia do txField
//    	socket = new Socket(jan.getTxEndereco().toString(), 12345);
//    	while (jan.getTxEndereco().toString().isEmpty()) {
//    		Thread.holdsLock(socket);	
//		}
    	
    	try {
			socket = new Socket("localhost", 12345);
			conectou.showMessageDialog(jan, "Cliente conectou com sucesso!", "Conex„o Cliente", JOptionPane.INFORMATION_MESSAGE);
	    	jan.getBtnEnviarArquivos().setEnabled(true);
	    	
            
    	} catch(ConnectException e) {
			conectou.showMessageDialog(jan, "Cliente falhou ao se conectar.", "Conex„o Cliente", JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			conectou.showMessageDialog(jan, "Cliente falhou ao se conectar.", "Conex„o Cliente", JOptionPane.ERROR_MESSAGE);
		}    	    	
    }
    

	public byte[] serializarArquivo(){
        try {
                 ByteArrayOutputStream bao = new ByteArrayOutputStream();
                 objectOutputStream = new ObjectOutputStream(bao);
                 objectOutputStream.writeObject(imagem);
                 return bao.toByteArray();
        } catch (IOException e) {
                 e.printStackTrace();
        }
        return null;
	}
    
    

}
