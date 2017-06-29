package control;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import view.InternalClient;

public class Server extends Thread {

	private int contadorArquivosCliente;
	private int contadorArquivosServidor;
	private InternalClient internal;
	
	private ArrayList<PrintStream> clientes;
	
	//Declaro o ServerSocket
    ServerSocket servSocket = null; 
    //Declaro o Socket de comunicaÃ§Ã£o
    Socket socket = null;
    
    // Compara os valores entre cliete e servidor
    DataInputStream dataInputStream;
    DataOutputStream dataOutputStream;
    
    // Envia e recebe as listas dos clientes;
    ObjectInputStream objectInputStream;
    ObjectOutputStream objectOutputStream;
    
    
    public boolean aguardaClientes() {
    	
    	boolean conectou = false;
    	
    	try {
			servSocket = new ServerSocket(12345);
			System.out.println("Porta 12345 aberta!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	while (true) {
			try {
				socket = servSocket.accept();
				conectou = true;
				
				// Se conectou subir um JOptionPane informando pedido de conexão
				// Ok pressionado, abre JInternalFrame na área do JFrame
				System.out.print("Aguardando conexao do cliente...");
				System.out.println("Nova conexao com o cliente " + socket.getInetAddress().getHostAddress());
				
				// adiciona saida do cliente à lista
			    PrintStream ps = new PrintStream(socket.getOutputStream());
			    this.clientes.add(ps);
			       
			    // cria tratador de cliente numa nova thread
			    TrataClients tc = new TrataClients(socket.getInputStream(), this, this.internal);
			    new Thread(tc).start();
			       
				return conectou;
			} catch (IOException e) {
				System.out.println(e.getMessage()+" \n Algum problema ocorreu para criar ou receber o socket.");
			}
			
		}
    }
    
    public void recebeDados() {
    	
    }
	
	
	public String sendMensagem() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int comparaDados(int num1, int num2){
        int diferenca = 0;

		 try {
			dataInputStream = new DataInputStream(socket.getInputStream());
	        dataOutputStream = new DataOutputStream(socket.getOutputStream());
	        
			this.contadorArquivosCliente = num1;
			this.contadorArquivosServidor = num2;
			
			contadorArquivosCliente = Integer.parseInt(dataInputStream.readUTF());
			
			
			// se o numero entre cliente e servidor for maior no Cliente, significa que precisamos emitir uma mensagem de adição no Servidor
			if (contadorArquivosCliente > contadorArquivosServidor) {
				
			} // se o numero for maior no servidor, significa que o Cliente removeu arquivos, e precisamos mandar uma msg pro Servidor e atualizar a lista 
			else if (contadorArquivosCliente < contadorArquivosServidor) {
				
			} // se o numero ficar inalterado, tudo ok
			else {
				
			}
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return diferenca;

	}
	
	@Override
	public void run() {
		comparaDados(contadorArquivosCliente, contadorArquivosServidor);
	}

}
