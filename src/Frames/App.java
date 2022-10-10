
package Frames;
import java.awt.Frame;
import javax.swing.JFrame;


public class App extends JFrame{
    
    public static void main(String[] args) {
        new inicio().setVisible(true);
    }
    
    public void cambiarFrame(Frame ocultar, Frame mostrar){
        ocultar.setVisible(false);
        mostrar.setVisible(true);
    }
    
    
}
