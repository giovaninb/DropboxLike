package control;

import model.Imagem;

public class ControleImagens {
	
	private Server servidor;
	private ControleJanelaPrincipal janelaControle;
	private Imagem imagem;
	
	public ControleImagens(Imagem img) {
		this.imagem = img;
	}

	
	public void enviarDados() {

	}
	
	public void mostrarDadosEnviados() {
		
	}
	
	public String retornaMensagem() {
		return servidor.sendMensagem();
		
	}
	

}
