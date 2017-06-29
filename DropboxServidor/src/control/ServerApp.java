package control;

import java.awt.EventQueue;

import model.Imagem;
import view.JanelaPrincipal;

public class ServerApp {
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaPrincipal frame = new JanelaPrincipal();
					Imagem img = new Imagem();
					ControleImagens controle = new ControleImagens(img, frame);
					controle.aguardarClientes();
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
