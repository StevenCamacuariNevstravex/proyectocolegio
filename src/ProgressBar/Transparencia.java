
package ProgressBar;

import javax.swing.JFrame;
import com.sun.awt.AWTUtilities;

public class Transparencia {

    public void BorrarFondo(JFrame x){      
           x.setUndecorated(true);
           AWTUtilities.setWindowOpaque(x, false);
    }
    
    
}
