package control;

import java.awt.EventQueue;

import model.Cronometro;
import model.Imagem;
import view.JanelaPrincipal;

public class ClientApp {
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						JanelaPrincipal frame = new JanelaPrincipal();
						frame.setVisible(true);
						Imagem img = new Imagem();
						ClientSocket cliente = new ClientSocket(frame);
						ControleImagens controleSocket = new ControleImagens(img, cliente);
						ControleJanelaPrincipal controleGUI = new ControleJanelaPrincipal(frame, cliente);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

	}


