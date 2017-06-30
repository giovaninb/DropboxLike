package control;

import model.Imagem;
import view.InternalClient;
import view.JanelaPrincipal;

public class ControleImagens extends Thread {
	
	private Server servidor;
	private Imagem imagem;
	private JanelaPrincipal jan;
	private InternalClient internal;
	private int cont = 0;

	
	public ControleImagens(Imagem img, JanelaPrincipal jan) {
		this.imagem = img;
		this.jan = jan;
		
		//cria uma thread que envia a conexao
		Thread t = new Server();
		//inicia a thread t
		t.start();
	}
	
	public void aguardarClientes() {
		internal = new InternalClient();
		internal.setVisible(true);
		internal.getTxtIP().setText(servidor.getIpCliente());
		jan.getContentPane().add(internal);
		
		
	}
	
	public void receberDados() {
		servidor.recebeDados();
	}
	
	public void mostrarDadosEnviados() {
		
	}
	
	public String retornaMensagem() {
		return servidor.sendMensagem();
		
	}
	
	@Override
	public void run() {
		aguardarClientes();
	}
	

}
