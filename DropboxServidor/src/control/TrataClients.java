package control;

import java.io.DataInputStream;
import java.io.InputStream;

import javax.swing.JInternalFrame;

import view.JanelaPrincipal;

public class TrataClients implements Runnable {

	private JanelaPrincipal jan;
	private InputStream cliente;
	private Server servidor;
	private JInternalFrame internalFrame;
	
	
	public TrataClients(InputStream cliente, Server servidor, JInternalFrame interna) {
		this.cliente = cliente;
		this.servidor = servidor;
		this.internalFrame = interna;
		this.jan = jan;
	}

	@Override
	public void run() {
		internalFrame = new JInternalFrame();
		jan.getContentPane().add(internalFrame);
		
	}

}
