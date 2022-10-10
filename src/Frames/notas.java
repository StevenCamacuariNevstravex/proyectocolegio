
package Frames;

import Metodos_sql.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class notas extends javax.swing.JPanel {
    
    
    Conexion enlace = new Conexion();
    Connection conect = enlace.conectar();
   
    public notas() {
        initComponents();                          
    }

        
    public void DatosAcceso(String x,String y){
        
        String nombrecurso=null;
        String nombreprofesor=null;
        String apellidoprofesor=null;
        int practica = 0;
        int tarea = 0;
        int exa_parcial = 0;
        int exa_final=0;
        int actitud=0;
        
        try {
            Statement leer = conect.createStatement();
            ResultSet resultado = leer.executeQuery("call Buscar_Nombre_Curso('"+x+"','"+y+"');");//FALTA ASIGNAR ATRIBUTO AL NOMBRE DEL CURSO
            while (resultado.next()) {                
                nombrecurso = resultado.getString(1);
                apellidoprofesor = resultado.getString(2);
                nombreprofesor = resultado.getString(3);
                practica = Integer.parseInt(resultado.getString(4));
                tarea = Integer.parseInt(resultado.getString(5));
                exa_parcial = Integer.parseInt(resultado.getString(6));
                exa_final = Integer.parseInt(resultado.getString(7));
                actitud = Integer.parseInt(resultado.getString(8));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error :"+e);
        }
        
        //CONFIGURAR DATOS DE LAS NOTAS
        lblNombreCurso.setText(nombrecurso);
        lblNombreProfesor.setText(apellidoprofesor+", "+nombreprofesor);
        notapracticas.setText(String.valueOf(practica));
        notatareas.setText(String.valueOf(tarea));
        notaparcial.setText(String.valueOf(exa_parcial));
        notaexafinal.setText(String.valueOf(exa_final));
        notaactitud.setText(String.valueOf(actitud));
        
        double prom=0;
        
        prom = Integer.parseInt(notatareas.getText())*0.15 
                + Integer.parseInt(notapracticas.getText())*0.15 
                + Integer.parseInt(notaparcial.getText())*0.3 
                + Integer.parseInt(notaexafinal.getText())*0.3 
                + Integer.parseInt(notaactitud.getText())*0.1; 
        
        lblPromedio.setText(String.valueOf(prom));
                
    }
    
    
    public double Promedio(double prom){
        
        prom=0;
        
        prom = Integer.parseInt(notatareas.getText())*0.15 
                + Integer.parseInt(notapracticas.getText())*0.15 
                + Integer.parseInt(notaparcial.getText())*0.3 
                + Integer.parseInt(notaexafinal.getText())*0.3 
                + Integer.parseInt(notaactitud.getText())*0.1; 
        return prom;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPrincipal = new javax.swing.JPanel();
        actitud = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        tareas = new javax.swing.JLabel();
        parcial = new javax.swing.JLabel();
        exafinal = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        practicas = new javax.swing.JLabel();
        notaactitud = new javax.swing.JLabel();
        notapracticas = new javax.swing.JLabel();
        notatareas = new javax.swing.JLabel();
        notaparcial = new javax.swing.JLabel();
        notaexafinal = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        PanelDatos = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        lblNombreProfesor = new javax.swing.JLabel();
        lblNombreCurso = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        PanelPromedio = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        lblPromedio = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(690, 420));

        PanelPrincipal.setBackground(new java.awt.Color(236, 167, 57));
        PanelPrincipal.setPreferredSize(new java.awt.Dimension(690, 420));
        PanelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        actitud.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        actitud.setText("Actitud");
        PanelPrincipal.add(actitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 370, 150, -1));

        jLabel37.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        jLabel37.setText("Evaluación");
        PanelPrincipal.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 120, -1));

        tareas.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        tareas.setText("Tareas");
        PanelPrincipal.add(tareas, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, 120, -1));

        parcial.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        parcial.setText("Examen Parcial");
        PanelPrincipal.add(parcial, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 310, 150, -1));

        exafinal.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        exafinal.setText("Examen Final");
        PanelPrincipal.add(exafinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 340, 150, -1));

        jLabel34.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        jLabel34.setText("Nota");
        PanelPrincipal.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, 50, -1));

        practicas.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        practicas.setText("Prácticas");
        PanelPrincipal.add(practicas, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, 120, -1));

        notaactitud.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        notaactitud.setText("20");
        PanelPrincipal.add(notaactitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 370, 30, -1));

        notapracticas.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        notapracticas.setText("20");
        PanelPrincipal.add(notapracticas, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 250, 30, -1));

        notatareas.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        notatareas.setText("20");
        PanelPrincipal.add(notatareas, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 280, 30, -1));

        notaparcial.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        notaparcial.setText("20");
        PanelPrincipal.add(notaparcial, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 310, 30, -1));

        notaexafinal.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        notaexafinal.setText("20");
        PanelPrincipal.add(notaexafinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 340, 30, -1));
        PanelPrincipal.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 390, 270, 10));
        PanelPrincipal.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 270, 270, 10));
        PanelPrincipal.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, 270, 10));
        PanelPrincipal.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 330, 270, 10));
        PanelPrincipal.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 360, 270, 10));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("15%");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PanelPrincipal.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, 30, 20));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("30%");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PanelPrincipal.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 310, 30, 20));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("30%");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PanelPrincipal.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 340, 30, 20));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("10%");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PanelPrincipal.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 370, 30, 20));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("15%");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PanelPrincipal.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, 30, 20));

        PanelDatos.setBackground(new java.awt.Color(255, 153, 0));
        PanelDatos.setPreferredSize(new java.awt.Dimension(690, 420));
        PanelDatos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel33.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        jLabel33.setText("Nombre del profesor:");
        PanelDatos.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel32.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        jLabel32.setText("Nombre del curso:");
        PanelDatos.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 199, -1));

        lblNombreProfesor.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        lblNombreProfesor.setText("Razonamiento Matematico");
        PanelDatos.add(lblNombreProfesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 290, -1));

        lblNombreCurso.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        lblNombreCurso.setText("Razonamiento Matematico");
        PanelDatos.add(lblNombreCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 290, -1));
        PanelDatos.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 570, 20));

        PanelPrincipal.add(PanelDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 590, 100));

        PanelPromedio.setBackground(new java.awt.Color(255, 153, 0));
        PanelPromedio.setPreferredSize(new java.awt.Dimension(690, 420));
        PanelPromedio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel35.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        jLabel35.setText("Promedio Ponderado: ");
        PanelPromedio.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 210, -1));

        lblPromedio.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        lblPromedio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPromedio.setText("20");
        PanelPromedio.add(lblPromedio, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 60, -1));

        PanelPrincipal.add(PanelPromedio, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 310, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelDatos;
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JPanel PanelPromedio;
    private javax.swing.JLabel actitud;
    private javax.swing.JLabel exafinal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel lblNombreCurso;
    private javax.swing.JLabel lblNombreProfesor;
    private javax.swing.JLabel lblPromedio;
    private javax.swing.JLabel notaactitud;
    private javax.swing.JLabel notaexafinal;
    private javax.swing.JLabel notaparcial;
    private javax.swing.JLabel notapracticas;
    private javax.swing.JLabel notatareas;
    private javax.swing.JLabel parcial;
    private javax.swing.JLabel practicas;
    private javax.swing.JLabel tareas;
    // End of variables declaration//GEN-END:variables
}
