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
		jan.getContentPane().add(internal);
		internal.getTxtIP().setText(servidor.getIpCliente());
		internal.setBounds(cont, cont, 450, 800);
		internal.setVisible(true);
		cont = cont+50;
		internal.revalidate();
		jan.revalidate();
		
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
