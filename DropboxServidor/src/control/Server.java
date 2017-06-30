package control;

import java.awt.Image;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import model.Imagem;
import view.InternalClient;
import view.JanelaPrincipal;

public class Server extends Thread {

	private int contadorArquivosCliente;
	private int contadorArquivosServidor;

	private DefaultListModel<Imagem> listaImagens;
	private String ipCliente;
	private JanelaPrincipal jan;
	private int conectou = 0;

	// Declaro o ServerSocket
	ServerSocket servSocket = null;
	// Declaro o Socket de comunicaÃ§Ã£o
	Socket socket = null;

	// Compara os valores entre cliete e servidor
	DataInputStream dataInputStream;
	DataOutputStream dataOutputStream;

	// Envia e recebe as listas dos clientes;
	ObjectInputStream objectInputStream;
	ObjectOutputStream objectOutputStream;

	public void estabeleConexoes() throws BindException {
		try {
			servSocket = new ServerSocket(12345);
			System.out.println("Porta 12345 aberta!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int aguardaClientes() {
		try {
			socket = servSocket.accept();
			this.conectou++;
			// Se conectou subir um JOptionPane informando pedido de conexão
			// Ok pressionado, abre JInternalFrame na área do JFrame
			System.out.print("Aguardando conexao do cliente...");
			ipCliente = socket.getInetAddress().getHostAddress();
			System.out.println("Nova conexao com o cliente " + ipCliente);

		} catch (IOException e) {
			System.out.println(e.getMessage() + " \n Algum problema ocorreu para criar ou receber o socket.");
		}
		System.out.println("Cliente " + conectou + " conectou!");
		return conectou;

	}

	public void recebeDados() {
		try {
			objectInputStream = new ObjectInputStream(socket.getInputStream());
			System.out.println("Lista recebida com sucesso!");
			// Número de arquivos Cliente
			dataInputStream = new DataInputStream(socket.getInputStream());
			contadorArquivosCliente = Integer.parseInt(dataInputStream.readUTF());
			listaImagens = new DefaultListModel<>();
			for (int i = 0; i < listaImagens.size(); i++) {
				String s;
				try {
					s = objectInputStream.readObject().toString();
					Imagem img = new Imagem(listaImagens.indexOf(s), s);
					listaImagens.addElement(img);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String sendMensagem() {
		// TODO Auto-generated method stub
		return null;
	}

	public Thread comparaDados(int num1, int num2) {
		int diferenca = 0;
		JOptionPane modificados = new JOptionPane();
		try {
			dataInputStream = new DataInputStream(socket.getInputStream());
			dataOutputStream = new DataOutputStream(socket.getOutputStream());

			this.contadorArquivosCliente = num1;
			this.contadorArquivosServidor = num2;

			contadorArquivosCliente = Integer.parseInt(dataInputStream.readUTF());

			diferenca = contadorArquivosServidor - contadorArquivosCliente;
			// se o numero entre cliente e servidor for maior no Cliente,
			// significa que precisamos emitir uma mensagem de adição no
			// Servidor
			if (contadorArquivosCliente > contadorArquivosServidor) {
				 modificados.showMessageDialog(jan, "Cliente removeu "+diferenca+" com sucesso!", "Arquivos Modificados", JOptionPane.INFORMATION_MESSAGE);
			} // se o numero for maior no servidor, significa que o Cliente
				// removeu arquivos, e precisamos mandar uma msg pro Servidor e
				// atualizar a lista
			else if(contadorArquivosCliente < contadorArquivosServidor) {
				 modificados.showMessageDialog(jan, "Cliente adicionou "+diferenca+" com sucesso!", "Arquivos Modificados", JOptionPane.INFORMATION_MESSAGE);
			} // se o numero ficar inalterado, tudo ok
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public void run() {
		try {
			estabeleConexoes();
		} catch (BindException e) {
			JOptionPane ocupado = new JOptionPane();
			ocupado.showMessageDialog(jan, "Endereço já está em uso!", "Endereço Ocupado", JOptionPane.ERROR_MESSAGE);
		}
		aguardaClientes();
		
		Thread t = comparaDados(contadorArquivosCliente, contadorArquivosServidor);
	}

	public DefaultListModel<Imagem> getListaImagens() {
		return listaImagens;
	}

	public void setListaImagens(DefaultListModel<Imagem> listaImagens) {
		this.listaImagens = listaImagens;
	}

	public String getIpCliente() {
		return ipCliente;
	}

	public void setIpCliente(String ipCliente) {
		this.ipCliente = ipCliente;
	}

	public int getConectou() {
		return conectou;
	}

	public void setConectou(int conectou) {
		this.conectou = conectou;
	}

}
