package control;

import model.Imagem;
import view.JanelaPrincipal;

public class ControleImagens {

	private Imagem imagem;
	private ClientSocket cliente;
	private JanelaPrincipal jan;
	
	public ControleImagens(Imagem img, ClientSocket client) {
		this.imagem = img;
		this.cliente = client;
		
		
	}

	
	public void enviarDados() {

	}
	
	public void mostrarDadosEnviados() {
		
	}

}
