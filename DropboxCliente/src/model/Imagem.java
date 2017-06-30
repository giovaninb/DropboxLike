package model;

import java.io.Serializable;
import java.util.Date;

public class Imagem implements Serializable {

	private String nome;
	private int identificador;
	private byte[] conteudo;
	private long tamanhoKB;
	private String ipDestino;
	private String portaDestino;
	private String diretorioDestino;

	public Imagem() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String string) {
		this.nome = string;
	}

	public byte[] getConteudo() {
		return conteudo;
	}

	public void setConteudo(byte[] conteudo) {
		this.conteudo = conteudo;
	}

	public long getTamanhoKB() {
		return tamanhoKB;
	}

	public void setTamanhoKB(long tamanhoKB) {
		this.tamanhoKB = tamanhoKB;
	}

	public String getIpDestino() {
		return ipDestino;
	}

	public void setIpDestino(String ipDestino) {
		this.ipDestino = ipDestino;
	}

	public String getPortaDestino() {
		return portaDestino;
	}

	public void setPortaDestino(String portaDestino) {
		this.portaDestino = portaDestino;
	}

	public String getDiretorioDestino() {
		return diretorioDestino;
	}

	public void setDiretorioDestino(String diretorioDestino) {
		this.diretorioDestino = diretorioDestino;
	}

}
