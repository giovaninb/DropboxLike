package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.plaf.ProgressBarUI;

public class BarraProgresso extends Thread {
	
	private Timer tempo;
    private int porcentagem;
    private Cronometro cron;
    private JProgressBar progressBar;
	private JButton btnIniciar;
	
    public BarraProgresso(JProgressBar progressBar, JButton button, Cronometro cronometro) {
		this.progressBar = progressBar;
		this.btnIniciar = button;
		this.cron = cronometro;
	}
    
    private void iniciaProgressBar(JProgressBar progressBar) {
    	 	btnIniciar.setEnabled(false);
    		porcentagem = 0;
    		cron.cleanTime();
    		tempo = new Timer(60, new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   porcentagem++;
                   progressBar.setValue(porcentagem);
                   if (porcentagem >= 100) {
                       tempo.stop();
                       cron.stopTime();
                       btnIniciar.setEnabled(true);
                   }
               }
           });
           tempo.start();
    }
    
    public void run() {
    	iniciaProgressBar(progressBar);
    }
    
    
    

}
