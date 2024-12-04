package org.itson.presentation.config;

import javax.swing.JOptionPane;
import org.itson.presentation.strategy.StrategyModelView;
import org.itson.domain.Player;

/**
 *
 * @author PabloCeasxr
 */
public class FrmBattleship extends javax.swing.JFrame {

    private static FrmBattleship instance; // Singleton
    private String selectedColor = "Red"; // Color predeterminado.

    private FrmBattleship() {
        initComponents();
    }

    /**
     * Obtiene la instancia única de FrmBattleship.
     *
     * @return Instancia única de FrmBattleship.
     */
    public static FrmBattleship getInstance() {
        if (instance == null) {
            instance = new FrmBattleship();
        }
        return instance;
    }

    /**
     * Método que maneja el inicio del juego. Recoge la información ingresada y
     * la pasa al siguiente flujo.
     */
    private void playGame() {
        String username = jTextFieldUsername.getText().trim();
        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a username.");
            return;
        }

        // Crear un nuevo jugador y pasar los datos al modelo de juego.
        Player player = new Player(username, selectedColor);

        // Cambiar a la pantalla de juego.
        this.setVisible(false); // Ocultar la pantalla de configuración.
        StrategyModelView.getInstance().startGame(player); // Pasar los datos del jugador.
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabelUsername = new javax.swing.JLabel();
        jTextFieldUsername = new javax.swing.JTextField();
        jLabelColor = new javax.swing.JLabel();
        jButtonColorRed = new javax.swing.JButton();
        jButtonColorBlue = new javax.swing.JButton();
        jButtonPlay = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Battleship");

        jLabelUsername.setText("Username");

        jTextFieldUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUsernameActionPerformed(evt);
            }
        });

        jLabelColor.setText("Color");

        jButtonColorRed.setBackground(new java.awt.Color(255, 0, 51));
        jButtonColorRed.setText("Red");
        jButtonColorRed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonColorRedActionPerformed(evt);
            }
        });

        jButtonColorBlue.setBackground(new java.awt.Color(51, 153, 255));
        jButtonColorBlue.setText("Blue");
        jButtonColorBlue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonColorBlueActionPerformed(evt);
            }
        });

        jButtonPlay.setText("Play");
        jButtonPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPlayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabelUsername))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabelColor)))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonColorRed)
                                .addGap(34, 34, 34)
                                .addComponent(jButtonColorBlue))
                            .addComponent(jTextFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(123, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonPlay)
                .addGap(167, 167, 167))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUsername)
                    .addComponent(jTextFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelColor)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonColorRed)
                        .addComponent(jButtonColorBlue)))
                .addGap(39, 39, 39)
                .addComponent(jButtonPlay)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonColorRedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonColorRedActionPerformed
        // Configurar el color seleccionado a "Red"
        selectedColor = "Red";
        System.out.println("Color seleccionado: Red");
    }//GEN-LAST:event_jButtonColorRedActionPerformed

    private void jButtonColorBlueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonColorBlueActionPerformed
        // Configurar el color seleccionado a "Blue"
        selectedColor = "Blue";
        System.out.println("Color seleccionado: Blue");
    }//GEN-LAST:event_jButtonColorBlueActionPerformed

    private void jTextFieldUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldUsernameActionPerformed

    private void jButtonPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPlayActionPerformed
        // Obtener el nombre del usuario desde el campo de texto.
        String username = jTextFieldUsername.getText().trim();

        // Validar que se haya ingresado un nombre.
        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a username.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Salir si no hay nombre.
        }

        // Crear un nuevo jugador con el nombre y el color seleccionado.
        Player player = new Player(username, selectedColor);

        // Pasar los datos del jugador al modelo y cambiar a la pantalla del juego.
        this.setVisible(false); // Ocultar la pantalla de configuración.
        StrategyModelView.getInstance().startGame(player); // Iniciar el juego con los datos configurados.
    }//GEN-LAST:event_jButtonPlayActionPerformed

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
            java.util.logging.Logger.getLogger(FrmBattleship.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmBattleship.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmBattleship.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmBattleship.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmBattleship().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonColorBlue;
    private javax.swing.JButton jButtonColorRed;
    private javax.swing.JButton jButtonPlay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelColor;
    private javax.swing.JLabel jLabelUsername;
    private javax.swing.JTextField jTextFieldUsername;
    // End of variables declaration//GEN-END:variables
}
