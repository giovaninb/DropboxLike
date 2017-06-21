package model;

public class Imagem {
	
	private String nome;
	private int identificador;
	
	public Imagem(int id, String nome) {
		this.identificador = id;
		this.nome = nome;
	}
	
	public Imagem() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
