package control;

import model.Imagem;

public class ControleImagens {

	private Imagem imagem;
	private ClientSocket cliente;
	
	public ControleImagens(Imagem img, ClientSocket client) {
		this.imagem = img;
		this.cliente = client;
	}

	
	public void enviarDados() {

	}
	
	public void mostrarDadosEnviados() {
		
	}

}
