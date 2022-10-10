
package Frames;

import ProgressBar.Transparencia;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.applet.AudioClip;
import java.io.File;
import javax.sound.sampled.*;


public class inicio extends javax.swing.JFrame {
    
    private Timer t;
    private ActionListener ac;
    private int x=0;
    

    public inicio() {
        
        
        new Transparencia().BorrarFondo(this);
        initComponents();
        this.setLocationRelativeTo(null);
        IniciarBarra();
        //IniciarSonido();
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();

        jProgressBar1.setForeground(new java.awt.Color(255, 255, 255));
        jProgressBar1.setPreferredSize(new java.awt.Dimension(790, 5));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nombr.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 791, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    public static void main(String args[]) {
   
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables

   public void IniciarBarra(){
       ac = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x+=9;
                jProgressBar1.setValue(x);
                if (jProgressBar1.getValue()==100) {
                    dispose();
                    t.stop();
                    Acceso f = new Acceso();
                    f.setVisible(true);
                }
            }
        };
       t=new Timer(100,ac);
        t.start();
       
   }
   
   //*public void IniciarSonido(){
       
//       AudioClip Sound;
 //      Sound = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/SONIDO-DE-INICIO.wav"));//MEJORAR SONIDO AQUI                  
  //     Sound.play();
       
  // }
  

   
   
   
   

}
