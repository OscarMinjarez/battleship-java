package org.itson.presentation.strategy;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class StrategyView extends JFrame implements IStrategyObserver {

    private static StrategyView instance;
    private JPanel gridPanel;
    private JButton[] gridButtons; // Arreglo de botones de la cuadrícula
    private JLabel shipsLabel; // Etiqueta para mostrar el estado de los barcos disponibles
    private JLayeredPane layeredPane; // Panel en capas para personalizar botones y cuadrícula

    private StrategyView() {
        initializeComponents(); // Método manual para inicializar componentes
    }

    public static StrategyView getInstance() {
        if (instance == null) {
            instance = new StrategyView();
        }
        return instance;
    }

    /**
     * Inicializa los componentes principales de la vista.
     */
    private void initializeComponents() {
        setTitle("Strategy Game");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Crear el panel en capas
        initLayeredPane();

        // Crear la cuadrícula
        initGridPanel();

        // Crear los botones personalizados
        initCustomButtonRow();

        // Crear etiqueta para mostrar el estado de los barcos disponibles
        shipsLabel = new JLabel("<html>Ships available:<br></html>");
        add(shipsLabel, BorderLayout.PAGE_END);
    }

    /**
     * Inicializa el panel en capas para personalizar la vista.
     */
    private void initLayeredPane() {
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(400, 400));
        getContentPane().add(layeredPane, BorderLayout.CENTER);
    }

    /**
     * Inicializa la cuadrícula de botones.
     */
    private void initGridPanel() {
        gridPanel = new JPanel(new GridLayout(10, 10));
        gridButtons = new JButton[100];

        for (int i = 0; i < 100; i++) {
            gridButtons[i] = new JButton();
            gridPanel.add(gridButtons[i]);
        }

        layeredPane.add(gridPanel, JLayeredPane.DEFAULT_LAYER);
        gridPanel.setBounds(200, 0, 400, 400); // Ajusta la posición y el tamaño de la cuadrícula
    }

    /**
     * Inicializa los botones personalizados para seleccionar barcos y orientación.
     */
    private void initCustomButtonRow() {
        JPanel customButtonRowPanel = new JPanel();
        customButtonRowPanel.setLayout(null);
        customButtonRowPanel.setBounds(10, 10, 150, 400);
        customButtonRowPanel.setOpaque(true);
        customButtonRowPanel.setBackground(Color.LIGHT_GRAY);

        String[] buttonNames = {"Aircraft carriers", "Cruisers", "Submarines", "Ships"};
        int[] shipSizes = {4, 3, 2, 1};

        int yPosition = 10;
        for (int i = 0; i < buttonNames.length; i++) {
            String name = buttonNames[i];
            int size = shipSizes[i];
            JButton button = new JButton(name);
            button.setBounds(10, yPosition, 130, 40);
            yPosition += 50;

            customButtonRowPanel.add(button);
        }

        JButton horizontalButton = new JButton("Horizontal");
        horizontalButton.setBounds(10, yPosition, 130, 40);
        customButtonRowPanel.add(horizontalButton);

        yPosition += 50;

        JButton verticalButton = new JButton("Vertical");
        verticalButton.setBounds(10, yPosition, 130, 40);
        customButtonRowPanel.add(verticalButton);

        layeredPane.add(customButtonRowPanel, JLayeredPane.PALETTE_LAYER);
    }

    /**
     * Obtiene los botones de la cuadrícula.
     *
     * @return Arreglo de botones de la cuadrícula.
     */
    public JButton[] getGridButtons() {
        return gridButtons;
    }

    /**
     * Actualiza el estado de los barcos disponibles.
     *
     * @param object Mapa que contiene los tipos de barcos y sus cantidades.
     */
    @Override
public void update(Object object) {
    if (object instanceof Map<?, ?> shipsAvailable) {
        updateShipsCountLabel((Map<String, Integer>) shipsAvailable);
    }
}


    /**
     * Actualiza la etiqueta con el estado de los barcos disponibles.
     *
     * @param shipsAvailable Mapa que contiene los tipos de barcos y sus
     * cantidades.
     */
    public void updateShipsCountLabel(Map<String, Integer> shipsAvailable) {
    StringBuilder labelText = new StringBuilder("<html>Ships available:<br>");
    shipsAvailable.forEach((key, value) -> labelText.append(key)
            .append(": ")
            .append(value)
            .append("<br>"));
    labelText.append("</html>");
    shipsLabel.setText(labelText.toString());
}

    /**
     * Agrega un panel personalizado a la vista.
     *
     * @param panel Panel a añadir.
     */
    public void addCustomButtonPanel(JPanel panel) {
        add(panel, BorderLayout.LINE_END); // Añade el panel al lado derecho
        revalidate(); // Refresca el layout
        repaint();   // Redibuja la interfaz
    }

/**
 * This method is called from within the constructor to initialize the form.
 * WARNING: Do NOT modify this code. The content of this method is always
 * regenerated by the Form Editor.
 */
// </editor-fold>
@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabelCountShips = new javax.swing.JLabel();
        jLabelWaitingEnemy = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setAutoRequestFocus(false);
        setLocationByPlatform(true);

        jLabel1.setText("Strategy screen");
        getContentPane().add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jLabelCountShips.setText("Ships left: 11");
        getContentPane().add(jLabelCountShips, java.awt.BorderLayout.LINE_END);

        jLabelWaitingEnemy.setText("Waiting enemy :");
        getContentPane().add(jLabelWaitingEnemy, java.awt.BorderLayout.PAGE_END);
        getContentPane().add(jLayeredPane1, java.awt.BorderLayout.LINE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(StrategyView.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);

} catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StrategyView.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);

} catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StrategyView.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);

} catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StrategyView.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(() -> {
            StrategyView view = getInstance();
            view.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelCountShips;
    private javax.swing.JLabel jLabelWaitingEnemy;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
