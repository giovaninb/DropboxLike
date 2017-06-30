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
		servidor = new Server();
	}
	
	public void aguardarClientes() {
		
		if (servidor.aguardaClientes()) {
			internal = new InternalClient();
			jan.getContentPane().add(internal);
			internal.getTxtIP().setText(servidor.getIpCliente());
			internal.setBounds(cont, cont, 450, 800);
			internal.setVisible(true);
			cont = cont+50;
			jan.revalidate();
		}
		
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
