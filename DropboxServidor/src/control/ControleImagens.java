package control;

import model.Imagem;
import view.JanelaPrincipal;

public class ControleImagens extends Thread {
	
	private Server servidor;
	private Imagem imagem;
	private JanelaPrincipal jan;
	
	public ControleImagens(Imagem img, JanelaPrincipal jan) {
		this.imagem = img;
		this.jan = jan;
		servidor = new Server();
	}
	
	public void aguardarClientes() {
		servidor.aguardaClientes();
	}
	
	public void receberDados() {
		servidor.recebeDados();
	}
	
	public void mostrarDadosEnviados() {
		
	}
	
	public String retornaMensagem() {
		return servidor.sendMensagem();
		
	}
	

}
