
package Metodos_sql;
import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {
    
    public String url="jdbc:mysql://localhost:3306/proyectocolegio";
    public String usuario="root";
    public String pass="marcelo";
    public String llave="com.mysql.cj.jdbc.Driver";
    public Statement sentencia;
    
    Connection enlazar = null;
    
    public Connection conectar(){
        try {
            Class.forName(llave);
            enlazar = (Connection)DriverManager.getConnection(url, usuario, pass);
            sentencia = enlazar.createStatement();
            //JOptionPane.showMessageDialog(null,"Conexion Establecida");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error : " + e);
        }
        return enlazar;
    }    
}
