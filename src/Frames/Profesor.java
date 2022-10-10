
package Frames;

import Metodos_sql.Conexion;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Profesor extends javax.swing.JFrame {

    
    int xMouse, yMouse;
    Conexion enlace = new Conexion();
    Connection conect = enlace.conectar();
    private String usuarioprofesor; 
        
    public Profesor() {
        initComponents();
        this.setLocationRelativeTo(null);
        LimpiarDatosAlumnos();
              
    }

    public void DatosAcceso(String x){
        String nombre1=null;
        String apellido=null;
               
        try {
            Statement leer = conect.createStatement();            
            ResultSet resultado = leer.executeQuery("call datos_profesor('"+ x +"');");            
            while (resultado.next()) {                
                apellido = resultado.getString(1);
                nombre1 = resultado.getString(2);                
            }            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error: "+e);
        }
        lblusuario.setText(apellido+", "+nombre1);
        usuarioprofesor = x;
        
        AgregarListaCursos();       
        
        
        
    }
    
    public void AgregarListaCursos(){        
        String n[];
        n = new String[100];
        
        int i=0;
        
        try {            
            Statement leer = conect.createStatement();            
            ResultSet resul = leer.executeQuery("call Profesor_Cursos('"+usuarioprofesor+"');");
            while (resul.next()) { 
                n[i] = resul.getString(1);                  
                i=i+1;
            }
            i=i-1;    
            for (int j = 0; j <= i; j++) {
                cbocurso.addItem(n[j]);
            }    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error: "+e);
        }        
    }    
    
    public void AgregarListaAge(){        
        String n[];
        n = new String[100];
        
        int i=0;
        
        try {            
            Statement leer = conect.createStatement();            
            ResultSet resul = leer.executeQuery("call Profesor_Grado('"+usuarioprofesor+"');");
            while (resul.next()) { 
                n[i] = resul.getString(1);                  
                i=i+1;
            }
            i=i-1;    
            for (int j = 0; j <= i; j++) {
                cboaño.addItem(n[j]);
            }    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error: "+e);
        }        
    }   
    
    public void ComboBoxCurso(){        
        String n[];
        n = new String[100];
        cboaño.removeAllItems();
        cboaño.addItem("Año");
        int i=0;
        
        try {            
            Statement leer = conect.createStatement();            
            ResultSet resul = leer.executeQuery("call Curso_Grado('"+usuarioprofesor+"','"+ cbocurso.getSelectedItem() +"');");
            while (resul.next()) { 
                n[i] = resul.getString(1);                  
                i=i+1;
            }
            i=i-1;    
            for (int j = 0; j <= i; j++) {
                cboaño.addItem(n[j]);
            }    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error: "+e);
        }        
    }
    
    public void ComboBoxAge(){        
        String n[];
        n = new String[100];
        cboseccion.removeAllItems();
        cboseccion.addItem("Seccion");
        int i=0;
        
        try {            
            Statement leer = conect.createStatement();            
            ResultSet resul = leer.executeQuery("call Grado_Seccion('"+usuarioprofesor+"','"+ cbocurso.getSelectedItem() +"','"+cboaño.getSelectedItem()+"');");
            while (resul.next()) { 
                n[i] = resul.getString(1);                  
                i=i+1;
            }
            i=i-1;    
            for (int j = 0; j <= i; j++) {
                cboseccion.addItem(n[j]);
            }    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error: "+e);
        }        
    }
     
    public void ComboBoxSeccion(){        
        String n[];
        n = new String[100];
        cboturno.removeAllItems();
        cboturno.addItem("Turno");
        int i=0;
        
        try {            
            Statement leer = conect.createStatement();            
            ResultSet resul = leer.executeQuery("call Grado_Seccion_Turno('"+usuarioprofesor+"','"+ cbocurso.getSelectedItem() +"','"+cboaño.getSelectedItem()+"','"+cboseccion.getSelectedItem()+"');");
            while (resul.next()) { 
                n[i] = resul.getString(1);                  
                i=i+1;
            }
            i=i-1;    
            for (int j = 0; j <= i; j++) {
                cboturno.addItem(n[j]);
            }    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error: "+e);
        }        
    }
    
    public void ListarAlumnos(){
        
        String apellido[];
        apellido = new String[10];
                
        String nombre[];
        nombre = new String[10];
        
        String nota1[];
        nota1 = new String[10];
        
        String nota2[];
        nota2 = new String[10];
        
        String nota3[];
        nota3 = new String[10];
        
        String nota4[];
        nota4 = new String[10];
        
        String nota5[];
        nota5 = new String[10];       
       
        int i=0;
        try {
            Statement leer = conect.createStatement();            
            ResultSet resultado = leer.executeQuery("call Listado_Alumno_Curso"
                    + "('"+ usuarioprofesor +"'"                  
                    + ",'"+ cbocurso.getSelectedItem() +"'"
                    + ",'"+cboaño.getSelectedItem() +"'"
                    + ",'"+ cboseccion.getSelectedItem() +"'"
                    + ",'"+ cboturno.getSelectedItem() +"');");
            
            while (resultado.next()) {                
                apellido[i]=resultado.getString(1);
                nombre[i]=resultado.getString(2);
                nota1[i]=resultado.getString(3);
                nota2[i]=resultado.getString(4);
                nota3[i]=resultado.getString(5);
                nota4[i]=resultado.getString(6);
                nota5[i]=resultado.getString(7);
                i++;
            }
            
            
            
            //PARA 1            
            if (nombre[0].equals(null) || apellido[0].equals(null)) {
                LimpiarDatosAlumnos();
            } else {
                lbl1.setText(String.valueOf("1"));
                lblnombre1.setText(apellido[0]+", "+nombre[0]);
                lblnombre1nota1.setText(nota1[0]);
                lblnombre1nota2.setText(nota2[0]);
                lblnombre1nota3.setText(nota3[0]);
                lblnombre1nota4.setText(nota4[0]);
                lblnombre1nota5.setText(nota5[0]);
            }
            
            //PARA 2
            if (nombre[1].equals(null) || apellido[1].equals(null)) {
                LimpiarDatosAlumnos();
                lbl1.setText(String.valueOf("1"));
                lblnombre1.setText(apellido[0]+", "+nombre[0]);
                lblnombre1nota1.setText(nota1[0]);
                lblnombre1nota2.setText(nota2[0]);
                lblnombre1nota3.setText(nota3[0]);
                lblnombre1nota4.setText(nota4[0]);
                lblnombre1nota5.setText(nota5[0]);                
            } else {
                separadorV1.setVisible(true);
                lbl2.setText(String.valueOf("2"));
                lblnombre2.setText(apellido[1]+", "+nombre[1]);
                lblnombre2nota1.setText(nota1[1]);
                lblnombre2nota2.setText(nota2[1]);
                lblnombre2nota3.setText(nota3[1]);
                lblnombre2nota4.setText(nota4[1]);
                lblnombre2nota5.setText(nota5[1]);
            }
            
            //PARA 3
            if (nombre[2].equals(null) || apellido[2].equals(null)) {
                LimpiarDatosAlumnos();
                lbl1.setText(String.valueOf("1"));
                lblnombre1.setText(apellido[0]+", "+nombre[0]);
                lblnombre1nota1.setText(nota1[0]);
                lblnombre1nota2.setText(nota2[0]);
                lblnombre1nota3.setText(nota3[0]);
                lblnombre1nota4.setText(nota4[0]);
                lblnombre1nota5.setText(nota5[0]);
                separadorV1.setVisible(true);
                lbl2.setText(String.valueOf("2"));
                lblnombre2.setText(apellido[1]+", "+nombre[1]);
                lblnombre2nota1.setText(nota1[1]);
                lblnombre2nota2.setText(nota2[1]);
                lblnombre2nota3.setText(nota3[1]);
                lblnombre2nota4.setText(nota4[1]);
                lblnombre2nota5.setText(nota5[1]);
            } else {
                separadorV2.setVisible(true);
                lbl3.setText(String.valueOf("3"));
                lblnombre3.setText(apellido[2]+", "+nombre[2]);
                lblnombre3nota1.setText(nota1[2]);
                lblnombre3nota2.setText(nota2[2]);
                lblnombre3nota3.setText(nota3[2]);
                lblnombre3nota4.setText(nota4[2]);
                lblnombre3nota5.setText(nota5[2]);
            }
            
            //PARA 4
            if (nombre[3].equals(null) || apellido[3].equals(null)) {
                LimpiarDatosAlumnos();
                lbl1.setText(String.valueOf("1"));
                lblnombre1.setText(apellido[0]+", "+nombre[0]);
                lblnombre1nota1.setText(nota1[0]);
                lblnombre1nota2.setText(nota2[0]);
                lblnombre1nota3.setText(nota3[0]);
                lblnombre1nota4.setText(nota4[0]);
                lblnombre1nota5.setText(nota5[0]);
                separadorV1.setVisible(true);
                lbl2.setText(String.valueOf("2"));
                lblnombre2.setText(apellido[1]+", "+nombre[1]);
                lblnombre2nota1.setText(nota1[1]);
                lblnombre2nota2.setText(nota2[1]);
                lblnombre2nota3.setText(nota3[1]);
                lblnombre2nota4.setText(nota4[1]);
                lblnombre2nota5.setText(nota5[1]);
                separadorV2.setVisible(true);
                lbl3.setText(String.valueOf("3"));
                lblnombre3.setText(apellido[2]+", "+nombre[2]);
                lblnombre3nota1.setText(nota1[2]);
                lblnombre3nota2.setText(nota2[2]);
                lblnombre3nota3.setText(nota3[2]);
                lblnombre3nota4.setText(nota4[2]);
                lblnombre3nota5.setText(nota5[2]);
            } else {
                separadorV3.setVisible(true);
                lbl4.setText(String.valueOf("4"));
                lblnombre4.setText(apellido[3]+", "+nombre[3]);
                lblnombre4nota1.setText(nota1[3]);
                lblnombre4nota2.setText(nota2[3]);
                lblnombre4nota3.setText(nota3[3]);
                lblnombre4nota4.setText(nota4[3]);
                lblnombre4nota5.setText(nota5[3]);
            }
  
            //PARA 5
            if (nombre[4].equals(null) || apellido[4].equals(null)) {
                LimpiarDatosAlumnos();
                lbl1.setText(String.valueOf("1"));
                lblnombre1.setText(apellido[0]+", "+nombre[0]);
                lblnombre1nota1.setText(nota1[0]);
                lblnombre1nota2.setText(nota2[0]);
                lblnombre1nota3.setText(nota3[0]);
                lblnombre1nota4.setText(nota4[0]);
                lblnombre1nota5.setText(nota5[0]);
                separadorV1.setVisible(true);
                lbl2.setText(String.valueOf("2"));
                lblnombre2.setText(apellido[1]+", "+nombre[1]);
                lblnombre2nota1.setText(nota1[1]);
                lblnombre2nota2.setText(nota2[1]);
                lblnombre2nota3.setText(nota3[1]);
                lblnombre2nota4.setText(nota4[1]);
                lblnombre2nota5.setText(nota5[1]);
                separadorV2.setVisible(true);
                lbl3.setText(String.valueOf("3"));
                lblnombre3.setText(apellido[2]+", "+nombre[2]);
                lblnombre3nota1.setText(nota1[2]);
                lblnombre3nota2.setText(nota2[2]);
                lblnombre3nota3.setText(nota3[2]);
                lblnombre3nota4.setText(nota4[2]);
                lblnombre3nota5.setText(nota5[2]);
                separadorV3.setVisible(true);
                lbl4.setText(String.valueOf("4"));
                lblnombre4.setText(apellido[3]+", "+nombre[3]);
                lblnombre4nota1.setText(nota1[3]);
                lblnombre4nota2.setText(nota2[3]);
                lblnombre4nota3.setText(nota3[3]);
                lblnombre4nota4.setText(nota4[3]);
                lblnombre4nota5.setText(nota5[3]);
            } else {
                separadorV4.setVisible(true);
                lbl5.setText(String.valueOf("5"));
                lblnombre5.setText(apellido[4]+", "+nombre[4]);
                lblnombre5nota1.setText(nota1[4]);
                lblnombre5nota2.setText(nota2[4]);
                lblnombre5nota3.setText(nota3[4]);
                lblnombre5nota4.setText(nota4[4]);
                lblnombre5nota5.setText(nota5[4]);
            }
            
            //PARA 6
            if (nombre[5].equals(null) || apellido[5].equals(null)) {
                LimpiarDatosAlumnos();
                lbl1.setText(String.valueOf("1"));
                lblnombre1.setText(apellido[0]+", "+nombre[0]);
                lblnombre1nota1.setText(nota1[0]);
                lblnombre1nota2.setText(nota2[0]);
                lblnombre1nota3.setText(nota3[0]);
                lblnombre1nota4.setText(nota4[0]);
                lblnombre1nota5.setText(nota5[0]);
                separadorV1.setVisible(true);
                lbl2.setText(String.valueOf("2"));
                lblnombre2.setText(apellido[1]+", "+nombre[1]);
                lblnombre2nota1.setText(nota1[1]);
                lblnombre2nota2.setText(nota2[1]);
                lblnombre2nota3.setText(nota3[1]);
                lblnombre2nota4.setText(nota4[1]);
                lblnombre2nota5.setText(nota5[1]);
                separadorV2.setVisible(true);
                lbl3.setText(String.valueOf("3"));
                lblnombre3.setText(apellido[2]+", "+nombre[2]);
                lblnombre3nota1.setText(nota1[2]);
                lblnombre3nota2.setText(nota2[2]);
                lblnombre3nota3.setText(nota3[2]);
                lblnombre3nota4.setText(nota4[2]);
                lblnombre3nota5.setText(nota5[2]);
                separadorV3.setVisible(true);
                lbl4.setText(String.valueOf("4"));
                lblnombre4.setText(apellido[3]+", "+nombre[3]);
                lblnombre4nota1.setText(nota1[3]);
                lblnombre4nota2.setText(nota2[3]);
                lblnombre4nota3.setText(nota3[3]);
                lblnombre4nota4.setText(nota4[3]);
                lblnombre4nota5.setText(nota5[3]);
                separadorV4.setVisible(true);
                lbl5.setText(String.valueOf("5"));
                lblnombre5.setText(apellido[4]+", "+nombre[4]);
                lblnombre5nota1.setText(nota1[4]);
                lblnombre5nota2.setText(nota2[4]);
                lblnombre5nota3.setText(nota3[4]);
                lblnombre5nota4.setText(nota4[4]);
                lblnombre5nota5.setText(nota5[4]);
            } else {
                separadorV5.setVisible(true);
                lbl6.setText(String.valueOf("6"));
                lblnombre6.setText(apellido[5]+", "+nombre[5]);
                lblnombre6nota1.setText(nota1[5]);
                lblnombre6nota2.setText(nota2[5]);
                lblnombre6nota3.setText(nota3[5]);
                lblnombre6nota4.setText(nota4[5]);
                lblnombre6nota5.setText(nota5[5]);                
            }
            
            //PARA 7
            if (nombre[6].equals(null) || apellido[6].equals(null)) {
                LimpiarDatosAlumnos();
                lbl1.setText(String.valueOf("1"));
                lblnombre1.setText(apellido[0]+", "+nombre[0]);
                lblnombre1nota1.setText(nota1[0]);
                lblnombre1nota2.setText(nota2[0]);
                lblnombre1nota3.setText(nota3[0]);
                lblnombre1nota4.setText(nota4[0]);
                lblnombre1nota5.setText(nota5[0]);
                separadorV1.setVisible(true);
                lbl2.setText(String.valueOf("2"));
                lblnombre2.setText(apellido[1]+", "+nombre[1]);
                lblnombre2nota1.setText(nota1[1]);
                lblnombre2nota2.setText(nota2[1]);
                lblnombre2nota3.setText(nota3[1]);
                lblnombre2nota4.setText(nota4[1]);
                lblnombre2nota5.setText(nota5[1]);
                separadorV2.setVisible(true);
                lbl3.setText(String.valueOf("3"));
                lblnombre3.setText(apellido[2]+", "+nombre[2]);
                lblnombre3nota1.setText(nota1[2]);
                lblnombre3nota2.setText(nota2[2]);
                lblnombre3nota3.setText(nota3[2]);
                lblnombre3nota4.setText(nota4[2]);
                lblnombre3nota5.setText(nota5[2]);
                separadorV3.setVisible(true);
                lbl4.setText(String.valueOf("4"));
                lblnombre4.setText(apellido[3]+", "+nombre[3]);
                lblnombre4nota1.setText(nota1[3]);
                lblnombre4nota2.setText(nota2[3]);
                lblnombre4nota3.setText(nota3[3]);
                lblnombre4nota4.setText(nota4[3]);
                lblnombre4nota5.setText(nota5[3]);
                separadorV4.setVisible(true);
                lbl5.setText(String.valueOf("5"));
                lblnombre5.setText(apellido[4]+", "+nombre[4]);
                lblnombre5nota1.setText(nota1[4]);
                lblnombre5nota2.setText(nota2[4]);
                lblnombre5nota3.setText(nota3[4]);
                lblnombre5nota4.setText(nota4[4]);
                lblnombre5nota5.setText(nota5[4]);
                separadorV5.setVisible(true);
                lbl6.setText(String.valueOf("6"));
                lblnombre6.setText(apellido[5]+", "+nombre[5]);
                lblnombre6nota1.setText(nota1[5]);
                lblnombre6nota2.setText(nota2[5]);
                lblnombre6nota3.setText(nota3[5]);
                lblnombre6nota4.setText(nota4[5]);
                lblnombre6nota5.setText(nota5[5]);
            } else {
                separadorV6.setVisible(true);
                lbl7.setText(String.valueOf("7"));
                lblnombre7.setText(apellido[6]+", "+nombre[6]);
                lblnombre7nota1.setText(nota1[6]);
                lblnombre7nota2.setText(nota2[6]);
                lblnombre7nota3.setText(nota3[6]);
                lblnombre7nota4.setText(nota4[6]);
                lblnombre7nota5.setText(nota5[6]);                
            }
            
            
            //PARA 8
            if (nombre[7].equals(null) || apellido[7].equals(null)) {
                LimpiarDatosAlumnos();
                lbl1.setText(String.valueOf("1"));
                lblnombre1.setText(apellido[0]+", "+nombre[0]);
                lblnombre1nota1.setText(nota1[0]);
                lblnombre1nota2.setText(nota2[0]);
                lblnombre1nota3.setText(nota3[0]);
                lblnombre1nota4.setText(nota4[0]);
                lblnombre1nota5.setText(nota5[0]);
                separadorV1.setVisible(true);
                lbl2.setText(String.valueOf("2"));
                lblnombre2.setText(apellido[1]+", "+nombre[1]);
                lblnombre2nota1.setText(nota1[1]);
                lblnombre2nota2.setText(nota2[1]);
                lblnombre2nota3.setText(nota3[1]);
                lblnombre2nota4.setText(nota4[1]);
                lblnombre2nota5.setText(nota5[1]);
                separadorV2.setVisible(true);
                lbl3.setText(String.valueOf("3"));
                lblnombre3.setText(apellido[2]+", "+nombre[2]);
                lblnombre3nota1.setText(nota1[2]);
                lblnombre3nota2.setText(nota2[2]);
                lblnombre3nota3.setText(nota3[2]);
                lblnombre3nota4.setText(nota4[2]);
                lblnombre3nota5.setText(nota5[2]);
                separadorV3.setVisible(true);
                lbl4.setText(String.valueOf("4"));
                lblnombre4.setText(apellido[3]+", "+nombre[3]);
                lblnombre4nota1.setText(nota1[3]);
                lblnombre4nota2.setText(nota2[3]);
                lblnombre4nota3.setText(nota3[3]);
                lblnombre4nota4.setText(nota4[3]);
                lblnombre4nota5.setText(nota5[3]);
                separadorV4.setVisible(true);
                lbl5.setText(String.valueOf("5"));
                lblnombre5.setText(apellido[4]+", "+nombre[4]);
                lblnombre5nota1.setText(nota1[4]);
                lblnombre5nota2.setText(nota2[4]);
                lblnombre5nota3.setText(nota3[4]);
                lblnombre5nota4.setText(nota4[4]);
                lblnombre5nota5.setText(nota5[4]);
                separadorV5.setVisible(true);
                lbl6.setText(String.valueOf("6"));
                lblnombre6.setText(apellido[5]+", "+nombre[5]);
                lblnombre6nota1.setText(nota1[5]);
                lblnombre6nota2.setText(nota2[5]);
                lblnombre6nota3.setText(nota3[5]);
                lblnombre6nota4.setText(nota4[5]);
                lblnombre6nota5.setText(nota5[5]);
                separadorV6.setVisible(true);
                lbl7.setText(String.valueOf("7"));
                lblnombre7.setText(apellido[6]+", "+nombre[6]);
                lblnombre7nota1.setText(nota1[6]);
                lblnombre7nota2.setText(nota2[6]);
                lblnombre7nota3.setText(nota3[6]);
                lblnombre7nota4.setText(nota4[6]);
                lblnombre7nota5.setText(nota5[6]); 
            } else {
                separadorV7.setVisible(true);
                lbl8.setText(String.valueOf("8"));
                lblnombre8.setText(apellido[7]+", "+nombre[7]);
                lblnombre8nota1.setText(nota1[7]);
                lblnombre8nota2.setText(nota2[7]);
                lblnombre8nota3.setText(nota3[7]);
                lblnombre8nota4.setText(nota4[7]);
                lblnombre8nota5.setText(nota5[7]);                
            }
            
            
            //PARA 9
            if (nombre[8].equals(null) || apellido[8].equals(null)) {
                LimpiarDatosAlumnos();
                lbl1.setText(String.valueOf("1"));
                lblnombre1.setText(apellido[0]+", "+nombre[0]);
                lblnombre1nota1.setText(nota1[0]);
                lblnombre1nota2.setText(nota2[0]);
                lblnombre1nota3.setText(nota3[0]);
                lblnombre1nota4.setText(nota4[0]);
                lblnombre1nota5.setText(nota5[0]);
                separadorV1.setVisible(true);
                lbl2.setText(String.valueOf("2"));
                lblnombre2.setText(apellido[1]+", "+nombre[1]);
                lblnombre2nota1.setText(nota1[1]);
                lblnombre2nota2.setText(nota2[1]);
                lblnombre2nota3.setText(nota3[1]);
                lblnombre2nota4.setText(nota4[1]);
                lblnombre2nota5.setText(nota5[1]);
                separadorV2.setVisible(true);
                lbl3.setText(String.valueOf("3"));
                lblnombre3.setText(apellido[2]+", "+nombre[2]);
                lblnombre3nota1.setText(nota1[2]);
                lblnombre3nota2.setText(nota2[2]);
                lblnombre3nota3.setText(nota3[2]);
                lblnombre3nota4.setText(nota4[2]);
                lblnombre3nota5.setText(nota5[2]);
                separadorV3.setVisible(true);
                lbl4.setText(String.valueOf("4"));
                lblnombre4.setText(apellido[3]+", "+nombre[3]);
                lblnombre4nota1.setText(nota1[3]);
                lblnombre4nota2.setText(nota2[3]);
                lblnombre4nota3.setText(nota3[3]);
                lblnombre4nota4.setText(nota4[3]);
                lblnombre4nota5.setText(nota5[3]);
                separadorV4.setVisible(true);
                lbl5.setText(String.valueOf("5"));
                lblnombre5.setText(apellido[4]+", "+nombre[4]);
                lblnombre5nota1.setText(nota1[4]);
                lblnombre5nota2.setText(nota2[4]);
                lblnombre5nota3.setText(nota3[4]);
                lblnombre5nota4.setText(nota4[4]);
                lblnombre5nota5.setText(nota5[4]);
                separadorV5.setVisible(true);
                lbl6.setText(String.valueOf("6"));
                lblnombre6.setText(apellido[5]+", "+nombre[5]);
                lblnombre6nota1.setText(nota1[5]);
                lblnombre6nota2.setText(nota2[5]);
                lblnombre6nota3.setText(nota3[5]);
                lblnombre6nota4.setText(nota4[5]);
                lblnombre6nota5.setText(nota5[5]);
                separadorV6.setVisible(true);
                lbl7.setText(String.valueOf("7"));
                lblnombre7.setText(apellido[6]+", "+nombre[6]);
                lblnombre7nota1.setText(nota1[6]);
                lblnombre7nota2.setText(nota2[6]);
                lblnombre7nota3.setText(nota3[6]);
                lblnombre7nota4.setText(nota4[6]);
                lblnombre7nota5.setText(nota5[6]);
                separadorV7.setVisible(true);
                lbl8.setText(String.valueOf("8"));
                lblnombre8.setText(apellido[7]+", "+nombre[7]);
                lblnombre8nota1.setText(nota1[7]);
                lblnombre8nota2.setText(nota2[7]);
                lblnombre8nota3.setText(nota3[7]);
                lblnombre8nota4.setText(nota4[7]);
                lblnombre8nota5.setText(nota5[7]); 
            } else {
                separadorV8.setVisible(true);
                lbl9.setText(String.valueOf("9"));
                lblnombre9.setText(apellido[8]+", "+nombre[8]);
                lblnombre9nota1.setText(nota1[8]);
                lblnombre9nota2.setText(nota2[8]);
                lblnombre9nota3.setText(nota3[8]);
                lblnombre9nota4.setText(nota4[8]);
                lblnombre9nota5.setText(nota5[8]);                
            }
            
            
            //PARA 10
            if (nombre[9].equals(null) || apellido[9].equals(null)) {
                LimpiarDatosAlumnos();
                lbl1.setText(String.valueOf("1"));
                lblnombre1.setText(apellido[0]+", "+nombre[0]);
                lblnombre1nota1.setText(nota1[0]);
                lblnombre1nota2.setText(nota2[0]);
                lblnombre1nota3.setText(nota3[0]);
                lblnombre1nota4.setText(nota4[0]);
                lblnombre1nota5.setText(nota5[0]);
                separadorV1.setVisible(true);
                lbl2.setText(String.valueOf("2"));
                lblnombre2.setText(apellido[1]+", "+nombre[1]);
                lblnombre2nota1.setText(nota1[1]);
                lblnombre2nota2.setText(nota2[1]);
                lblnombre2nota3.setText(nota3[1]);
                lblnombre2nota4.setText(nota4[1]);
                lblnombre2nota5.setText(nota5[1]);
                separadorV2.setVisible(true);
                lbl3.setText(String.valueOf("3"));
                lblnombre3.setText(apellido[2]+", "+nombre[2]);
                lblnombre3nota1.setText(nota1[2]);
                lblnombre3nota2.setText(nota2[2]);
                lblnombre3nota3.setText(nota3[2]);
                lblnombre3nota4.setText(nota4[2]);
                lblnombre3nota5.setText(nota5[2]);
                separadorV3.setVisible(true);
                lbl4.setText(String.valueOf("4"));
                lblnombre4.setText(apellido[3]+", "+nombre[3]);
                lblnombre4nota1.setText(nota1[3]);
                lblnombre4nota2.setText(nota2[3]);
                lblnombre4nota3.setText(nota3[3]);
                lblnombre4nota4.setText(nota4[3]);
                lblnombre4nota5.setText(nota5[3]);
                separadorV4.setVisible(true);
                lbl5.setText(String.valueOf("5"));
                lblnombre5.setText(apellido[4]+", "+nombre[4]);
                lblnombre5nota1.setText(nota1[4]);
                lblnombre5nota2.setText(nota2[4]);
                lblnombre5nota3.setText(nota3[4]);
                lblnombre5nota4.setText(nota4[4]);
                lblnombre5nota5.setText(nota5[4]);
                separadorV5.setVisible(true);
                lbl6.setText(String.valueOf("6"));
                lblnombre6.setText(apellido[5]+", "+nombre[5]);
                lblnombre6nota1.setText(nota1[5]);
                lblnombre6nota2.setText(nota2[5]);
                lblnombre6nota3.setText(nota3[5]);
                lblnombre6nota4.setText(nota4[5]);
                lblnombre6nota5.setText(nota5[5]);
                separadorV6.setVisible(true);
                lbl7.setText(String.valueOf("7"));
                lblnombre7.setText(apellido[6]+", "+nombre[6]);
                lblnombre7nota1.setText(nota1[6]);
                lblnombre7nota2.setText(nota2[6]);
                lblnombre7nota3.setText(nota3[6]);
                lblnombre7nota4.setText(nota4[6]);
                lblnombre7nota5.setText(nota5[6]);
                separadorV7.setVisible(true);
                lbl8.setText(String.valueOf("8"));
                lblnombre8.setText(apellido[7]+", "+nombre[7]);
                lblnombre8nota1.setText(nota1[7]);
                lblnombre8nota2.setText(nota2[7]);
                lblnombre8nota3.setText(nota3[7]);
                lblnombre8nota4.setText(nota4[7]);
                lblnombre8nota5.setText(nota5[7]);
                separadorV8.setVisible(true);
                lbl9.setText(String.valueOf("9"));
                lblnombre9.setText(apellido[8]+", "+nombre[8]);
                lblnombre9nota1.setText(nota1[8]);
                lblnombre9nota2.setText(nota2[8]);
                lblnombre9nota3.setText(nota3[8]);
                lblnombre9nota4.setText(nota4[8]);
                lblnombre9nota5.setText(nota5[8]);
            } else {
                separadorV9.setVisible(true);
                lbl10.setText(String.valueOf("10"));
                lblnombre10.setText(apellido[9]+", "+nombre[9]);
                lblnombre10nota1.setText(nota1[9]);
                lblnombre10nota2.setText(nota2[9]);
                lblnombre10nota3.setText(nota3[9]);
                lblnombre10nota4.setText(nota4[9]);
                lblnombre10nota5.setText(nota5[9]);                
            }
     
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null,"Error :"+e);
        }

    }
        
    public void LimpiarDatosAlumnos(){
        separadorV1.setVisible(false);
        separadorV2.setVisible(false);
        separadorV3.setVisible(false);
        separadorV4.setVisible(false);
        separadorV5.setVisible(false);
        separadorV6.setVisible(false);
        separadorV7.setVisible(false);
        separadorV8.setVisible(false);
        separadorV9.setVisible(false);        
        lbl1.setText("");
        lbl2.setText("");
        lbl3.setText("");
        lbl4.setText("");
        lbl5.setText("");
        lbl6.setText("");
        lbl7.setText("");
        lbl8.setText("");
        lbl9.setText("");
        lbl10.setText("");
        lblnombre1.setText("");
        lblnombre2.setText("");
        lblnombre3.setText("");
        lblnombre4.setText("");
        lblnombre5.setText("");
        lblnombre6.setText("");
        lblnombre7.setText("");
        lblnombre8.setText("");
        lblnombre9.setText("");
        lblnombre10.setText("");
        lblnombre1nota1.setText("");
        lblnombre1nota2.setText("");
        lblnombre1nota3.setText("");
        lblnombre1nota4.setText("");
        lblnombre1nota5.setText("");
        lblnombre2nota1.setText("");
        lblnombre2nota2.setText("");
        lblnombre2nota3.setText("");
        lblnombre2nota4.setText("");
        lblnombre2nota5.setText("");
        lblnombre3nota1.setText("");
        lblnombre3nota2.setText("");
        lblnombre3nota3.setText("");
        lblnombre3nota4.setText("");
        lblnombre3nota5.setText("");
        lblnombre4nota1.setText("");
        lblnombre4nota2.setText("");
        lblnombre4nota3.setText("");
        lblnombre4nota4.setText("");
        lblnombre4nota5.setText("");
        lblnombre5nota1.setText("");
        lblnombre5nota2.setText("");
        lblnombre5nota3.setText("");
        lblnombre5nota4.setText("");
        lblnombre5nota5.setText("");
        lblnombre6nota1.setText("");
        lblnombre6nota2.setText("");
        lblnombre6nota3.setText("");
        lblnombre6nota4.setText("");
        lblnombre6nota5.setText("");
        lblnombre7nota1.setText("");
        lblnombre7nota2.setText("");
        lblnombre7nota3.setText("");
        lblnombre7nota4.setText("");
        lblnombre7nota5.setText("");
        lblnombre8nota1.setText("");
        lblnombre8nota2.setText("");
        lblnombre8nota3.setText("");
        lblnombre8nota4.setText("");
        lblnombre8nota5.setText("");
        lblnombre9nota1.setText("");
        lblnombre9nota2.setText("");
        lblnombre9nota3.setText("");
        lblnombre9nota4.setText("");
        lblnombre9nota5.setText("");
        lblnombre10nota1.setText("");
        lblnombre10nota2.setText("");
        lblnombre10nota3.setText("");
        lblnombre10nota4.setText("");
        lblnombre10nota5.setText("");       
    }
    
    public void NotasID(){
        
        String id[];
        id = new String[100];
        
        int p=0;
        
        try {            
            Statement leer = conect.createStatement();            
            ResultSet resultado = leer.executeQuery("call id_Notas"
                    + "('"+ usuarioprofesor +"'"                  
                    + ",'"+ cbocurso.getSelectedItem() +"'"
                    + ",'"+cboaño.getSelectedItem() +"'"
                    + ",'"+ cboseccion.getSelectedItem() +"'"
                    + ",'"+ cboturno.getSelectedItem() +"');");
            
            while (resultado.next()) {                
               id[p] = resultado.getString(1);
               p++;
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : "+e);
        }
        
    }
    
    public void Actualizar(){
        
        //IDENTIFICO LOS ID DE LOS ALUMNOS
        String id[];
        id = new String[100];
        
        int p=0;
        
        try {            
            Statement leer = conect.createStatement();            
            ResultSet resultado = leer.executeQuery("call id_Notas"
                    + "('"+ usuarioprofesor +"'"                  
                    + ",'"+ cbocurso.getSelectedItem() +"'"
                    + ",'"+cboaño.getSelectedItem() +"'"
                    + ",'"+ cboseccion.getSelectedItem() +"'"
                    + ",'"+ cboturno.getSelectedItem() +"');");
            
            while (resultado.next()) {                
               id[p] = resultado.getString(1);
               p++;
            }
            p--;
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Error : "+e);
        }
        
        //EMPIEZO A ACTULIZAR LISTADO DE ALUMNOS
        
        
        
        try {
                            
            PreparedStatement guardar0 = conect.prepareStatement("Call ActualizarArea('"+id[0]+"','"
                    + lblnombre1nota1.getText() +"','"
                    + lblnombre1nota2.getText() +"','"
                    + lblnombre1nota3.getText() +"','"
                    + lblnombre1nota4.getText() +"','"
                    + lblnombre1nota5.getText() +"');");            
            guardar0.executeUpdate();
            
            
            PreparedStatement guardar1 = conect.prepareStatement("Call ActualizarArea('"+id[1]+"','"
                    + lblnombre2nota1.getText() +"','"
                    + lblnombre2nota2.getText() +"','"
                    + lblnombre2nota3.getText() +"','"
                    + lblnombre2nota4.getText() +"','"
                    + lblnombre2nota5.getText() +"');");            
            guardar1.executeUpdate();
            
            
            PreparedStatement guardar2 = conect.prepareStatement("Call ActualizarArea('"+id[2]+"','"
                    + lblnombre3nota1.getText() +"','"
                    + lblnombre3nota2.getText() +"','"
                    + lblnombre3nota3.getText() +"','"
                    + lblnombre3nota4.getText() +"','"
                    + lblnombre3nota5.getText() +"');");            
            guardar2.executeUpdate();
            
           
            PreparedStatement guardar3 = conect.prepareStatement("Call ActualizarArea('"+id[3]+"','"
                    + lblnombre4nota1.getText() +"','"
                    + lblnombre4nota2.getText() +"','"
                    + lblnombre4nota3.getText() +"','"
                    + lblnombre4nota4.getText() +"','"
                    + lblnombre4nota5.getText() +"');");            
            guardar3.executeUpdate();
            
            
            PreparedStatement guardar4 = conect.prepareStatement("Call ActualizarArea('"+id[4]+"','"
                    + lblnombre5nota1.getText() +"','"
                    + lblnombre5nota2.getText() +"','"
                    + lblnombre5nota3.getText() +"','"
                    + lblnombre5nota4.getText() +"','"
                    + lblnombre5nota5.getText() +"');");            
            guardar4.executeUpdate();
            
            
            PreparedStatement guardar5 = conect.prepareStatement("Call ActualizarArea('"+id[5]+"','"
                    + lblnombre6nota1.getText() +"','"
                    + lblnombre6nota2.getText() +"','"
                    + lblnombre6nota3.getText() +"','"
                    + lblnombre6nota4.getText() +"','"
                    + lblnombre6nota5.getText() +"');");            
            guardar5.executeUpdate();
            
            
            PreparedStatement guardar6 = conect.prepareStatement("Call ActualizarArea('"+id[6]+"','"
                    + lblnombre7nota1.getText() +"','"
                    + lblnombre7nota2.getText() +"','"
                    + lblnombre7nota3.getText() +"','"
                    + lblnombre7nota4.getText() +"','"
                    + lblnombre7nota5.getText() +"');");            
            guardar6.executeUpdate();
            
            
            PreparedStatement guardar7 = conect.prepareStatement("Call ActualizarArea('"+id[7]+"','"
                    + lblnombre8nota1.getText() +"','"
                    + lblnombre8nota2.getText() +"','"
                    + lblnombre8nota3.getText() +"','"
                    + lblnombre8nota4.getText() +"','"
                    + lblnombre8nota5.getText() +"');");            
            guardar7.executeUpdate();
            
            
            PreparedStatement guardar8 = conect.prepareStatement("Call ActualizarArea('"+id[8]+"','"
                    + lblnombre9nota1.getText() +"','"
                    + lblnombre9nota2.getText() +"','"
                    + lblnombre9nota3.getText() +"','"
                    + lblnombre9nota4.getText() +"','"
                    + lblnombre9nota5.getText() +"');");            
            guardar8.executeUpdate();
            
            
            PreparedStatement guardar9 = conect.prepareStatement("Call ActualizarArea('"+id[9]+"','"
                    + lblnombre10nota1.getText() +"','"
                    + lblnombre10nota2.getText() +"','"
                    + lblnombre10nota3.getText() +"','"
                    + lblnombre10nota4.getText() +"','"
                    + lblnombre10nota5.getText() +"');");            
            guardar9.executeUpdate();            
            
            
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null,"Error: "+e);
        }
        
        
        
        
    }
    
    
    
    

    @SuppressWarnings("unchecked")
    
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelFondo = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        nombrecolegio = new javax.swing.JLabel();
        lblusuario = new javax.swing.JLabel();
        btnMoverPanel = new javax.swing.JPanel();
        lblCerrar = new javax.swing.JLabel();
        lblCerrarX = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JPanel();
        PanelAlumnos = new javax.swing.JPanel();
        btnactualizar = new javax.swing.JPanel();
        lblactualizar = new javax.swing.JLabel();
        btnlimpiar = new javax.swing.JPanel();
        lbllimpiar = new javax.swing.JLabel();
        PanelScrollNotas = new javax.swing.JScrollPane();
        PanelNotasAlumno = new javax.swing.JPanel();
        separadorH1 = new javax.swing.JSeparator();
        separadorH2 = new javax.swing.JSeparator();
        separadorH3 = new javax.swing.JSeparator();
        separadorH4 = new javax.swing.JSeparator();
        separadorH5 = new javax.swing.JSeparator();
        separadorH6 = new javax.swing.JSeparator();
        separadorV1 = new javax.swing.JSeparator();
        separadorV2 = new javax.swing.JSeparator();
        separadorV3 = new javax.swing.JSeparator();
        separadorV4 = new javax.swing.JSeparator();
        separadorV5 = new javax.swing.JSeparator();
        separadorV6 = new javax.swing.JSeparator();
        separadorV7 = new javax.swing.JSeparator();
        separadorV8 = new javax.swing.JSeparator();
        separadorV9 = new javax.swing.JSeparator();
        lbl1 = new javax.swing.JLabel();
        lblnombre1 = new javax.swing.JLabel();
        lblnombre1nota1 = new javax.swing.JTextField();
        lblnombre1nota2 = new javax.swing.JTextField();
        lblnombre1nota3 = new javax.swing.JTextField();
        lblnombre1nota4 = new javax.swing.JTextField();
        lblnombre1nota5 = new javax.swing.JTextField();
        lbl2 = new javax.swing.JLabel();
        lblnombre2 = new javax.swing.JLabel();
        lblnombre2nota1 = new javax.swing.JTextField();
        lblnombre2nota2 = new javax.swing.JTextField();
        lblnombre2nota3 = new javax.swing.JTextField();
        lblnombre2nota4 = new javax.swing.JTextField();
        lblnombre2nota5 = new javax.swing.JTextField();
        lbl3 = new javax.swing.JLabel();
        lblnombre3 = new javax.swing.JLabel();
        lblnombre3nota1 = new javax.swing.JTextField();
        lblnombre3nota2 = new javax.swing.JTextField();
        lblnombre3nota3 = new javax.swing.JTextField();
        lblnombre3nota4 = new javax.swing.JTextField();
        lblnombre3nota5 = new javax.swing.JTextField();
        lbl4 = new javax.swing.JLabel();
        lblnombre4 = new javax.swing.JLabel();
        lblnombre4nota1 = new javax.swing.JTextField();
        lblnombre4nota2 = new javax.swing.JTextField();
        lblnombre4nota3 = new javax.swing.JTextField();
        lblnombre4nota4 = new javax.swing.JTextField();
        lblnombre4nota5 = new javax.swing.JTextField();
        lbl5 = new javax.swing.JLabel();
        lblnombre5 = new javax.swing.JLabel();
        lblnombre5nota1 = new javax.swing.JTextField();
        lblnombre5nota2 = new javax.swing.JTextField();
        lblnombre5nota3 = new javax.swing.JTextField();
        lblnombre5nota4 = new javax.swing.JTextField();
        lblnombre5nota5 = new javax.swing.JTextField();
        lbl6 = new javax.swing.JLabel();
        lblnombre6 = new javax.swing.JLabel();
        lblnombre6nota1 = new javax.swing.JTextField();
        lblnombre6nota2 = new javax.swing.JTextField();
        lblnombre6nota3 = new javax.swing.JTextField();
        lblnombre6nota4 = new javax.swing.JTextField();
        lblnombre6nota5 = new javax.swing.JTextField();
        lbl7 = new javax.swing.JLabel();
        lblnombre7 = new javax.swing.JLabel();
        lblnombre7nota1 = new javax.swing.JTextField();
        lblnombre7nota2 = new javax.swing.JTextField();
        lblnombre7nota3 = new javax.swing.JTextField();
        lblnombre7nota4 = new javax.swing.JTextField();
        lblnombre7nota5 = new javax.swing.JTextField();
        lbl8 = new javax.swing.JLabel();
        lblnombre8 = new javax.swing.JLabel();
        lblnombre8nota1 = new javax.swing.JTextField();
        lblnombre8nota2 = new javax.swing.JTextField();
        lblnombre8nota3 = new javax.swing.JTextField();
        lblnombre8nota4 = new javax.swing.JTextField();
        lblnombre8nota5 = new javax.swing.JTextField();
        lbl9 = new javax.swing.JLabel();
        lblnombre9 = new javax.swing.JLabel();
        lblnombre9nota1 = new javax.swing.JTextField();
        lblnombre9nota2 = new javax.swing.JTextField();
        lblnombre9nota3 = new javax.swing.JTextField();
        lblnombre9nota4 = new javax.swing.JTextField();
        lblnombre9nota5 = new javax.swing.JTextField();
        lbl10 = new javax.swing.JLabel();
        lblnombre10 = new javax.swing.JLabel();
        lblnombre10nota1 = new javax.swing.JTextField();
        lblnombre10nota2 = new javax.swing.JTextField();
        lblnombre10nota3 = new javax.swing.JTextField();
        lblnombre10nota4 = new javax.swing.JTextField();
        lblnombre10nota5 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator19 = new javax.swing.JSeparator();
        jSeparator20 = new javax.swing.JSeparator();
        jSeparator21 = new javax.swing.JSeparator();
        jSeparator22 = new javax.swing.JSeparator();
        jSeparator23 = new javax.swing.JSeparator();
        jSeparator24 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        lblusuario1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        cboturno = new javax.swing.JComboBox<>();
        cboaño = new javax.swing.JComboBox<>();
        cbocurso = new javax.swing.JComboBox<>();
        btnfiltrar = new javax.swing.JPanel();
        lblFiltrar = new javax.swing.JLabel();
        cboseccion = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        PanelFondo.setBackground(new java.awt.Color(255, 255, 255));
        PanelFondo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PanelFondo.setMinimumSize(new java.awt.Dimension(1450, 850));
        PanelFondo.setPreferredSize(new java.awt.Dimension(1100, 650));
        PanelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/insignia.png"))); // NOI18N
        PanelFondo.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 80, 100));

        nombrecolegio.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        nombrecolegio.setText("I.E \"Manuel Fernando Cabrel Niche\"");
        PanelFondo.add(nombrecolegio, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 370, 70));

        lblusuario.setFont(new java.awt.Font("Roboto Light", 0, 20)); // NOI18N
        lblusuario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblusuario.setText("Marcelo Apazsdasa, Ever Jesus");
        PanelFondo.add(lblusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 70, 410, 50));

        btnMoverPanel.setBackground(new java.awt.Color(255, 255, 255));
        btnMoverPanel.setForeground(new java.awt.Color(0, 204, 204));
        btnMoverPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMoverPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btnMoverPanelMouseDragged(evt);
            }
        });
        btnMoverPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMoverPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMoverPanelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnMoverPanelMousePressed(evt);
            }
        });
        btnMoverPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCerrar.setFont(new java.awt.Font("Roboto Light", 0, 20)); // NOI18N
        lblCerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCerrar.setText("X");
        lblCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCerrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCerrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCerrarMouseExited(evt);
            }
        });
        btnMoverPanel.add(lblCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 0, 50, 40));

        lblCerrarX.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        lblCerrarX.setForeground(new java.awt.Color(255, 255, 255));
        lblCerrarX.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCerrarX.setText("X");
        lblCerrarX.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCerrarX.setMaximumSize(new java.awt.Dimension(12, 24));
        lblCerrarX.setMinimumSize(new java.awt.Dimension(12, 24));
        lblCerrarX.setName(""); // NOI18N
        lblCerrarX.setPreferredSize(new java.awt.Dimension(12, 24));
        btnMoverPanel.add(lblCerrarX, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 0, 50, 40));

        btnCerrar.setBackground(new java.awt.Color(255, 255, 255));
        btnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCerrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCerrarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnCerrarLayout = new javax.swing.GroupLayout(btnCerrar);
        btnCerrar.setLayout(btnCerrarLayout);
        btnCerrarLayout.setHorizontalGroup(
            btnCerrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        btnCerrarLayout.setVerticalGroup(
            btnCerrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        btnMoverPanel.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 0, -1, -1));

        PanelFondo.add(btnMoverPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 40));

        PanelAlumnos.setBackground(new java.awt.Color(236, 167, 57));
        PanelAlumnos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblactualizar.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        lblactualizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblactualizar.setText("Actualizar");
        lblactualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblactualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblactualizarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblactualizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblactualizarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnactualizarLayout = new javax.swing.GroupLayout(btnactualizar);
        btnactualizar.setLayout(btnactualizarLayout);
        btnactualizarLayout.setHorizontalGroup(
            btnactualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblactualizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );
        btnactualizarLayout.setVerticalGroup(
            btnactualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblactualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        PanelAlumnos.add(btnactualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 330, 120, 60));

        lbllimpiar.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        lbllimpiar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbllimpiar.setText("Limpiar");
        lbllimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbllimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbllimpiarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbllimpiarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbllimpiarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnlimpiarLayout = new javax.swing.GroupLayout(btnlimpiar);
        btnlimpiar.setLayout(btnlimpiarLayout);
        btnlimpiarLayout.setHorizontalGroup(
            btnlimpiarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbllimpiar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );
        btnlimpiarLayout.setVerticalGroup(
            btnlimpiarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbllimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        PanelAlumnos.add(btnlimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 330, 120, 60));

        PanelScrollNotas.setPreferredSize(new java.awt.Dimension(1080, 230));

        PanelNotasAlumno.setBackground(new java.awt.Color(236, 167, 57));
        PanelNotasAlumno.setPreferredSize(new java.awt.Dimension(1060, 600));
        PanelNotasAlumno.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        separadorH1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        PanelNotasAlumno.add(separadorH1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 20, 600));

        separadorH2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        PanelNotasAlumno.add(separadorH2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 20, 600));

        separadorH3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        PanelNotasAlumno.add(separadorH3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 0, 20, 600));

        separadorH4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        PanelNotasAlumno.add(separadorH4, new org.netbeans.lib.awtextra.AbsoluteConstraints(745, 0, 20, 600));

        separadorH5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        PanelNotasAlumno.add(separadorH5, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 0, 20, 600));

        separadorH6.setOrientation(javax.swing.SwingConstants.VERTICAL);
        PanelNotasAlumno.add(separadorH6, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 0, 20, 600));

        separadorV1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        separadorV1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        PanelNotasAlumno.add(separadorV1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1070, 10));

        separadorV2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        separadorV2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        PanelNotasAlumno.add(separadorV2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 1070, 10));

        separadorV3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        separadorV3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        PanelNotasAlumno.add(separadorV3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 1070, 10));

        separadorV4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        separadorV4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        PanelNotasAlumno.add(separadorV4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 1070, 10));

        separadorV5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        separadorV5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        PanelNotasAlumno.add(separadorV5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 1070, 10));

        separadorV6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        separadorV6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        PanelNotasAlumno.add(separadorV6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 1070, 10));

        separadorV7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        separadorV7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        PanelNotasAlumno.add(separadorV7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 1070, 10));

        separadorV8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        separadorV8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        PanelNotasAlumno.add(separadorV8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 1070, 10));

        separadorV9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        separadorV9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        PanelNotasAlumno.add(separadorV9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 1070, 10));

        lbl1.setFont(new java.awt.Font("Roboto Light", 1, 30)); // NOI18N
        lbl1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl1.setText("1");
        PanelNotasAlumno.add(lbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, 60, 50));

        lblnombre1.setFont(new java.awt.Font("Roboto Light", 1, 24)); // NOI18N
        lblnombre1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblnombre1.setText("Marcelo Apaza, Ever Jesus");
        PanelNotasAlumno.add(lblnombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 3, 440, 55));

        lblnombre1nota1.setBackground(new java.awt.Color(236, 167, 57));
        lblnombre1nota1.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        lblnombre1nota1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblnombre1nota1.setText("20");
        lblnombre1nota1.setBorder(null);
        lblnombre1nota1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblnombre1nota1ActionPerformed(evt);
            }
        });
        lblnombre1nota1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lblnombre1nota1KeyTyped(evt);
            }
        });
        PanelNotasAlumno.add(lblnombre1nota1, new org.netbeans.lib.awtextra.AbsoluteConstraints(515, 5, 90, 50));

        lblnombre1nota2.setBackground(new java.awt.Color(236, 167, 57));
        lblnombre1nota2.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        lblnombre1nota2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblnombre1nota2.setText("20");
        lblnombre1nota2.setBorder(null);
        lblnombre1nota2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblnombre1nota2ActionPerformed(evt);
            }
        });
        PanelNotasAlumno.add(lblnombre1nota2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 5, 120, 50));

        lblnombre1nota3.setBackground(new java.awt.Color(236, 167, 57));
        lblnombre1nota3.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        lblnombre1nota3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblnombre1nota3.setText("20");
        lblnombre1nota3.setBorder(null);
        lblnombre1nota3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblnombre1nota3ActionPerformed(evt);
            }
        });
        PanelNotasAlumno.add(lblnombre1nota3, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 5, 110, 50));

        lblnombre1nota4.setBackground(new java.awt.Color(236, 167, 57));
        lblnombre1nota4.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        lblnombre1nota4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblnombre1nota4.setText("20");
        lblnombre1nota4.setBorder(null);
        lblnombre1nota4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblnombre1nota4ActionPerformed(evt);
            }
        });
        PanelNotasAlumno.add(lblnombre1nota4, new org.netbeans.lib.awtextra.AbsoluteConstraints(865, 5, 100, 50));

        lblnombre1nota5.setBackground(new java.awt.Color(236, 167, 57));
        lblnombre1nota5.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        lblnombre1nota5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblnombre1nota5.setText("20");
        lblnombre1nota5.setBorder(null);
        lblnombre1nota5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblnombre1nota5ActionPerformed(evt);
            }
        });
        PanelNotasAlumno.add(lblnombre1nota5, new org.netbeans.lib.awtextra.AbsoluteConstraints(975, 5, 90, 50));

        lbl2.setFont(new java.awt.Font("Roboto Light", 1, 30)); // NOI18N
        lbl2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl2.setText("2");
        PanelNotasAlumno.add(lbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 66, 60, 50));

        lblnombre2.setFont(new java.awt.Font("Roboto Light", 1, 24)); // NOI18N
        lblnombre2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblnombre2.setText("Marcelo Apaza, Ever Jesus");
        PanelNotasAlumno.add(lblnombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 64, 440, 55));

        lblnombre2nota1.setBackground(new java.awt.Color(236, 167, 57));
        lblnombre2nota1.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        lblnombre2nota1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblnombre2nota1.setText("20");
        lblnombre2nota1.setBorder(null);
        lblnombre2nota1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblnombre2nota1ActionPerformed(evt);
            }
        });
        PanelNotasAlumno.add(lblnombre2nota1, new org.netbeans.lib.awtextra.AbsoluteConstraints(515, 66, 90, 50));

        lblnombre2nota2.setBackground(new java.awt.Color(236, 167, 57));
        lblnombre2nota2.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        lblnombre2nota2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblnombre2nota2.setText("20");
        lblnombre2nota2.setBorder(null);
        lblnombre2nota2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblnombre2nota2ActionPerformed(evt);
            }
        });
        PanelNotasAlumno.add(lblnombre2nota2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 66, 120, 50));

        lblnombre2nota3.setBackground(new java.awt.Color(236, 167, 57));
        lblnombre2nota3.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        lblnombre2nota3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblnombre2nota3.setText("20");
        lblnombre2nota3.setBorder(null);
        lblnombre2nota3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblnombre2nota3ActionPerformed(evt);
            }
        });
        PanelNotasAlumno.add(lblnombre2nota3, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 66, 110, 50));

        lblnombre2nota4.setBackground(new java.awt.Color(236, 167, 57));
        lblnombre2nota4.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        lblnombre2nota4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblnombre2nota4.setText("20");
        lblnombre2nota4.setBorder(null);
        lblnombre2nota4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblnombre2nota4ActionPerformed(evt);
            }
        });
        PanelNotasAlumno.add(lblnombre2nota4, new org.netbeans.lib.awtextra.AbsoluteConstraints(865, 66, 100, 50));

        lblnombre2nota5.setBackground(new java.awt.Color(236, 167, 57));
        lblnombre2nota5.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        lblnombre2nota5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblnombre2nota5.setText("20");
        lblnombre2nota5.setBorder(null);
        lblnombre2nota5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblnombre2nota5ActionPerformed(evt);
            }
        });
        PanelNotasAlumno.add(lblnombre2nota5, new org.netbeans.lib.awtextra.AbsoluteConstraints(975, 66, 90, 50));

        lbl3.setFont(new java.awt.Font("Roboto Light", 1, 30)); // NOI18N
        lbl3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl3.setText("3");
        PanelNotasAlumno.add(lbl3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 125, 60, 50));

        lblnombre3.setFont(new java.awt.Font("Roboto Light", 1, 24)); // NOI18N
        lblnombre3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblnombre3.setText("Marcelo Apaza, Ever Jesus");
        PanelNotasAlumno.add(lblnombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 123, 440, 55));

        lblnombre3nota1.setBackground(new java.awt.Color(236, 167, 57));
        lblnombre3nota1.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        lblnombre3nota1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblnombre3nota1.setText("20");
        lblnombre3nota1.setBorder(null);
        lblnombre3nota1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblnombre3nota1ActionPerformed(evt);
            }
        });
        PanelNotasAlumno.add(lblnombre3nota1, new org.netbeans.lib.awtextra.AbsoluteConstraints(515, 125, 90, 50));

        lblnombre3nota2.setBackground(new java.awt.Color(236, 167, 57));
        lblnombre3nota2.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        lblnombre3nota2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblnombre3nota2.setText("20");
        lblnombre3nota2.setBorder(null);
        lblnombre3nota2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblnombre3nota2ActionPerformed(evt);
            }
        });
        PanelNotasAlumno.add(lblnombre3nota2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 125, 120, 50));

        lblnombre3nota3.setBackground(new java.awt.Color(236, 167, 57));
        lblnombre3nota3.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        lblnombre3nota3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblnombre3nota3.setText("20");
        lblnombre3nota3.setBorder(null);
        lblnombre3nota3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblnombre3nota3ActionPerformed(evt);
            }
        });
        PanelNotasAlumno.add(lblnombre3nota3, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 125, 110, 50));

        lblnombre3nota4.setBackground(new java.awt.Color(236, 167, 57));
        lblnombre3nota4.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        lblnombre3nota4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblnombre3nota4.setText("20");
        lblnombre3nota4.setBorder(null);
        lblnombre3nota4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblnombre3nota4ActionPerformed(evt);
            }
        });
        PanelNotasAlumno.add(lblnombre3nota4, new org.netbeans.lib.awtextra.AbsoluteConstraints(865, 125, 100, 50));

        lblnombre3nota5.setBackground(new java.awt.Color(236, 167, 57));
        lblnombre3nota5.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        lblnombre3nota5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblnombre3nota5.setText("20");
        lblnombre3nota5.setBorder(null);
        lblnombre3nota5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblnombre3nota5ActionPerformed(evt);
            }
        });
        PanelNotasAlumno.add(lblnombre3nota5, new org.netbeans.lib.awtextra.AbsoluteConstraints(975, 125, 90, 50));

        lbl4.setFont(new java.awt.Font("Roboto Light", 1, 30)); // NOI18N
        lbl4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl4.setText("4");
        PanelNotasAlumno.add(lbl4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 185, 60, 50));

        lblnombre4.setFont(new java.awt.Font("Roboto Light", 1, 24)); // NOI18N
        lblnombre4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblnombre4.setText("Marcelo Apaza, Ever Jesus");
        PanelNotasAlumno.add(lblnombre4, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 184, 440, 55));

        lblnombre4nota1.setBackground(new java.awt.Color(236, 167, 57));
        lblnombre4nota1.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        lblnombre4nota1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblnombre4nota1.setText("20");
        lblnombre4nota1.setBorder(null);
        lblnombre4nota1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblnombre4nota1ActionPerformed(evt);
            }
        });
        PanelNotasAlumno.add(lblnombre4nota1, new org.netbeans.lib.awtextra.AbsoluteConstraints(515, 185, 90, 50));

        lblnombre4nota2.setBackground(new java.awt.Color(236, 167, 57));
        lblnombre4nota2.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        lblnombre4nota2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblnombre4nota2.setText("20");
        lblnombre4nota2.setBorder(null);
        lblnombre4nota2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblnombre4nota2ActionPerformed(evt);
            }
        });
        PanelNotasAlumno.add(lblnombre4nota2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 185, 120, 50));

        lblnombre4nota3.setBackground(new java.awt.Color(236, 167, 57));
        lblnombre4nota3.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        lblnombre4nota3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblnombre4nota3.setText("20");
        lblnombre4nota3.setBorder(null);
        lblnombre4nota3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblnombre4nota3ActionPerformed(evt);
            }
        });
        PanelNotasAlumno.add(lblnombre4nota3, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 185, 110, 50));

        lblnombre4nota4.setBackground(new java.awt.Color(236, 167, 57));
        lblnombre4nota4.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        lblnombre4nota4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblnombre4nota4.setText("20");
        lblnombre4nota4.setBorder(null);
        lblnombre4nota4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblnombre4nota4ActionPerformed(evt);
            }
        });
        PanelNotasAlumno.add(lblnombre4nota4, new org.netbeans.lib.awtextra.AbsoluteConstraints(865, 185, 100, 50));

        lblnombre4nota5.setBackground(new java.awt.Color(236, 167, 57));
        lblnombre4nota5.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        lblnombre4nota5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblnombre4nota5.setText("20");
        lblnombre4nota5.setBorder(null);
        lblnombre4nota5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblnombre4nota5ActionPerformed(evt);
            }
        });
        PanelNotasAlumno.add(lblnombre4nota5, new org.netbeans.lib.awtextra.AbsoluteConstraints(975, 185, 90, 50));

        lbl5.setFont(new java.awt.Font("Roboto Light", 1, 30)); // NOI18N
        lbl5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl5.setText("5");
        PanelNotasAlumno.add(lbl5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 245, 60, 50));

        lblnombre5.setFont(new java.awt.Font("Roboto Light", 1, 24)); // NOI18N
        lblnombre5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblnombre5.setText("Marcelo Apaza, Ever Jesus");
        PanelNotasAlumno.add(lblnombre5, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 244, 440, 55));

        lblnombre5nota1.setBackground(new java.awt.Color(236, 167, 57));
        lblnombre5nota1.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        lblnombre5nota1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblnombre5nota1.setText("20");
        lblnombre5nota1.setBorder(null);
        lblnombre5nota1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblnombre5nota1ActionPerformed(evt);
            }
        });
        PanelNotasAlumno.add(lblnombre5nota1, new org.netbeans.lib.awtextra.AbsoluteConstraints(515, 245, 90, 50));

        lblnombre5nota2.setBackground(new java.awt.Color(236, 167, 57));
        lblnombre5nota2.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        lblnombre5nota2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblnombre5nota2.setText("20");
        lblnombre5nota2.setBorder(null);
        lblnombre5nota2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblnombre5nota2ActionPerformed(evt);
            }
        });
        PanelNotasAlumno.add(lblnombre5nota2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 245, 120, 50));

        lblnombre5nota3.setBackground(new java.awt.Color(236, 167, 57));
        lblnombre5nota3.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        lblnombre5nota3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblnombre5nota3.setText("20");
        lblnombre5nota3.setBorder(null);
        lblnombre5nota3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblnombre5nota3ActionPerformed(evt);
            }
        });
        PanelNotasAlumno.add(lblnombre5nota3, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 245, 110, 50));

        lblnombre5nota4.setBackground(new java.awt.Color(236, 167, 57));
        lblnombre5nota4.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        lblnombre5nota4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblnombre5nota4.setText("20");
        lblnombre5nota4.setBorder(null);
        lblnombre5nota4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblnombre5nota4ActionPerformed(evt);
            }
        });
        PanelNotasAlumno.add(lblnombre5nota4, new org.netbeans.lib.awtextra.AbsoluteConstraints(865, 245, 100, 50));

        lblnombre5nota5.setBackground(new java.awt.Color(236, 167, 57));
        lblnombre5nota5.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        lblnombre5nota5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblnombre5nota5.setText("20");
        lblnombre5nota5.setBorder(null);
        lblnombre5nota5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblnombre5nota5ActionPerformed(evt);
            }
        });
        PanelNotasAlumno.add(lblnombre5nota5, new org.netbeans.lib.awtextra.AbsoluteConstraints(975, 245, 90, 50));

        lbl6.setFont(new java.awt.Font("Roboto Light", 1, 30)); // NOI18N
        lbl6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl6.setText("6");
        PanelNotasAlumno.add(lbl6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 305, 60, 50));

        lblnombre6.setFont(new java.awt.Font("Roboto Light", 1, 24)); // NOI18N
        lblnombre6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblnombre6.setText("Marcelo Apaza, Ever Jesus");
        PanelNotasAlumno.add(lblnombre6, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 303, 440, 55));

        lblnombre6nota1.setBackground(new java.awt.Color(236, 167, 57));
        lblnombre6nota1.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        lblnombre6nota1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblnombre6nota1.setText("20");
        lblnombre6nota1.setBorder(null);
        lblnombre6nota1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblnombre6nota1ActionPerformed(evt);
            }
        });
        PanelNotasAlumno.add(lblnombre6nota1, new org.netbeans.lib.awtextra.AbsoluteConstraints(515, 305, 90, 50));

        lblnombre6nota2.setBackground(new java.awt.Color(236, 167, 57));
        lblnombre6nota2.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        lblnombre6nota2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblnombre6nota2.setText("20");
        lblnombre6nota2.setBorder(null);
        lblnombre6nota2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblnombre6nota2ActionPerformed(evt);
            }
        });
        PanelNotasAlumno.add(lblnombre6nota2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 305, 120, 50));

        lblnombre6nota3.setBackground(new java.awt.Color(236, 167, 57));
        lblnombre6nota3.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        lblnombre6nota3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblnombre6nota3.setText("20");
        lblnombre6nota3.setBorder(null);
        lblnombre6nota3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblnombre6nota3ActionPerformed(evt);
            }
        });
        PanelNotasAlumno.add(lblnombre6nota3, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 305, 110, 50));

        lblnombre6nota4.setBackground(new java.awt.Color(236, 167, 57));
        lblnombre6nota4.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        lblnombre6nota4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblnombre6nota4.setText("20");
        lblnombre6nota4.setBorder(null);
        lblnombre6nota4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblnombre6nota4ActionPerformed(evt);
            }
        });
        PanelNotasAlumno.add(lblnombre6nota4, new org.netbeans.lib.awtextra.AbsoluteConstraints(865, 305, 100, 50));

        lblnombre6nota5.setBackground(new java.awt.Color(236, 167, 57));
        lblnombre6nota5.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        lblnombre6nota5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblnombre6nota5.setText("20");
        lblnombre6nota5.setBorder(null);
        lblnombre6nota5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblnombre6nota5ActionPerformed(evt);
            }
        });
        PanelNotasAlumno.add(lblnombre6nota5, new org.netbeans.lib.awtextra.AbsoluteConstraints(975, 305, 90, 50));

        lbl7.setFont(new java.awt.Font("Roboto Light", 1, 30)); // NOI18N
        lbl7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl7.setText("7");
        PanelNotasAlumno.add(lbl7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 365, 60, 50));

        lblnombre7.setFont(new java.awt.Font("Roboto Light", 1, 24)); // NOI18N
        lblnombre7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblnombre7.setText("Marcelo Apaza, Ever Jesus");
        PanelNotasAlumno.add(lblnombre7, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 364, 440, 55));

        lblnombre7nota1.setBackground(new java.awt.Color(236, 167, 57));
        lblnombre7nota1.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        lblnombre7nota1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblnombre7nota1.setText("20");
        lblnombre7nota1.setBorder(null);
        lblnombre7nota1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblnombre7nota1ActionPerformed(evt);
            }
        });
        PanelNotasAlumno.add(lblnombre7nota1, new org.netbeans.lib.awtextra.AbsoluteConstraints(515, 365, 90, 50));

        lblnombre7nota2.setBackground(new java.awt.Color(236, 167, 57));
        lblnombre7nota2.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        lblnombre7nota2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblnombre7nota2.setText("20");
        lblnombre7nota2.setBorder(null);
        lblnombre7nota2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblnombre7nota2ActionPerformed(evt);
            }
        });
        PanelNotasAlumno.add(lblnombre7nota2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 365, 120, 50));

        lblnombre7nota3.setBackground(new java.awt.Color(236, 167, 57));
        lblnombre7nota3.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        lblnombre7nota3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblnombre7nota3.setText("20");
        lblnombre7nota3.setBorder(null);
        lblnombre7nota3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblnombre7nota3ActionPerformed(evt);
            }
        });
        PanelNotasAlumno.add(lblnombre7nota3, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 365, 110, 50));

        lblnombre7nota4.setBackground(new java.awt.Color(236, 167, 57));
        lblnombre7nota4.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        lblnombre7nota4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblnombre7nota4.setText("20");
        lblnombre7nota4.setBorder(null);
        lblnombre7nota4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblnombre7nota4ActionPerformed(evt);
            }
        });
        PanelNotasAlumno.add(lblnombre7nota4, new org.netbeans.lib.awtextra.AbsoluteConstraints(865, 365, 100, 50));

        lblnombre7nota5.setBackground(new java.awt.Color(236, 167, 57));
        lblnombre7nota5.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        lblnombre7nota5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblnombre7nota5.setText("20");
        lblnombre7nota5.setBorder(null);
        lblnombre7nota5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblnombre7nota5ActionPerformed(evt);
            }
        });
        PanelNotasAlumno.add(lblnombre7nota5, new org.netbeans.lib.awtextra.AbsoluteConstraints(975, 365, 90, 50));

        lbl8.setFont(new java.awt.Font("Roboto Light", 1, 30)); // NOI18N
        lbl8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl8.setText("8");
        PanelNotasAlumno.add(lbl8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 425, 60, 50));

        lblnombre8.setFont(new java.awt.Font("Roboto Light", 1, 24)); // NOI18N
        lblnombre8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblnombre8.setText("Marcelo Apaza, Ever Jesus");
        PanelNotasAlumno.add(lblnombre8, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 424, 440, 55));

        lblnombre8nota1.setBackground(new java.awt.Color(236, 167, 57));
        lblnombre8nota1.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        lblnombre8nota1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblnombre8nota1.setText("20");
        lblnombre8nota1.setBorder(null);
        lblnombre8nota1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblnombre8nota1ActionPerformed(evt);
            }
        });
        PanelNotasAlumno.add(lblnombre8nota1, new org.netbeans.lib.awtextra.AbsoluteConstraints(515, 425, 90, 50));

        lblnombre8nota2.setBackground(new java.awt.Color(236, 167, 57));
        lblnombre8nota2.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        lblnombre8nota2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblnombre8nota2.setText("20");
        lblnombre8nota2.setBorder(null);
        lblnombre8nota2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblnombre8nota2ActionPerformed(evt);
            }
        });
        PanelNotasAlumno.add(lblnombre8nota2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 425, 120, 50));

        lblnombre8nota3.setBackground(new java.awt.Color(236, 167, 57));
        lblnombre8nota3.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        lblnombre8nota3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblnombre8nota3.setText("20");
        lblnombre8nota3.setBorder(null);
        lblnombre8nota3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblnombre8nota3ActionPerformed(evt);
            }
        });
        PanelNotasAlumno.add(lblnombre8nota3, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 425, 110, 50));

        lblnombre8nota4.setBackground(new java.awt.Color(236, 167, 57));
        lblnombre8nota4.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        lblnombre8nota4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblnombre8nota4.setText("20");
        lblnombre8nota4.setBorder(null);
        lblnombre8nota4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblnombre8nota4ActionPerformed(evt);
            }
        });
        PanelNotasAlumno.add(lblnombre8nota4, new org.netbeans.lib.awtextra.AbsoluteConstraints(865, 425, 100, 50));

        lblnombre8nota5.setBackground(new java.awt.Color(236, 167, 57));
        lblnombre8nota5.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        lblnombre8nota5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblnombre8nota5.setText("20");
        lblnombre8nota5.setBorder(null);
        lblnombre8nota5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblnombre8nota5ActionPerformed(evt);
            }
        });
        PanelNotasAlumno.add(lblnombre8nota5, new org.netbeans.lib.awtextra.AbsoluteConstraints(975, 425, 90, 50));

        lbl9.setFont(new java.awt.Font("Roboto Light", 1, 30)); // NOI18N
        lbl9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl9.setText("9");
        PanelNotasAlumno.add(lbl9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 485, 60, 50));

        lblnombre9.setFont(new java.awt.Font("Roboto Light", 1, 24)); // NOI18N
        lblnombre9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblnombre9.setText("Marcelo Apaza, Ever Jesus");
        PanelNotasAlumno.add(lblnombre9, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 484, 440, 55));

        lblnombre9nota1.setBackground(new java.awt.Color(236, 167, 57));
        lblnombre9nota1.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        lblnombre9nota1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblnombre9nota1.setText("20");
        lblnombre9nota1.setBorder(null);
        lblnombre9nota1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblnombre9nota1ActionPerformed(evt);
            }
        });
        PanelNotasAlumno.add(lblnombre9nota1, new org.netbeans.lib.awtextra.AbsoluteConstraints(515, 485, 90, 50));

        lblnombre9nota2.setBackground(new java.awt.Color(236, 167, 57));
        lblnombre9nota2.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        lblnombre9nota2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblnombre9nota2.setText("20");
        lblnombre9nota2.setBorder(null);
        lblnombre9nota2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblnombre9nota2ActionPerformed(evt);
            }
        });
        PanelNotasAlumno.add(lblnombre9nota2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 485, 120, 50));

        lblnombre9nota3.setBackground(new java.awt.Color(236, 167, 57));
        lblnombre9nota3.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        lblnombre9nota3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblnombre9nota3.setText("20");
        lblnombre9nota3.setBorder(null);
        lblnombre9nota3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblnombre9nota3ActionPerformed(evt);
            }
        });
        PanelNotasAlumno.add(lblnombre9nota3, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 485, 110, 50));

        lblnombre9nota4.setBackground(new java.awt.Color(236, 167, 57));
        lblnombre9nota4.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        lblnombre9nota4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblnombre9nota4.setText("20");
        lblnombre9nota4.setBorder(null);
        lblnombre9nota4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblnombre9nota4ActionPerformed(evt);
            }
        });
        PanelNotasAlumno.add(lblnombre9nota4, new org.netbeans.lib.awtextra.AbsoluteConstraints(865, 485, 100, 50));

        lblnombre9nota5.setBackground(new java.awt.Color(236, 167, 57));
        lblnombre9nota5.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        lblnombre9nota5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblnombre9nota5.setText("20");
        lblnombre9nota5.setBorder(null);
        lblnombre9nota5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblnombre9nota5ActionPerformed(evt);
            }
        });
        PanelNotasAlumno.add(lblnombre9nota5, new org.netbeans.lib.awtextra.AbsoluteConstraints(975, 485, 90, 50));

        lbl10.setFont(new java.awt.Font("Roboto Light", 1, 30)); // NOI18N
        lbl10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl10.setText("10");
        PanelNotasAlumno.add(lbl10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 545, 60, 50));

        lblnombre10.setFont(new java.awt.Font("Roboto Light", 1, 24)); // NOI18N
        lblnombre10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblnombre10.setText("Marcelo Apaza, Ever Jesus");
        PanelNotasAlumno.add(lblnombre10, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 544, 440, 55));

        lblnombre10nota1.setBackground(new java.awt.Color(236, 167, 57));
        lblnombre10nota1.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        lblnombre10nota1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblnombre10nota1.setText("20");
        lblnombre10nota1.setBorder(null);
        lblnombre10nota1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblnombre10nota1ActionPerformed(evt);
            }
        });
        PanelNotasAlumno.add(lblnombre10nota1, new org.netbeans.lib.awtextra.AbsoluteConstraints(515, 545, 90, 50));

        lblnombre10nota2.setBackground(new java.awt.Color(236, 167, 57));
        lblnombre10nota2.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        lblnombre10nota2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblnombre10nota2.setText("20");
        lblnombre10nota2.setBorder(null);
        lblnombre10nota2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblnombre10nota2ActionPerformed(evt);
            }
        });
        PanelNotasAlumno.add(lblnombre10nota2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 545, 120, 50));

        lblnombre10nota3.setBackground(new java.awt.Color(236, 167, 57));
        lblnombre10nota3.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        lblnombre10nota3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblnombre10nota3.setText("20");
        lblnombre10nota3.setBorder(null);
        lblnombre10nota3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblnombre10nota3ActionPerformed(evt);
            }
        });
        PanelNotasAlumno.add(lblnombre10nota3, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 545, 110, 50));

        lblnombre10nota4.setBackground(new java.awt.Color(236, 167, 57));
        lblnombre10nota4.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        lblnombre10nota4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblnombre10nota4.setText("20");
        lblnombre10nota4.setBorder(null);
        lblnombre10nota4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblnombre10nota4ActionPerformed(evt);
            }
        });
        PanelNotasAlumno.add(lblnombre10nota4, new org.netbeans.lib.awtextra.AbsoluteConstraints(865, 545, 100, 50));

        lblnombre10nota5.setBackground(new java.awt.Color(236, 167, 57));
        lblnombre10nota5.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        lblnombre10nota5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblnombre10nota5.setText("20");
        lblnombre10nota5.setBorder(null);
        lblnombre10nota5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblnombre10nota5ActionPerformed(evt);
            }
        });
        PanelNotasAlumno.add(lblnombre10nota5, new org.netbeans.lib.awtextra.AbsoluteConstraints(975, 545, 90, 50));

        PanelScrollNotas.setViewportView(PanelNotasAlumno);

        PanelAlumnos.add(PanelScrollNotas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        jLabel4.setText("Nombres");
        PanelAlumnos.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, -1, -1));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        jLabel3.setText("N°");
        PanelAlumnos.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 30, -1, 20));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        jLabel5.setText("Tareas");
        PanelAlumnos.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(531, 30, -1, -1));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        jLabel6.setText("Prácticas");
        PanelAlumnos.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(634, 30, -1, -1));

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        jLabel10.setText("Examen");
        PanelAlumnos.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(769, 10, -1, -1));

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        jLabel11.setText("Parcial");
        PanelAlumnos.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(775, 40, -1, -1));

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        jLabel9.setText("Examen");
        PanelAlumnos.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, -1, -1));

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        jLabel8.setText("Final");
        PanelAlumnos.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 40, -1, -1));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        jLabel2.setText("Actitud");
        PanelAlumnos.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 30, -1, -1));

        jSeparator19.setOrientation(javax.swing.SwingConstants.VERTICAL);
        PanelAlumnos.add(jSeparator19, new org.netbeans.lib.awtextra.AbsoluteConstraints(981, 10, 20, 70));

        jSeparator20.setOrientation(javax.swing.SwingConstants.VERTICAL);
        PanelAlumnos.add(jSeparator20, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 10, 20, 70));

        jSeparator21.setOrientation(javax.swing.SwingConstants.VERTICAL);
        PanelAlumnos.add(jSeparator21, new org.netbeans.lib.awtextra.AbsoluteConstraints(521, 10, 20, 70));

        jSeparator22.setOrientation(javax.swing.SwingConstants.VERTICAL);
        PanelAlumnos.add(jSeparator22, new org.netbeans.lib.awtextra.AbsoluteConstraints(621, 10, 20, 70));

        jSeparator23.setOrientation(javax.swing.SwingConstants.VERTICAL);
        PanelAlumnos.add(jSeparator23, new org.netbeans.lib.awtextra.AbsoluteConstraints(756, 10, 20, 70));

        jSeparator24.setOrientation(javax.swing.SwingConstants.VERTICAL);
        PanelAlumnos.add(jSeparator24, new org.netbeans.lib.awtextra.AbsoluteConstraints(871, 10, 20, 70));

        jSeparator8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSeparator8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        PanelAlumnos.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 75, 1070, 20));

        PanelFondo.add(PanelAlumnos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 1100, 420));

        lblusuario1.setFont(new java.awt.Font("Roboto Medium", 0, 20)); // NOI18N
        lblusuario1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblusuario1.setText("Docente :");
        PanelFondo.add(lblusuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 70, 100, 50));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        PanelFondo.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1100, 20));

        cboturno.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        cboturno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Turno" }));
        PanelFondo.add(cboturno, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, 100, 40));

        cboaño.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        cboaño.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Año" }));
        cboaño.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboañoItemStateChanged(evt);
            }
        });
        cboaño.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboañoMouseClicked(evt);
            }
        });
        cboaño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboañoActionPerformed(evt);
            }
        });
        PanelFondo.add(cboaño, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, 70, 40));

        cbocurso.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        cbocurso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Curso" }));
        cbocurso.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbocursoItemStateChanged(evt);
            }
        });
        cbocurso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbocursoMouseClicked(evt);
            }
        });
        cbocurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbocursoActionPerformed(evt);
            }
        });
        cbocurso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cbocursoKeyReleased(evt);
            }
        });
        PanelFondo.add(cbocurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 260, 40));

        btnfiltrar.setBackground(new java.awt.Color(204, 204, 204));

        lblFiltrar.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        lblFiltrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFiltrar.setText("Filtrar");
        lblFiltrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblFiltrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFiltrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblFiltrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblFiltrarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnfiltrarLayout = new javax.swing.GroupLayout(btnfiltrar);
        btnfiltrar.setLayout(btnfiltrarLayout);
        btnfiltrarLayout.setHorizontalGroup(
            btnfiltrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblFiltrar, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );
        btnfiltrarLayout.setVerticalGroup(
            btnfiltrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblFiltrar, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        PanelFondo.add(btnfiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 160, 110, 40));

        cboseccion.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        cboseccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seccion" }));
        cboseccion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboseccionItemStateChanged(evt);
            }
        });
        cboseccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboseccionMouseClicked(evt);
            }
        });
        cboseccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboseccionActionPerformed(evt);
            }
        });
        PanelFondo.add(cboseccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, 90, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void btnMoverPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMoverPanelMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
        //OK
    }//GEN-LAST:event_btnMoverPanelMousePressed

    private void btnMoverPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMoverPanelMouseExited
        btnMoverPanel.setBackground(Color.white);
        //OK
    }//GEN-LAST:event_btnMoverPanelMouseExited

    private void btnMoverPanelMouseEntered(java.awt.event.MouseEvent evt) {                                           
        btnMoverPanel.setBackground(Color.black);
        //OK
    }  
//GEN-FIRST:event_btnMoverPanelMouseEntered

//GEN-LAST:event_btnMoverPanelMouseEntered

    private void btnMoverPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMoverPanelMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
        //OK
    }//GEN-LAST:event_btnMoverPanelMouseDragged

    private void lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lblCerrarMouseClicked

    private void lblCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseEntered
        lblCerrar.setForeground(Color.white);
        btnCerrar.setBackground(Color.red);
        lblCerrarX.setVisible(true);
    }//GEN-LAST:event_lblCerrarMouseEntered

    private void lblCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseExited
        lblCerrar.setForeground(Color.black);
        btnCerrar.setBackground(Color.white);
        lblCerrarX.hide();
    }//GEN-LAST:event_lblCerrarMouseExited

    private void btnCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseEntered

        lblCerrar.setForeground(Color.red);
        btnCerrar.setBackground(Color.red);
        lblCerrarX.setVisible(true);
    }//GEN-LAST:event_btnCerrarMouseEntered

    private void btnCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseExited
        System.exit(0);
    }//GEN-LAST:event_btnCerrarMouseExited

    private void cbocursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbocursoActionPerformed
        // TODO add your handling code here:
        ComboBoxCurso();
        
    }//GEN-LAST:event_cbocursoActionPerformed

    private void lblnombre1nota1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblnombre1nota1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_lblnombre1nota1ActionPerformed

    private void lblnombre1nota2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblnombre1nota2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblnombre1nota2ActionPerformed

    private void lblnombre1nota3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblnombre1nota3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblnombre1nota3ActionPerformed

    private void lblnombre1nota4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblnombre1nota4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblnombre1nota4ActionPerformed

    private void lblnombre1nota5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblnombre1nota5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblnombre1nota5ActionPerformed

    private void lblnombre2nota1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblnombre2nota1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblnombre2nota1ActionPerformed

    private void lblnombre2nota2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblnombre2nota2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblnombre2nota2ActionPerformed

    private void lblnombre2nota3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblnombre2nota3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblnombre2nota3ActionPerformed

    private void lblnombre2nota4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblnombre2nota4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblnombre2nota4ActionPerformed

    private void lblnombre2nota5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblnombre2nota5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblnombre2nota5ActionPerformed

    private void lblnombre3nota1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblnombre3nota1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblnombre3nota1ActionPerformed

    private void lblnombre3nota2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblnombre3nota2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblnombre3nota2ActionPerformed

    private void lblnombre3nota3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblnombre3nota3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblnombre3nota3ActionPerformed

    private void lblnombre3nota4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblnombre3nota4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblnombre3nota4ActionPerformed

    private void lblnombre3nota5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblnombre3nota5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblnombre3nota5ActionPerformed

    private void lblnombre4nota1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblnombre4nota1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblnombre4nota1ActionPerformed

    private void lblnombre4nota2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblnombre4nota2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblnombre4nota2ActionPerformed

    private void lblnombre4nota3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblnombre4nota3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblnombre4nota3ActionPerformed

    private void lblnombre4nota4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblnombre4nota4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblnombre4nota4ActionPerformed

    private void lblnombre4nota5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblnombre4nota5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblnombre4nota5ActionPerformed

    private void lblnombre5nota1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblnombre5nota1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblnombre5nota1ActionPerformed

    private void lblnombre5nota2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblnombre5nota2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblnombre5nota2ActionPerformed

    private void lblnombre5nota3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblnombre5nota3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblnombre5nota3ActionPerformed

    private void lblnombre5nota4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblnombre5nota4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblnombre5nota4ActionPerformed

    private void lblnombre5nota5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblnombre5nota5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblnombre5nota5ActionPerformed

    private void lblnombre6nota1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblnombre6nota1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblnombre6nota1ActionPerformed

    private void lblnombre6nota2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblnombre6nota2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblnombre6nota2ActionPerformed

    private void lblnombre6nota3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblnombre6nota3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblnombre6nota3ActionPerformed

    private void lblnombre6nota4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblnombre6nota4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblnombre6nota4ActionPerformed

    private void lblnombre6nota5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblnombre6nota5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblnombre6nota5ActionPerformed

    private void lblnombre7nota1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblnombre7nota1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblnombre7nota1ActionPerformed

    private void lblnombre7nota2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblnombre7nota2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblnombre7nota2ActionPerformed

    private void lblnombre7nota3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblnombre7nota3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblnombre7nota3ActionPerformed

    private void lblnombre7nota4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblnombre7nota4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblnombre7nota4ActionPerformed

    private void lblnombre7nota5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblnombre7nota5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblnombre7nota5ActionPerformed

    private void lblnombre8nota1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblnombre8nota1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblnombre8nota1ActionPerformed

    private void lblnombre8nota2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblnombre8nota2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblnombre8nota2ActionPerformed

    private void lblnombre8nota3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblnombre8nota3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblnombre8nota3ActionPerformed

    private void lblnombre8nota4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblnombre8nota4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblnombre8nota4ActionPerformed

    private void lblnombre8nota5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblnombre8nota5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblnombre8nota5ActionPerformed

    private void lblnombre9nota1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblnombre9nota1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblnombre9nota1ActionPerformed

    private void lblnombre9nota2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblnombre9nota2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblnombre9nota2ActionPerformed

    private void lblnombre9nota3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblnombre9nota3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblnombre9nota3ActionPerformed

    private void lblnombre9nota4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblnombre9nota4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblnombre9nota4ActionPerformed

    private void lblnombre9nota5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblnombre9nota5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblnombre9nota5ActionPerformed

    private void lblnombre10nota1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblnombre10nota1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblnombre10nota1ActionPerformed

    private void lblnombre10nota2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblnombre10nota2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblnombre10nota2ActionPerformed

    private void lblnombre10nota3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblnombre10nota3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblnombre10nota3ActionPerformed

    private void lblnombre10nota4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblnombre10nota4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblnombre10nota4ActionPerformed

    private void lblnombre10nota5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblnombre10nota5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblnombre10nota5ActionPerformed

    private void lblFiltrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFiltrarMouseClicked
        // TODO add your handling code here:
        LimpiarDatosAlumnos();
        ListarAlumnos();
        JOptionPane.showMessageDialog(null,"Filtro Exitoso");
        
        
    }//GEN-LAST:event_lblFiltrarMouseClicked

    private void cboañoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboañoMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cboañoMouseClicked

    private void cboseccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboseccionMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cboseccionMouseClicked

    private void cboañoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboañoActionPerformed
        // TODO add your handling code here:        
        ComboBoxAge();
    }//GEN-LAST:event_cboañoActionPerformed

    private void cbocursoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbocursoMouseClicked
        // TODO add your handling code here:
        //AgregarLista();       
    }//GEN-LAST:event_cbocursoMouseClicked

    private void cbocursoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbocursoItemStateChanged
        // TODO add your handling code here:
        //JOptionPane.showMessageDialog(null, cbocurso.getSelectedItem());
        //AQUI MODIFICAR
        //ComboBoxCurso();
    }//GEN-LAST:event_cbocursoItemStateChanged

    private void cboañoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboañoItemStateChanged
        // TODO add your handling code here:
        //ComboBoxAge();
    }//GEN-LAST:event_cboañoItemStateChanged

    private void cboseccionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboseccionItemStateChanged
        // TODO add your handling code here:
        //ComboBoxSeccion();
    }//GEN-LAST:event_cboseccionItemStateChanged

    private void cbocursoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbocursoKeyReleased
        // TODO add your handling code here:
        //JOptionPane.showMessageDialog(null, cbocurso.getSelectedItem());
    }//GEN-LAST:event_cbocursoKeyReleased

    private void cboseccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboseccionActionPerformed
        // TODO add your handling code here:
        
        ComboBoxSeccion();
    }//GEN-LAST:event_cboseccionActionPerformed

    private void lblactualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblactualizarMouseClicked
        // TODO add your handling code here:
        Actualizar();
        JOptionPane.showMessageDialog(null,"Actualizacion Exitosa");
    }//GEN-LAST:event_lblactualizarMouseClicked

    private void lblFiltrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFiltrarMouseEntered
        // TODO add your handling code here:
        lblFiltrar.setForeground(Color.white);
        btnfiltrar.setBackground(Color.BLACK);
    }//GEN-LAST:event_lblFiltrarMouseEntered

    private void lblFiltrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFiltrarMouseExited
        // TODO add your handling code here:
        btnfiltrar.setBackground(new Color(204, 204, 204));
        lblFiltrar.setForeground(new Color(60, 63, 65));
    }//GEN-LAST:event_lblFiltrarMouseExited

    private void lblactualizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblactualizarMouseEntered
        // TODO add your handling code here:
        btnactualizar.setBackground(Color.black);
        lblactualizar.setForeground(Color.white);
    }//GEN-LAST:event_lblactualizarMouseEntered

    private void lblactualizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblactualizarMouseExited
        // TODO add your handling code here:
        btnactualizar.setBackground(Color.white);
        lblactualizar.setForeground(Color.black);
    }//GEN-LAST:event_lblactualizarMouseExited

    private void lbllimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbllimpiarMouseClicked
        // TODO add your handling code here:
        LimpiarDatosAlumnos();
    }//GEN-LAST:event_lbllimpiarMouseClicked

    private void lbllimpiarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbllimpiarMouseEntered
        // TODO add your handling code here:
        lbllimpiar.setForeground(Color.white);
        btnlimpiar.setBackground(Color.black);
    }//GEN-LAST:event_lbllimpiarMouseEntered

    private void lbllimpiarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbllimpiarMouseExited
        // TODO add your handling code here:
        btnlimpiar.setBackground(Color.white);
        lbllimpiar.setForeground(Color.black);
    }//GEN-LAST:event_lbllimpiarMouseExited

    private void lblnombre1nota1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblnombre1nota1KeyTyped
        // TODO add your handling code here:              
    }//GEN-LAST:event_lblnombre1nota1KeyTyped


    
    

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Profesor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelAlumnos;
    private javax.swing.JPanel PanelFondo;
    private javax.swing.JPanel PanelNotasAlumno;
    private javax.swing.JScrollPane PanelScrollNotas;
    private javax.swing.JPanel btnCerrar;
    private javax.swing.JPanel btnMoverPanel;
    private javax.swing.JPanel btnactualizar;
    private javax.swing.JPanel btnfiltrar;
    private javax.swing.JPanel btnlimpiar;
    private javax.swing.JComboBox<String> cboaño;
    private javax.swing.JComboBox<String> cbocurso;
    private javax.swing.JComboBox<String> cboseccion;
    private javax.swing.JComboBox<String> cboturno;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator21;
    private javax.swing.JSeparator jSeparator22;
    private javax.swing.JSeparator jSeparator23;
    private javax.swing.JSeparator jSeparator24;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl10;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lbl4;
    private javax.swing.JLabel lbl5;
    private javax.swing.JLabel lbl6;
    private javax.swing.JLabel lbl7;
    private javax.swing.JLabel lbl8;
    private javax.swing.JLabel lbl9;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JLabel lblCerrarX;
    private javax.swing.JLabel lblFiltrar;
    private javax.swing.JLabel lblactualizar;
    private javax.swing.JLabel lbllimpiar;
    private javax.swing.JLabel lblnombre1;
    private javax.swing.JLabel lblnombre10;
    private javax.swing.JTextField lblnombre10nota1;
    private javax.swing.JTextField lblnombre10nota2;
    private javax.swing.JTextField lblnombre10nota3;
    private javax.swing.JTextField lblnombre10nota4;
    private javax.swing.JTextField lblnombre10nota5;
    private javax.swing.JTextField lblnombre1nota1;
    private javax.swing.JTextField lblnombre1nota2;
    private javax.swing.JTextField lblnombre1nota3;
    private javax.swing.JTextField lblnombre1nota4;
    private javax.swing.JTextField lblnombre1nota5;
    private javax.swing.JLabel lblnombre2;
    private javax.swing.JTextField lblnombre2nota1;
    private javax.swing.JTextField lblnombre2nota2;
    private javax.swing.JTextField lblnombre2nota3;
    private javax.swing.JTextField lblnombre2nota4;
    private javax.swing.JTextField lblnombre2nota5;
    private javax.swing.JLabel lblnombre3;
    private javax.swing.JTextField lblnombre3nota1;
    private javax.swing.JTextField lblnombre3nota2;
    private javax.swing.JTextField lblnombre3nota3;
    private javax.swing.JTextField lblnombre3nota4;
    private javax.swing.JTextField lblnombre3nota5;
    private javax.swing.JLabel lblnombre4;
    private javax.swing.JTextField lblnombre4nota1;
    private javax.swing.JTextField lblnombre4nota2;
    private javax.swing.JTextField lblnombre4nota3;
    private javax.swing.JTextField lblnombre4nota4;
    private javax.swing.JTextField lblnombre4nota5;
    private javax.swing.JLabel lblnombre5;
    private javax.swing.JTextField lblnombre5nota1;
    private javax.swing.JTextField lblnombre5nota2;
    private javax.swing.JTextField lblnombre5nota3;
    private javax.swing.JTextField lblnombre5nota4;
    private javax.swing.JTextField lblnombre5nota5;
    private javax.swing.JLabel lblnombre6;
    private javax.swing.JTextField lblnombre6nota1;
    private javax.swing.JTextField lblnombre6nota2;
    private javax.swing.JTextField lblnombre6nota3;
    private javax.swing.JTextField lblnombre6nota4;
    private javax.swing.JTextField lblnombre6nota5;
    private javax.swing.JLabel lblnombre7;
    private javax.swing.JTextField lblnombre7nota1;
    private javax.swing.JTextField lblnombre7nota2;
    private javax.swing.JTextField lblnombre7nota3;
    private javax.swing.JTextField lblnombre7nota4;
    private javax.swing.JTextField lblnombre7nota5;
    private javax.swing.JLabel lblnombre8;
    private javax.swing.JTextField lblnombre8nota1;
    private javax.swing.JTextField lblnombre8nota2;
    private javax.swing.JTextField lblnombre8nota3;
    private javax.swing.JTextField lblnombre8nota4;
    private javax.swing.JTextField lblnombre8nota5;
    private javax.swing.JLabel lblnombre9;
    private javax.swing.JTextField lblnombre9nota1;
    private javax.swing.JTextField lblnombre9nota2;
    private javax.swing.JTextField lblnombre9nota3;
    private javax.swing.JTextField lblnombre9nota4;
    private javax.swing.JTextField lblnombre9nota5;
    private javax.swing.JLabel lblusuario;
    private javax.swing.JLabel lblusuario1;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel nombrecolegio;
    private javax.swing.JSeparator separadorH1;
    private javax.swing.JSeparator separadorH2;
    private javax.swing.JSeparator separadorH3;
    private javax.swing.JSeparator separadorH4;
    private javax.swing.JSeparator separadorH5;
    private javax.swing.JSeparator separadorH6;
    private javax.swing.JSeparator separadorV1;
    private javax.swing.JSeparator separadorV2;
    private javax.swing.JSeparator separadorV3;
    private javax.swing.JSeparator separadorV4;
    private javax.swing.JSeparator separadorV5;
    private javax.swing.JSeparator separadorV6;
    private javax.swing.JSeparator separadorV7;
    private javax.swing.JSeparator separadorV8;
    private javax.swing.JSeparator separadorV9;
    // End of variables declaration//GEN-END:variables




}
