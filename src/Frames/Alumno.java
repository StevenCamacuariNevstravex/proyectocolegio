package Frames;
import Metodos_sql.Conexion;
import attributes.alumno;
import java.awt.BorderLayout;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import Frames.Acceso;


public class Alumno extends javax.swing.JFrame {

    
    int xMouse, yMouse;
    String usuario;
    
    Conexion enlace = new Conexion();
    Connection conect = enlace.conectar(); 
        
    public Alumno() {
        initComponents();
        this.setLocationRelativeTo(null);
        Presentacion n = new Presentacion();
        n.setSize(690,420);
        n.setLocation(0,0);
        PanelCambios.removeAll();
        PanelCambios.add(n, BorderLayout.CENTER);
        PanelCambios.revalidate();
        PanelCambios.repaint();       
    }    
    
    public void DatosAcceso(String x){
        String nombre1=null;
        String apellido=null;
        Integer grado=null;
        String seccion=null;        
        try {
            Statement leer = conect.createStatement();            
            ResultSet resultado = leer.executeQuery("call datos_alumno('"+ x + "');");            
            while (resultado.next()) {                
                apellido = resultado.getString(1);
                nombre1 = resultado.getString(2);
                grado = Integer.parseInt(resultado.getString(3)); 
                seccion = resultado.getString(4);
            }            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error: "+e);
        }
        lblNombreAlumno.setText(apellido+", "+nombre1);
        lblGradoSeccion.setText(grado+"to - "+seccion);
        usuario = x; 
    }
        
           
    
    
    
    
    


    @SuppressWarnings("unchecked")   
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        curso3 = new javax.swing.JLabel();
        PanelFondo = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        nombrecolegio = new javax.swing.JLabel();
        lblNombreAlumno = new javax.swing.JLabel();
        lblusuario1 = new javax.swing.JLabel();
        lblusuario2 = new javax.swing.JLabel();
        lblGradoSeccion = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        PanelMenu = new javax.swing.JScrollPane();
        Cursos = new javax.swing.JPanel();
        AreaMatematica = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnRazonamientoMatematico = new javax.swing.JPanel();
        lblRazonamientoMatematico1 = new javax.swing.JLabel();
        btnTrigonometria = new javax.swing.JPanel();
        lblTrigonometria = new javax.swing.JLabel();
        btnAritmetica = new javax.swing.JPanel();
        lblAritmetica = new javax.swing.JLabel();
        btnGeometria = new javax.swing.JPanel();
        lblGeometria = new javax.swing.JLabel();
        btnAlgebra = new javax.swing.JPanel();
        lblAlgebra = new javax.swing.JLabel();
        AreaLetras = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        btnRazonamientoVerbal = new javax.swing.JPanel();
        lblRazonamientoVerbal = new javax.swing.JLabel();
        btnLiteratura = new javax.swing.JPanel();
        lblLiteratura = new javax.swing.JLabel();
        btnLenguaje = new javax.swing.JPanel();
        lblLenguaje = new javax.swing.JLabel();
        btnHistoriaPeru = new javax.swing.JPanel();
        lblHistoriaPeru = new javax.swing.JLabel();
        btnHistoriaUniversal = new javax.swing.JPanel();
        lblHistoriaUniversal = new javax.swing.JLabel();
        AreaCiencias = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        btnFisica = new javax.swing.JPanel();
        lblFisica = new javax.swing.JLabel();
        btnQuimica = new javax.swing.JPanel();
        lblQuimica = new javax.swing.JLabel();
        btnBiologia = new javax.swing.JPanel();
        lblBiologia = new javax.swing.JLabel();
        btnMoverPanelSuperior1 = new javax.swing.JPanel();
        lblCerrar1 = new javax.swing.JLabel();
        lblCerrarX1 = new javax.swing.JLabel();
        btnCerrar1 = new javax.swing.JPanel();
        PanelCambios = new javax.swing.JPanel();

        jLabel1.setText("jLabel1");

        curso3.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        curso3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        curso3.setText("Razon. Matematico");

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
        PanelFondo.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 80, 100));

        nombrecolegio.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        nombrecolegio.setText("I.E \"Manuel Fernando Cabrel Niche\"");
        PanelFondo.add(nombrecolegio, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 370, 70));

        lblNombreAlumno.setFont(new java.awt.Font("Roboto Light", 0, 20)); // NOI18N
        lblNombreAlumno.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNombreAlumno.setText("Marcelo Apaza, Ever Jesus");
        PanelFondo.add(lblNombreAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 80, 410, 50));

        lblusuario1.setFont(new java.awt.Font("Roboto Medium", 0, 20)); // NOI18N
        lblusuario1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblusuario1.setText("Alumno: ");
        PanelFondo.add(lblusuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, 100, 50));

        lblusuario2.setFont(new java.awt.Font("Roboto Medium", 0, 20)); // NOI18N
        lblusuario2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblusuario2.setText("Año / Sección:");
        PanelFondo.add(lblusuario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, 130, 50));

        lblGradoSeccion.setFont(new java.awt.Font("Roboto Light", 0, 20)); // NOI18N
        lblGradoSeccion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblGradoSeccion.setText("5to - A");
        PanelFondo.add(lblGradoSeccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 130, 360, 50));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        PanelFondo.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1100, 20));

        PanelMenu.setToolTipText("");
        PanelMenu.setPreferredSize(new java.awt.Dimension(200, 400));

        Cursos.setBackground(new java.awt.Color(51, 51, 51));
        Cursos.setPreferredSize(new java.awt.Dimension(200, 1000));
        Cursos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AreaMatematica.setBackground(new java.awt.Color(255, 255, 255));
        AreaMatematica.setFont(new java.awt.Font("Roboto Black", 1, 40)); // NOI18N
        AreaMatematica.setForeground(new java.awt.Color(184, 25, 43));
        AreaMatematica.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AreaMatematica.setText("Matemáticas");
        AreaMatematica.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        Cursos.add(AreaMatematica, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 400, 50));
        Cursos.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 400, 20));

        btnRazonamientoMatematico.setBackground(new java.awt.Color(51, 51, 51));
        btnRazonamientoMatematico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRazonamientoMatematico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRazonamientoMatematicoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRazonamientoMatematicoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRazonamientoMatematicoMouseExited(evt);
            }
        });

        lblRazonamientoMatematico1.setBackground(new java.awt.Color(255, 255, 255));
        lblRazonamientoMatematico1.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        lblRazonamientoMatematico1.setForeground(new java.awt.Color(255, 255, 255));
        lblRazonamientoMatematico1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRazonamientoMatematico1.setText("Razonamiento Matemático");
        lblRazonamientoMatematico1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRazonamientoMatematico1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblRazonamientoMatematico1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblRazonamientoMatematico1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnRazonamientoMatematicoLayout = new javax.swing.GroupLayout(btnRazonamientoMatematico);
        btnRazonamientoMatematico.setLayout(btnRazonamientoMatematicoLayout);
        btnRazonamientoMatematicoLayout.setHorizontalGroup(
            btnRazonamientoMatematicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblRazonamientoMatematico1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        btnRazonamientoMatematicoLayout.setVerticalGroup(
            btnRazonamientoMatematicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblRazonamientoMatematico1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        Cursos.add(btnRazonamientoMatematico, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 400, 60));

        btnTrigonometria.setBackground(new java.awt.Color(51, 51, 51));
        btnTrigonometria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTrigonometria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTrigonometriaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTrigonometriaMouseExited(evt);
            }
        });

        lblTrigonometria.setBackground(new java.awt.Color(255, 255, 255));
        lblTrigonometria.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        lblTrigonometria.setForeground(new java.awt.Color(255, 255, 255));
        lblTrigonometria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTrigonometria.setText("Trigonometría");
        lblTrigonometria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTrigonometriaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblTrigonometriaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblTrigonometriaMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnTrigonometriaLayout = new javax.swing.GroupLayout(btnTrigonometria);
        btnTrigonometria.setLayout(btnTrigonometriaLayout);
        btnTrigonometriaLayout.setHorizontalGroup(
            btnTrigonometriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTrigonometria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        btnTrigonometriaLayout.setVerticalGroup(
            btnTrigonometriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTrigonometria, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        Cursos.add(btnTrigonometria, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 400, 60));

        btnAritmetica.setBackground(new java.awt.Color(51, 51, 51));
        btnAritmetica.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAritmetica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAritmeticaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAritmeticaMouseExited(evt);
            }
        });

        lblAritmetica.setBackground(new java.awt.Color(255, 255, 255));
        lblAritmetica.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        lblAritmetica.setForeground(new java.awt.Color(255, 255, 255));
        lblAritmetica.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAritmetica.setText("Aritmética");
        lblAritmetica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAritmeticaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblAritmeticaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblAritmeticaMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnAritmeticaLayout = new javax.swing.GroupLayout(btnAritmetica);
        btnAritmetica.setLayout(btnAritmeticaLayout);
        btnAritmeticaLayout.setHorizontalGroup(
            btnAritmeticaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAritmetica, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        btnAritmeticaLayout.setVerticalGroup(
            btnAritmeticaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAritmetica, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        Cursos.add(btnAritmetica, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 400, -1));

        btnGeometria.setBackground(new java.awt.Color(51, 51, 51));
        btnGeometria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGeometria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGeometriaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGeometriaMouseExited(evt);
            }
        });

        lblGeometria.setBackground(new java.awt.Color(255, 255, 255));
        lblGeometria.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        lblGeometria.setForeground(new java.awt.Color(255, 255, 255));
        lblGeometria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGeometria.setText("Geometría");
        lblGeometria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGeometriaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblGeometriaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblGeometriaMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnGeometriaLayout = new javax.swing.GroupLayout(btnGeometria);
        btnGeometria.setLayout(btnGeometriaLayout);
        btnGeometriaLayout.setHorizontalGroup(
            btnGeometriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblGeometria, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        btnGeometriaLayout.setVerticalGroup(
            btnGeometriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblGeometria, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        Cursos.add(btnGeometria, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 400, -1));

        btnAlgebra.setBackground(new java.awt.Color(51, 51, 51));
        btnAlgebra.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAlgebra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAlgebraMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAlgebraMouseExited(evt);
            }
        });

        lblAlgebra.setBackground(new java.awt.Color(255, 255, 255));
        lblAlgebra.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        lblAlgebra.setForeground(new java.awt.Color(255, 255, 255));
        lblAlgebra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAlgebra.setText("Álgebra");
        lblAlgebra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAlgebraMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblAlgebraMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblAlgebraMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnAlgebraLayout = new javax.swing.GroupLayout(btnAlgebra);
        btnAlgebra.setLayout(btnAlgebraLayout);
        btnAlgebraLayout.setHorizontalGroup(
            btnAlgebraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAlgebra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        btnAlgebraLayout.setVerticalGroup(
            btnAlgebraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAlgebra, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        Cursos.add(btnAlgebra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 400, -1));

        AreaLetras.setBackground(new java.awt.Color(255, 255, 255));
        AreaLetras.setFont(new java.awt.Font("Roboto Black", 1, 36)); // NOI18N
        AreaLetras.setForeground(new java.awt.Color(212, 197, 46));
        AreaLetras.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AreaLetras.setText("Letras");
        AreaLetras.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        Cursos.add(AreaLetras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 400, 50));
        Cursos.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 400, 20));

        btnRazonamientoVerbal.setBackground(new java.awt.Color(51, 51, 51));
        btnRazonamientoVerbal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblRazonamientoVerbal.setBackground(new java.awt.Color(255, 255, 255));
        lblRazonamientoVerbal.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        lblRazonamientoVerbal.setForeground(new java.awt.Color(255, 255, 255));
        lblRazonamientoVerbal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRazonamientoVerbal.setText("Razonamiento Verbal");
        lblRazonamientoVerbal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRazonamientoVerbalMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblRazonamientoVerbalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblRazonamientoVerbalMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnRazonamientoVerbalLayout = new javax.swing.GroupLayout(btnRazonamientoVerbal);
        btnRazonamientoVerbal.setLayout(btnRazonamientoVerbalLayout);
        btnRazonamientoVerbalLayout.setHorizontalGroup(
            btnRazonamientoVerbalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblRazonamientoVerbal, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        btnRazonamientoVerbalLayout.setVerticalGroup(
            btnRazonamientoVerbalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblRazonamientoVerbal, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        Cursos.add(btnRazonamientoVerbal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 400, -1));

        btnLiteratura.setBackground(new java.awt.Color(51, 51, 51));
        btnLiteratura.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblLiteratura.setBackground(new java.awt.Color(255, 255, 255));
        lblLiteratura.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        lblLiteratura.setForeground(new java.awt.Color(255, 255, 255));
        lblLiteratura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLiteratura.setText("Literatura");
        lblLiteratura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLiteraturaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblLiteraturaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblLiteraturaMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnLiteraturaLayout = new javax.swing.GroupLayout(btnLiteratura);
        btnLiteratura.setLayout(btnLiteraturaLayout);
        btnLiteraturaLayout.setHorizontalGroup(
            btnLiteraturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLiteratura, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        btnLiteraturaLayout.setVerticalGroup(
            btnLiteraturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLiteratura, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        Cursos.add(btnLiteratura, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 400, -1));

        btnLenguaje.setBackground(new java.awt.Color(51, 51, 51));
        btnLenguaje.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblLenguaje.setBackground(new java.awt.Color(255, 255, 255));
        lblLenguaje.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        lblLenguaje.setForeground(new java.awt.Color(255, 255, 255));
        lblLenguaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLenguaje.setText("Lenguaje");
        lblLenguaje.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLenguajeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblLenguajeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblLenguajeMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnLenguajeLayout = new javax.swing.GroupLayout(btnLenguaje);
        btnLenguaje.setLayout(btnLenguajeLayout);
        btnLenguajeLayout.setHorizontalGroup(
            btnLenguajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLenguaje, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        btnLenguajeLayout.setVerticalGroup(
            btnLenguajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLenguaje, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        Cursos.add(btnLenguaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, 400, -1));

        btnHistoriaPeru.setBackground(new java.awt.Color(51, 51, 51));
        btnHistoriaPeru.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblHistoriaPeru.setBackground(new java.awt.Color(255, 255, 255));
        lblHistoriaPeru.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        lblHistoriaPeru.setForeground(new java.awt.Color(255, 255, 255));
        lblHistoriaPeru.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHistoriaPeru.setText("Historia del Perú");
        lblHistoriaPeru.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHistoriaPeruMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblHistoriaPeruMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblHistoriaPeruMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnHistoriaPeruLayout = new javax.swing.GroupLayout(btnHistoriaPeru);
        btnHistoriaPeru.setLayout(btnHistoriaPeruLayout);
        btnHistoriaPeruLayout.setHorizontalGroup(
            btnHistoriaPeruLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHistoriaPeru, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        btnHistoriaPeruLayout.setVerticalGroup(
            btnHistoriaPeruLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHistoriaPeru, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        Cursos.add(btnHistoriaPeru, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 620, 400, -1));

        btnHistoriaUniversal.setBackground(new java.awt.Color(51, 51, 51));
        btnHistoriaUniversal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblHistoriaUniversal.setBackground(new java.awt.Color(255, 255, 255));
        lblHistoriaUniversal.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        lblHistoriaUniversal.setForeground(new java.awt.Color(255, 255, 255));
        lblHistoriaUniversal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHistoriaUniversal.setText("Historia Universal");
        lblHistoriaUniversal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHistoriaUniversalMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblHistoriaUniversalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblHistoriaUniversalMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnHistoriaUniversalLayout = new javax.swing.GroupLayout(btnHistoriaUniversal);
        btnHistoriaUniversal.setLayout(btnHistoriaUniversalLayout);
        btnHistoriaUniversalLayout.setHorizontalGroup(
            btnHistoriaUniversalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHistoriaUniversal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        btnHistoriaUniversalLayout.setVerticalGroup(
            btnHistoriaUniversalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHistoriaUniversal, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        Cursos.add(btnHistoriaUniversal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 680, 400, -1));

        AreaCiencias.setBackground(new java.awt.Color(255, 255, 255));
        AreaCiencias.setFont(new java.awt.Font("Roboto Black", 1, 36)); // NOI18N
        AreaCiencias.setForeground(new java.awt.Color(16, 147, 41));
        AreaCiencias.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AreaCiencias.setText("Ciencias");
        AreaCiencias.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        Cursos.add(AreaCiencias, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 750, 400, 50));
        Cursos.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 800, 400, 20));

        btnFisica.setBackground(new java.awt.Color(51, 51, 51));
        btnFisica.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblFisica.setBackground(new java.awt.Color(255, 255, 255));
        lblFisica.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        lblFisica.setForeground(new java.awt.Color(255, 255, 255));
        lblFisica.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFisica.setText("Física ");
        lblFisica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFisicaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblFisicaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblFisicaMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnFisicaLayout = new javax.swing.GroupLayout(btnFisica);
        btnFisica.setLayout(btnFisicaLayout);
        btnFisicaLayout.setHorizontalGroup(
            btnFisicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblFisica, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        btnFisicaLayout.setVerticalGroup(
            btnFisicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblFisica, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        Cursos.add(btnFisica, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 810, 400, -1));

        btnQuimica.setBackground(new java.awt.Color(51, 51, 51));
        btnQuimica.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblQuimica.setBackground(new java.awt.Color(255, 255, 255));
        lblQuimica.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        lblQuimica.setForeground(new java.awt.Color(255, 255, 255));
        lblQuimica.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQuimica.setText("Química");
        lblQuimica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQuimicaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblQuimicaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblQuimicaMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnQuimicaLayout = new javax.swing.GroupLayout(btnQuimica);
        btnQuimica.setLayout(btnQuimicaLayout);
        btnQuimicaLayout.setHorizontalGroup(
            btnQuimicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblQuimica, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        btnQuimicaLayout.setVerticalGroup(
            btnQuimicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblQuimica, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        Cursos.add(btnQuimica, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 870, 400, -1));

        btnBiologia.setBackground(new java.awt.Color(51, 51, 51));
        btnBiologia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblBiologia.setBackground(new java.awt.Color(255, 255, 255));
        lblBiologia.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        lblBiologia.setForeground(new java.awt.Color(255, 255, 255));
        lblBiologia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBiologia.setText("Biología");
        lblBiologia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBiologiaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBiologiaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBiologiaMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnBiologiaLayout = new javax.swing.GroupLayout(btnBiologia);
        btnBiologia.setLayout(btnBiologiaLayout);
        btnBiologiaLayout.setHorizontalGroup(
            btnBiologiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblBiologia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        btnBiologiaLayout.setVerticalGroup(
            btnBiologiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblBiologia, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        Cursos.add(btnBiologia, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 930, 400, -1));

        PanelMenu.setViewportView(Cursos);

        PanelFondo.add(PanelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 410, 420));

        btnMoverPanelSuperior1.setBackground(new java.awt.Color(255, 255, 255));
        btnMoverPanelSuperior1.setForeground(new java.awt.Color(0, 204, 204));
        btnMoverPanelSuperior1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMoverPanelSuperior1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btnMoverPanelSuperior1MouseDragged(evt);
            }
        });
        btnMoverPanelSuperior1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMoverPanelSuperior1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMoverPanelSuperior1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnMoverPanelSuperior1MousePressed(evt);
            }
        });
        btnMoverPanelSuperior1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCerrar1.setFont(new java.awt.Font("Roboto Light", 0, 20)); // NOI18N
        lblCerrar1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCerrar1.setText("X");
        lblCerrar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCerrar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCerrar1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCerrar1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCerrar1MouseExited(evt);
            }
        });
        btnMoverPanelSuperior1.add(lblCerrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 0, 50, 40));

        lblCerrarX1.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        lblCerrarX1.setForeground(new java.awt.Color(255, 255, 255));
        lblCerrarX1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCerrarX1.setText("X");
        lblCerrarX1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCerrarX1.setMaximumSize(new java.awt.Dimension(12, 24));
        lblCerrarX1.setMinimumSize(new java.awt.Dimension(12, 24));
        lblCerrarX1.setName(""); // NOI18N
        lblCerrarX1.setPreferredSize(new java.awt.Dimension(12, 24));
        btnMoverPanelSuperior1.add(lblCerrarX1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 0, 50, 40));

        btnCerrar1.setBackground(new java.awt.Color(255, 255, 255));
        btnCerrar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCerrar1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCerrar1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnCerrar1Layout = new javax.swing.GroupLayout(btnCerrar1);
        btnCerrar1.setLayout(btnCerrar1Layout);
        btnCerrar1Layout.setHorizontalGroup(
            btnCerrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        btnCerrar1Layout.setVerticalGroup(
            btnCerrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        btnMoverPanelSuperior1.add(btnCerrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 0, -1, -1));

        PanelFondo.add(btnMoverPanelSuperior1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 40));

        PanelCambios.setBackground(new java.awt.Color(255, 255, 255));
        PanelCambios.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout PanelCambiosLayout = new javax.swing.GroupLayout(PanelCambios);
        PanelCambios.setLayout(PanelCambiosLayout);
        PanelCambiosLayout.setHorizontalGroup(
            PanelCambiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 688, Short.MAX_VALUE)
        );
        PanelCambiosLayout.setVerticalGroup(
            PanelCambiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 418, Short.MAX_VALUE)
        );

        PanelFondo.add(PanelCambios, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 210, 690, 420));

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
     
    private void lblCerrar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrar1MouseClicked
    System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_lblCerrar1MouseClicked

    private void lblCerrar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrar1MouseEntered
    lblCerrar1.setForeground(Color.white);
    btnCerrar1.setBackground(Color.red);
    lblCerrarX1.setVisible(true);
// TODO add your handling code here:
    }//GEN-LAST:event_lblCerrar1MouseEntered

    private void lblCerrar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrar1MouseExited
    lblCerrar1.setForeground(Color.white);
    btnCerrar1.setBackground(Color.red);
    lblCerrarX1.hide();
    // TODO add your handling code here:
    }//GEN-LAST:event_lblCerrar1MouseExited

    private void btnCerrar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrar1MouseEntered
        lblCerrar1.setForeground(Color.red);
        lblCerrar1.setBackground(Color.red);
        lblCerrarX1.setVisible(true);
// TODO add your handling code here:
    }//GEN-LAST:event_btnCerrar1MouseEntered

    private void btnCerrar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrar1MouseExited
    System.exit(0);
    // TODO add your handling code here:
    }//GEN-LAST:event_btnCerrar1MouseExited

    private void btnMoverPanelSuperior1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMoverPanelSuperior1MouseDragged
    int x = evt.getXOnScreen();
    int y = evt.getYOnScreen();
    this.setLocation(x - xMouse, y - yMouse);
// TODO add your handling code here:
    }//GEN-LAST:event_btnMoverPanelSuperior1MouseDragged

    private void btnMoverPanelSuperior1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMoverPanelSuperior1MouseEntered
    btnMoverPanelSuperior1.setBackground(Color.black);
// TODO add your handling code here:
    }//GEN-LAST:event_btnMoverPanelSuperior1MouseEntered

    private void btnMoverPanelSuperior1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMoverPanelSuperior1MouseExited
    btnMoverPanelSuperior1.setBackground(Color.white);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMoverPanelSuperior1MouseExited

    private void btnMoverPanelSuperior1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMoverPanelSuperior1MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
// TODO add your handling code here:
    }//GEN-LAST:event_btnMoverPanelSuperior1MousePressed

    private void btnRazonamientoMatematicoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRazonamientoMatematicoMouseEntered

    }//GEN-LAST:event_btnRazonamientoMatematicoMouseEntered

    private void btnRazonamientoMatematicoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRazonamientoMatematicoMouseExited

    }//GEN-LAST:event_btnRazonamientoMatematicoMouseExited

    private void btnTrigonometriaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrigonometriaMouseEntered

    }//GEN-LAST:event_btnTrigonometriaMouseEntered

    private void btnTrigonometriaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrigonometriaMouseExited

    }//GEN-LAST:event_btnTrigonometriaMouseExited

    private void btnAritmeticaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAritmeticaMouseEntered

    }//GEN-LAST:event_btnAritmeticaMouseEntered

    private void btnAritmeticaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAritmeticaMouseExited

    }//GEN-LAST:event_btnAritmeticaMouseExited

    private void btnGeometriaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGeometriaMouseEntered

    }//GEN-LAST:event_btnGeometriaMouseEntered

    private void btnGeometriaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGeometriaMouseExited

    }//GEN-LAST:event_btnGeometriaMouseExited

    private void btnAlgebraMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlgebraMouseEntered

    }//GEN-LAST:event_btnAlgebraMouseEntered

    private void btnAlgebraMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlgebraMouseExited

    }//GEN-LAST:event_btnAlgebraMouseExited

    
    //AREA DE NUMEROS
    private void lblAlgebraMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAlgebraMouseEntered
        btnAlgebra.setBackground(Color.black); 
    }//GEN-LAST:event_lblAlgebraMouseEntered

    private void lblAlgebraMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAlgebraMouseExited
        btnAlgebra.setBackground(new Color(51,51,51));
    }//GEN-LAST:event_lblAlgebraMouseExited

    private void lblRazonamientoMatematico1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRazonamientoMatematico1MouseEntered
        btnRazonamientoMatematico.setBackground(Color.black);
    }//GEN-LAST:event_lblRazonamientoMatematico1MouseEntered

    private void lblRazonamientoMatematico1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRazonamientoMatematico1MouseExited
        btnRazonamientoMatematico.setBackground(new Color(51,51,51));
    }//GEN-LAST:event_lblRazonamientoMatematico1MouseExited

    private void lblTrigonometriaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTrigonometriaMouseEntered
        btnTrigonometria.setBackground(Color.black);
    }//GEN-LAST:event_lblTrigonometriaMouseEntered

    private void lblTrigonometriaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTrigonometriaMouseExited
        btnTrigonometria.setBackground(new Color(51,51,51));
    }//GEN-LAST:event_lblTrigonometriaMouseExited

    private void lblAritmeticaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAritmeticaMouseEntered
        btnAritmetica.setBackground(Color.black);
    }//GEN-LAST:event_lblAritmeticaMouseEntered

    private void lblAritmeticaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAritmeticaMouseExited
        btnAritmetica.setBackground(new Color(51,51,51));
    }//GEN-LAST:event_lblAritmeticaMouseExited

    private void lblGeometriaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGeometriaMouseEntered
        btnGeometria.setBackground(Color.black);
    }//GEN-LAST:event_lblGeometriaMouseEntered

    private void lblGeometriaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGeometriaMouseExited
        btnGeometria.setBackground(new Color(51,51,51));
    }//GEN-LAST:event_lblGeometriaMouseExited

//AREA DE LETRAS    
    private void lblRazonamientoVerbalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRazonamientoVerbalMouseEntered
        btnRazonamientoVerbal.setBackground(Color.black);
    }//GEN-LAST:event_lblRazonamientoVerbalMouseEntered

    private void lblRazonamientoVerbalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRazonamientoVerbalMouseExited
        btnRazonamientoVerbal.setBackground(new Color(51,51,51));
    }//GEN-LAST:event_lblRazonamientoVerbalMouseExited

    private void lblLiteraturaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLiteraturaMouseEntered
        btnLiteratura.setBackground(Color.black);
    }//GEN-LAST:event_lblLiteraturaMouseEntered

    private void lblLiteraturaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLiteraturaMouseExited
        btnLiteratura.setBackground(new Color(51,51,51));
    }//GEN-LAST:event_lblLiteraturaMouseExited

    private void lblHistoriaPeruMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHistoriaPeruMouseEntered
        btnHistoriaPeru.setBackground(Color.black);
    }//GEN-LAST:event_lblHistoriaPeruMouseEntered

    private void lblHistoriaPeruMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHistoriaPeruMouseExited
        btnHistoriaPeru.setBackground(new Color(51,51,51));
    }//GEN-LAST:event_lblHistoriaPeruMouseExited

    private void lblHistoriaUniversalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHistoriaUniversalMouseEntered
        btnHistoriaUniversal.setBackground(Color.black);
    }//GEN-LAST:event_lblHistoriaUniversalMouseEntered

    private void lblHistoriaUniversalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHistoriaUniversalMouseExited
        btnHistoriaUniversal.setBackground(new Color(51,51,51));
    }//GEN-LAST:event_lblHistoriaUniversalMouseExited

    //AREA DE CIENCIAS   
    private void lblFisicaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFisicaMouseEntered
        btnFisica.setBackground(Color.black);
    }//GEN-LAST:event_lblFisicaMouseEntered

    private void lblFisicaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFisicaMouseExited
        btnFisica.setBackground(new Color(51,51,51));
    }//GEN-LAST:event_lblFisicaMouseExited

    private void lblQuimicaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuimicaMouseEntered
        btnQuimica.setBackground(Color.black);
    }//GEN-LAST:event_lblQuimicaMouseEntered

    private void lblQuimicaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuimicaMouseExited
        btnQuimica.setBackground(new Color(51,51,51));
    }//GEN-LAST:event_lblQuimicaMouseExited

    private void lblBiologiaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBiologiaMouseEntered
        btnBiologia.setBackground(Color.black);
    }//GEN-LAST:event_lblBiologiaMouseEntered

    private void lblBiologiaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBiologiaMouseExited
        btnBiologia.setBackground(new Color(51,51,51));
    }//GEN-LAST:event_lblBiologiaMouseExited

    private void lblLenguajeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLenguajeMouseEntered
        btnLenguaje.setBackground(Color.black);
    }//GEN-LAST:event_lblLenguajeMouseEntered

    private void lblLenguajeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLenguajeMouseExited
        btnLenguaje.setBackground(new Color(51,51,51));
    }//GEN-LAST:event_lblLenguajeMouseExited

    private void btnRazonamientoMatematicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRazonamientoMatematicoMouseClicked
        // TODO add your handling code here:
        
              
                
    }//GEN-LAST:event_btnRazonamientoMatematicoMouseClicked

    private void lblRazonamientoMatematico1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRazonamientoMatematico1MouseClicked
        // TODO add your handling code here:
        
        notas n = new notas();
        n.DatosAcceso(usuario,"razonamiento matematico");
        n.setSize(690,420);
        n.setLocation(0,0);
        PanelCambios.removeAll();
        PanelCambios.add(n,BorderLayout.CENTER);
        PanelCambios.revalidate();
        PanelCambios.repaint();                        
    }//GEN-LAST:event_lblRazonamientoMatematico1MouseClicked

    private void lblTrigonometriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTrigonometriaMouseClicked
        // TODO add your handling code here:
        notas n = new notas();
        n.DatosAcceso(usuario,"trigonometria");
        n.setSize(690,420);
        n.setLocation(0,0);
        PanelCambios.removeAll();
        PanelCambios.add(n,BorderLayout.CENTER);
        PanelCambios.revalidate();
        PanelCambios.repaint();   
    }//GEN-LAST:event_lblTrigonometriaMouseClicked

    private void lblAritmeticaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAritmeticaMouseClicked
        // TODO add your handling code here:
        notas n = new notas();
        n.DatosAcceso(usuario,"aritmetica");
        n.setSize(690,420);
        n.setLocation(0,0);
        PanelCambios.removeAll();
        PanelCambios.add(n,BorderLayout.CENTER);
        PanelCambios.revalidate();
        PanelCambios.repaint();   
    }//GEN-LAST:event_lblAritmeticaMouseClicked

    private void lblGeometriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGeometriaMouseClicked
        // TODO add your handling code here:
        notas n = new notas();
        n.DatosAcceso(usuario,"geometria");
        n.setSize(690,420);
        n.setLocation(0,0);
        PanelCambios.removeAll();
        PanelCambios.add(n,BorderLayout.CENTER);
        PanelCambios.revalidate();
        PanelCambios.repaint();
    }//GEN-LAST:event_lblGeometriaMouseClicked

    private void lblAlgebraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAlgebraMouseClicked
        // TODO add your handling code here:
        notas n = new notas();
        n.DatosAcceso(usuario,"algebra");
        n.setSize(690,420);
        n.setLocation(0,0);
        PanelCambios.removeAll();
        PanelCambios.add(n,BorderLayout.CENTER);
        PanelCambios.revalidate();
        PanelCambios.repaint();
    }//GEN-LAST:event_lblAlgebraMouseClicked

    private void lblRazonamientoVerbalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRazonamientoVerbalMouseClicked
        // TODO add your handling code here:
        notas n = new notas();
        n.DatosAcceso(usuario,"razonamiento verbal");
        n.setSize(690,420);
        n.setLocation(0,0);
        PanelCambios.removeAll();
        PanelCambios.add(n,BorderLayout.CENTER);
        PanelCambios.revalidate();
        PanelCambios.repaint();
    }//GEN-LAST:event_lblRazonamientoVerbalMouseClicked

    private void lblLiteraturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLiteraturaMouseClicked
        // TODO add your handling code here:
        notas n = new notas();
        n.DatosAcceso(usuario,"literatura");
        n.setSize(690,420);
        n.setLocation(0,0);
        PanelCambios.removeAll();
        PanelCambios.add(n,BorderLayout.CENTER);
        PanelCambios.revalidate();
        PanelCambios.repaint();
    }//GEN-LAST:event_lblLiteraturaMouseClicked

    private void lblLenguajeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLenguajeMouseClicked
        // TODO add your handling code here:
        notas n = new notas();
        n.DatosAcceso(usuario,"lenguaje");
        n.setSize(690,420);
        n.setLocation(0,0);
        PanelCambios.removeAll();
        PanelCambios.add(n,BorderLayout.CENTER);
        PanelCambios.revalidate();
        PanelCambios.repaint();
    }//GEN-LAST:event_lblLenguajeMouseClicked

    private void lblHistoriaPeruMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHistoriaPeruMouseClicked
        // TODO add your handling code here:
        notas n = new notas();
        n.DatosAcceso(usuario,"historia del peru");
        n.setSize(690,420);
        n.setLocation(0,0);
        PanelCambios.removeAll();
        PanelCambios.add(n,BorderLayout.CENTER);
        PanelCambios.revalidate();
        PanelCambios.repaint();
    }//GEN-LAST:event_lblHistoriaPeruMouseClicked

    private void lblHistoriaUniversalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHistoriaUniversalMouseClicked
        // TODO add your handling code here:
        notas n = new notas();
        n.DatosAcceso(usuario,"historia universal");
        n.setSize(690,420);
        n.setLocation(0,0);
        PanelCambios.removeAll();
        PanelCambios.add(n,BorderLayout.CENTER);
        PanelCambios.revalidate();
        PanelCambios.repaint();
    }//GEN-LAST:event_lblHistoriaUniversalMouseClicked

    private void lblFisicaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFisicaMouseClicked
        // TODO add your handling code here:
        notas n = new notas();
        n.DatosAcceso(usuario,"fisica");
        n.setSize(690,420);
        n.setLocation(0,0);
        PanelCambios.removeAll();
        PanelCambios.add(n,BorderLayout.CENTER);
        PanelCambios.revalidate();
        PanelCambios.repaint();
    }//GEN-LAST:event_lblFisicaMouseClicked

    private void lblQuimicaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuimicaMouseClicked
        // TODO add your handling code here:
        notas n = new notas();
        n.DatosAcceso(usuario,"quimica");
        n.setSize(690,420);
        n.setLocation(0,0);
        PanelCambios.removeAll();
        PanelCambios.add(n,BorderLayout.CENTER);
        PanelCambios.revalidate();
        PanelCambios.repaint();
    }//GEN-LAST:event_lblQuimicaMouseClicked

    private void lblBiologiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBiologiaMouseClicked
        // TODO add your handling code here:
        notas n = new notas();
        n.DatosAcceso(usuario,"biologia");
        n.setSize(690,420);
        n.setLocation(0,0);
        PanelCambios.removeAll();
        PanelCambios.add(n,BorderLayout.CENTER);
        PanelCambios.revalidate();
        PanelCambios.repaint();
    }//GEN-LAST:event_lblBiologiaMouseClicked

 
    

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Alumno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AreaCiencias;
    private javax.swing.JLabel AreaLetras;
    private javax.swing.JLabel AreaMatematica;
    private javax.swing.JPanel Cursos;
    private javax.swing.JPanel PanelCambios;
    private javax.swing.JPanel PanelFondo;
    private javax.swing.JScrollPane PanelMenu;
    private javax.swing.JPanel btnAlgebra;
    private javax.swing.JPanel btnAritmetica;
    private javax.swing.JPanel btnBiologia;
    private javax.swing.JPanel btnCerrar1;
    private javax.swing.JPanel btnFisica;
    private javax.swing.JPanel btnGeometria;
    private javax.swing.JPanel btnHistoriaPeru;
    private javax.swing.JPanel btnHistoriaUniversal;
    private javax.swing.JPanel btnLenguaje;
    private javax.swing.JPanel btnLiteratura;
    private javax.swing.JPanel btnMoverPanelSuperior1;
    private javax.swing.JPanel btnQuimica;
    private javax.swing.JPanel btnRazonamientoMatematico;
    private javax.swing.JPanel btnRazonamientoVerbal;
    private javax.swing.JPanel btnTrigonometria;
    private javax.swing.JLabel curso3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lblAlgebra;
    private javax.swing.JLabel lblAritmetica;
    private javax.swing.JLabel lblBiologia;
    private javax.swing.JLabel lblCerrar1;
    private javax.swing.JLabel lblCerrarX1;
    private javax.swing.JLabel lblFisica;
    private javax.swing.JLabel lblGeometria;
    private javax.swing.JLabel lblGradoSeccion;
    private javax.swing.JLabel lblHistoriaPeru;
    private javax.swing.JLabel lblHistoriaUniversal;
    private javax.swing.JLabel lblLenguaje;
    private javax.swing.JLabel lblLiteratura;
    private javax.swing.JLabel lblNombreAlumno;
    private javax.swing.JLabel lblQuimica;
    private javax.swing.JLabel lblRazonamientoMatematico1;
    private javax.swing.JLabel lblRazonamientoVerbal;
    private javax.swing.JLabel lblTrigonometria;
    private javax.swing.JLabel lblusuario1;
    private javax.swing.JLabel lblusuario2;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel nombrecolegio;
    // End of variables declaration//GEN-END:variables




}
