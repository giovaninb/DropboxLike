package model;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextField;

import view.JanelaPrincipal;

public class TransfereImagens extends Thread {
	
	private DefaultListModel modeloOrigem;
	private JList<Imagem> listaDeImagensOrigem;
	private DefaultListModel modeloDestino;
	private JList<Imagem> listaDeImagensDestino;
	
	public TransfereImagens(DefaultListModel modeloOrigem, JList<Imagem> listaDeImagensOrigem,
			DefaultListModel modeloDestino, JList<Imagem> listaDeImagensDestino) {
		super();
		this.modeloOrigem = modeloOrigem;
		this.listaDeImagensOrigem = listaDeImagensOrigem;
		this.modeloDestino = modeloDestino;
		this.listaDeImagensDestino = listaDeImagensDestino;
	}
	
	public boolean transfereImagens() {
		boolean resultado = false;
		
		modeloOrigem = new DefaultListModel<>();
		modeloDestino = new DefaultListModel<>();
		listaDeImagensOrigem = new JList<Imagem>(modeloOrigem);
		listaDeImagensDestino = new JList<Imagem>(modeloDestino);
		
		JTextField contadorOrigem = new JTextField();
		JTextField contadorDestino = new JTextField();
		
		
		
		
		return resultado;
	}
	
	@Override
	public void run() {
		transfereImagens();
	}
	
	

}
