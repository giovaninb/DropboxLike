package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

public class Cronometro extends Thread {
	
	private Timer timer;  
    private int currentSegundo = 0;
    private int currentMinuto = 0;
    private int currentHora = 0;
    private int velocidade = 1000;
    private JLabel label;   
    
    public Cronometro(JLabel label) {
		this.label = label;
	}

	private void iniciarContagem() {
        ActionListener action = new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                currentSegundo++;
                
                if(currentSegundo==60){
                    currentMinuto++;
                    currentSegundo = 0;
                }
                
                if(currentMinuto==60){
                    currentHora++;
                    currentMinuto = 0;
                }
          
                String min = currentMinuto <= 9? "0"+currentMinuto:currentMinuto+"";
                String seg = currentSegundo <= 9? "0"+currentSegundo:currentSegundo+"";
                
                label.setText(min+":"+seg);  
            }  
        };  
        this.timer = new Timer(velocidade, action);  
        this.timer.start();
    }
	
	public void stopTime() {
        timer.stop();
        
	}
	public void cleanTime() {
        currentMinuto = 0;
        currentSegundo = 0;
        label.setText("00:00");
	}

    @Override
    public void run() {
    	iniciarContagem();
    }
    
    

}
