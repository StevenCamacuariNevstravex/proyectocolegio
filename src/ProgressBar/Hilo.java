
package ProgressBar;

import javax.swing.JProgressBar;



public class Hilo extends Thread{
    
    private int num=0;
    private JProgressBar barra;
    
    public Hilo(JProgressBar barra){
        this.barra=barra;
    }
            
    
    public void llamarBarra(){
        if (barra.getValue()<=100) {         
            //num = num + (int) (Math.random()*19+10);
            num+=4;
            barra.setValue(num);
            barra.setStringPainted(true);            
        } else {
            barra.setValue(0);            
        }
    }
    
   
    public void run(){
        while (true) {            
            try {
                Thread.sleep(210);
                llamarBarra();
            } catch (InterruptedException e) {
            }
        }
    }

   
       
}

 