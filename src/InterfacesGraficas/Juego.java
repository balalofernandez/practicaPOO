/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesGraficas;

import practicapoo.*;

/**
 *
 * @author balalo
 */
public class Juego extends javax.swing.JDialog {
    Problema problema;
    Usuario usuario;
    /**
     * Creates new form Juego
        AreaJuego.append(tablero.mostrarTablero());
     */
    
    public Juego(java.awt.Frame parent, boolean modal, Problema p, Usuario u) {
        super(parent, modal);
        initComponents();
        problema = p;
        usuario = u;
//        if (usuario.verSiResuelto(problema))
//            AreaJuego.append("Este problema ya se ha jugado");
    }
    
    public Juego(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SolucionText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AreaJuego = new javax.swing.JTextArea();
        EnviarBoton = new javax.swing.JButton();
        VolverBoton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        SolucionText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SolucionTextActionPerformed(evt);
            }
        });

        jLabel1.setText("Solución del Problema:");

        AreaJuego.setColumns(20);
        AreaJuego.setRows(5);
        jScrollPane1.setViewportView(AreaJuego);

        EnviarBoton.setText("Enviar");
        EnviarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnviarBotonActionPerformed(evt);
            }
        });

        VolverBoton.setText("Volver");
        VolverBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverBotonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(VolverBoton)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(SolucionText, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(EnviarBoton)))))
                .addContainerGap(171, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SolucionText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(EnviarBoton))
                .addGap(18, 18, 18)
                .addComponent(VolverBoton)
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SolucionTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SolucionTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SolucionTextActionPerformed

    private void EnviarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnviarBotonActionPerformed
        String solucion = SolucionText.getText();
        String ultimoTramo = solucion.substring(solucion.length()-2, solucion.length());
        if (ultimoTramo.equals("++")){
            solucion = solucion.substring(0, solucion.length()-2);}
        if(solucion.equals("")){
            AreaJuego.append("No se ha introducido nada");
        }
        solucion = solucion.toUpperCase();
        if (!usuario.verSiResuelto(problema)){
            problema.incrementarIntento();
            if (problema.solucionValida(solucion)){
                AreaJuego.append("¡Enhorabuena, la solución es correcta!"+"\n");
                problema.addResuelto(usuario);
                usuario.añadirProblemaResuelto(problema);
            }
            else{
                AreaJuego.append("No has tenido suerte"+"\n"+"Intentalo de nuevo"+"\n");
                usuario.añadirError();
            }    
        }
        else{
            if (problema.solucionValida(solucion)){
                AreaJuego.append("¡Enhorabuena, la solución es correcta!"+"\n");
            }
            else{
                AreaJuego.append("No has tenido suerte"+"\n"+"Intentalo de nuevo"+"\n");
            }            
        }
    }//GEN-LAST:event_EnviarBotonActionPerformed

    private void VolverBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverBotonActionPerformed
        usuario.calculaPorcentajeExito();
        problema.setPorcentajeExito();
        this.dispose();  
    }//GEN-LAST:event_VolverBotonActionPerformed
    
    public void Jugar(){//Tengo que seguir por aqui
        AreaJuego.append(problema.getTablero().pintarTablero()+"\n");
        AreaJuego.setEditable(false);
    }
    
    public void Jugar(Problema p, Usuario u){//Tengo que seguir por aqui
        problema = p;
        usuario = u;
        if (usuario.verSiResuelto(problema))
            AreaJuego.append("Este problema ya se ha jugado"+"\n"+"\n");
        else
            usuario.añadirIntentado();//No calculamos si se ha intentado antes
        AreaJuego.append(problema.getTablero().pintarTablero()+"\n");
        AreaJuego.setEditable(false);
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Juego dialog = new Juego(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AreaJuego;
    private javax.swing.JButton EnviarBoton;
    private javax.swing.JTextField SolucionText;
    private javax.swing.JButton VolverBoton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
