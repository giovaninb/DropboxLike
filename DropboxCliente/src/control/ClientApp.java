package control;

import java.awt.EventQueue;

import model.Cronometro;
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
						ClientSocket client = new ClientSocket(frame);
						ControleJanelaPrincipal controle = new ControleJanelaPrincipal(frame, client);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

	}


