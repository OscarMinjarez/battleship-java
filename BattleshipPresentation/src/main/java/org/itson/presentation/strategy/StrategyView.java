package org.itson.presentation.strategy;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import org.itson.presentation.strategy.StrategyModelView;

/**
 *
 * @author PabloCeasxr
 */
public class StrategyView extends javax.swing.JFrame {

    private StrategyModelView strategyModelView;
    private static StrategyView instance;
    private ImageIcon boatIcon;
    private JLabel boatLabel;
    private Point initialClick;
    private JPanel gridPanel;
    private JLayeredPane layeredPane;
    private JButton[] gridButtons;
    private int currentShipSize = 0;
    private boolean horizontalOrientation = true;
    private JButton[] selectedButtons = new JButton[4];
    private int selectedCount = 0;
    private Map<String, Integer> shipsAvailable = new HashMap<>() {
        {
            put("Aircraft carriers", 2);
            put("Cruisers", 2);
            put("Submarines", 4);
            put("Ships", 3);
        }
    };

    /**
     * Creates new form StrategyView
     */
    private StrategyView() {
        initComponents();
        initShips();
        initLayeredPane();

        initGridPanel();
        initCustomButtonRow();
        setLocationRelativeTo(null);
        setSize(1280, 720);
        setResizable(true);
        pack();

    }

    public static StrategyView getInstance() {
        if (instance == null) {
            instance = new StrategyView();
        }
        return instance;
    }

    private void initShips() {
        shipsAvailable.put("Aircraft carriers", 2);
        shipsAvailable.put("Cruisers", 2);
        shipsAvailable.put("Submarines", 4);
        shipsAvailable.put("Ships", 3);
    }

    private void initGridPanel() {
        gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(10, 10)); 
        gridPanel.setSize(new Dimension(400, 400));
        gridButtons = new JButton[100];

        for (int i = 0; i < 100; i++) {
            JButton button = new JButton();
            button.setPreferredSize(new Dimension(20, 20));
            gridButtons[i] = button; // save button

            // Solution 
            final int index = i;

            
            button.addActionListener(e -> handleGridButtonClick(button, index));

            gridPanel.add(button);
        }

        layeredPane.add(gridPanel, JLayeredPane.DEFAULT_LAYER);
        gridPanel.setLocation(200, 0);
    }

    private void initLayeredPane() {
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(400, 400));
        getContentPane().add(layeredPane, java.awt.BorderLayout.CENTER);
    }

    private void updateShipsCountLabel() {
        StringBuilder labelText = new StringBuilder("Ships left: ");
        for (Map.Entry<String, Integer> entry : shipsAvailable.entrySet()) {
            labelText.append(entry.getKey())
                    .append(": ")
                    .append(entry.getValue())
                    .append(", ");
        }
      
        System.out.println(labelText.toString());
    }

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

            button.addActionListener(e -> {
                currentShipSize = size;
                System.out.println(name + " seleccionado con tamaño " + size);
            });

            customButtonRowPanel.add(button);
        }

        JButton horizontalButton = new JButton("Horizontal");
        horizontalButton.setBounds(10, yPosition, 130, 40);
        horizontalButton.addActionListener(e -> {
            horizontalOrientation = true;
            System.out.println("Orientacion seleccionada: Horizontal");
        });
        customButtonRowPanel.add(horizontalButton);

        yPosition += 50;

        JButton verticalButton = new JButton("Vertical");
        verticalButton.setBounds(10, yPosition, 130, 40);
        verticalButton.addActionListener(e -> {
            horizontalOrientation = false;
            System.out.println("Orientacion seleccionada: Vertical");
        });
        customButtonRowPanel.add(verticalButton);

        layeredPane.add(customButtonRowPanel, JLayeredPane.PALETTE_LAYER);
    }

  
    private void handleGridButtonClick(JButton button, int index) {
        if (currentShipSize == 0) {
            System.out.println("Por favor selecciona un barco.");
            return;
        }

   
        if (!canPlaceShip(index)) {
            System.out.println("No hay espacio suficiente para colocar el barco.");
            return;
        }

       
        placeShip(index);

       
        updateShipsAvailable();
        currentShipSize = 0; 
    }

    private boolean canPlaceShip(int startIndex) {
        int row = startIndex / 10;
        int col = startIndex % 10;

        for (int i = 0; i < currentShipSize; i++) {
            int checkIndex = horizontalOrientation ? startIndex + i : startIndex + i * 10;

            if (checkIndex >= gridButtons.length) {
                return false; 
            }
            int checkRow = checkIndex / 10;
            int checkCol = checkIndex % 10;

      
            if (horizontalOrientation && checkRow != row) {
                return false;
            }

            // Validcion cassilla disponiblidad
            if (gridButtons[checkIndex].getBackground() == Color.RED) {
                return false;
            }
        }
        return true;
    }

    private void placeShip(int startIndex) {
        for (int i = 0; i < currentShipSize; i++) {
            int paintIndex = horizontalOrientation ? startIndex + i : startIndex + i * 10;
            gridButtons[paintIndex].setBackground(Color.RED);
        }
        System.out.println("Barco colocado en orientación " + (horizontalOrientation ? "Horizontal" : "Vertical"));
    }

    private boolean isValidSelection() {
        if (horizontalOrientation) {
            int row = selectedButtons[0].getY() / selectedButtons[0].getHeight();
            for (int i = 1; i < selectedCount; i++) {
                int currentRow = selectedButtons[i].getY() / selectedButtons[i].getHeight();
                if (currentRow != row) {
                    return false;
                }
            }
        } else {
            int col = selectedButtons[0].getX() / selectedButtons[0].getWidth();
            for (int i = 1; i < selectedCount; i++) {
                int currentCol = selectedButtons[i].getX() / selectedButtons[i].getWidth();
                if (currentCol != col) {
                    return false;
                }
            }
        }
        return true;
    }

    private void finalizeSelection(String shipType) {
        for (JButton button : selectedButtons) {
            if (button != null) {
                button.setBackground(Color.RED);
            }
        }

       
        shipsAvailable.put(shipType, shipsAvailable.get(shipType) - 1);

        System.out.println(shipType + " colocado.");
        updateShipsCountLabel();

        currentShipSize = 0; 
        selectedCount = 0; 
    }

    private void resetSelection() {
        for (JButton button : selectedButtons) {
            if (button != null) {
                button.setBackground(null);
            }
        }
        selectedCount = 0; 
    }

    private String getShipTypeBySize(int size) {
        switch (size) {
            case 4:
                return "Aircraft carriers";
            case 3:
                return "Cruisers";
            case 2:
                return "Submarines";
            case 1:
                return "Ships";
            default:
                return "";
        }
    }

    private void updateShipsAvailable() {
        for (Map.Entry<String, Integer> entry : shipsAvailable.entrySet()) {
            if (entry.getValue() > 0 && entry.getValue() == currentShipSize) {
                shipsAvailable.put(entry.getKey(), entry.getValue() - 1);
                System.out.println("Quedan " + entry.getValue() + " " + entry.getKey());
                break;
            }
        }
    }

    public void clickReady() {
    }

    public void clickPutShipOnTable() {
    }

    public void clickRotateShip() {
    }

    public void clickExitGame() {
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
            java.util.logging.Logger.getLogger(StrategyView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StrategyView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StrategyView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StrategyView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                getInstance().setVisible(true);
            }
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
