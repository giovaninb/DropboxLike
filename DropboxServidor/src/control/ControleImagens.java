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
	private int quantidade = 32;

	
	public ControleImagens(Imagem img, JanelaPrincipal jan) {
		this.imagem = img;
		this.jan = jan;
		
		//cria uma thread que envia a conexao
		Thread t = new Server();
		//inicia a thread t
		t.start();
		while (true) {
			aguardarClientes();
		}
	}
	
	public void aguardarClientes() {
		internal = new InternalClient();
		internal.setVisible(true);
		//internal.getTxtIP().setText(servidor.getIpCliente().toString());
		jan.getContentPane().add(internal);
		jan.validate();
		
		
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
		Thread t = servidor.comparaDados(quantidade, Integer.parseInt(internal.getTxtQuantidade().toString()));
		t.start();		
	}
	

}
